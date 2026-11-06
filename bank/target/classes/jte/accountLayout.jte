<%-- Java Imports --%>
@import java.util.Map

<%-- Parameters --%>
@param String title
@param gg.jte.Content account
@param gg.jte.Content detail

<html>
    <head>
        <title>${title}</title>
    </head>
    <body>
        <h1>${title}</h1>
        <div>
            ${account}
        </div>
        
        <div>
            ${detail}
        </div>
    </body>
</html>