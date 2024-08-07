WITH FISH_COUNT AS (
    SELECT FISH_TYPE, COUNT(ID) FISH_COUNT
    FROM FISH_INFO
    GROUP BY FISH_TYPE
)

SELECT c.FISH_COUNT, n.FISH_NAME
FROM FISH_COUNT c
LEFT JOIN FISH_NAME_INFO n
ON c.FISH_TYPE = n.FISH_TYPE
ORDER BY c.FISH_COUNT DESC