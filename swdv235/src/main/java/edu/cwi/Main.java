package edu.cwi;

import io.javalin.Javalin;
/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        var app = Javalin.create( config -> {
            config.routes.get("/hello/{name}", ctx -> {
                ctx.result("Hello, " + ctx.pathParam("name"));
            }); 

            config.routes.get("/hello/{name}/html", ctx -> {
                ctx.html("<html>" +
                            "<head>" +
                                "<title>Javalin Intro</title>" +
                            "</head>" +
                            "<body>" +
                                "<h1>Hello, " + ctx.pathParam("name") + "</h1>" +
                            "</body>" +
                        "</html>");
            }); 
        }).start(7070);

        // System.out.println( "Hello World!" );
    }
}
