-- 이름에 "EL"이 들어가는 개의 아이디와 이름을 조회
SELECT animal_id, name from animal_ins
where animal_type = 'Dog' and name like '%el%' or '%El%' or '%eL' or '%EL%'
-- 이름 순으로 조회
order by name