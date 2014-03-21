package info.re4k.asfc.croudia.param;

public class StatusIdParam extends StatusParam{
	private long id;

	public StatusIdParam(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}
}
