<%-- 
    Document   : view-user
    Created on : Jan 11, 2014, 2:35:42 AM
    Author     : MinhPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supportive Learning - Administrator Page</title>
    </head>
    <body>
        <div class="main">
            <%--<s:if test="%{#session.user!=null}">--%>
                <%@include file="../header.jsp" %>
                <%@include file="menu.jsp" %>
                <div id="body" style="height: 1000px">
                </div>
                <%@include file="/footer.jsp" %>
            <%--</s:if>--%>
            <%--<s:else>--%>
                <!--<META HTTP-EQUIV="Refresh" CONTENT="0;URL=viewLogin.action">-->
            <%--</s:else>--%>
        </div>

    </body>
</html>
