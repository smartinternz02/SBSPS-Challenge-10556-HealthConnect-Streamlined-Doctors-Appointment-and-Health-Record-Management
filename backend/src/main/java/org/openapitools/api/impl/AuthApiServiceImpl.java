package org.openapitools.api.impl;

import org.bson.Document;
import org.openapitools.api.*;
import org.openapitools.api.db.DBClient;
import org.openapitools.api.logging.LogClient;
import org.openapitools.model.ErrorObject;
import org.openapitools.model.LoggedInUserDetails;
import org.openapitools.model.LoginCreds;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class AuthApiServiceImpl extends AuthApiService {
    @Override
    public Response login(LoginCreds loginCreds, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(HealthReportsApiServiceImpl.class);
        logClient.debug("received new request for `login`");
        if (!loginCreds.isValid()) {
            logClient.error("supplied login credentials are invalid");
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("supplied login credentials are invalid!")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        String collectionName = "";
        if (loginCreds.getType().toString().equals("user")) {
            collectionName = "users";
        } else if (loginCreds.getType().toString().equals("doctor")) {
            collectionName = "doctors";
        } else {
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("type not supported!")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            Document query = loginCreds.toDocument();
            FindIterable<Document> matchingUsers =
                    dbClient.getCollection(collectionName).find(query);
            if (matchingUsers.first() == null) {
                ErrorObject err = new ErrorObject().code(Response.Status.NOT_FOUND.getStatusCode())
                        .description("no matching user found!")
                        .moreInfo(Response.Status.NOT_FOUND.getReasonPhrase());
                return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(err)
                        .build();
            }
            LoggedInUserDetails response = new LoggedInUserDetails();
            Date currDate = new Date(System.currentTimeMillis());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currDate);
            calendar.add(Calendar.HOUR_OF_DAY, 2);
            Date expDate = calendar.getTime();
            String adminUsername = System.getProperty("ADMINUSERNAME").toString();
            byte[] secretKey = System.getProperty("JWTSECRETKEY").toString().getBytes();
            String jwtToken = Jwts.builder().claim("role", "admin")
                    .setSubject(adminUsername)
                    .setId(UUID.randomUUID().toString()).setIssuedAt(currDate)
                    .setExpiration(expDate)
                    .signWith(SignatureAlgorithm.HS256, secretKey)
                    .compact();
            response.setAuthToken(jwtToken);
            response.setEmail(loginCreds.getEmail().toString());
            response.setType(loginCreds.getType().toString()
                    .equals(LoggedInUserDetails.TypeEnum.DOCTOR.toString())
                            ? LoggedInUserDetails.TypeEnum.DOCTOR
                            : LoggedInUserDetails.TypeEnum.USER);
            return Response.status(Response.Status.OK.getStatusCode()).entity(response).build();
        } catch (Exception e) {
            ErrorObject err =
                    new ErrorObject().code(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .description(e.getMessage().toString())
                            .moreInfo(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                    .entity(err).build();
        }
    }
}
