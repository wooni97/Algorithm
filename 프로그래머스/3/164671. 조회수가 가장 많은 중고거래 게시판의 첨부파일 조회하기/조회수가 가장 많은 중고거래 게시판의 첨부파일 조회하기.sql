-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/', F.BOARD_ID, '/', F.FILE_ID, F.FILE_NAME, F.FILE_EXT) AS FILE_PATH
FROM (
    SELECT *,
    RANK() OVER(ORDER BY A.VIEWS DESC) AS RN
    FROM USED_GOODS_BOARD AS A
) AS RANKED
LEFT JOIN USED_GOODS_FILE AS F
ON RANKED.BOARD_ID = F.BOARD_ID
WHERE RANKED.RN = 1
;