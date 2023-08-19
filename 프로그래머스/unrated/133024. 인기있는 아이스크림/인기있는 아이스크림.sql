-- 상반기에 판매된 아이스크림의 맛을 총주문량을 기준으로 내림차순 정렬
-- 총주문량이 같다면 출하 번호를 기준으로 오름차순 정렬하여 조회
SELECT FH.FLAVOR
FROM FIRST_HALF FH
ORDER BY FH.TOTAL_ORDER DESC, FH.SHIPMENT_ID ASC