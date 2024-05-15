SELECT MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
FROM (SELECT MEMBER_ID, MEMBER_NAME
      FROM MEMBER_PROFILE
      WHERE MEMBER_ID = (SELECT MEMBER_ID
                         FROM REST_REVIEW
                         GROUP BY MEMBER_ID
                         ORDER BY COUNT(*) DESC
                         LIMIT 1)) g, REST_REVIEW r
WHERE r.MEMBER_ID = g.MEMBER_ID
ORDER BY REVIEW_DATE, REVIEW_TEXT;