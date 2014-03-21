package info.re4k.asfc.croudia;

public interface CroudiaAPI{
	public static final String base = "https://api.croudia.com";

	public static final String statuses_public = base+"/statuses/public_timeline.json";
	public static final String statuses_home = base+"/statuses/home_timeline.json";
	public static final String statuses_user = base+"/statuses/user_timeline.json";
	public static final String statuses_mention = base+"/statuses/mentions.json";
	public static final String statuses_update = base+"/statuses/update.json";
	public static final String statuses_destroy = base+"/statuses/destroy/";
	public static final String statuses_show = base+"/statuses/show/";
	public static final String statuses_spread = base+"/statuses/spread/";
	public static final String statuses_share = base+"/statuses/share.json";

	public static final String secretmail = base+"/secret_mails.json";
	public static final String secretmail_sent = base+"/secret_mails/sent.json";
	public static final String secretmail_new = base+"/secret_mails/new.json";
	public static final String secretmail_destroy = base+"/secret_mails/destroy/";
	public static final String secretmail_show = base+"/secret_mails/show/";

	public static final String user_show = base+"/users/show.json";
	public static final String user_lookup = base+"/users/lookup.json";
	public static final String user_search = base+"/users/search.json";

	public static final String account_verify = base+"/account/verify_credentials.json";
	public static final String account_update = base+"/account/update_profile.json";

	public static final String friendship_create = base+"/friendships/create.json";
	public static final String friendship_destroy = base+"/friendships/destroy.json";
	public static final String friendship_show = base+"/friendships/show.json";
	public static final String friendship_lookup = base+"/friendships/lookup.json";

	public static final String friend_ids = base+"/friends/ids.json";
	public static final String friend_list = base+"/friends/list.json";

	public static final String follower_ids = base+"/followers/ids.json";
	public static final String follower_list = base+"/followers/list.json";

	public static final String favorite = base+"/favorites.json";
	public static final String favorite_create = base+"/favorites/create/";
	public static final String favorite_destroy = base+"/favorites/destroy/";

	public static final String trend_place = base+"/trends/place.json";

	public static final String search_voice = base+"/search/voices.json";
	public static final String search_favorite = base+"/search/favorites.json";

	public static final String profile_search = base+"/profile/search.json";
}
