package com.mudounet.xml;

import java.util.ArrayList;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class StatList {
	private static final int MAX_ITEMS = 6;
	
	@ElementList(inline=true)
	private ArrayList<Float> list = new ArrayList<Float>();
	
	public void add(float value) {
		if(list.size() >= MAX_ITEMS) list.remove(0);
		
		list.add(value);
	}
	
	public float mean() {
		float mean = 0.0f;
		
		if (list.size() == 0) return 0;
		
		for (int index = 0; index < list.size(); index++)
			mean += list.get(index);
		
		return mean / list.size();	
	}
}
