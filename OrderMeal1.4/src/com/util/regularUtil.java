package com.util;

import java.util.Arrays;
import java.util.HashMap;

public class regularUtil
{
	public static String[] regular(String[] good)
	{
		HashMap<String, Integer> hm = new HashMap<>();
		for(int i = 0; i < good.length; i++)
		{
			if (hm.containsKey(good[i]))
			{
				hm.put(good[i], hm.get(good[i])+1);
			}
			else
			{
				hm.put(good[i], 1);
			}
		}
		
		Dish[] dishs = new Dish[hm.size()];	
		int i = 0;
		for(String sss:hm.keySet())
		{
			dishs[i++] = new Dish(sss, hm.get(sss));
		}
		
		Arrays.sort(dishs);
		String[] result = new String[2];
		result[0] = dishs[0].getName();
		result[1] = dishs[1].getName();
		
		return result;
	}

}

class Dish implements Comparable<Dish>
{
	public String name;
	public int times;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getTimes()
	{
		return times;
	}
	public void setTimes(int times)
	{
		this.times = times;
	}
	public Dish(String name, int times)
	{
		super();
		this.name = name;
		this.times = times;
	}
	@Override
	public String toString()
	{
		return "dish [name=" + name + ", times=" + times + "]";
	}
	@Override
	public int compareTo(Dish o)
	{
		int num = o.getTimes() - this.getTimes();
		return num == 0? 1:num;
	}
	
	
}
