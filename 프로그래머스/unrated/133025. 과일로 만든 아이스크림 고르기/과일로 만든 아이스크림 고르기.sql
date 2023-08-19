-- 상반기 아이스크림 총주문량이 3,000보다 높으면서
-- 아이스크림의 주 성분이 과일
-- 아이스크림의 맛을 총주문량이 큰 순서대로 조회
SELECT FH.FLAVOR
FROM FIRST_HALF FH
JOIN ICECREAM_INFO II
ON FH.FLAVOR = II.FLAVOR
WHERE 
    II.INGREDIENT_TYPE = 'fruit_based' AND
    FH.TOTAL_ORDER >= 3000
ORDER BY FH.TOTAL_ORDER DESC