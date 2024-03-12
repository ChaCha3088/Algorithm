with sorted as (
    SELECT 
        HISTORY_ID, 
        DAILY_FEE, 
        DURATION,
        CASE WHEN DISCOUNT_RATE IS NULL THEN 1
             ELSE 1 - (DISCOUNT_RATE * 0.01)
             END RATE
    FROM CAR_RENTAL_COMPANY_CAR C 
    JOIN (
        SELECT 
            HISTORY_ID, 
            CAR_ID, 
            DATEDIFF(END_DATE, START_DATE)+1 DURATION,
            CASE WHEN DATEDIFF(END_DATE, START_DATE)+1 >= 90 THEN '90일 이상'
                 WHEN DATEDIFF(END_DATE, START_DATE)+1 >= 30 THEN '30일 이상'
                 WHEN DATEDIFF(END_DATE, START_DATE)+1 >= 7  THEN '7일 이상'
            ELSE '7일 미만'
            END DURATION_TYPE
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    ) H ON C.CAR_ID = H.CAR_ID AND C.CAR_TYPE = '트럭'
    LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON H.DURATION_TYPE = P.DURATION_TYPE AND P.CAR_TYPE = '트럭'
)

select
    history_id,
    round(daily_fee * duration * rate) as 'FEE'
from
    sorted
order by
    `FEE` desc,
    history_id desc