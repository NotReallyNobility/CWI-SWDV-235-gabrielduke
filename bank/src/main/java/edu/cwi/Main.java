package edu.cwi;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import edu.cwi.data.enums.AppRole;
import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.crud;
import static io.javalin.apibuilder.ApiBuilder.path;
import io.javalin.http.UnauthorizedResponse;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinJte;

public class Main 
{
    public static void main( String[] args )
    {   
        /*System.out.println(BCrypt.hashpw("weak", BCrypt.gensalt()));
        System.out.println(BCrypt.hashpw("weak", BCrypt.gensalt()));*/
        
        var app = Javalin.create(config -> {
            config.staticFiles.add("/public", Location.CLASSPATH);
            
            config.routes.post("/login", AuthController::authenticate);

            config.routes.get("/accounts", ctx -> {
                int userId = ctx.cookieStore().get("user-id");
                Optional<UserAccount> user = AccountController.getUser(userId);
                if (user.isPresent()) {
                    ctx.render("jte/accountPage.jte", Map.of("title", "Account Transactions", "account", user.get()));
                } else {
                    ctx.redirect("/"); // redirect to home if user is not present
                }
            });

            config.routes.apiBuilder(() -> {
                path("/users", List.of(AppRole.ADMIN), () -> {
                    crud("/{id}", new UserController());
                });
            });

            config.routes.get("/logout", ctx -> {
                ctx.redirect("/");
            });

            
            config.fileRenderer(new JavalinJte()); // <-- set jte as the renderer

            config.routes.apiBuilder(() -> {
                crud("/transactions/{id}", new TransactionsController());
            });
            
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
