package edu.cwi;

import io.javalin.Javalin;
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
        }).start(7070);
    }
}
