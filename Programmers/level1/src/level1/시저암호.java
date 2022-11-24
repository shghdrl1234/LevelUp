package level1;

import java.util.Arrays;

public class 시저암호 {

	/*
	 * 문제 설명 
	 * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 
	 * 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 
	 * 
	 * 예를 들어
	 * "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. 
	 * "z"는 1만큼 밀면 "a"가 됩니다. 
	 * 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
	 * 
	 * 제한 조건
	 * 공백은 아무리 밀어도 공백입니다. 
	 * s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다. 
	 * s의 길이는 8000이하입니다.
	 * n은 1 이상, 25이하인 자연수입니다.
	 * 
	 */
	
	public static void main(String[] args) {
		solution("AZ",1);
		solution("az",1);

		
	}
	

    public static String solution(String s, int n) {
        
    	/*
    	 * 내가 문제 푸는 방법
    	 * 
    	 * ! 일정한 거리만큼 밀어서 => "거리"라는 표현으로 1,2 단위의 숫자를 유추
    	 * ! 다른 알파벳으로 바꾸는 => 유추한 숫자를 알파벳으로 바꾼다라.. char 타입으로 접근
    	 * ! char 타입 z는 다음은 기호가 온다. 여기서 재지정 해주는 방법.
    	 * 
    	 * 1. 전달받은 문자열을 각 배열로 만든다. => toCharArray()
  		 *
    	 * 3. if문을 두어  90 < s[i]-n < 97 일 때, 97 < s[i] <123 일 때를 나눈다
    	 * 4.  90 < s[i]-n < 97 일 때, s[i] = n-s[i] + 64
    	 * 5.  97 < s[i]-n < 123 일 때, s[i] = n-s[i] + 96
    	 * 
    	 */

    	String answer = "";
    	char[] ch = s.toCharArray();
    		
    	for(int i = 0 ; i < ch.length; i++) {
    	
    		if(ch[i] == ' ')  {
    			ch[i] = 32;
    			continue;
    		}

    		if('A' <= ch[i] && ch[i] <= 'Z') {
    			// 대문자일때
    			if( ch[i]+n > 'Z') {
    				ch[i] = (char)(n-26+Integer.valueOf(ch[i]));
    			} else {
    				ch[i] = (char)(ch[i]+n);
    			}
    			
     		} else if( 'z' < ch[i] + n )  {
     			ch[i] = (char)(n-26+Integer.valueOf(ch[i]));
     		} else  {
     			ch[i] = (char)(ch[i]+n);
     		}
    		
    	}
    	
    	
    	answer = String.valueOf(ch, 0, ch.length);
    	System.out.println(answer);
    	
        return answer;
    }
    
    
}

class 시저암호_다른사람 {
    String caesar(String s, int n) {
        String result = "";
	    n = n % 26;
	    for (int i = 0; i < s.length(); i++) {
	      char ch = s.charAt(i);
	      if (Character.isLowerCase(ch)) {
	        ch = (char) ((ch - 'a' + n) % 26 + 'a');
	      } else if (Character.isUpperCase(ch)) {
	        ch = (char) ((ch - 'A' + n) % 26 + 'A');
	      }
	      result += ch;
	    }
	        return result;
	    }
}


/*
 * 
 * 그렇게 어렵지는 않았지만, 분기점을 확실하게 생각해주어야함.
 * 
 */


