-- 상품 카테고리 코드(PRODUCT_CODE 앞 2자리) 별 상품 개수를 출력
SELECT SUBSTR(PRODUCT_CODE, 1, 2) AS CATEGORY, count(*) as 'products'
from product
group by category
-- 상품 카테고리 코드를 기준으로 오름차순 정렬
order by product_code