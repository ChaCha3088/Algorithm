-- BOOK 테이블에서 2021년에 출판된 '인문' 카테고리에 속하는 도서 리스트를 찾아서 도서 ID(BOOK_ID), 출판일 (PUBLISHED_DATE)을 출력
-- 출판일을 기준으로 오름차순 정렬
SELECT B.BOOK_ID, TO_CHAR(B.PUBLISHED_DATE, 'YYYY-MM-DD') AS "PUBLISHED_DATE"
FROM BOOK B
WHERE B.CATEGORY = '인문' AND B.PUBLISHED_DATE BETWEEN TO_DATE('2021-01-01', 'YYYY-MM-DD') AND TO_DATE('2021-12-31', 'YYYY-MM-DD')
ORDER BY B.PUBLISHED_DATE