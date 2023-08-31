package org.openapitools.api.impl;

import org.bson.Document;
import org.openapitools.api.*;
import org.openapitools.api.db.DBClient;
import org.openapitools.model.ProbeResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class ReadyApiServiceImpl extends ReadyApiService {
    @Override
    public Response readyGet(SecurityContext securityContext) throws NotFoundException {
        Document DBPing = DBClient.getDatabase().runCommand(new Document("ping", 1));
        String dbOK = DBPing.get("ok").toString();
        if (dbOK.equals("1")) {
            return Response.ok().entity(new ProbeResponse().ok(true)).build();
        } else {
            return Response.ok().entity(new ProbeResponse().ok(false)).build();
        }
    }
}
