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
        <title>Email Detail</title>
        <script type="text/javascript">
            function handleChange(){
                window.location="changeObjective.action"; 
            }
        </script>
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
                    <s:form action="reportStudent.action" method="POST">
                        <table cellspacing="0" cellpadding="0" width="100%">
                            <s:select label="Class" list="mClass" name="clo.classname" value="%{clo.classname}" cssClass="select"/>
                            <s:select label="Objective" list="mObjective" name="ojto.objId" value="%{ojto.objId}" cssClass="select" />
                            <s:select label="Topic" list="mTopic" name="tpo.topicId" value="%{tpo.topicId}" cssClass="select"/>
                            <s:textfield label="Over Mark" name="stdo.strMark" value="%{stdo.strMark}" cssClass="textfield" />
                            
                            <s:submit value="Report" cssClass="button"/>
                        </table>
                    </s:form>
                </div>
                
                <div>
                    <table cellspacing="0" cellpadding="0" width="100%">
                        <tr>
                            <th>RollNo</th>
                            <th>Full Name</th>
                            <th>Email</th>
                            <th>Mark</th>   
                        </tr>
                        <s:iterator value="students">
                            <tr>
                                <td>${rollNo}</td>
                                <td>${fullName}</td>
                                <td>${email}</td>
                                <td>${mark}</td>
                            </tr>
                        </s:iterator>
                    </table>
                </div>
            </div>
            <%@include file="/footer.jsp" %>
        </div>

    </body>
</html>