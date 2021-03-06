

<%@page import="entity.Role"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>

<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Assignment</title>
    </head>
    <body>
        <div class="main">
            <%@include file="../../header.jsp" %>
            <%@include file="../menu.jsp" %>

            <div id="body">
                <div>
                    <s:actionerror/>
                    <s:actionmessage/>
                </div>
                <div>
                    <s:form action="saveAssignment.action" method="POST" enctype="multipart/form-data">
                        <table cellspacing="0" cellpadding="0" width="100%">
                             <tr>
                                <td class="tdLabel" colspan="2" align="right">
                                    <s:a href="preCreateNewTopic.action">Create with new topic</s:a>
                                </td>
                            </tr>
                            <s:select label="Topic" list="mTopic" name="asmo.topicId" value="%{topic.topicId}" cssClass="select" />
                            <s:select label="Class" list="mClass" name="asmo.classname" value="%{asmo.classname}" cssClass="select" />
                            <s:textfield label="Deadline (dd/mm/yyyy)" name="asmo.deadline" value="%{asmo.deadline}" cssClass="textfield"/>
                            <s:submit value="Create" cssClass="button"/>
                        </table>
                    </s:form>
                </div>
            </div>
            <%@include file="/footer.jsp" %>
        </div>

    </body>
</html>