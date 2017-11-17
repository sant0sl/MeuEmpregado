function fMasc(objeto,mascara) {
	obj=objeto
	masc=mascara
	setTimeout("fMascEx()",1)
}
function fMascEx() {
	obj.value=masc(obj.value)
}
function maskCPF(cpf){
	cpf=cpf.replace(/\D/g,"")
	cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2")
	cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2")
	cpf=cpf.replace(/(\d{3})(\d{1,2})$/,"$1-$2")
	return cpf
}
function maskTel(tel) {
	tel=tel.replace(/\D/g,"")
	tel=tel.replace(/^(\d)/,"($1")
	tel=tel.replace(/(.{3})(\d)/,"$1)$2")
	if(tel.length == 9) {
		tel=tel.replace(/(.{1})$/,"-$1")
	} else if (tel.length == 10) {
		tel=tel.replace(/(.{2})$/,"-$1")
	} else if (tel.length == 11) {
		tel=tel.replace(/(.{3})$/,"-$1")
	} else if (tel.length == 12) {
		tel=tel.replace(/(.{4})$/,"-$1")
	} else if (tel.length > 12) {
		tel=tel.replace(/(.{4})$/,"-$1")
	}
	return tel;
}
function maskCEP(cep){
	cep=cep.replace(/\D/g,"")
	cep=cep.replace(/^(\d{2})(\d)/,"$1.$2")
	cep=cep.replace(/\.(\d{3})(\d)/,".$1-$2")
	return cep
}

function validarFormulario (){
	validarCamposObrigatorios();
	verificarTelefone();
	verificarSenha();
}

function validarCamposObrigatorios (){
	if((document.getElementById("nomeCompleto").value == "")||(document.getElementById("dataNascimento").value == "")||(document.getElementById("cfp").value == "")||(document.getElementById("rg").value == "")||(document.getElementById("cep").value == "")||(document.getElementById("enderecoRua").value == "")||(document.getElementById("enderecoNumero").value == "")||(document.getElementById("bairro").value == "")||(document.getElementById("cidade").value == "")||(document.getElementById("uf").value == "")||(document.getElementById("email").value == "")){
	alert('Por favor, preencha todos os campos que são obrigatórios!');
	document.getElementById("nomeCompleto").focus();
	return false
}

function verificarTelefone (){
	if (document.getElementById("telefoneFixo").value == "")||(document.getElementById("telefoneCelular").value == "")
	alert('Por favor, preencha ao menos um número para contato, precisamos!');
	document.getElementById("telefoneCelular").focus();
	return false
}

function verificarSenha (){
	if (document.getElementById("novaSenha").value != document.getElementById("confirmarSenha").value)
	alert('As senhas precisam se coincidir!');
	document.getElementById("novaSenha").focus();
	return false
}