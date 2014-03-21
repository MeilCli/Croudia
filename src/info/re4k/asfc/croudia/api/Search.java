package info.re4k.asfc.croudia.api;

import info.re4k.asfc.croudia.CroudiaException;
import info.re4k.asfc.croudia.SearchResult;
import info.re4k.asfc.croudia.param.StatusQueryParam;

public interface Search{
	public SearchResult searchVoice(StatusQueryParam p) throws CroudiaException;

	public SearchResult searchFavorite(StatusQueryParam p) throws CroudiaException;
}
