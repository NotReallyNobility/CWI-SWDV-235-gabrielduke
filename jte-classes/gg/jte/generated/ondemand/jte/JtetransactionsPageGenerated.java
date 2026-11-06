package gg.jte.generated.ondemand.jte;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JtetransactionsPageGenerated {
	public static final String JTE_NAME = "jte/transactionsPage.jte";
	public static final int[] JTE_LINE_INFO = {1,1,3,3,3,3,14,14,14,16,16,16,17,17,17,17,22,22,29,29,29,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Map<String, String> transactions) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html>\r\n    <head>\r\n        <meta charset=\"utf-8\">\r\n        <title>Transactions</title>\r\n    </head>\r\n    <body>\r\n        <h1>All Transactions</h1>\r\n        <ul>\r\n            ");
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
		jteOutput.writeContent("\r\n        </ul>\r\n        <form action=\"transactions\" method=\"POST\">\r\n            <input type=\"text\" name=\"new_item_body\" placeholder=\"New Transaction\" required>\r\n            <button type=\"submit\">Submit</button>\r\n        </form>\r\n    </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Map<String, String> transactions = (Map<String, String>)params.get("transactions");
		render(jteOutput, jteHtmlInterceptor, transactions);
	}
}
