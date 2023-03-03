-- REST_INFO 테이블에서 음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회
-- 결과는 음식 종류를 기준으로 내림차순 정렬


SELECT food_type, rest_id, rest_name, favorites
from rest_info
where favorites in (select max(favorites)
                    from rest_info
                    group by food_type)
group by food_type
order by food_type desc