SELECT SCORE, h.EMP_NO, EMP_NAME, POSITION, EMAIL
FROM HR_EMPLOYEES h, (SELECT EMP_NO, SUM(SCORE) SCORE
                   FROM HR_GRADE
                   WHERE YEAR = '2022'
                   GROUP BY EMP_NO
                   ORDER BY SUM(SCORE) DESC
                   LIMIT 1) s
WHERE h.EMP_NO = s.EMP_NO;