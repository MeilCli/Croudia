package info.re4k.asfc.croudia.param;

public class SecretPageParam implements Param{
	private int since_id = -1;
	private int max_id = -1;
	private int count = -1;

	public int getSince_id(){
		return since_id;
	}

	public void setSince_id(int since_id){
		this.since_id = since_id;
	}

	public int getMax_id(){
		return max_id;
	}

	public void setMax_id(int max_id){
		this.max_id = max_id;
	}

	public int getCount(){
		return count;
	}

	public void setCount(int count){
		this.count = count;
	}

	@Override
	public StringBuilder toParam(){
		StringBuilder sb = new StringBuilder();
		if(since_id!=-1){
			addAnd(sb);
			sb.append("since_id=");
			sb.append(since_id);
		}
		if(max_id!=-1){
			addAnd(sb);
			sb.append("max_id=");
			sb.append(max_id);
		}
		if(count!=-1){
			addAnd(sb);
			sb.append("count=");
			sb.append(count);
		}
		return sb;
	}

	protected void addAnd(StringBuilder sb){
		if(sb.length()>0){
			sb.append('&');
		}
	}

}
