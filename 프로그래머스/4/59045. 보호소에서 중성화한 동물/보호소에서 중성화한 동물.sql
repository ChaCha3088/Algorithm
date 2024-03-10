-- 보호소에 들어올 당시에는 중성화되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 
select i.animal_id, i.animal_type, i.name
from animal_ins i, animal_outs o
where i.animal_id = o.animal_id and i.sex_upon_intake like 'Intact%' and (o.sex_upon_outcome like 'Spayed%' or o.sex_upon_outcome like 'Neutered%')
-- 아이디 순으로 조회
order by i.animal_id