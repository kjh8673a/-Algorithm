# SELECT HISTORY_ID, DATEDIFF(END_DATE, START_DATE) + 1
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY

# SELECT * FROM CAR_RENTAL_COMPANY_CAR
# SELECT * FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# SELECT * FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN

WITH C AS (
    SELECT 
        RANK() OVER (ORDER BY CAST(SUBSTRING_INDEX(DURATION_TYPE, '일', 1) AS UNSIGNED) ASC) AS PLAN_ID, 
        (100 - DISCOUNT_RATE) DISCOUNT_RATE
     FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE CAR_TYPE = '트럭'
)

SELECT DISTINCT A.HISTORY_ID,
    ROUND(CASE 
        WHEN A.DURATION >= 90 THEN A.DAILY_FEE * A.DURATION * (SELECT C.DISCOUNT_RATE FROM C WHERE C.PLAN_ID = 3) / 100
        WHEN A.DURATION >= 30 THEN A.DAILY_FEE * A.DURATION * (SELECT C.DISCOUNT_RATE FROM C WHERE C.PLAN_ID = 2) / 100
        WHEN A.DURATION >= 7 THEN A.DAILY_FEE * A.DURATION * (SELECT C.DISCOUNT_RATE FROM C WHERE C.PLAN_ID = 1) / 100
        ELSE A.DAILY_FEE * A.DURATION
    END) AS FEE
FROM (SELECT T.HISTORY_ID, DATEDIFF(T.END_DATE, START_DATE) + 1 AS DURATION, DAILY_FEE 
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY T
    JOIN CAR_RENTAL_COMPANY_CAR B
    ON T.CAR_ID = B.CAR_ID AND B.CAR_TYPE = '트럭') A, C
ORDER BY FEE DESC, HISTORY_ID DESC


    # (SELECT 
    #     RANK() OVER (ORDER BY CAST(SUBSTRING_INDEX(DURATION_TYPE, '일', 1) AS UNSIGNED) ASC) AS PLAN_ID, 
    #     (100 - DISCOUNT_RATE) DISCOUNT_RATE
    #  FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE CAR_TYPE = '트럭'
    # ) B

# SELECT RANK() OVER (ORDER BY CAST(SUBSTRING_INDEX(DURATION_TYPE, '일', 1) AS UNSIGNED) ASC) AS PLAN_ID, SUBSTRING_INDEX(DURATION_TYPE, '일', 1), DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE CAR_TYPE = '트럭'

# SELECT SUBSTRING_INDEX(DURATION_TYPE, '일', 1), DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE CAR_TYPE = '트럭'