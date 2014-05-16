package com.bodejidi;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;


public class UTFFilter implements Filter
{
	public void init(FilterConfig filter) throws ServletException
	{
	
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)throws ServletException, IOException
	{
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		chain.doFilter(req, resp);

	}

	public void destroy()
	{
	
	}
}
