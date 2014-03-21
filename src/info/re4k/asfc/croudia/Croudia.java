package info.re4k.asfc.croudia;

import info.re4k.asfc.croudia.api.CroudiaMethod;
import info.re4k.asfc.croudia.http.HttpResponseCode;
import info.re4k.asfc.croudia.impl.CursorIdImpl;
import info.re4k.asfc.croudia.impl.CursorUserImpl;
import info.re4k.asfc.croudia.impl.RelationshipImpl;
import info.re4k.asfc.croudia.impl.ResponseListImpl;
import info.re4k.asfc.croudia.impl.SearchResultImpl;
import info.re4k.asfc.croudia.impl.SecretMailImpl;
import info.re4k.asfc.croudia.impl.StatusImpl;
import info.re4k.asfc.croudia.impl.TrendResultImpl;
import info.re4k.asfc.croudia.impl.UserImpl;
import info.re4k.asfc.croudia.param.AccountProfileParam;
import info.re4k.asfc.croudia.param.CursorTrimUserParam;
import info.re4k.asfc.croudia.param.CursorUserParam;
import info.re4k.asfc.croudia.param.SecretPageParam;
import info.re4k.asfc.croudia.param.RelationshipParam;
import info.re4k.asfc.croudia.param.SecretMailNewParam;
import info.re4k.asfc.croudia.param.StatusIdParam;
import info.re4k.asfc.croudia.param.StatusPageParam;
import info.re4k.asfc.croudia.param.StatusQueryParam;
import info.re4k.asfc.croudia.param.StatusShareParam;
import info.re4k.asfc.croudia.param.StatusUpdateParam;
import info.re4k.asfc.croudia.param.StatusUserParam;
import info.re4k.asfc.croudia.param.UserMultiParam;
import info.re4k.asfc.croudia.param.UserParam;
import info.re4k.asfc.croudia.param.UserQueryParam;

public class Croudia extends CroudiaHelper implements CroudiaAPI,CroudiaMethod{

	private String state = null;

	public Croudia(CroudiaConfig config){
		super(config);
	}

	public CroudiaConfig getConfig(){
		return config;
	}

	public String getAuthorizeURL(){
		state = makeState();
		return config.getAuthorizeURL()+"?response_type=code&client_id="+config.getAPIKey().getConsumerkey()+"&state="+state;
	}

	public void getAccessToken(String callback) throws CroudiaException{
		String text = callback.substring(callback.lastIndexOf('?')+1);
		String[] param = text.split("&");
		String code = null;
		String state = null;
		String error = null;
		for(String p:param){
			if(p==null||p.length()==0){
				continue;
			}
			if(p.startsWith("code")){
				code = p.substring(p.indexOf('=')+1);
			}else if(p.startsWith("state")){
				state = p.substring(p.indexOf('=')+1);
			}else if(p.startsWith("error")){
				error = p.substring(p.indexOf('=')+1);
			}
		}
		if(error!=null){
			throw new CroudiaException(error);
		}else if(state!=null&&state.equals(this.state)==false&&CroudiaConfig.isTest==false){
			throw new CroudiaException("not equal state");
		}
		if(CroudiaConfig.isLog==true){
			System.out.println("code:"+code);
		}
		String ck = config.getAPIKey().getConsumerkey();
		String cs = config.getAPIKey().getConsumerSecret();
		makeKey(post(config.getAccessTokenURL(),"grant_type=authorization_code&client_id="+ck+"&client_secret="+cs+"&code="+code,false));
	}

	public void refreshToken() throws CroudiaException{
		String ck = config.getAPIKey().getConsumerkey();
		String cs = config.getAPIKey().getConsumerSecret();
		String refresh_token = config.getAPIKey().getRefreshToken();
		makeKey(post(config.getAccessTokenURL(),"grant_type=refresh_token&client_id="+ck+"&client_secret="+cs+"&refresh_token="
				+refresh_token,false));
	}

	@Override
	protected synchronized String getRooper(String url,String method,String post,boolean isAuthorization) throws CroudiaException{
		if(isAuthorization==true&&System.currentTimeMillis()>config.getAPIKey().getExpiresIn()&&CroudiaConfig.isTest==false){
			// トークンが必要な場合で使用期限が切れていそうなときはあらかじめ更新しとく
			refreshToken();
		}
		int roop = 1;
		for(int i = 0;i<roop;i++){
			try{
				return super.getRooper(url,method,post,isAuthorization);
			}catch(CroudiaException e){
				if(isAuthorization==false||roop==2){
					// トークンが必要じゃない場合 or 再トライ時 単なるエラー
					throw e;
				}else{
					String erm = e.getErrorResponseMessage();
					if(e.getMessage().equals("Authorization Required")||e.getStatusCode()==HttpResponseCode.Http_Bad_Request&&erm!=null
							&&erm.equals("invalid_grant")){
						// トークンの期限切れ
						refreshToken();
						// もう一回トライ
						roop = 2;
					}else{
						// 単なるエラー
						throw e;
					}
				}
			}
		}
		// どうやったらここまで来るの
		throw new CroudiaException("getRooper() error");
	}

	@Override
	public ResponseList<Status,StatusPageParam> getPublicTimeLine(StatusPageParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,statuses_public+"?").toString());
		ResponseList<Status,StatusPageParam> list = new ResponseListImpl<Status,StatusPageParam>(p);
		makeStatusList(list,res);
		return list;
	}

	@Override
	public ResponseList<Status,StatusPageParam> getHomeTimeLine(StatusPageParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,statuses_home+"?").toString());
		ResponseList<Status,StatusPageParam> list = new ResponseListImpl<Status,StatusPageParam>(p);
		makeStatusList(list,res);
		return list;
	}

	@Override
	public ResponseList<Status,StatusUserParam> getUserTimeLine(StatusUserParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,statuses_user+"?").toString());
		ResponseList<Status,StatusUserParam> list = new ResponseListImpl<Status,StatusUserParam>(p);
		makeStatusList(list,res);
		return list;
	}

	@Override
	public ResponseList<Status,StatusPageParam> getMentionTimeLine(StatusPageParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,statuses_mention+"?").toString());
		ResponseList<Status,StatusPageParam> list = new ResponseListImpl<Status,StatusPageParam>(p);
		makeStatusList(list,res);
		return list;
	}

	@Override
	public Status updateStatus(StatusUpdateParam p) throws CroudiaException{
		String res = post(statuses_update,p.toParam().toString(),true);
		return new StatusImpl(res);
	}

	@Override
	public Status destroyStatus(StatusIdParam p) throws CroudiaException{
		String res = post(statuses_destroy+p.getId()+".json",p!=null?p.toParam().toString():null,true);
		return new StatusImpl(res);
	}

	@Override
	public Status showStatus(StatusIdParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,statuses_show+p.getId()+".json").toString());
		return new StatusImpl(res);
	}

	@Override
	public ResponseList<SecretMail,SecretPageParam> getSecretMail(SecretPageParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,secretmail+"?").toString());
		ResponseList<SecretMail,SecretPageParam> list = new ResponseListImpl<SecretMail,SecretPageParam>(p);
		makeSecretMailList(list,res);
		return list;
	}

	@Override
	public ResponseList<SecretMail,SecretPageParam> getSentSecretMail(SecretPageParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,secretmail_sent+"?").toString());
		ResponseList<SecretMail,SecretPageParam> list = new ResponseListImpl<SecretMail,SecretPageParam>(p);
		makeSecretMailList(list,res);
		return list;
	}

	@Override
	public SecretMail newSecretMail(SecretMailNewParam p) throws CroudiaException{
		String res = post(secretmail_new,p.toParam().toString(),true);
		return new SecretMailImpl(res);
	}

	@Override
	public SecretMail destroySecretMail(long id) throws CroudiaException{
		String res = post(secretmail_destroy+id+".json",null,true);
		return new SecretMailImpl(res);
	}

	@Override
	public SecretMail showSecretMail(long id) throws CroudiaException{
		String res = get(secretmail_show+id+".json");
		return new SecretMailImpl(res);
	}

	@Override
	public User showUser(UserParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,user_show+"?").toString());
		return new UserImpl(res);
	}

	@Override
	public ResponseList<User,UserMultiParam> lookupUser(UserMultiParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,user_lookup+"?").toString());
		ResponseList<User,UserMultiParam> list = new ResponseListImpl<User,UserMultiParam>(p);
		makeUserList(list,res);
		return list;
	}

	@Override
	public User getVerifyCredentials() throws CroudiaException{
		String res = get(account_verify);
		return new UserImpl(res);
	}

	@Override
	public User updateProfile(AccountProfileParam p) throws CroudiaException{
		String res = post(account_update,p.toParam().toString(),true);
		return new UserImpl(res);
	}

	@Override
	public User createFriend(UserParam p) throws CroudiaException{
		String res = post(friendship_create,p.toParam().toString(),true);
		return new UserImpl(res);
	}

	@Override
	public User destroyFriend(UserParam p) throws CroudiaException{
		String res = post(friendship_destroy,p.toParam().toString(),true);
		return new UserImpl(res);
	}

	@Override
	public Relationship showFriend(RelationshipParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,friendship_show).toString());
		return new RelationshipImpl(res);
	}

	@Override
	public ResponseList<Friendship,UserMultiParam> lookupFriend(UserMultiParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,friendship_lookup+"?").toString());
		ResponseList<Friendship,UserMultiParam> list = new ResponseListImpl<Friendship,UserMultiParam>(p);
		makeFriendshipList(list,res);
		return list;
	}

	@Override
	public CursorId getFriendIds(CursorUserParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,friend_ids).toString());
		return new CursorIdImpl(res);
	}

	@Override
	public CursorId getFollowerIds(CursorUserParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,follower_ids).toString());
		return new CursorIdImpl(res);
	}

	@Override
	public CursorUser getFriendList(CursorTrimUserParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,friend_list).toString());
		return new CursorUserImpl(res);
	}

	@Override
	public CursorUser getFollowerList(CursorTrimUserParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,follower_list).toString());
		return new CursorUserImpl(res);
	}

	@Override
	public ResponseList<Status,StatusUserParam> getFavorite(StatusUserParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,favorite+"?").toString());
		ResponseList<Status,StatusUserParam> list = new ResponseListImpl<Status,StatusUserParam>(p);
		makeStatusList(list,res);
		return list;
	}

	@Override
	public Status createFavorite(StatusIdParam p) throws CroudiaException{
		String res = post(favorite_create+p.getId()+".json",p.toParam().toString(),true);
		return new StatusImpl(res);
	}

	@Override
	public Status destroyFavorite(StatusIdParam p) throws CroudiaException{
		String res = post(favorite_destroy+p.getId()+".json",p.toParam().toString(),true);
		return new StatusImpl(res);
	}

	@Override
	public Status spreadStatus(StatusIdParam p) throws CroudiaException{
		String res = post(statuses_spread+p.getId()+".json",p.toParam().toString(),true);
		return new StatusImpl(res);
	}

	@Override
	public Status shareStatus(StatusShareParam p) throws CroudiaException{
		String res = post(statuses_share,p.toParam().toString(),true);
		return new StatusImpl(res);
	}

	@Override
	public TrendResult getTrend() throws CroudiaException{
		String res = get(trend_place+"?id=1");
		return new TrendResultImpl(res);
	}

	@Override
	public SearchResult searchVoice(StatusQueryParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,search_voice).toString());
		return new SearchResultImpl(res);
	}

	@Override
	public ResponseList<User,UserQueryParam> searchUser(UserQueryParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,user_search+"?").toString());
		ResponseList<User,UserQueryParam> list = new ResponseListImpl<User,UserQueryParam>(p);
		makeUserList(list,res);
		return list;
	}

	@Override
	public ResponseList<User,UserQueryParam> searchProfile(UserQueryParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,profile_search+"?").toString());
		ResponseList<User,UserQueryParam> list = new ResponseListImpl<User,UserQueryParam>(p);
		makeUserList(list,res);
		return list;
	}

	@Override
	public SearchResult searchFavorite(StatusQueryParam p) throws CroudiaException{
		String res = get(p.toParam().insert(0,search_favorite).toString());
		return new SearchResultImpl(res);
	}
}
