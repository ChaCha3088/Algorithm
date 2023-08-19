-- 동물 보호소에 들어온 모든 동물의 아이디와 이름, 보호 시작일을 이름 순으로 조회
-- 보호를 나중에 시작한 동물을 먼저
SELECT A.ANIMAL_ID, A.NAME, A.DATETIME
FROM ANIMAL_INS A
ORDER BY A.NAME, A.DATETIME DESC