SELECT ID, (CASE
            WHEN PCNT = 1 THEN 'CRITICAL'
            WHEN PCNT = 2 THEN 'HIGH'
            WHEN PCNT = 3 THEN 'MEDIUM'
            ELSE 'LOW'
            END) COLONY_NAME
FROM (SELECT ID, NTILE(4) OVER(ORDER BY SIZE_OF_COLONY DESC) PCNT
      FROM ECOLI_DATA) g
ORDER BY ID;