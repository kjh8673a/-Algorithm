WITH TOTAL_ORDER AS (
    (SELECT * FROM FIRST_HALF)
    UNION
    (SELECT * FROM JULY)
)


SELECT FLAVOR FROM (
    SELECT FLAVOR, SUM(TOTAL_ORDER) FROM TOTAL_ORDER
    GROUP BY FLAVOR
    ORDER BY SUM(TOTAL_ORDER) DESC
)
WHERE ROWNUM <= 3
