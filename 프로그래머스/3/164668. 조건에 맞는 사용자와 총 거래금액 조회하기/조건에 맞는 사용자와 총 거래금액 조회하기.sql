-- 완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회
-- 총거래금액을 기준으로 오름차순 정렬

select u.user_id, u.nickname, sum(b.price) as TOTAL_SALES
from USED_GOODS_USER u, USED_GOODS_BOARD b
where u.user_id = b.writer_id and b.status = 'DONE'
group by u.user_id
having `TOTAL_SALES` >= 700000
order by `TOTAL_SALES`