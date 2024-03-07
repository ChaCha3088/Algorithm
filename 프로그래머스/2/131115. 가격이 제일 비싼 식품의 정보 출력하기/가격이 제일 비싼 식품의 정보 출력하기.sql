-- 가격이 제일 비싼 식품의 식품 ID, 식품 이름, 식품 코드, 식품분류, 식품 가격을 조회
SELECT product_id, product_name, product_cd, category, price
from food_product
order by price desc
limit 1;
