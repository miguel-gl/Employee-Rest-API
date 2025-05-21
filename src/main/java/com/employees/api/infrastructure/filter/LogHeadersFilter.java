package com.employees.api.infrastructure.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Enumeration;

/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: LogHeadersFilter.
 * Date: 2025-05-21
 * Version: 1.0
 */

@Component
public class LogHeadersFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(LogHeadersFilter.class);

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        logger.info("Request Headers [{}]:", request.getRequestURI());
        Enumeration<String> headerNames = request.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                logger.info("-> {}: {}", headerName, headerValue);
            }
        }

        filterChain.doFilter(request, response);
    }
}
