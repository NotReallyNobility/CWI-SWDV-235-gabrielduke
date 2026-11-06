package gg.jte.generated.ondemand.jte;
@SuppressWarnings("unchecked")
public final class JteuserAccountGenerated {
	public static final String JTE_NAME = "jte/userAccount.jte";
	public static final int[] JTE_LINE_INFO = {1,1,1,1,1,5,5,5,5,6,6,6,6,6,6,1,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String name, String balance) {
		jteOutput.writeContent("\r\n<h1>User Info</h1>\r\n<p> Account Holder's Name: ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(name);
		jteOutput.writeContent("</p>\r\n<p> Account Balance: ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(balance);
		jteOutput.writeContent("</p>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String name = (String)params.get("name");
		String balance = (String)params.get("balance");
		render(jteOutput, jteHtmlInterceptor, name, balance);
	}
}
