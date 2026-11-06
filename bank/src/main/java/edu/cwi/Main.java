package edu.cwi;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.http.staticfiles.Location;
/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        var app = Javalin.create(config -> {
            config.staticFiles.add("/public", Location.CLASSPATH);
            config.staticFiles.add("/public/index.html", Location.CLASSPATH);
            config.staticFiles.add("/public/account.html", Location.CLASSPATH);

            config.routes.post("/account", ctx -> {
                ctx.redirect("account.html");
            });

            config.routes.get("/logout", ctx -> {
                ctx.redirect("/");
            });

            
            config.fileRenderer(new JavalinJte()); // <-- set jte as the renderer

            config.routes.apiBuilder(() -> {
                crud("/transactions/{id}", new TransactionsController());
            });
        }).start(7070);
    }
}
