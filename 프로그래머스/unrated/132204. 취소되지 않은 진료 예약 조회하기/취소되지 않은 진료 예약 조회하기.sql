SELECT tbl1.APNT_NO, tbl1.PT_NAME, tbl1.PT_NO, tbl1.MCDP_CD, tbl2.DR_NAME, tbl1.APNT_YMD
FROM (SELECT a.APNT_NO,p.PT_NAME, a.PT_NO, a.MCDP_CD, a.MDDR_ID, a.APNT_YMD
    FROM APPOINTMENT a
    JOIN PATIENT p
    ON a.PT_NO = p.PT_NO
    WHERE a.MCDP_CD = "CS" AND a.APNT_CNCL_YN = "N") tbl1
JOIN DOCTOR tbl2
ON tbl1.MDDR_ID = tbl2.DR_ID
WHERE tbl1.APNT_YMD REGEXP '^2022-04-13'
ORDER BY tbl1.APNT_YMD
