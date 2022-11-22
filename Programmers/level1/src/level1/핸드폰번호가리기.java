package level1;

import java.util.Arrays;

public class 핸드폰번호가리기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명
		 * 프로그래머스 모바일은 개인정보 보호를 위해 
		 * 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다. 
		 * 
		 * 전화번호가 문자열 phone_number로 주어졌을 때, 
		 * 전화번호의 뒷 4자리를 제외한 나머지 숫자를 
		 * 전부 *으로 가린 문자열을 리턴하는 함수,
		 * solution을 완성해주세요.
		 * 
		 * 제한 조건 
		 * phone_number는 길이 4 이상, 20이하인 문자열입니다.
		 * 
		 */
		
		solution("01077416096");

	}
	
	   public static String solution(String phone_number) {
	        
		   // 1. 문자열을 받아온다.
		   // 2. 문자열의 길이를 구한다.
		   // 3. 문자열의 길이를 기준으로 뒤에서 4자리 제외하고 *로 바꾼다.
		   
		   String answer = "";
		   String[] num = phone_number.split("");
		   // 문자열의 값을 하나씩 떼어서 배열로 만든다.
		   
		   for(int i = 0; i < num.length; i++) {
			  
			   if(i < num.length-4) {
				   answer += "*";
				   // 인덱스 번호가 뒤에서 부터 4자리수가 아니면 실행.
				   
			   } else {
				   answer += num[i];
				   // 인덱스 번호가 뒤에서 부터 4자리에 들면 실행.
			   }
		   }
		   System.out.println(answer);
	        return answer;
	    }

}

		class 핸드폰번호가리기_다른사람 {
		  public String solution(String phone_number) {
			  // 이 분은 char 타입 배열로 문제를 해결하였다.
			  
		     char[] ch = phone_number.toCharArray();
		     // 문자열을 char타입으로 하나하나 만들어줌.
		     
		     for(int i = 0; i < ch.length - 4; i ++){
		         ch[i] = '*';
		         // 인덱스 번호가 뒤에 4자리수가 아니면 *를 저장해줌.
		     }
		     return String.valueOf(ch);
		     // ch타입 배열을 String으로 변환하여 반환.
		  }
		}
