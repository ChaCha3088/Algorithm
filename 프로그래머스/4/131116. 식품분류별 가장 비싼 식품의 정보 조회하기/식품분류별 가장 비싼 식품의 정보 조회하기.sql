-- 식품분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회
-- 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력
select category, price, product_name
from food_product
where (category, price) in (
    select category, max(price) as 'MAX_PRICE'
    from food_product
    where category in ('과자', '국', '김치', '식용유')
    group by category
)
# -- 식품 가격을 기준으로 내림차순 정렬
order by price desc