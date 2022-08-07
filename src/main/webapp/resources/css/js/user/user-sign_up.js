function ck_infor(){
	
	let name = document.getElementById("name");
	let phone = document.getElementById("phone");
	let pw1 = document.getElementById("pw");
	let pw2 = document.getElementById("re_pw");
	
	// 이름 검사
	// 2글자 이상, 한글만
	if(!chk(/^[가-힣]{2,}$/, name, "이름은 한글로 2글자 이상으로 넣으세요.")){

    	return false;
    }
	
	// 전화번호 검사
	// 전화번호는 11자
	if(!chk(/^[0-9]{11}$/, phone, "전화번호는 '-'없이 11자리 숫자입니다.")){
		
		return false;
	}
	
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


