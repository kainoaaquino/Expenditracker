import Model.Category;
import Model.Entry;
import Model.Users;
import Service.usersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import Service.categoryService;
import Service.spendingService;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

import java.sql.SQLException;

public class menuAPI {
    //this is a comment
    public static void main(String args[]) throws SQLException {
        spendingService ss = new spendingService();
        categoryService cs = new categoryService();
        usersService us = new usersService();
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);
        app.start(9000);
        // app.get("/", ctx -> ctx.result("Hello World. I go in the lidder bock"));
        app.get("/entries", ctx ->
        {
            ctx.json(ss.getAllEntries());
        });
        app.get("/entries/categoryname/{name}", ctx ->
                {
                    ctx.json(ss.getEntriesByCategoryName(ctx.pathParam("name")));

                }
        );
        app.get("/entries/date/{entryDate}", ctx ->
            {
            ctx.json(ss.getEntriesByDate(ctx.pathParam("entryDate")));
            }
        );
        app.get("/entries/month/{entryDate}", ctx ->
                {
                    ctx.json(ss.getEntriesByMonth(ctx.pathParam("entryDate")));
                }
        );

        app.post("entries", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Entry requestEntry = mapper.readValue(ctx.body(), Entry.class);
            ss.addEntry(requestEntry.getAmount(), requestEntry.getentryDate(), requestEntry.getCategory(), requestEntry.getentryuserid());
        });

        app.get("/users", ctx ->
                {
                    ctx.json(us.getAllUsers());
                }
        );

        app.post("users", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Users requestUsers = mapper.readValue(ctx.body(), Users.class);
            us.addUser(requestUsers.getUser_id(), requestUsers.getUsername(), requestUsers.getPassword());
        });

        app.get("/users/username/{username}", ctx ->
        {
            ctx.json(ss.getEntriesByUserName(ctx.pathParam("username")));

        }
        );

        app.get("/users/necessary/{username}", ctx ->
        {
            ctx.json(ss.getNecessaryUserEntriesByUserName (ctx.pathParam("username")));

        });

        app.get("/users/notnecessary/{username}", ctx ->
        {
            ctx.json(ss.getNotNecessaryUserEntriesByUserName (ctx.pathParam("username")));

        });



    }
}

