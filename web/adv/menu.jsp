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
        <li><a href='#'>Administrator</a>
        </li>
        <li><a href='#'>Teacher</a>
        </li>
        <li><a href='#'>Student</a></li>
        <li><a href='#'>Feedback</a></li>
        <li><a href='#'>FAQ</a></li>
    </ul>
</div>