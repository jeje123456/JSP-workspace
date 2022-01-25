const 상태들 = document.querySelectorAll('.status');

상태들.forEach((td) => {
  if (td.textContent == 'false') td.textContent = '진행중';
  else td.textContent = '완료';
});
