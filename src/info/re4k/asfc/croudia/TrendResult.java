package info.re4k.asfc.croudia;

public interface TrendResult{
	public long getAsOf();

	public long getCreatedAt();

	public TrendLocation getLocation();

	public Trend[] getTrends();
}
