

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mail Management</title>
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
                            <th>Subject</th>
                            <th>Total Mark</th>
                            <th>Deadline</th>
                            <th>File Name</th>
                            <th>Size</th>
                        </tr>
                        <s:iterator value="assignments">
                                <td>${subject}</td>
                                <td>${totalMark}</td>
                                <td>${deadline}</td>
                                <td><a href="${path}">${fileName}</a></td>
                                <td>${size} KB</td>
                        </s:iterator>
                    </table>
                </div>
            </div>
            <%@include file="/footer.jsp" %>
        </div>

    </body>
</html>
