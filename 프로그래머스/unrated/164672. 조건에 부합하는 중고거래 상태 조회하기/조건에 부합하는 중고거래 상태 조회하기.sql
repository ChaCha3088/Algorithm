-- 2022년 10월 5일에 등록된 중고거래 게시물의 게시글 ID, 작성자 ID, 게시글 제목, 가격, 거래상태를 조회
-- 거래상태가 SALE 이면 판매중, RESERVED이면 예약중, DONE이면 거래완료 분류하여 출력
SELECT B.BOARD_ID, B.WRITER_ID, B.TITLE, B.PRICE, 
    CASE B.STATUS 
        WHEN 'SALE' THEN '판매중' 
        WHEN 'RESERVED' THEN '예약중'
        ELSE '거래완료' END AS "STATUS"
FROM USED_GOODS_BOARD B
WHERE B.CREATED_DATE = TO_DATE('2022-10-05', 'YYYY-MM-DD')
ORDER BY B.BOARD_ID DESC