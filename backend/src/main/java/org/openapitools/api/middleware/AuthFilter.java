package org.openapitools.api.middleware;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import org.openapitools.api.Bootstrap;
import org.openapitools.api.logging.LogClient;
import org.openapitools.api.utils.SecurityUtils;
import org.openapitools.model.ErrorObject;
import javax.ws.rs.core.Response;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import java.util.Map;

@Provider
public class AuthFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        LogClient logClient = new LogClient(Bootstrap.class);

        String method = requestContext.getMethod();
        if(method.equals(HttpMethod.OPTIONS)) {
                Response preflightResponse = Response.ok()
                    .header("Access-Control-Allow-Origin", "*") // Change * to the appropriate origin
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE")
                    .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                    .build();
            requestContext.abortWith(preflightResponse);
        }
        String uri = requestContext.getUriInfo().getPath().toString();
        logClient.info("new request received --> method: " + method + " | uri: " + uri);
        if (SecurityUtils.isSecurityExempted(uri, method)) {
            logClient.debug("security is not required for this endpoint");
        } else {
            try {
                String authHeader = requestContext.getHeaderString("Authorization");
                if (authHeader == null || authHeader.equals("")) {
                    ErrorObject err =
                            new ErrorObject().code(Response.Status.UNAUTHORIZED.getStatusCode())
                                    .description("invalid auth header provided!")
                                    .moreInfo(Response.Status.UNAUTHORIZED.getReasonPhrase());
                    requestContext
                            .abortWith(Response.status(Response.Status.UNAUTHORIZED.getStatusCode())
                                    .entity(err).build());
                    return;
                }
                String[] authHeaderParts = authHeader.split(" ");
                if (authHeaderParts.length < 2 || !authHeaderParts[0].equalsIgnoreCase("bearer")) {
                    ErrorObject err =
                            new ErrorObject().code(Response.Status.UNAUTHORIZED.getStatusCode())
                                    .description("invalid auth header provided!")
                                    .moreInfo(Response.Status.UNAUTHORIZED.getReasonPhrase());
                    requestContext
                            .abortWith(Response.status(Response.Status.UNAUTHORIZED.getStatusCode())
                                    .entity(err).build());
                    return;
                }
                String adminUsername = System.getProperty("ADMINUSERNAME").toString();
                byte[] secretKey = System.getProperty("JWTSECRETKEY").toString().getBytes();
                Jws<Claims> jws = Jwts.parserBuilder().setSigningKey(secretKey).build()
                        .parseClaimsJws(authHeaderParts[1]);
                Claims claims = jws.getBody();
                String sub = claims.getSubject();
                String role = claims.get("role", String.class);
                if (!sub.equals(adminUsername) && role.equalsIgnoreCase("admin")) {
                    ErrorObject err =
                            new ErrorObject().code(Response.Status.UNAUTHORIZED.getStatusCode())
                                    .description("invalid subject or role provided in jwt token!")
                                    .moreInfo(Response.Status.UNAUTHORIZED.getReasonPhrase());
                    requestContext
                            .abortWith(Response.status(Response.Status.UNAUTHORIZED.getStatusCode())
                                    .entity(err).build());
                } else {
                    logClient.debug("validated auth token, security gate passed!");
                }
            } catch (Exception e) {
                ErrorObject err =
                        new ErrorObject().code(Response.Status.UNAUTHORIZED.getStatusCode())
                                .description(e.getMessage().toString())
                                .moreInfo(Response.Status.UNAUTHORIZED.getReasonPhrase());
                requestContext.abortWith(Response
                        .status(Response.Status.UNAUTHORIZED.getStatusCode()).entity(err).build());
            }
        }
    }
}
