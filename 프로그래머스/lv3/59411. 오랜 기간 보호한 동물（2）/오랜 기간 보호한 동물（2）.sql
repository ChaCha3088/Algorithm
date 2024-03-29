-- 입양을 간 동물 중, 
-- 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회
-- 보호 기간이 긴 순으로 조회
SELECT OUTS.ANIMAL_ID, OUTS.NAME
FROM ANIMAL_OUTS OUTS

JOIN ANIMAL_INS INS
ON INS.ANIMAL_ID = OUTS.ANIMAL_ID

ORDER BY DATEDIFF(INS.DATETIME, OUTS.DATETIME) ASC
LIMIT 2

