SELECT o.PRODUCT_ID, p.PRODUCT_NAME, (o.AMOUNT * p.PRICE) AS "TOTAL_SALES"
FROM (SELECT PRODUCT_ID, SUM(AMOUNT) AS "AMOUNT" 
      FROM FOOD_ORDER 
      WHERE PRODUCE_DATE REGEXP '^2022-05' 
      GROUP BY PRODUCT_ID) AS o
JOIN FOOD_PRODUCT AS p
ON o.PRODUCT_ID = p.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, PRODUCT_ID ASC