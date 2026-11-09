package edu.cwi;

import java.util.Map;
import java.util.Optional;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.crud;
import io.javalin.http.UnauthorizedResponse;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.security.RouteRole;
/**
 * Hello world!
 *
 */
public class Main 
{

    public enum AppRole implements RouteRole { NONE, CUSTOMER, ADMIN }
    public static void main( String[] args )
    {
        var app = Javalin.create(config -> {
            config.staticFiles.add("/public", Location.CLASSPATH);

            config.routes.post("/login", AccountController::authenticate);

            config.routes.get("/account", ctx -> {
                String userId = ctx.cookieStore().get("user-id");
                Optional<UserAccount> user = AccountController.getUser(userId);
                if (user.isPresent()) {
                    ctx.render("jte/accountPage.jte", Map.of("title", "Account Transactions", "account", user.get()));
                } else {
                    ctx.redirect("/"); // redirect to home if user is not present
                }
            });

            config.routes.get("/logout", ctx -> {
                ctx.redirect("/");
            });

            
            config.fileRenderer(new JavalinJte()); // <-- set jte as the renderer

            config.routes.apiBuilder(() -> {
                crud("/transactions/{id}", new TransactionsController());
            });

            System.out.println("Starting Javalin application...");
            config.routes.beforeMatched(ctx -> {
                if (ctx.routeRoles().isEmpty()) {
                    return; // if there are no route roles, we don't need to check anything
                }

                String role = ctx.cookieStore().get("user-role"); // get the role from the cookie store
                AppRole appRole = AppRole.valueOf(role);

                if (!ctx.routeRoles().contains(appRole)) {
                    throw new UnauthorizedResponse(); // deny access to the route if the user doesn't have the role
                }
            });
        }).start(7070);
    }
}
