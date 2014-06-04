package com.bodejidi;

public class Util
{
	public static boolean isEquals(String str, String par)
	{
		if(str == null || par == null)
		{
			return false;
		}
		else
		{
			if(str.equals(par))
			{
      				return true;
   			}
			else
			{
   				return false;
			}
		}
   		
	}

	public static boolean isTrue(boolean... pa)
	{
		for(boolean i : pa)
		{
			if(i == false)
			{
				break;
			}
		}

		return false;
	}
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
	public static long number(String str)
	{
		if(isNumeric(str))
		{
			long par = Long.valueOf(str);
			return par;
		}
		else
		{
			return 0;
		}
	}
}
