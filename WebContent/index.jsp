

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Acadêmico</title>
<style type="text/css">
	
	body{
	margin: 0;
	padding: 0;
	background: #0c002b;
	font-family: sans-serif;
}
a{
	
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: #1670f0;
	padding: 30px 60px;
	font-size: 30px;
	letter-spacing: 2px;
	text-transform: uppercase;
	text-decoration: none;
	box-shadow: 0 20px 50px rgba(0,0,0,0.5);
	overflow: hidden;

}
a:before
{
	content: '';
	
	top: 2px;
	left: 2px;
	bottom: 2px;
	width: 50%;
	background: rgba(255,255,255,0.05);
}

a span:nth-child(1){
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 2px;
	background: linear-gradient(to right, #0c002b, #1779ff);

	animation: animate1 2s linear infinite;
	animation-delay: 1s;
}
@keyframes animate1{
	0%{
		transform: translateX(-100%);
	}
	100%{
		transform: translateX(100%);
	}
}
a span:nth-child(2){
	position: absolute;
	top: 0;
	right: 0;
	width: 2px;
	height: 100%;
	background: linear-gradient(to bottom, #0c002b, #1779ff);

	animation: animate2 2s linear infinite;
}
@keyframes animate2{
	0%{
		transform: translateY(-100%);
	}
	100%{
		transform: translateY(100%);
	}
}
a span:nth-child(3){
	position: absolute;
	bottom: 0;
	left: 0;
	width: 100%;
	height: 2px;
	background: linear-gradient(to left, #0c002b, #1779ff);

	animation: animate3 2s linear infinite;
	animation-delay: 1s;
}
@keyframes animate3{
	0%{
		transform: translateX(100%);
	}
	100%{
		transform: translateX(-100%);
	}
}
a span:nth-child(4){
	position: absolute;
	top: 0;
	left: 0;
	width: 2px;
	height: 100%;
	background: linear-gradient(to top, #0c002b, #1779ff);

	animation: animate4 2s linear infinite;
}
@keyframes animate4{
	0%{
		transform: translateY(100%);
	}
	100%{
		transform: translateY(-100%);
	}
}
h1 {
	color: white;
}
</style>
<link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
	<h1 align="center">Cadastro de Alunos</h1>
	<center><div><a href="incluir.jsp">
			<span></span>
		<span></span>
		<span></span>
		<span></span>Incluir Alunos
		</a></div>
		<br />
		<div><a
			href="atualizar.jsp">
			Alterar Alunos
		</a></div>
		 <br /> 
		 <div><a
			href="consultar.jsp">
			Consultar Alunos
		</a></div>
			<br />
			<div><a
			href="excluir.jsp">
			Excluir Alunos
		</a></div>
			 <br /> 
			 <div><a
			href="ServletAlunos?cmd=listar">
			Listar Alunos
		</a></div>
			<br />
	</center>
</body>
</html>