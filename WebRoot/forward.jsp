<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path ;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>办公室管理系统</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
</head>
<body>
<script type="text/javascript">
	alert("${msg}") ;
	window.location = "<%=basePath%>${url}" ;
</script>
</body>
</html>
