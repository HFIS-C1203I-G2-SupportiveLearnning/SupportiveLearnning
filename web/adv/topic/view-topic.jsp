<%-- 
    Document   : composeReceiver
    Created on : Jan 15, 2014, 9:57:12 AM
    Author     : MyPC
--%>

<%@page import="entity.Role"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>

<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topic Detail</title>
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
                    <s:form action="saveTopic.action" method="POST" enctype="multipart/form-data">
                        <table cellspacing="0" cellpadding="0" width="100%">
                            <s:hidden value="%{topic.topicId}" name="topic.topicId" />
                            <s:select label="Objective" list="mObjective" name="topic.objId" value="%{topic.objId}" cssClass="select" />
                            <s:textfield label="Topic Name" name="topic.name" value="%{topic.name}" cssClass="textfield"/>
                            <tr>
                                <td class="tdLabel"><label for="saveTopic_file_name" class="label">File Name</label></td>
                                <td>
                                    <s:a href="%{topic.path}">${topic.fileName}</s:a>
                                </td>
                            </tr>
                            <s:file label="Change File" name="upload" value="upload" />
                            <s:submit value="Save" cssClass="button"/>
                        </table>
                    </s:form>
                </div>
            </div>
            <%@include file="/footer.jsp" %>
        </div>

    </body>
</html>