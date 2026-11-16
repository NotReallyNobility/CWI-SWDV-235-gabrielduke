package edu.cwi;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import edu.cwi.data.enums.AppRole;
import io.javalin.http.Context;


public class AccountController {
    
    record Pair(String a, String b) {}

    private static final Map<Pair, UserAccount> userMap = Map.of(
        new Pair("jboo", "weak"), new UserAccount(5, "Jimmity Bobbity Boo", AppRole.CUSTOMER, 1235.8, Map.of("1", "Deposited $1235.80")),
        new Pair("goob", "weak"), new UserAccount(6, "gREG oOB", AppRole.CUSTOMER, 8532.1, Map.of("1", "Deposited $8532.10"))
    );

    public static Optional<UserAccount> getUser(int id) {

        Collection<UserAccount> accounts = userMap.values();

        for (UserAccount account : accounts) {
            if (account.getId() == id) {
                return Optional.of(account);
            }
        }

        return Optional.empty();
    }


    /*public static void authenticate(Context ctx) {

            UserController usersController = new UserController();

            String username = ctx.formParam("username");
            String password = ctx.formParam("password");

            User user = usersController.authenticateUser(ctx, username, password);

            if(user != null) {
                ctx.cookieStore().set("user-id", user.getId());
                ctx.cookieStore().set("user-role", user.getRole());
                ctx.redirect("/accounts");
            }
            else {
                ctx.cookieStore().clear();
                ctx.redirect("/unauthorized.html");
            }
        }*/

    //Former authenticator
    /*public static void authenticate(Context ctx) {
        System.out.println("Authenticating user...");
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        Pair credentials = new Pair(username, password);
        UserAccount user = userMap.get(credentials);

		if(user != null) {
            ctx.cookieStore().set("user-id", user.getStringId());
            ctx.cookieStore().set("user-role", user.getRole());
            ctx.redirect("/accounts");
        }
        else {
            ctx.cookieStore().clear();
            ctx.redirect("/unauthorized.html");
        }
    }*/

    public static void logout(Context ctx) {
        ctx.cookieStore().clear();
        ctx.redirect("/");
    }
}