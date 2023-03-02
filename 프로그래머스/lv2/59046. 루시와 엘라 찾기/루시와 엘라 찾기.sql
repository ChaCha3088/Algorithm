-- 이름이 Lucy, Ella, Pickle, Rogan, Sabrina, Mitty인 동물의 아이디와 이름, 성별 및 중성화 여부를 조회
-- 아이디 순으로 조회
SELECT 
    ANIMAL_ID, 
    NAME, 
    SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE 'Lucy, Ella, Pickle, Rogan, Sabrina, Mitty' LIKE CONCAT('%', NAME, '%')
ORDER BY ANIMAL_ID