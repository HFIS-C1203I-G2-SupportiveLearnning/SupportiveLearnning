<%-- 
    Document   : composeReceiver
    Created on : Jan 15, 2014, 9:57:12 AM
    Author     : MyPC
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="entity.Role"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>

<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mark Student</title>
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
                    <%--<s:actionerror/>--%>
                </div>
                
                <div>
                    <s:form action="markByMark.action" method="POST">
                        <table cellspacing="0" cellpadding="0" width="100%">
                            <s:select label="Class" list="mClass" name="clo.classname" value="%{clo.classname}" cssClass="select"/>
                            <s:select label="Objective" list="mObjective" name="ojto.objId" value="%{ojto.objId}" cssClass="select" />
                            <s:select label="Topic" list="mTopic" name="tpo.topicId" value="%{tpo.topicId}" cssClass="select"/>
                            <s:hidden name="stdo.strMark" value="-1" />
                            
                            <s:submit value="Search" cssClass="button"/>
                        </table>
                    </s:form>
                </div>
                                
                <div class="new">
                    <table cellspacing="0" cellpadding="0" width="100%">
                        <tr>
                            <th width="3%">Index</th>
                            <th>Class</th>
                            <th>Topic</th>
                            <th>Roll No</th>
                            <th>Full Name</th>
                            <th width="3%">Mark</th>   
                        </tr>
                        <%
                            int i = 1;
                        %>
                        <s:iterator value="students">
                            <tr>
                                <td><%=i++%></td>
                                <td>${classname}</td>
                                <td>${topicName}</td>
                                <td>${rollNo}</td>
                                <td>${fullName}</td>
                                <td><s:a href="#" onclick="return prompt('Please enter mark', '')"><img src="img/mark.png" alt="Mark Result" /></s:a></td>
                            </tr>
                        </s:iterator>
                    </table>
                </div>
            </div>
            <%@include file="/footer.jsp" %>
        </div>

    </body>
</html>