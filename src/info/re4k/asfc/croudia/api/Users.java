package info.re4k.asfc.croudia.api;

import info.re4k.asfc.croudia.CroudiaException;
import info.re4k.asfc.croudia.ResponseList;
import info.re4k.asfc.croudia.User;
import info.re4k.asfc.croudia.param.UserMultiParam;
import info.re4k.asfc.croudia.param.UserParam;
import info.re4k.asfc.croudia.param.UserQueryParam;

public interface Users{
	public User showUser(UserParam p) throws CroudiaException;

	public ResponseList<User,UserMultiParam> lookupUser(UserMultiParam p) throws CroudiaException;

	public ResponseList<User,UserQueryParam> searchUser(UserQueryParam p) throws CroudiaException;
}
