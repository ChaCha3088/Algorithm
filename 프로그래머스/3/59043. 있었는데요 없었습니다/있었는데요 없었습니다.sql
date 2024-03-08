-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회
SELECT i.animal_id, i.name
from animal_ins i, animal_outs o
where 
    i.animal_id = o.animal_id
    and
    i.datetime > o.datetime
-- 결과는 보호 시작일이 빠른 순으로 조회
order by i.datetime