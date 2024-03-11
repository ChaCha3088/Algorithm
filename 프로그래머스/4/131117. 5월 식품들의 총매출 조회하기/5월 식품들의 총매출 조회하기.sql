-- 생산일자가 2022년 5월인 식품들의 식품 ID, 식품 이름, 총매출을 조회
select p.product_id, p.product_name, sum(p.price * o.amount) as 'TOTAL_SALES'
from food_product p, food_order o
where date_format(o.produce_date, '%Y-%m') = '2022-05' and p.product_id = o.product_id
group by p.product_id
-- 총매출을 기준으로 내림차순 정렬해주시고 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬
order by `TOTAL_SALES` desc, p.product_id
