<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- jquery -->
<script type="text/javascript" src="<%=basePath %>js/jquery-1.10.2.min.js"></script>

