package level1;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 
		 * 새로운 문자열을 리턴하는 함수, solution을 완성해주세요. 
		 * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
		 * 
		 * 제한 사항 
		 * str은 길이 1 이상인 문자열입니다.
		 */System.out.println(solution("Zbcdefg"));

	}
	   public static String solution(String s) {
	        
		   /*
		    * 내가 문제 푸는 방법
		    * 1. 문자열 비교.
		    * 2. sort 사용하기 적합하다. => 오름차순 정렬 후
		    * 3. 배열을 뒤집는다.
		    */
		   
		   String[] str = s.split("");
		   Arrays.sort(str);
		   
		   String answer = String.join("",str);
		   
		   String answer2 = "";
		   
		   for(int i = s.length()-1; i >=0; i--) {
			   answer2 += answer.charAt(i);
		   }
		   
	        return answer2;
	    }

}

	 class 문자열내림차순으로배치하기_다른사람 {
		
	    public String reverseStr(String str){
	    	char[] sol = str.toCharArray();
	    	Arrays.sort(sol);
	    return new StringBuilder(new String(sol)).reverse().toString();
	    }
	}

	 
	 /*
	  * 일단 이 문제를 풀면서 검색을 좀 했다.
	  * 
	  * 1. String 타입의 배열을 문자열로 전환하는 String.join(배열사이 추가할 문자,배열)
	  * 
	  * 이 문제 말고도 풀이에 간결한 식을 쓴느 분들이 많이 계셨다.
	  * 초급 문제 다 풀고 한 번에 정리 해보도록 하자.
	  * 
	  * 
	  */
	 
	 
	 
	 