package sql;

import java.util.List;

public class Join_문제 {
	// 상품을 구매한 회원 비율 구하기
	String a1 = "select to_number(SUBSTR(day, 0, 4)) year, to_number(SUBSTR(day, 6)) month, PUCHASED_USERS, round(PUCHASED_USERS/total_users, 1) PUCHASED_RATIO\r\n"
			+ "from (SELECT to_char(sales_date, 'YYYY/MM') day,\r\n" + "(select count(distinct oos.user_id) \r\n"
			+ "from online_sale oos inner join user_info uui on oos.user_id = uui.user_id\r\n"
			+ "where to_char(oos.sales_date, 'YYYY/MM') = to_char(os.sales_date, 'YYYY/MM')\r\n"
			+ "and to_char(uui.joined, 'YYYY') = 2021) PUCHASED_USERS,\r\n"
			+ "(select count(*) from user_info where to_char(joined, 'YYYY') = 2021) total_users\r\n"
			+ "from online_sale os inner join user_info ui \r\n" + "on os.user_id = ui.user_id \r\n"
			+ "where to_char(joined, 'YYYY') = 2021 \r\n" + "group by to_char(sales_date, 'YYYY/MM') order by day)";

	// 보호소에서 중성화한 동물
	String a2 = "SELECT ai.animal_id, ai.animal_type, ai.name\r\n" + "from animal_ins ai inner join animal_outs ao \r\n"
			+ "on ai.animal_id = ao.animal_id\r\n" + "where ai.SEX_UPON_INTAKE != ao.SEX_UPON_OUTCOME\r\n"
			+ "order by ai.animal_id";
	
	
	
	
}
