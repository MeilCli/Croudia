package info.re4k.asfc.croudia;

import java.util.ArrayList;
import java.util.List;

public interface ResponseList<T,E> extends List<T>{
	public E getParam();

	public ArrayList<T> getList();
}
