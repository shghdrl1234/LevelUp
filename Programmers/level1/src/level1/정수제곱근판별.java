package level1;

import java.util.ArrayList;
import java.util.List;

public class 정수제곱근판별 {

	public static void main(String[] args) {
		/*
		 * 문제 설명
		 * 
		 * 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다. 
		 * n이 양의 정수 x의 제곱이라면 x+1의 제곱을
		 * 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
		 * 
		 * 제한 사항
		 * 
		 * n은 1이상, 50000000000000 이하인 양의 정수입니다.
		 * 
		 */
		System.out.println(solution(12));

	}

	public static long solution(long n) {
		long answer = 0;
		
		// 반복문을 통해서..
		
		
		for(int x = 1; x <=n; x++) {
			
			if(x*x == n) {
				
				return (x+1)*(x+1);
			}
			
		}

		return -1;
	}

//	   public static long solution(long n) {
//	        long answer = 0;
//	        // 인수 분해 후, 배열에 각 값을 저장,
//	        // 배열의 길이가 홀수 이면, x+1 제곱리턴,
//	        // 배열의 길이가 양수 이면, -1 리턴,
//	        
//	        // 배열의 길이가 홀수는 길이%2+1하여 x값 구함.
//	        
//	        int i = 1;
//	        
//	        
//	        while(n>=i) {
//	        	
//	        	if(n%i == 0) {
//	        		
//	        	}
//	        	i++;
//	        }
//	        
//	        System.out.println(str);
//	        
//	        if(str.length()/2 == 0 ) {
//	        	
//	        	return -1;
//	        }
//	        	
//	        answer = Integer.valueOf(str.indexOf(str.length()%2+1));
//	        	
//	        return (answer+1)*(answer+1);
//	    }
}



class 정수제곱근판별_다른사람 {
  public long solution(long n) {
      if (Math.pow((int)Math.sqrt(n), 2) == n) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }

        return -1;
  }
}
