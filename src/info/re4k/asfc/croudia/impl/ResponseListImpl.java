package info.re4k.asfc.croudia.impl;

import java.util.ArrayList;
import info.re4k.asfc.croudia.ResponseList;

public class ResponseListImpl<T,E> extends ArrayList<T> implements ResponseList<T,E>{
	private static final long serialVersionUID = 1L;

	private E param;

	public ResponseListImpl(E param){
		super();
		this.param = param;
	}

	@Override
	public E getParam(){
		return param;
	}

}
