<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>AJAX 연습</title>
  </head>
  <body>
    <h1>아이디를 입력시 DB검색해 결과를 출력</h1>
    아이디 입력 : <input onkeyup="sendServer()" type="text" />
    <div id="output"></div>

    <script type="text/javascript">
		// const input = input 태그중에 타입이 text인것 = 태그 타입으로 선택
      const input = document.querySelector('input[type="text"]'); //태그타입으로선택
      const output = document.getElementById('output');
      const request = new XMLHttpRequest(); //Ajax request객체 생성
      // input 태그에 이벤트속성 onkeyup을 사용 안할때 아래와 같이 이벤트리스너로 가능
      //input.addEventListener('keyup', sendServer);
      
      function sendServer() {
        //버튼을 누르면 실행되는 함수 : ajax로 서버로 http 요청
        let id = input.value; // 인풋창에 입력한 값을 파라메타로 넘김
        let url = 'getDB.jsp?id=' + id; // 요청할 서버의 jsp 페이지 주소
        request.open('GET', url, true);
        request.send();
        request.onreadystatechange = getInfo;
      }
      
      function getInfo() {
          if (request.readyState == 4 && request.status == 200) {
            let info = request.responseText; //요청한 결과 받기
            output.textContent = info;
          }
        };
    </script>
  </body>
</html>