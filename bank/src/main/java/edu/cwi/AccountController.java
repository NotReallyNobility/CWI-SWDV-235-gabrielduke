package edu.cwi;

import io.javalin.http.Context;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import edu.cwi.Main.AppRole;


public class AccountController {
    
    record Pair(String a, String b) {}

    private static final Map<Pair, UserAccount> userMap = Map.of(
        new Pair("jboo", "weak"), new UserAccount(UUID.fromString("94f6901f-cd0f-4c90-81dc-3601a071c077"), "Jimmity Bobbity Boo", AppRole.CUSTOMER, 1235.8, Map.of("1", "Deposited $1235.80")),
        new Pair("goob", "weak"), new UserAccount(UUID.fromString("99377dc1-617d-45bd-b5fe-ac6418f06f43"), "gREG oOB", AppRole.CUSTOMER, 8532.1, Map.of("1", "Deposited $8532.10"))
    );

    public static Optional<UserAccount> getUser(String id) {

        Collection<UserAccount> accounts = userMap.values();

        for (UserAccount account : accounts) {
            if (account.getStringId().equals(id)) {
                return Optional.of(account);
            }
        }

        return Optional.empty();
    }

    public static void authenticate(Context ctx) {
        System.out.println("Authenticating user...");
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        Pair credentials = new Pair(username, password);
        UserAccount user = userMap.get(credentials);

		if(user != null) {
            ctx.cookieStore().set("user-id", user.getStringId());
            ctx.cookieStore().set("user-role", user.getRole());
            ctx.redirect("/account");
        }
        else {
            ctx.cookieStore().clear();
            ctx.redirect("/unauthorized.html");
        }
    }

    public static void logout(Context ctx) {
        ctx.cookieStore().clear();
        ctx.redirect("/");
    }
}