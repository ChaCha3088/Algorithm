-- 자동차 종류가 '세단'인 자동차들 중 10월에 대여를 시작한 기록이 있는 자동차 ID 리스트를 출력
select distinct h.car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h, CAR_RENTAL_COMPANY_CAR c
where c.car_type = '세단' and date_format(h.start_date, '%Y-%m') = '2022-10' and c.car_id = h.car_id
order by h.car_id desc

-- 자동차 ID 리스트는 중복이 없어야 하며
-- 자동차 ID를 기준으로 내림차순 정렬