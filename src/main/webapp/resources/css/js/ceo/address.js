  function address_kakao() {
            new daum.Postcode({
                oncomplete: function(data) { //선택시 입력값 세팅
                    document.getElementById("address_kakao").value = data.address; // 주소 넣기
                }
            }).open();
    }

    window.onload = function(){
        document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
    
            new daum.Postcode({
                oncomplete: function(data) { //선택시 입력값 세팅
                    document.getElementById("address_kakao").value = data.address; // 주소 넣기
                }
            }).open();
        });
    }
    