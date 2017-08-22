/**
 * 
 */
/**
 * 
 */


function cWrite(){
	alert("wow");
	var ct = document.reply.value;
    alert(ct);
    alert("wow");
    return ;
}

function infoConfirm(){
	
	
	
	if(document.reg_frm.uid.value.length==0){
		alert("아이디는 필 수 사항입니다.");
		reg_frm.uid.focus();
		return;
	}
	
	if(document.reg_frm.uid.value.length < 4){
		alert("아이디는 4글자 이상이어야 합니다.");
		reg_frm.uid.focus();
		return;
	}
	
	if(document.reg_frm.uname.value.length==0){
		alert("이름은 필 수 사항입니다.");
		reg_frm.uname.focus();
		return;
	}
	
	if(document.reg_frm.upasswd.value.length==0){
		alert("비밀번호는 필 수 사항입니다.");
		reg_frm.upasswd.focus();
		return;
	}
	
	if(document.reg_frm.upasswd.value != document.reg_frm.pw_check.value){
		alert("비밀번호가 일치하지 않습니다.");
		reg_frm.upasswd.focus();
		return;
	}
	
	/*if(document.reg_frm.ubirth.value.length==0){
		alert("생년월일은 필 수 사항입니다.");
		reg_frm.ubirth.focus();
		return;
	}*/
	
	if(document.reg_frm.umail.value.length==0){
		alert("이메일은 필 수 사항입니다.");
		reg_frm.umail.focus();
		return;
	}
	
	document.reg_frm.submit();
}


function updateinfoConfirm(){
	
	if(document.reg_frm.uname.value==""){
		alert("이름을 입력하세요.");
		reg_frm.uname.focus();
		return;
	}
	
	
	if(document.reg_frm.umail.value.length==0){
		alert("이메일을 입력하세요.");
		reg_frm.umail.focus();
		return;
	}
	
	
	if((document.reg_frm.chk_pass.value!="") && (document.reg_frm.new_pass.value!="") && (document.reg_frm.chk_new_pass.value!="")) {
		
		if((document.reg_frm.chk_pass.value!=document.reg_frm.upasswd.value)&&(document.reg_frm.right.value!=1)){
			
			document.reg_frm.chk_pass.value="";
			document.reg_frm.chk_pass.focus();
			document.reg_frm.right.value=0;
			alert("현재 비밀번호를 확인해주세요.");
			return ;
		}
		
		if(document.reg_frm.new_pass.value != document.reg_frm.chk_new_pass.value) {
			document.reg_frm.new_pass.value="";
			document.reg_frm.chk_new_pass.value="";
			document.reg_frm.new_pass.focus();
			alert("신규 비밀번호를 확인해 주세요.");
			return ;
		}
		
		if(document.reg_frm.new_pass.value == document.reg_frm.upasswd.value) {
			document.reg_frm.new_pass.value="";
			document.reg_frm.chk_new_pass.value="";
			document.reg_frm.new_pass.focus();
			alert("현재 비밀번호와 일치합니다.");
			return ;
		}
		document.reg_frm.upasswd.value=document.reg_frm.new_pass.value;
	}
	
	document.reg_frm.submit();
}

function passwd_chk(){
	if(document.reg_frm.upasswd.value == document.reg_frm.chk_pass.value) {
		alert("입력한 비밀번호가 일치합니다.");
		document.reg_frm.right.value=1;
	} else {
		alert("비밀번호가 일치하지 않습니다.");
		document.reg_frm.right.value=0;
	}
}