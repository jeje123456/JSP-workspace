const 상태들 = document.querySelectorAll('.farmCheck');

상태들.forEach((td) => {
  if (td.textContent == 'false') td.textContent = 'No';
  else td.textContent = '완료';
});
