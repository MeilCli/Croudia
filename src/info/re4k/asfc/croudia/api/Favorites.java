package info.re4k.asfc.croudia.api;

import info.re4k.asfc.croudia.CroudiaException;
import info.re4k.asfc.croudia.ResponseList;
import info.re4k.asfc.croudia.Status;
import info.re4k.asfc.croudia.param.StatusIdParam;
import info.re4k.asfc.croudia.param.StatusUserParam;

public interface Favorites{
	// http://developer.croudia.com/docs/51_favorites ここのドキュメント不備がある気がする
	public ResponseList<Status,StatusUserParam> getFavorite(StatusUserParam p) throws CroudiaException;

	// trim_userどうなってるの
	public Status createFavorite(StatusIdParam p) throws CroudiaException;

	// trim_userどうなってるの
	public Status destroyFavorite(StatusIdParam p) throws CroudiaException;
}
