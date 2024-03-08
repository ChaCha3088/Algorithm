# -- PRODUCT 테이블과 OFFLINE_SALE 테이블에서 상품코드 별 매출액(판매가 * 판매량) 합계를 출력
select p.product_code, sum(sales_amount) * p.price as 'SALES'
from product p, OFFLINE_SALE o
where p.product_id = o.product_id
group by p.product_code

# -- 매출액을 기준으로 내림차순 정렬
# -- 매출액이 같다면 상품코드를 기준으로 오름차순 정렬
order by `SALES` desc, product_code asc;