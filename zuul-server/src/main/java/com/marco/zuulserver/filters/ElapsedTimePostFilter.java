package com.marco.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ElapsedTimePostFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ElapsedTimePostFilter.class);

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        final HttpServletRequest request = ctx.getRequest();

        final Long startTime = (Long)request.getAttribute("elapsedTime");
        final Long currentTime = System.currentTimeMillis();
        final long elapsedTime = currentTime - startTime;

        log.info("FILTER: Request elapsed time: {} ms", (double) elapsedTime);

        return null;
    }

    @Override
    public String filterType() {
        return "post";
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
