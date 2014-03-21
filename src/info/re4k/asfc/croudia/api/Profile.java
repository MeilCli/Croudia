package info.re4k.asfc.croudia.api;

import info.re4k.asfc.croudia.CroudiaException;
import info.re4k.asfc.croudia.ResponseList;
import info.re4k.asfc.croudia.User;
import info.re4k.asfc.croudia.param.UserQueryParam;

public interface Profile{
	public ResponseList<User,UserQueryParam> searchProfile(UserQueryParam p) throws CroudiaException;
}
