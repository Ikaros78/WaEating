function ck_infor(){
	
	let pw1 = document.getElementById("pw");
	let pw2 = document.getElementById("re_pw");
	
	// 비밀번호 일치 검사
	if(pw1.value != pw2.value){
		
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	
	
}
function chk(re, ele, msg){

     if(!re.test(ele.value)){
          alert(msg);
          ele.select();
          return false;
     }
     return true;
}