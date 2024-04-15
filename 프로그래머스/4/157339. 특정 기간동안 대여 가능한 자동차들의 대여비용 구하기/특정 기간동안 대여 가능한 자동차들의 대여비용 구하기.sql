SELECT CAR_ID, CAR_TYPE, FEE
FROM (
    SELECT CAR_ID, c.CAR_TYPE, ROUND(DAILY_FEE * 30 * (100-DISCOUNT_RATE)/100) FEE
    FROM CAR_RENTAL_COMPANY_CAR c, (
        SELECT CAR_TYPE, DISCOUNT_RATE
        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
        WHERE DURATION_TYPE LIKE '30%'
        ) p
    WHERE c.CAR_TYPE = p.CAR_TYPE
    AND c.CAR_TYPE in('세단', 'SUV')
    AND DAILY_FEE * 30 * (100-DISCOUNT_RATE)/100 >= 500000
    AND DAILY_FEE * 30 * (100-DISCOUNT_RATE)/100 < 2000000
) n
WHERE CAR_ID not in (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN DATE('2022-11-01') AND DATE('2022-11-30')
    OR END_DATE BETWEEN DATE('2022-11-01') AND DATE('2022-11-30')
    OR (START_DATE < DATE('2022-11-01') AND END_DATE > DATE('2022-11-30'))
    )
ORDER BY FEE DESC, CAR_TYPE, CAR_ID DESC;