package info.re4k.asfc.croudia.api;

import info.re4k.asfc.croudia.CroudiaException;
import info.re4k.asfc.croudia.CursorId;
import info.re4k.asfc.croudia.CursorUser;
import info.re4k.asfc.croudia.param.CursorTrimUserParam;
import info.re4k.asfc.croudia.param.CursorUserParam;

public interface Followers{
	public CursorId getFollowerIds(CursorUserParam p) throws CroudiaException;

	public CursorUser getFollowerList(CursorTrimUserParam p) throws CroudiaException;
}
