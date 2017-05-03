<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>办公室管理系统</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<jsp:include page="/pages/include_javascript.jsp" />
</head>
<body class="userback">
	<div class="container contentback">
		<div id="headDiv" class="row">
			<div class="col-md-12 col-xs-12">
				<jsp:include page="/pages/include_menu_emp.jsp" />
			</div>
		</div>
		<div id="contentDiv" class="row">
			<div class="col-md-12 col-xs-12">
				<div class="panel panel-success">
					<div class="panel-heading">
						<strong>标题</strong>
					</div>
					<div class="panel-body">
						<table class="table table-bordered table-hover">
							<tr>
								<td colspan="3">
									<span class="h1"><span class="glyphicon glyphicon-user"></span>&nbsp;欢迎${emp.userid}光临！</span>
									<strong><span class="glyphicon glyphicon-envelope"></span>&nbsp;未读公告（<span class="text-danger">
										<a href="pages/jsp/emp/notice/emp_notice_list.jsp">26</a>
									</span>）</strong>
								</td>
							</tr>
							<tr>
								<td rowspan="4" style="width:130px;">
									<img src="upload/user/nophoto.jpg" class="image" style="height:128px;width:128px;">
								</td>
							</tr>
							<tr>
								<td style="width:240px;"><strong>雇员级别：</strong></td>
								<td>雇员</td>
							</tr>
							<tr>
								<td><strong>上次登录日期：</strong></td>
								<td>${emp.lastlogin}</td>
							</tr>
							<tr>
								<td colspan="2">
									<a href="pages/jsp/emp/emp/emp_password_edit.jsp" class="btn btn-primary">修改密码</a>
									<a href="pages/jsp/emp/emp/EmpUpdateAction!updatePre.action" class="btn btn-warning">完善个人资料</a>
									<a href="UserLogout!logout.action" class="btn btn-danger">登录注销</a>
								</td>
							</tr>
						</table>
					</div>
					<div class="panel-footer">
						<div class="alert alert-success" id="alertDiv" style="display: none;">
	                        <button type="button" class="close" data-dismiss="alert">&times;</button>
	                        <span id="alertText"></span>
	                    </div>
					</div>
				</div>
			</div>
		</div>
		<div id="footDiv" class="row navbar-fixed-bottom">
			<jsp:include page="/pages/include_foot.jsp" />
		</div>
	</div>
</body>
</html>
