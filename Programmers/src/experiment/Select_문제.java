package sql;

public class Select_문제 {
// SELECT 관련 문제
// https://school.programmers.co.kr/learn/courses/30/parts/17042

	// 조건에 맞는 회원 수 구하기
	String a1 = "SELECT count(*) from user_info where to_char(joined, 'yyyy') = 2021 and age between 20 and 29";

	// 상위 n개 레코드
	String a2 = "SELECT name from animal_ins where datetime = (select min(datetime) from animal_ins)";

	// 여러기준으로 정렬하기
	String a3 = "SELECT animal_id, name, datetime from animal_ins order by name, datetime desc";
	
}
