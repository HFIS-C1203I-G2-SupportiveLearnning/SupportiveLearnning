<%-- 
    Document   : view-user
    Created on : Jan 11, 2014, 2:35:42 AM
    Author     : MyPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topic List</title>
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
                            <th width="15%">Objective</th>
                            <th>Topic Name</th>
                            <th width="20%">Topic File</th>
                            <th width="2%" colspan="2">Action</th>
                        </tr>
                        <%
                            int i = 1;
                        %>
                            <s:iterator value="topics">
                                <tr>
                                    <td><%=i++%></td>
                                    <td>${objName}</td>
                                    <td>${name}</td>
                                    <td><a href="${path}">${fileName}</a></td>
                                    <td><s:a href="viewTopic.action?topic.topicId=%{topicId}"><img src="img/edit.png" alt="Edit Topic" /></s:a></td>
                                    <td><s:a href="deleteTopic.action?topic.topicId=%{topicId}" onclick="return confirm('Are you sure you want to delete this record')"><img src="img/delete.png" alt="Delete Topic" /></s:a></td>
                                </tr>
                            </s:iterator>
                    </table>
                </div>
            </div>
            <%@include file="/footer.jsp" %>
        </div>

    </body>
</html>
