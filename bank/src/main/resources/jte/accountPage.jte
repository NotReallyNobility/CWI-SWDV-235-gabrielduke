<%-- Java Imports --%>
@import java.util.Map
@import edu.cwi.UserAccount

<%-- Parameters --%>
@param String title
@param edu.cwi.UserAccount account

@template.jte.accountLayout(
    title = title,
    account = @`@template.jte.userAccount(account.getName(), account.formatBalance())`,
    detail = @`@template.jte.transactionsList(account.getTransactions())`
)