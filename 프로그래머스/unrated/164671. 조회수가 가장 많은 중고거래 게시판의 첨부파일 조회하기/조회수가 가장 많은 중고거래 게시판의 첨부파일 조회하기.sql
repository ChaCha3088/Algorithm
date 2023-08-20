-- 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회
-- 첨부파일 경로는 FILE ID를 기준으로 내림차순 정렬
-- 기본적인 파일경로는 /home/grep/src/
-- 게시글 ID를 기준으로 디렉토리가 구분
-- 파일이름은 파일 ID, 파일 이름, 파일 확장자로 구성되도록 출력

SELECT '/home/grep/src/' || N2.BOARD_ID || '/' || F.FILE_ID || F.FILE_NAME || F.FILE_EXT AS "FILE_PATH"
FROM (
    SELECT *
    FROM 
        (
            SELECT B.BOARD_ID
            FROM USED_GOODS_BOARD B
            ORDER BY B.VIEWS DESC
        ) N1
    WHERE ROWNUM <= 1
) N2
JOIN USED_GOODS_FILE F
ON N2.BOARD_ID = F.BOARD_ID
ORDER BY F.FILE_ID DESC