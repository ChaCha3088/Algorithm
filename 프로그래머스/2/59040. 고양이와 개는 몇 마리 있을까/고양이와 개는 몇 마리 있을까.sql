-- 고양이와 개가 각각 몇 마리인지 조회
SELECT animal_type, count(*) as count
from animal_ins
group by animal_type
order by animal_type

# select animal_type, count(*)
# from animal_ins
# where animal_type = 'Cat'
# union all
# select animal_type, count(*)
# from animal_ins
# where animal_type = 'Dog'