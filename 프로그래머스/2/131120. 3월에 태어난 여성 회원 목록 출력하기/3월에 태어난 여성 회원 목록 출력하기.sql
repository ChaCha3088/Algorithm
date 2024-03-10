-- 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회
select member_id, member_name, gender, date_format(date_of_birth, '%Y-%m-%d')
from MEMBER_PROFILE
where tlno is not null and gender = 'W' and date_format(date_of_birth, '%m') = '03'
order by member_id

-- 전화번호가 NULL인 경우는 출력대상에서 제외
-- 회원ID를 기준으로 오름차순 정렬