package br.com.fiap.resource;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        String origin = request.getHeaderString("Origin");

        if (origin != null) {
            response.getHeaders().putSingle("Access-Control-Allow-Origin", origin);
            response.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
            response.getHeaders().putSingle("Vary", "Origin");
        } else {
            response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        }

        response.getHeaders().putSingle("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD");
        response.getHeaders().putSingle("Access-Control-Max-Age", "86400");
    }
}

