<html>
<head>
	<title>student</title>
</head>
<body>
	学生信息：<br>
	学号：${student.id}
	姓名：${student.name}
	年龄：${student.age}
	<table>
	<#list studentList as student>
		<tr>	
			<td>${student.id}</td> <td>${studnet.name}</td>
		</tr>
	</#list>
	</table>
</body>
</html>