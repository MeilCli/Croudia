package info.re4k.asfc.croudia;

public interface Relationship{
	public boolean isSourceBlocking();

	public boolean isSourceFollowedBy();

	public boolean isSourceFollowing();

	public long getSourceId();

	public String getSourceScreenName();

	public boolean isTargetFollowedBy();

	public boolean isTargetFollowing();

	public long getTargetId();

	public String getTargetScreenName();
}
