<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>converter</title>

<script type="text/javascript" src="assets/jquery.min.js"></script>
<script type="text/javascript">
function req(){
	$.ajax({
		url:"convert",
		data:"1-wangyufei",
		type:"post",
		contentType:"application/x-wisely",
		success:function(data){
			$("#resp").html(data);
		}
	})
}
</script>
</head>


<body>
<div id="resp">111</div><input type="button" value ="request" onclick="req();" />
</body>
</html>