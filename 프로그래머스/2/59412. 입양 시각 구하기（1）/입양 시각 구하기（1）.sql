-- 09:00부터 19:59까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회
select hour(datetime) as 'hour', count(animal_id) from animal_outs
where hour(datetime) between 9 and 19
group by `hour`

-- 시간대 순으로 정렬
order by `hour`