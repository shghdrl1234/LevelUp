package level1;

import java.util.Arrays;

public class 나누어떨어지는숫자배열 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * array의 각 element 중 divisor로 나누어 떨어지는 값을 
		 * 오름차순으로 정렬한 배열을 반환하는 함수 solution을 작성해주세요. 
		 * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
		 * 
		 * 제한사항 
		 * arr은 자연수를 담은 배열입니다. 
		 * 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다. 
		 * divisor는 자연수입니다. 
		 * array는 길이 1 이상인 배열입니다.
		 */
		int[] abc = {11,3,42,53,263,6,23,1};
		
		solution(abc,3);
	}
	  public static int[] solution(int[] arr, int divisor) {

		  // 내가 생각하는 풀이
		  
		  // 1. 각 인덱스 값을 동일한 매개변수로 나눈다.
		  // 2. 각 값중에 나머지가 없는 값들로만 구성된 배열을 추출한다.
		  // 3. 오름차순 진행하여 반환하기. => 문자열이 아니니 sort 사용.
		  // 4. 단, 배열에 나눠떨어지는 인덱스 값이 하나도 없으면 인덱스로 -1을 담은 배열 반환
		  
		  int j = 0;
		  String num = "";
		  for(int i = 0; i < arr.length; i++) {
			  
			  if(arr[i]%divisor == 0) {
				  j++;
				  num += arr[i] + "/";
			  }
		  }
		  
		  
		  if(j == 0) {
			  int[] answer = {-1};
			  return answer;
		  }

		  int[] answer = new int[j];
		  
		  String[] num2 = num.split("/");
		  
		  for(int i = 0; i < answer.length; i++) {
			  
			  answer[i] = Integer.valueOf(num2[i]);
		  }
		  
		  Arrays.sort(answer);
		  
		  System.out.println(answer.toString());
		  return answer;
	    }
}


class 나누어떨어지는숫자배열_다른사람 {
	  public int[] solution(int[] arr, int divisor) {
	          int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
	          if(answer.length == 0) answer = new int[] {-1};
	          Arrays.sort(answer);
	          return answer;
	  }
	}

// 다른 분이 깔끔한 코드로 작성함.
// 이 문제는 효율적인 면에서는 for문이 더 낫다고 한다.
// 추가적으로 내가 푼 방식은 String 타입 배열을 사용하였는데,
// 대부분의 사람들은 int 타입 배열에 직접 넣는 방법을 사용하였다.
// 나의 53번 코드 for문의 조건문에 arr.length를 사용하여 직접 answer에 값을 넣었음.