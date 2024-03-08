-- 2022년 1월의 카테고리 별 도서 판매량을 합산
-- 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력
select category, sum(sales) as 'TOTAL_SALES'
from book b, book_sales s

where b.book_id = s.book_id and date_format(s.sales_date, '%Y-%m') = '2022-01'
group by category
-- 카테고리명을 기준으로 오름차순 정렬
order by category asc