<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="data_list">
	<div class="data_info">
		<p>考生成绩列表</p>
	</div>
	<div class="search_content">
		<form action="${pageContext.request.contextPath}/exam_moreCondition.action" method="post">
			<table align="center">
				<tr>
					<td><label>准考证号：</label></td>
					<td><input type="text" id="s_id" name="student.stuid" value="${student.stuid }"/></td>
					<td>&nbsp;</td>
					<td><label>姓名：</label></td>
					<td><input type="text" id="s_name" name="student.stuname" value="${student.stuname }"/></td>
					<td>&nbsp;</td>
					<td><button class="btn btn-primary" style="margin-bottom: 8px;" type="submit" >查询</button></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="data_content">
		<table class="table table-bordered table-hover">
			 <tr>
				<th>序号</th>
				<th>准考证号</th>
				<th>考生姓名</th>
				<th>试卷名称</th>
				<th>考试日期</th>
				<th>单选题得分</th>
				<th>多选题得分</th>
				<th>总分</th>
			</tr>
			<c:forEach var="exam" items="${examList}" varStatus="status" >
				<tr>
					<td>${status.index+1 }</td>
					<td>${exam.student.stuid }</td>
					<td>${exam.student.stuname }</td>
					<td>${exam.paper.paperName }</td>
					<td><fmt:formatDate value="${exam.examDate }" type="date" pattern="yyyy-MM-dd"/></td>
					<td>${exam.singleScore }</td>
					<td>${exam.moreScore }</td>
					<td><font color="red">${exam.score }</font></td>
				</tr>
			</c:forEach>
	  </table>
	</div>
	<div class="pagination pagination-centered">
	 	 <ul>
	    	${pageCode }
	 	 </ul>
	</div>
</div>