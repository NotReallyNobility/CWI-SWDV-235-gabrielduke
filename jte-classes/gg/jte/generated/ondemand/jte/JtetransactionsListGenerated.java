package gg.jte.generated.ondemand.jte;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JtetransactionsListGenerated {
	public static final String JTE_NAME = "jte/transactionsList.jte";
	public static final int[] JTE_LINE_INFO = {1,1,4,4,4,4,8,8,8,10,10,10,11,11,11,11,16,16,21,21,21,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Map<String, String> transactions) {
		jteOutput.writeContent("\r\n<h1>All Transactions</h1>\r\n        <ul>\r\n            ");
		for (Map.Entry<String, String> entry : transactions.entrySet()) {
			jteOutput.writeContent("\r\n                <li>\r\n                    ");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(entry.getValue());
			jteOutput.writeContent("\r\n                    <form action=\"transactions/");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(entry.getKey());
			jteOutput.setContext("form", null);
			jteOutput.writeContent("\" method=\"PUT\">\r\n                        <input type=\"text\" name=\"update_body\" placeholder=\"Update Transaction\">\r\n                        <button type=\"submit\">Update</button>\r\n                    </form>\r\n                </li>\r\n            ");
		}
		jteOutput.writeContent("\r\n        </ul>\r\n        <form action=\"transactions\" method=\"POST\">\r\n            <input type=\"text\" name=\"new_item_body\" placeholder=\"New Transaction\" required>\r\n            <button type=\"submit\">Submit</button>\r\n        </form>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Map<String, String> transactions = (Map<String, String>)params.get("transactions");
		render(jteOutput, jteHtmlInterceptor, transactions);
	}
}
