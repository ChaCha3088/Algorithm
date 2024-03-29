-- SELECT 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일

-- WHERE 2022년 10월에 작성
-- ORDER BY 댓글 작성일을 기준으로 오름차순 정렬해주시고, 댓글 작성일이 같다면 게시글 제목을 기준으로 오름차순 정렬
SELECT B.TITLE, B.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, TO_CHAR(R.CREATED_DATE, 'YYYY-MM-DD') AS "CREATED_DATE"
FROM USED_GOODS_BOARD B
JOIN USED_GOODS_REPLY R
ON B.BOARD_ID = R.BOARD_ID
WHERE B.CREATED_DATE BETWEEN TO_DATE('2022-10-01', 'YYYY-MM-DD') AND TO_DATE('2022-10-31', 'YYYY-MM-DD')
ORDER BY R.CREATED_DATE, B.TITLE