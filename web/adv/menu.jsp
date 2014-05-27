<%@ taglib prefix="s" uri="/struts-tags" %>
     
<div id="menu">
    <ul class="drop_menu">
        <li><s:a href="#">Statistics</s:a>
            <ul>
                <li><s:a href="preReportBySubmitted.action">Statistics student submitted</s:a></li>
                <li><s:a href="preReportByMark.action">Statistics student by mark</s:a></li>
                <li><s:a href="preReportByType.action">Statistics student by type</s:a></li>
            </ul>
        </li>
        <li><a href='#'>Topic</a>
            <ul>
                <li><s:a href="preCreateTopic.action">Create topic</s:a></li>
                <li><s:a href="listTopic.action">List to topic</s:a></li>
            </ul>
        </li>
        <li><a href='#'>Teacher</a>
            <ul>
                <li><s:a href="preCreateAssignment.action">Create assignment</s:a></li>
                <li><s:a href="listAssignment.action">List to assignment</s:a></li>
                <li><s:a href="preMarkByMark.action">Mark result</s:a></li>
            </ul>
        </li>
        <li><a href='#'>Administrator</a>
        </li>
        <li><a href='#'>Student</a></li>
        <li><a href='#'>Feedback</a></li>
        <li><a href='#'>FAQ</a></li>
    </ul>
</div>