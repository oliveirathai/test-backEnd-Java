<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Cadastro de Jogadores</title>
</head>
<body>
	<form action="/add-jogador" method="post">
		<table align="center">
			<tr>
				<td colspan="2">
					<h2>Formulário de Cadastro de Jogador</h2>
				</td>
			</tr>

			<tr>
				<td width="122"><b>Nome:</b></td>
				<td align="left"><input type="text" name="Nome" required=""
					placeholder="Nome"
					oninvalid="this.setCustomValidity('Informe um nome')"
					oninput="setCustomValidity('')" size="40" maxlength="40"></td>
			</tr>
			<tr>
				<td width="122"><b>Email:</b></td>
				<td align="left"><input type="email" name="Email" required=""
					placeholder="E-mail"
					oninvalid="this.setCustomValidity('Informe um E-mail válido')"
					oninput="setCustomValidity('')" size="40" maxlength="40"></td>
			</tr>
			<tr>
				<td width="122"><b>Telefone: </b></td>
				<td align="left"><input type="tel" name="Telefone" required=""
					placeholder="Telefone"
					oninvalid="this.setCustomValidity('Informe um telefone válido')"
					oninput="setCustomValidity('')" size="11" maxlength="11"></td>
			</tr>
			<tr>
				<td></td>
				<td>Quero ser do grupo :</td>
			</tr>
			<tr>
				<td></td>
				<td><INPUT TYPE="RADIO" NAME="Time" VALUE="Vingadores">
					Vingadores <INPUT TYPE="RADIO" NAME="Time" VALUE="liga_da_justica">
					Liga da Justiça</td>
			</tr>
			<tr>
				<td align="left" width="122">
					<p align="center">&nbsp;
				</td>
				<td align="left">
					<p>
						<input type="submit" value="Cadastrar">
				</td>
			</tr>
		</table>
		</center>
	</form>
	<center>
		<form action="/lista-jogadores" method="get">
			<input type="submit" value="Listar Jogadores" />
		</form>
	</center>
</body>
</html>
