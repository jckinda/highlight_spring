<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>sse demo</title>
<script type="text/javascript" src="assets/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		if (!!window.EventSource) {
			var source = new EventSource("push");
			s = '';
			source.addEventListener('message', function(e) {
				s += e.data + "<br />";
				$("#msgFrompPush").html(s);
			});

			source.addEventListener('open', function(e) {
				console.log("open#连接打开.");
			}, false);
			
			source.addEventListener('error', function(e){
				if(e.readyState == EventSource.CLOSED){
					console.log('连接关闭');
				}else{
					console.log("error#"+e.readyState);
				}
			},false);
		}else{
			console.log("你的浏览器不支持SSE");
		}
	});
</script>
</head>
<body>
	<div id="msgFrompPush"></div>
</body>
</html>