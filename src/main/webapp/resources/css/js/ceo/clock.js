var clockTarget1 = document.getElementById("clock1");
var clockTarget2 = document.getElementById("clock2");

function clock1() {
    var date = new Date();
    var year = date.getFullYear();

    var month = date.getMonth();
    // 달을 받아옵니다 
        month = month + 1;
    var clockDate = date.getDate();
    // 몇일인지 받아옵니다 
    var day = date.getDay();
    // 요일을 받아옵니다. 
    var week = ['일', '월', '화', '수', '목', '금', '토'];
    // 요일은 숫자형태로 리턴되기때문에 미리 배열을 만듭니다.
   
    //clockTarget1 .innerText = `${year}. ${month < 10 ? `0${month}` : month}. ${clockDate < 10 ? `0${clockDate}` : clockDate} ${week[day]}요일`;
    clockTarget1 .innerText = `${year}. ${month < 10 ? `0${month}` : month}. ${clockDate < 10 ? `0${clockDate}` : clockDate}`;
    // 월은 0부터 1월이기때문에 +1일을 해줍니다.
}
function clock2() {
    var date = new Date();
   
    var hours = date.getHours();
    // 시간을 받아오고 
    var minutes = date.getMinutes();
    // 분도 받아옵니다.
    var seconds = date.getSeconds();
    // 초까지 받아온후 

     clockTarget2 .innerText = `${hours < 10 ? `0${hours}` : hours}:${minutes < 10 ? `0${minutes }`  : minutes }:${seconds < 10 ? `0${seconds }`  : seconds }`; 
}
function init() {
clock1();
clock2();
// 최초에 함수를 한번 실행시켜주고 
setInterval(clock1, 1000);
setInterval(clock2, 1000);
// setInterval이라는 함수로 매초마다 실행을 해줍니다.
// setInterval은 첫번째 파라메터는 함수이고 두번째는 시간인데 밀리초단위로 받습니다. 1000 = 1초 
}
init();