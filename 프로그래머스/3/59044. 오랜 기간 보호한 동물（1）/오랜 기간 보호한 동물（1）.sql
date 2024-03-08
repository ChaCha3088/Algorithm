-- 아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요. 이때 결과는 보호 시작일 순으로 조회

select name, datetime from animal_ins i
where i.animal_id not in (
    select animal_id from animal_outs o
)
order by i.datetime
limit 3