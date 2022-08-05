window.onload = function(){
	
	if(document.getElementById("logout")){
		const $logout = document.getElementById("logout");
		$logout.onclick = function(){
			location.href = "/WaEating/common/logout";
		}		
	}
	
	if(document.getElementById("loginAdmin")){
		const $login = document.getElementById("loginAdmin");
		$login.onclick = function(){
			location.href = "/WaEating/admin/login";
		}
	}
	
}