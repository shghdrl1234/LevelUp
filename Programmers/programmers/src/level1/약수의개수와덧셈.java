package level1;

public class 약수의개수와덧셈 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 두 정수 left와 right가 매개변수로 주어집니다. 
		 * left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 
		 * 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
		 * 
		 * 제한사항
		 * 1 ≤ left ≤ right ≤ 1,000
		 * 
		 */
		System.out.println(solution(24,27));
	}
	
	public static int solution(int left, int right) {
		/*
		 * 내가 문제 푸는 방법
		 * 1. 배열과 반복문으로 문제를 풀어보자. 
		 * 2. right - left +1 = 배열의 길이 
		 * 3. 약수의 개수가 짝수 :
		 * 4. 약수의 개수가 홀수 :
		 *
		 * 2-1. 반복문을 통하여 약수의 갯수를 구하자
		 */
		
		int[] value = new int[right-left+1];
		int[] numsOf약수 = new int[right-left+1];
		
		for(int i = 0; i < right-left+1; i++) {
			// 매개변수로 넘어온 값들의 사이 수를 순회하는 반복문
			value[i] = left + i;
			
			for(int j = 1; j <= left+i; j++) {
				
				if((left+i)%(j) == 0) {
						numsOf약수[i] += 1;
				}
			}
		}

		int answer = 0;
		int i = 0;
		
		for(int k : numsOf약수) {
			
			if(k%2 == 0) {
				answer += value[i];
			} else {
				answer -= value[i];
			}
			i++;
		}
		
        return answer;
    }
}

	class 약수의개수와덧셈_다른사람 {
	    public int solution(int left, int right) {
	        int answer = 0;
	        for(int i=left; i<=right; i++){
	            int cnt = 0;
	            for(int j=1; j<=i; j++){
	                if(i%j==0) cnt++;
	            }
	            if(cnt%2==0) answer += i;
	            else answer -= i;
	        }
	        return answer;
	    }
	}
/*
 * 
 * 식도 비슷한데, 
 * 나의 코드는 배열도 활용하였고, for문 범위 지정을 더 간결하게 하지 못하였다.
 * 
 */
	
	