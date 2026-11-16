package edu.cwi;

import edu.cwi.data.User;
import edu.cwi.data.enums.AppRole;
import io.javalin.http.Context;

public class AuthController {
    public static void authenticate(Context ctx) {
        System.out.println("Authenticating user...");
        UserController userController = new UserController();
        
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        User user = userController.authenticateUser(ctx, username, password);

		if(user != null) {
            ctx.cookieStore().set("user-id", user.getId());
            ctx.cookieStore().set("user-role", user.getRole());
            if (user.getRole().equals(AppRole.ADMIN)) {
                System.out.println("Admin user");
                ctx.redirect("/users");
            } else {
                System.out.println("Customer user");
                ctx.redirect("/accounts");
            }
        }
        else {
            ctx.cookieStore().clear();
            ctx.redirect("/unauthorized.html");
        }
    }
}
