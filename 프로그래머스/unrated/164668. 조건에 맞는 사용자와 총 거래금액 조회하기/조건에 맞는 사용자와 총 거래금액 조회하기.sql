-- 완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회
-- 총거래금액을 기준으로 오름차순 정렬

SELECT 
    B.USER_ID,
    B.NICKNAME, 
    SUM(A.PRICE) AS "TOTAL_SALES"
FROM
    USED_GOODS_BOARD A,
    USED_GOODS_USER B
WHERE
    A.WRITER_ID = B.USER_ID AND 
    A.STATUS = 'DONE'
GROUP BY 
    B.USER_ID,
    B.NICKNAME
HAVING
    SUM(A.PRICE) >= 700000
ORDER BY
    TOTAL_SALES