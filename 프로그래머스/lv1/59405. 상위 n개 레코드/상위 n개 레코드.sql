-- 동물 보호소에 가장 먼저 들어온 동물의 이름을 조회
SELECT S.NAME
FROM (
    SELECT A.NAME
    FROM ANIMAL_INS A
    ORDER BY A.DATETIME
    ) S
WHERE ROWNUM <= 1