package org.openapitools.api;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.openapitools.api.logging.LogClient;
import org.openapitools.api.db.DBClient;

import com.mongodb.client.MongoDatabase;
public class Bootstrap extends HttpServlet {

    private MongoDatabase dbClient;

    @Override
    public void init(ServletConfig config) throws ServletException {
        LogClient logClient = new LogClient(Bootstrap.class);
        try {
            dbClient = DBClient.getDatabase();
            String dbName = dbClient.getName();
            logClient.info("connected to DB: " + dbName);
            logClient.debug("attempting to starting server!");
            super.init(config);
            logClient.info("server has started listening!");
        } catch (ServletException e) {
            logClient.error("could not start server, because: " + e.getMessage().toString());
        }
    }

    @Override
    public void destroy() {
        DBClient.cleanup();
    }
}
