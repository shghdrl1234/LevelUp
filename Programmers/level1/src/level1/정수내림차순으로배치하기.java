package level1;

import java.util.Arrays;

public class 정수내림차순으로배치하기 {

	public static void main(String[] args) {
		/*
		 * 
		 * 문제 설명 
		 * 함수 solution은 정수 n을 매개변수로 입력받습니다. 
		 * n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 
		 * 예를들어 n이 118372면 873211을 리턴하면 됩니다.
		 * 
		 * 제한 조건 
		 * n은 1이상 8000000000 이하인 자연수입니다.
		 * 
		 * 
		 */
		System.out.println(solution(118372));
	}

	   public static  long solution(long n) {
	        long answer = 0;
	        
	        // 1. 문자열 배열, 스플릿과 반복문 활용. => 쉬워보임.
	        // 2. 오로지 정수로만 풀어보자. n/10 이런 것들 활용..?
	        
	        long num = n;

	        // 1의 자리 자리수 => 1
	        // 10의 자리 자리수 => 2
	        
	        int i = 0;
	        while(num >= 1) {
	        	// 1보다 크거나 같은 값이면 동작됨.
	        	
	        	num = num/10;
	        	i++;
	        }
	        // 배열의 크기를 지정해 주기 위한 반복문. 비록 주먹구구 식이긴 하지만.

	        int[] numArr = new int[i];
	        // 정수형 배열을 생성했다. long 타입이 아닌 이유는, 배열에 저장 할 것이기 때문에
	        // 그 자리값만 가져오면 되기 때문이다.
	        
	        num = n;
	        i = 0;
	        while(num >= 1) {
	        	System.out.println("num: "+ num);
	        	System.out.println("num/10: "+ num/10);
	        	numArr[i] = (int) (num%10);
	        	System.out.println("인덱스: "+ numArr[i]);

	        	num = (long) (num/10);
	        	// long 타입 이기 떄문에, / 연산자로 하여도 소수점 아래로 결과값이 나온다.
	        	// 그렇기 때문에 나머지 값을 또 구해서, 나머지를 제외한다.

	        	i++;
	        }
	        // 여기 까지 배열에 저장함.
	       
	        int store = 0;
	        for(int j = 0; j < numArr.length-1; j++) {
	        	for(i = 0; i < numArr.length-1; i++) {
		        	if(numArr[i] < numArr[i+1]) {
			        	store = numArr[i];
			        	numArr[i] = numArr[i+1];
			        	numArr[i+1] = store;
		        	}
	        	}
	        }
	        
	        
	        for(i = 0; i < numArr.length; i++) {
	        	
	        		answer += Math.pow(10,(numArr.length-i-1))*numArr[i];
	        		System.out.println(answer);
	        	}
	       
	        return answer;
	    }
	
}

	class 정수내림차순으로배치하기_다른사람 {
	  public long solution(long n) {
	        String[] list = String.valueOf(n).split("");
	        // 정수를 받아와서 스플릿 후 배열에 저장
	        
	        Arrays.sort(list);
	      

	        StringBuilder sb = new StringBuilder();
	        for (String aList : list) sb.append(aList);

	        return Long.parseLong(sb.reverse().toString());
	  }
	}


	class 정수내림차순으로배치하기_다른사람_2 {
	    String res = "";
	    
	    public int reverseInt(int n){
	        res = "";
	        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
	        return Integer.parseInt(res);
	    }
	}
	
	