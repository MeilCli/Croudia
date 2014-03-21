package info.re4k.asfc.croudia;

public interface SearchResult{
	public int getCompletedIn();

	public long getMaxId();

	public long getSinceId();

	public int getCount();

	public String getNextResults();

	public String getQuery();

	public String getRefreshUrl();

	public Status[] getTweet();
}
