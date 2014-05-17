package com.bodejidi;

public class LoggerFactory
{
	public static Logger getLogger(Class clazz)
	{
		return new Logger(org.slf4j.LoggerFactory.getLogger(clazz));
	}

}
