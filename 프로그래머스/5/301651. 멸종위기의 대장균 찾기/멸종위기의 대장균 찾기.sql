WITH RECURSIVE ECOLI_GEN_DATA AS (
    SELECT ID, PARENT_ID, 1 AS GEN
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL

    UNION ALL
    
    SELECT e.ID, e.PARENT_ID, g.GEN + 1 AS GEN
    FROM ECOLI_DATA e
    JOIN ECOLI_GEN_DATA g
    ON e.PARENT_ID = g.ID
)

SELECT COUNT(ID) AS COUNT, GEN AS GENERATION
FROM ECOLI_GEN_DATA
WHERE ID NOT IN (SELECT PARENT_ID FROM ECOLI_GEN_DATA WHERE PARENT_ID IS NOT NULL)
GROUP BY 2
ORDER BY 2