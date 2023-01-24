package level1;

import java.util.HashSet;

public class 소수만들기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
		 * 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 
		 * 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution
		 * 함수를 완성해주세요.
		 * 
		 * 제한사항 
		 * nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다. 
		 * nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
		 * 
		 */
		
		solution(new int[] {1,2,3,4});
	}
    public static int solution(int[] nums) {
        /*
         * 내가 문제 푸는 방법
         * 1. 숫자 3개를 선택하여 더한다.
         * 2. 소수 판별한다.
         * 3. 소수면 카운트
         * 
         * 4. 여기서 더했는데 숫자가 같다 => 소수판별 안함. 
         */
    	HashSet<Integer> hs = new HashSet<Integer>();
    	
    	int count = 0; // 합이 소수면 카운트.
    	for(int i = 0; i < nums.length-2; i++) {
    		
    		for(int j = i+1; j < nums.length-1; j++) {
    			for(int k = j+1; k < nums.length; k++) {
    				int total = nums[i]+nums[j]+nums[k];
    					count += is_prime(total);
    			}
    		}
    	}
        return count;
    }
    
	public static int is_prime(int num) {
		if(num < 2) {
			return 0;
		}
		// 2는 소수다.
		if(num == 2) {
			return 1;
		}

		for(int i = 2; i < num; i++) {
			// 소수가 아닐경우
			if(num % i == 0) {
				return 0;
			}
		}
		
		return 1;
	}
}

/*
 * 소수 알고리즘을 공부하지 않았다면 쉽게 풀 수 없는 문제다.
 * 하지만 소수 알고리즘을 알고 있다면, 여타 다른 문제보다 훨씬 쉽게 풀 수 있다.
 */ 
