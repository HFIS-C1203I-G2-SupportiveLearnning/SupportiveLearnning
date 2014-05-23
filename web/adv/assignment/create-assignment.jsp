

<%@page import="entity.Role"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>

<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report Student</title>
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
                    <div style="margin: 5px 5px 6px 0px;">
                    </div>
                    <table cellspacing="0" cellpadding="0" width="100%">
                        <s:form action="createAssignment.action" method="POST" enctype="multipart/form-data">
                            <s:textfield label="Subject" name="assignment.subject" value="%{assignment.subject}" cssClass="textfield" />
                            <s:textfield label="Total mark" name="assignment.totalMark" value="%{assignment.totalMark}" cssClass="textfield" />
                            <s:textfield label="Deadline" name="assignment.deadline" value="%{assignment.deadline}" cssClass="textfield" />
                            <s:file label="Assignment File" name="upload" />
                            <s:submit value="Create" cssClass="button"/>
                        </s:form>
                    </table>
                </div>
            </div>
            <%@include file="/footer.jsp" %>
        </div>

    </body>
</html>