package gg.jte.generated.ondemand.jte;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JteaccountLayoutGenerated {
	public static final String JTE_NAME = "jte/accountLayout.jte";
	public static final int[] JTE_LINE_INFO = {1,1,4,4,4,4,10,10,10,10,13,13,13,15,15,15,19,19,19,22,22,22,4,5,6,6,6,6};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, gg.jte.Content account, gg.jte.Content detail) {
		jteOutput.writeContent("\r\n<html>\r\n    <head>\r\n        <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</title>\r\n    </head>\r\n    <body>\r\n        <h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</h1>\r\n        <div>\r\n            ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(account);
		jteOutput.writeContent("\r\n        </div>\r\n        \r\n        <div>\r\n            ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(detail);
		jteOutput.writeContent("\r\n        </div>\r\n    </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.get("title");
		gg.jte.Content account = (gg.jte.Content)params.get("account");
		gg.jte.Content detail = (gg.jte.Content)params.get("detail");
		render(jteOutput, jteHtmlInterceptor, title, account, detail);
	}
}
