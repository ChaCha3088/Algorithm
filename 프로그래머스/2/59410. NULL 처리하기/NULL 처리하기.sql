-- 생물 종, 이름, 성별 및 중성화 여부를 아이디 순으로 조회
-- 이름이 없는 동물의 이름은 "No name"으로 표시
SELECT animal_type, ifnull(name, 'No name'), sex_upon_intake
from animal_ins
order by animal_id