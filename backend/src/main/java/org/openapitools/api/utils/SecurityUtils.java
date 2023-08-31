package org.openapitools.api.utils;

import javax.ws.rs.HttpMethod;

public abstract class SecurityUtils {
    
    private static String[] securityExemptedEndpoints = {
        "auth/login:"+HttpMethod.POST,
        "doctors:"+HttpMethod.GET,
        "healthy:"+HttpMethod.GET,
        "ready:"+HttpMethod.GET,
        "medicines:"+HttpMethod.GET,
        "reviews:"+HttpMethod.GET,
        "reviews:"+HttpMethod.POST,
        "swagger:"+HttpMethod.GET,
        "swagger.json:"+HttpMethod.GET
    };

    public static boolean isSecurityExempted(String uri, String method) {
        String apiKeyword = uri+":"+method.toUpperCase();
        for(String api: securityExemptedEndpoints) {
            if(api.equals(apiKeyword)){
                return true;
            }
        }
        return false;
    }
    
}
