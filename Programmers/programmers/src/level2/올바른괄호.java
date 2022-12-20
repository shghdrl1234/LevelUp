package level2;

import java.util.Stack;

public class �ùٸ���ȣ {

	public static void main(String[] args) {
		/*
		 * 
		 * ���� ���� 
		 * ��ȣ�� �ٸ��� ¦�������ٴ� ���� '(' ���ڷ� �������� �ݵ�� ¦��� ')' ���ڷ� ������ �Ѵٴ� ���Դϴ�. 
		 * ���� ��� "()()" �Ǵ� "(())()" �� �ùٸ� ��ȣ�Դϴ�.
		 * ")()(" �Ǵ� "(()(" �� �ùٸ��� ���� ��ȣ�Դϴ�. 
		 * '(' �Ǵ� ')'�θ� �̷���� ���ڿ� s�� �־����� ��, ���ڿ� s�� �ùٸ� ��ȣ�̸� true�� return �ϰ�, 
		 * �ùٸ��� ���� ��ȣ�̸� false��  return �ϴ� solution �Լ��� �ϼ��� �ּ���.
		 * 
		 * ���ѻ��� 
		 * ���ڿ� s�� ���� : 100,000 ������ �ڿ��� 
		 * ���ڿ� s�� '(' �Ǵ� ')' �θ� �̷���� �ֽ��ϴ�.
		 */

	}
	
    boolean solution(String s) {
        boolean answer = true;

        /* ���� Ǫ�� ���
         * 1. ) �� ���� ������ false
         * 2. ( �ϳ� ����� sum +1 
         * 3. ) �ϳ� ����� sum -1
         * 4. sum�� ������ �Ǹ� false
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

	class �ùٸ���ȣ_�ٸ���� {
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
	 * ���� �е��� stack�� ����Ͽ��ٰ� �Ѵ�.
	 * ���� for �ݺ����� sum ������ ����Ͽ� Ǯ����.
	 * stack�� ���� �� ������ ���̴� �� ���ſ�ΰ�.
	 * 
	 */