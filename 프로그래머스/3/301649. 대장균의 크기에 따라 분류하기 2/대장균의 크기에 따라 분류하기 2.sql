WITH PERCENT AS (
    SELECT ID, (PERCENT_RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) * 100) PERCENT
    FROM ECOLI_DATA
)

SELECT 
    ID,
    CASE
        WHEN PERCENT <= 25
        THEN 'CRITICAL'
        WHEN PERCENT <= 50
        THEN 'HIGH'
        WHEN PERCENT <= 75
        THEN 'MEDIUM'
        ELSE 'LOW'
    END COLONY_NAME
FROM PERCENT
ORDER BY ID ASC
    
