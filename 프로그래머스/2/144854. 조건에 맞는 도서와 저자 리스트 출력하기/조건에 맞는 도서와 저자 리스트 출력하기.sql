-- '경제' 카테고리에 속하는 도서들의 도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를 출력
select b.book_id, a.author_name, date_format(b.published_date, '%Y-%m-%d') as PUBLISHED_DATE
from book b, author a
where b.AUTHOR_ID = a.AUTHOR_ID and category = '경제'

-- 결과는 출판일을 기준으로 오름차순 정렬
order by published_date