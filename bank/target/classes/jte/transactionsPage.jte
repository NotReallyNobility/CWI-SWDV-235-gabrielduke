<%-- Java Imports --%>
@import java.util.Map

@param Map<String, String> transactions

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Transactions</title>
    </head>
    <body>
        <h1>All Transactions</h1>
        <ul>
            @for (Map.Entry<String, String> entry : transactions.entrySet())
                <li>
                    ${entry.getValue()}
                    <form action="transactions/${entry.getKey()}" method="PUT">
                        <input type="text" name="update_body" placeholder="Update Transaction">
                        <button type="submit">Update</button>
                    </form>
                </li>
            @endfor
        </ul>
        <form action="transactions" method="POST">
            <input type="text" name="new_item_body" placeholder="New Transaction" required>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>