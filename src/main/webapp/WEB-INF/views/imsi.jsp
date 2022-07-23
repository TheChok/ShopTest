<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>배경화면 색상 변경</h1>


<input type="text" id=target01/>
<button type="button" onclick="colroset(1)">녹색</button>
<input type="text" id=target02/>
<button type="button" onclick="colorset(2)">노랑색</button>
<input type="text" id=target03/>
<button type="button" onclick="colorset(3)">주황색</button>


<script type="text/javascript">
function colorset( num ) {
	
	if(num == 1){
		$("#target01").bgColor = "green";
	}
	if(num == 2){
		$("#target02").bgColor = "yellow";
	}
	if(num == 3){
		$("#target03").bgColor = "orange";
	}
	
	
}
</script>

</body>
</html>