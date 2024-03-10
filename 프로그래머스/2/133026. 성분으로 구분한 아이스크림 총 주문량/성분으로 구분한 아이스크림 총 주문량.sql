-- 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량을 총주문량이 작은 순서대로 조회
-- 총주문량을 나타내는 컬럼명은 TOTAL_ORDER로 지정
select i.ingredient_type, sum(f.total_order) as TOTAL_ORDER
from first_half f, icecream_info i
where f.flavor = i.flavor
group by i.ingredient_type
order by `TOTAL_ORDER`