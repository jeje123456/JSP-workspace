<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
  table {
    width: 100%;
    table-layout: fixed;
  }

  table th,
  td {
    /* !important : 무조건 적용시킴(우선순위 최상위) -> bootstrap랑 겹쳤을때 bootstrap보다 먼저 적용되게 */
    /* '수정' '삭제'단어를 세로로 표시하지말고 붙여서 표시해라 */
    word-break: keep-all !important;
    /* 테이블 안의 th, td안의 내용을 세로로 가운데 정렬 */
    vertical-align: middle !important;
  }

  .th-1 {
    width: 3%;
    padding-left: 3px !important;
    padding-right: 3px !important;
  }

  .th-2 {
    width: 10%;
  }
</style>

<jsp:include page="/includes/header.jsp" />

<div class="container-fluid">
  <div class="font-weight-bold mt-3 shadow p-3 mb-4 bg-light rounded">주문 내역 관리</div>

  <table class="table table-hover">
    <thead>
      <tr>
        <th class="th-1">주문</th>
        <th class="th-1">cart</th>
        <th>고객ID</th>
        <th>고객이름</th>
        <th class="th-2">고객 주소</th>
        <th class="th-2">고객 연락처</th>
        <th>총결제금액</th>
        <th>농민ID</th>
        <th class="th-2">농민 연락처</th>
        <th class="th-1">발주</th>
        <th class="th-2">송장 번호</th>
        <th>배송현황</th>
        <th width="4%">&nbsp;</th>
        <th width="4%">&nbsp;</th>
      </tr>
    </thead>
    <tbody>
      <!-- controller 에서 저장한 ordersList(변수 : List<ManagerOrder> ordersList)가 여기로 넘어옴 -->
      <c:forEach var="order" items="${ordersList}">
        <tr>
          <td><c:out value="${order.orderID}" /></td>
          <td><c:out value="${order.cartID}" /></td>
          <td><c:out value="${order.userID}" /></td>
          <td><c:out value="${order.userName}" /></td>
          <td><c:out value="${order.userAdd}" /></td>
          <td><c:out value="${order.userTel}" /></td>
          <td><c:out value="${order.totalPrice}" /></td>
          <td><c:out value="${order.farmID}" /></td>
          <td><c:out value="${order.farmTel}" /></td>
          <td class="farmCheck"><c:out value="${order.farmCheck}" /></td>
          <td><c:out value="${order.trackNum}" /></td>
          <td><c:out value="${order.is_status}" /></td>
          <td>
            <button type="button" class="btn btn-info btn-sm btn-edit" data-id="<c:out value='${contact.id}' />">수정</button>
          </td>
          <td>
            <button type="button" class="btn btn-danger btn-sm btn-delete" data-id="<c:out value='${contact.id}' />" data-toggle="modal" data-target="#modal-delete">삭제</button>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<jsp:include page="/includes/footer.jsp" />

<script src="https://cdn.datatables.net/v/bs4/dt-1.10.24/datatables.min.js"></script>

<script>
  $('.nav-link').removeClass('active');
  $('#m-order').addClass('active');
  var path = '<%= request.getContextPath() %>';
</script>

<script src="assets/js/ordersList.js"></script>
