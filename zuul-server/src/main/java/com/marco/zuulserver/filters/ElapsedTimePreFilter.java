package com.marco.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ElapsedTimePreFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ElapsedTimePreFilter.class);

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        final HttpServletRequest request = ctx.getRequest();

        log.info("FILTER: {} request routed to {}", request.getMethod(), request.getRequestURL().toString());

        Long time = System.currentTimeMillis();
        request.setAttribute("elapsedTime", time);

        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
}
