package edu.cwi;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import static j2html.TagCreator.body;
import static j2html.TagCreator.button;
import static j2html.TagCreator.each;
import static j2html.TagCreator.form;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.html;
import static j2html.TagCreator.input;
import static j2html.TagCreator.li;
import static j2html.TagCreator.p;
import static j2html.TagCreator.ul;

public class TransactionsController implements CrudHandler {
    
    private final Map<String, String> transactions = new ConcurrentHashMap<>();  //withdrawals and deposits

    public TransactionsController() { 
        transactions.put("1", "Initial transaction"); 
        transactions.put("2", "Second transaction");
        transactions.put("3", "The one after the second transaction");
    }
    @Override
    public void getAll(Context ctx) {
        // Use ctx to render all transactions html
        ctx.html(renderAll());
    }

    @Override
    public void getOne(Context ctx, String resourceId) {

        String singleTransaction = transactions.get(resourceId);

        if (singleTransaction != null) {
            // Use ctx to render transaction html
            String response = html(
                h1("Transaction, id = " + resourceId),
                p(singleTransaction)
            ).render();
            ctx.html(response);
        } else {
            ctx.status(404).result("Transaction not found");
        }
    }

    @Override
    public void create(Context ctx) {

        String body = ctx.formParam("new_item_body");
        String id = String.valueOf(transactions.size() + 1);

        transactions.put(id, body);

		// Use ctx to render all transactions html
        ctx.html(renderAll());
    }

    @Override
    public void update(Context ctx, String resourceId) {

        if (transactions.containsKey(resourceId)) {
            System.out.println("Resource Id" + resourceId);
            System.out.println("Intended Update: " + ctx.formParam("update_body"));
            System.out.println("Current Value: " + transactions.get(resourceId));
            transactions.put(resourceId, ctx.formParam("update_body"));
            System.out.println("Actual Updated Value: " + transactions.get(resourceId));
            // Use ctx to render all transactions html
            ctx.html(renderAll());
        } else {
            ctx.status(404).result("Transaction not found");
        }
    }

    @Override
    public void delete(Context ctx, String resourceId) {

        transactions.remove(resourceId);

		// Use ctx to render all transactions html (don't worry about for now, html doesn't support)
        ctx.html(renderAll());
    }



    public String renderAll() {
        return html(
            body(
                h1("All Transactions"),
                ul(
                    each(transactions.entrySet(), (entry) ->
                        form(
                            li(entry.getValue()),
                            input().withName("update_body").withType("text").withPlaceholder("Update Transaction"),
                            button("Update").withType("submit")
                        ).withMethod("PUT").withAction("transactions/" + entry.getKey())
                    )
                ),
                form(
                    input().withName("new_item_body").withType("text").withPlaceholder("New Transaction").isRequired(),
                    button("Submit").withType("submit")
                ).withMethod("POST").withAction("/transactions")
            )
        ).render();
    }
}