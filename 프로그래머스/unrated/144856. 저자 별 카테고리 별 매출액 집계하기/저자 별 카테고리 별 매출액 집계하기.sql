-- 2022년 1월의 도서 판매 데이터를 기준으로 저자 별, 카테고리 별 매출액(TOTAL_SALES = 판매량 * 판매가) 을 구하여, 
-- 저자 ID(AUTHOR_ID), 저자명(AUTHOR_NAME), 카테고리(CATEGORY), 매출액(SALES) 리스트를 출력
-- 결과는 저자 ID를 오름차순으로, 저자 ID가 같다면 카테고리를 내림차순 정렬

SELECT a.author_id, author_name, category, sum(a.price * c.sales) as total_sales
from book as a 
inner join author as b 
on a.author_id = b.author_id
inner join book_sales as c 
on a.book_id = c.book_id 
where year(sales_date) = 2022 and month(sales_date) = 01
group by a.author_id, a.category
order by a.author_id asc, category desc