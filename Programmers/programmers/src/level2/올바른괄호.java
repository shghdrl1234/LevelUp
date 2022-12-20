package level2;

import java.util.Stack;

public class 올바른괄호 {

	public static void main(String[] args) {
		/*
		 * 
		 * 문제 설명 
		 * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 
		 * 예를 들어 "()()" 또는 "(())()" 는 올바른 괄호입니다.
		 * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다. 
		 * '(' 또는 ')'로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 
		 * 올바르지 않은 괄호이면 false를  return 하는 solution 함수를 완성해 주세요.
		 * 
		 * 제한사항 
		 * 문자열 s의 길이 : 100,000 이하의 자연수 
		 * 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
		 */

	}
	
    boolean solution(String s) {
        boolean answer = true;

        /* 내가 푸는 방법
         * 1. ) 가 먼저 나오면 false
         * 2. ( 하나 생기면 sum +1 
         * 3. ) 하나 생기면 sum -1
         * 4. sum이 음수가 되면 false
         *
         */
        System.out.println("Hello Java");

        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
        	
        	if(s.charAt(i) == '(') {
        		sum += 0;
        	} else {
        		sum -= 0;
        	}
        	
        	if(sum < 0) {
        		return false;
        	}
        }
        
        if(sum!= 0 ) {
        	return false;
        }
        
        return true;
    }

}

	class 올바른괄호_다른사람 {
	    boolean solution(String s) {
	        boolean answer = true;  
	        String res = "YES";
	        Stack<Integer> st = new Stack<>();
	
	        for (int i = 0; i < s.length(); i++) {
	                if (s.charAt(i) == '(') {
	                    st.push(1);
	                } else if (s.charAt(i) == ')') {
	                    if (st.isEmpty()) {
	                        answer = false;
	                        break;
	                    } else {
	                        st.pop();
	                    }
	                }
	            }
	
	            if(!st.isEmpty()) {
	
	                answer = false;
	
	            }
	
	            System.out.println(res);
	       return answer;
	    }   
	
	}
	
	/*
	 * 많은 분들이 stack을 사용하였다고 한다.
	 * 나는 for 반복문과 sum 변수를 사용하여 풀었다.
	 * stack이 조금 더 복잡해 보이는 건 기분탓인가.
	 * 
	 */