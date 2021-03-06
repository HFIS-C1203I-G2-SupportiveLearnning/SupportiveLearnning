

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment List</title>
    </head>
    <body>
        <div class="main">
            <%@include file="../../header.jsp" %>
            <%@include file="../menu.jsp" %>

            <div id="body">
                <div>
                    <s:actionerror/>
                </div>
                <div>
                    <table cellspacing="0" cellpadding="0" width="100%">
                        <tr>
                            <th width="3%">Index</th>
                            <th width="15%">Class</th>
                            <th>Topic</th>
                            <th width="6%">Deadline</th>
                        </tr>
                        <%
                            int i = 1;
                        %>
                            <s:iterator value="assignments">
                                <tr>
                                    <td><%=i++%></td>
                                    <td>${classname}</td>
                                    <td>${name}</td>
                                    <td>${deadline}</td>
                                </tr>
                            </s:iterator>
                    </table>
                </div>
            </div>
            <%@include file="/footer.jsp" %>
        </div>

    </body>
</html>
