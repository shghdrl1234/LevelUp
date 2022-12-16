package level1;

public class 문자열다루기기본 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 문자열 s의 길이가 4 혹은 6이고, 
		 * 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 
		 * 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
		 * 
		 * 제한 사항 
		 * s는 길이 1 이상, 길이 8 이하인 문자열입니다.
		 * s는 영문 알파벳 대소문자 또는 0부터 9까지 숫자로 이루어져 있습니다.
		 * 
		 */
		
		System.out.println(solution("124"));
	}
	
	   public static boolean solution(String s) {
		   /*
		    * 내가 문제푸는 방법
		    * 1. 조건문을 통해 s의 길이 판별.
		    * 2. 문자가 없으면 true 반환.
		    */
	
		   boolean answer = false;
		   
		   if(s.length() == 4 || s.length() == 6) {
			   
			   for(int i = 0; i < s.length(); i++) {
				   answer = true;	
				   
				   if(!(s.charAt(i) >= 48 && s.charAt(i) < 58)) {
					   return false;
				   }
			   }
			   
			   
		   }
		   
	        return answer;
	    }
	
	   public boolean 문자열다루기기본_다른사람(String s) {
		   if(s.length() == 4 || s.length() == 6){
			   try{
				   int x = Integer.parseInt(s);
				   return true;
			   } catch(NumberFormatException e){
				   return false;
			   }
		   }
		   else return false;
	   }
	   // try-catch를 사용함.
}

/*
 * 나는 아스키코드를 활용하여 풀어보았다.
 * 하지만 아스키코드가 잘 생각이 나질 않아 시간을 잡아먹었다.
 * 
 *  숫자 0~9 => ASCII 48~57
 *  대문자 A~Z => ASCII 65~90
 *  소문자 a~z => ASCII 97~122
 * 
 */