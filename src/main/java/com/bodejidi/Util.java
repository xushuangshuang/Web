package com.bodejidi;

public class Util
{
	public static boolean isNumeric(String str)
	{
   		for(int i=str.length();--i>=0;)
		{
      			int chr=str.charAt(i);
      			if(chr<48 || chr>57)
         		return false;
   		}
   		return true;
	}

}
