SELECT DISTINCT c.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR c, CAR_RENTAL_COMPANY_RENTAL_HISTORY h
WHERE c.CAR_ID = h.CAR_ID 
    AND c.CAR_TYPE = '세단' 
    AND DATE_FORMAT(h.START_DATE, '%m') = '10'
ORDER BY c.CAR_ID DESC