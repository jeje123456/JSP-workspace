<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <!-- bootstrap, datatables, css, favicon -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdn.datatables.net/v/bs4/dt-1.10.24/datatables.min.css" />
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/style.css" />
    <link rel="shortcut icon" href="<%= request.getContextPath() %>/assets/images/contact.png" type="image/x-icon" />
    <title>못난이 농산품</title>
  </head>
  <body>
    <header>
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a id="m-home" class="nav-link" href="<%= request.getContextPath() %>/manager">🥦못난이 농산품</a>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <a id="m-product" class="nav-link" href="<%= request.getContextPath() %>/manager/product">농산물</a>
            <a id="m-review" class="nav-link" href="<%= request.getContextPath() %>/manager/review">리뷰</a>
            <a id="m-member" class="nav-link" href="<%= request.getContextPath() %>/manager/member">농민·회원 관리</a>
            <a id="m-order" class="nav-link" href="<%= request.getContextPath() %>/manager/order">주문 내역 관리</a>
          </div>
          <button class="login" type="button">로그인</button>
        </div>
      </nav>
    </header>
  </body>
</html>
