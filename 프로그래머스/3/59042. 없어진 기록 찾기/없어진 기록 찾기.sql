SELECT o.ANIMAL_ID, o.NAME
FROM ANIMAL_OUTS o LEFT JOIN ANIMAL_INS i
ON o.ANIMAL_ID = I.ANIMAL_ID
WHERE SEX_UPON_INTAKE is NULL;