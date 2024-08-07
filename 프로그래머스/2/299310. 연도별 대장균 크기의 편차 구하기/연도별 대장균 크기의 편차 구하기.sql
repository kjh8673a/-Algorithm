WITH MAX_COLONY AS (
    SELECT YEAR(DIFFERENTIATION_DATE) YEAR, MAX(SIZE_OF_COLONY) MAX_SIZE
    FROM ECOLI_DATA
    GROUP BY YEAR(DIFFERENTIATION_DATE)
)


SELECT YEAR(a.DIFFERENTIATION_DATE) YEAR, (b.MAX_SIZE - a.SIZE_OF_COLONY) YEAR_DEV, a.ID ID
FROM ECOLI_DATA a
JOIN MAX_COLONY b
ON YEAR(a.DIFFERENTIATION_DATE) = b.YEAR
ORDER BY YEAR, YEAR_DEV
