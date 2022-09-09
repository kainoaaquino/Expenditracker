import Model.Category;
import Model.Entry;
import com.fasterxml.jackson.databind.ObjectMapper;
import Service.categoryService;
import Service.spendingService;
import io.javalin.Javalin;

import java.sql.SQLException;

public class menuAPI {

    public static void main(String args[]) throws SQLException {
        spendingService ss = new spendingService();
        categoryService cs = new categoryService();
        Javalin app = Javalin.create().start(4444);
        // app.get("/", ctx -> ctx.result("Hello World. I go peepee in the lidder bock"));
        app.get("/entries", ctx ->
        {
            ctx.result(ss.getAllEntries().toString());
        });
        app.get("/entries/categoryname/{name}", ctx ->
                {
                    ctx.json(ss.getEntriesByCategoryName(ctx.pathParam("name")));

                }
        );
        app.post("entries", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Entry requestEntry = mapper.readValue(ctx.body(), Entry.class);
            ss.addEntry(requestEntry.getAmount(), requestEntry.getDate(), requestEntry.getCategory());
        });

    }
}

