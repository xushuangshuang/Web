package com.bodejidi;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;

public class ConstantTypeFilter implements Filter
{
	public void init(FilterConfig filterConfig) throws ServletException
	{
	
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain  chain) throws IOException , ServletException
	{
		resp.setContentType("text/html");
		chain.doFilter(req, resp);
	}

	public void destroy()
	{
	
	}
}
