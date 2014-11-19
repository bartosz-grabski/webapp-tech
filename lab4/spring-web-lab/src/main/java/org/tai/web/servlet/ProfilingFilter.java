package org.tai.web.servlet;

import com.google.common.base.Stopwatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Przemyslaw Dadel
 */
@Component
public class ProfilingFilter implements Filter {

	@Autowired
	private PerSessionRequestCounter counter;
	
	public void setCounter(PerSessionRequestCounter counter) {
		this.counter = counter;
	}
	
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        try {
        	counter.newRequest();
            filterChain.doFilter(servletRequest, servletResponse);
            
        } finally {
            LOGGER.info("Processing request to {} took {} ms", ((HttpServletRequest) servletRequest).getRequestURI(), stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }
    }

    @Override
    public void destroy() {

    }
}
