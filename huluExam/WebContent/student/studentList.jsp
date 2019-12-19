<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function studentDelete(studentId){
		if(confirm("确定要删除这条记录吗?")){
			$.post("student_deleteStudent",{stuid:studentId},
				function(result){
					
					
						alert("删除成功！");
						window.location.href="${pageContext.request.contextPath}/student_moreCondition.action";
					
				}
			);
		}
	}
</script>
<div class="data_list">
	<div class="data_info">
		<p>考生信息管理</p>
	</div>
	<div class="search_content">
		<form action="${pageContext.request.contextPath}/student_moreCondition.action" method="post">
			<table align="center">
				<tr>
					<td><label>准考证号：</label></td>
					<td><input type="text" id="s_id" name="stuid" value="${student.stuid }"/></td>
					<td>&nbsp;</td>
					<td><label>姓名：</label></td>
					<td><input type="text" id="s_name" name="stuname" value="${student.stuname }"/></td>
					<td>&nbsp;</td>
					<td><button class="btn btn-primary" style="margin-bottom: 8px;" type="submit" >查询</button></td>
				</tr>
			</table>
		</form>
		<button class="btn-mini btn-primary" style="float: right;margin-bottom: 5px;" type="button" onclick="javascript:window.location='student_toAddStudent.action'">添加考生信息</button>
	</div>
	<div class="data_content">
		<table class="table table-bordered table-hover">
			 <tr>
				<th>序号</th>
				<th>准考证号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>身份证</th>
				<th>密码</th>
				<th>专业</th>
				<th>操作</th>
			</tr>
			<c:forEach var="studenta" items="${pageBean.list}" varStatus="status" >
				<tr>
					<td>${status.index+1 }</td>
					<td>${studenta.stuid }</td>
					<td>${studenta.stuname }</td>
					<td></td>
					<td></td>
					<td>${studenta.stupassword }</td>
					<td></td>
					<td><button class="btn-mini btn-info" type="button" onclick="javascript:window.location='student_preSave?stuid=${studenta.stuid }'">修改</button>&nbsp;&nbsp;<button class="btn-mini btn-danger" type="button" onclick="studentDelete('${studenta.stuid }')">删除</button></td>
				</tr>
			</c:forEach>
			
	  </table>
	</div>
	<div class="pagination pagination-centered">
		共[<B>${pageBean.totalCount}</B>]条记录,共[<B>${pageBean.totalPage}</B>]页
		,当前第[<b>${pageBean.currentPage}</b>]页
	 	 <c:if test="${pageBean.currentPage!=1 }">
				[<A href="${pageContext.request.contextPath }/student_studentList.action?currentPage=${pageBean.currentPage-1}">前一页</A>]
			</c:if>
			<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
				[<A href="${pageContext.request.contextPath }/student_studentList.action?currentPage=${pageBean.currentPage+1}">后一页</A>]
			</c:if>
	 	
	</div>
</div>