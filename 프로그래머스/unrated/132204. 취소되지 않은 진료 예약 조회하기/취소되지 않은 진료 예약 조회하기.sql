-- PATIENT, DOCTOR 그리고 APPOINTMENT 테이블에서 2022년 4월 13일 취소되지 않은 흉부외과(CS) 진료 예약 내역을 조회
-- 진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시 항목이 출력
-- 결과는 진료예약일시를 기준으로 오름차순 정렬



SELECT AP.APNT_NO, PT.PT_NAME, PT.PT_NO, DR.MCDP_CD, DR.DR_NAME, AP.APNT_YMD
  FROM PATIENT PT, DOCTOR DR, APPOINTMENT AP
  WHERE PT.PT_NO = AP.PT_NO AND DR.MCDP_CD = AP.MCDP_CD AND DR.DR_ID = AP.MDDR_ID
        AND AP.APNT_CNCL_YN = 'N' AND AP.MCDP_CD = 'CS'
        AND DATE_FORMAT(APNT_YMD,'%Y%m%d') = '20220413'
  ORDER BY AP.APNT_YMD ASC;