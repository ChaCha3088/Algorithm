-- 각 동물의 아이디와 이름, 들어온 날짜를 조회
SELECT animal_id, name, DATE_FORMAT(datetime, '%Y-%m-%d') as '날짜'
from animal_ins
-- 아이디 순으로 조회
order by animal_id