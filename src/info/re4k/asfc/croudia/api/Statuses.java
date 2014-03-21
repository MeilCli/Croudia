package info.re4k.asfc.croudia.api;

import info.re4k.asfc.croudia.CroudiaException;
import info.re4k.asfc.croudia.ResponseList;
import info.re4k.asfc.croudia.Status;
import info.re4k.asfc.croudia.param.StatusIdParam;
import info.re4k.asfc.croudia.param.StatusPageParam;
import info.re4k.asfc.croudia.param.StatusShareParam;
import info.re4k.asfc.croudia.param.StatusUpdateParam;
import info.re4k.asfc.croudia.param.StatusUserParam;

public interface Statuses{
	public ResponseList<Status,StatusPageParam> getPublicTimeLine(StatusPageParam p) throws CroudiaException;

	public ResponseList<Status,StatusPageParam> getHomeTimeLine(StatusPageParam p) throws CroudiaException;

	public ResponseList<Status,StatusUserParam> getUserTimeLine(StatusUserParam p) throws CroudiaException;

	public ResponseList<Status,StatusPageParam> getMentionTimeLine(StatusPageParam p) throws CroudiaException;

	public Status updateStatus(StatusUpdateParam p) throws CroudiaException;

	public Status destroyStatus(StatusIdParam p) throws CroudiaException;

	public Status showStatus(StatusIdParam p) throws CroudiaException;

	public Status spreadStatus(StatusIdParam p) throws CroudiaException;

	public Status shareStatus(StatusShareParam p) throws CroudiaException;
}
