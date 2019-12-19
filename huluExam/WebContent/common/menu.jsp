<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">

	function logout(){
		if(confirm('您确定要退出系统吗？')){
			window.location.href='index.jsp';
		}
	}
	
	function logout2(){
		if(confirm('您确定要退出系统吗？')){
			window.location.href='index2.jsp';
		}
	}
	
</script>
<div class="navbar">
  <div class="navbar-inner">
    <a class="brand" href="main.jsp">首页</a>
    <ul class="nav">
    	<c:choose>
    		<c:when test="${currentUser.flag==1}">
    			<li><a href="${pageContext.request.contextPath}/student_studentList.action?currentPage=1">考生信息管理</a></li>
    			<li><a href="${pageContext.request.contextPath}/exam_getStudentScore.action">考生成绩查询</a></li>
    			<li><a href="${pageContext.request.contextPath}/paper_paperList.action">试卷管理</a></li>
    			<li><a href="${pageContext.request.contextPath}/question_questionList.action">题目管理</a></li>
    			<li><a href="javascript:logout2()">退出系统</a></li>
    		</c:when>
    		<c:otherwise>
		    	<li><a href="${pageContext.request.contextPath}/paper_selectPaper.action">在线考试</a></li>
		    	<li><a href="${pageContext.request.contextPath}/exam_queryScore.action?student.stuid=${currentUser.stuid}">成绩查询</a></li>
		    	<li><a href="${pageContext.request.contextPath}/student_updatePassword.action">修改密码</a></li>
		    	<li><a href="javascript:logout()">退出系统</a></li>
    		</c:otherwise>
    	</c:choose>
    </ul>
  </div>
</div>