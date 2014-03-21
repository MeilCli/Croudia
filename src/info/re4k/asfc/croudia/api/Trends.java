package info.re4k.asfc.croudia.api;

import info.re4k.asfc.croudia.CroudiaException;
import info.re4k.asfc.croudia.TrendResult;

public interface Trends{
	public TrendResult getTrend() throws CroudiaException;
}
