WITH TBL AS (
    SELECT
        MEMBER_ID,
        COUNT(*) AS COUNTS
    FROM
        REST_REVIEW
    GROUP BY
        MEMBER_ID
    ORDER BY
        COUNTS DESC
    LIMIT 1    
)


SELECT
    m.MEMBER_NAME,
    r.REVIEW_TEXT,
    DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM
    MEMBER_PROFILE m
    INNER JOIN REST_REVIEW r ON m.MEMBER_ID = r.MEMBER_ID
    INNER JOIN TBL t ON m.MEMBER_ID = t.MEMBER_ID
ORDER BY
    r.REVIEW_DATE ASC,
    r.REVIEW_TEXT ASC;