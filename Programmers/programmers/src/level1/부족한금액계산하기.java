package level1;

public class 부족한금액계산하기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않습니다. 
		 * 이 놀이기구의 원래 이용료는 price원 인데, 
		 * 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다. 
		 * 
		 * 즉, 처음 이용료가 100이었다면 2번째에는 200, 
		 * 3번째에는 300으로 요금이 인상됩니다. 
		 * 놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 
		 * 얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요. 
		 * 단, 금액이 부족하지 않으면 0을 return 하세요.
		 * 
		 * 제한사항 
		 * 놀이기구의 이용료 price : 1 ≤ price ≤ 2,500, price는 자연수 
		 * 처음 가지고 있던 금액 money : 1 ≤ money ≤ 1,000,000,000, money는 자연수 
		 * 놀이기구의 이용 횟수 count : 1 ≤ count ≤ 2,500, count는 자연수
		 */

	}

    public long solution(int price, int money, int count) {
        /*
         * 내가 문제 푸는 방법
         * 1. n번째 이용요금 => n * price
         * 2. count번 이용 금액 =>  count = price * (1+2+...+count)  
         * 3. 내 수중의 돈 money, => money - count으로 음수, 양수 판단하여 리턴
         * 
         */

    	long myMoney = money;
    	
    	long countOfPrice = 0;

    	long answer = 0;
    	
    	for(int i = 1; i<=count; i++) {
    		countOfPrice += i*price;
    	}
    	
    	if(myMoney - countOfPrice < 0) {
    		answer = Math.abs(myMoney - countOfPrice);
    	}
    
        return answer;
    }

}


	class 부족한금액계산하기_다른사람 {
	    public long solution(long price, long money, long count) {
	        return Math.max(price * (count * (count + 1) / 2) - money, 0);
	        // 이 분은 등차수열의 합으로 문제를 품.
	        // Math.max 란??
	    }
	}
	
	/*
	 * 1레벨에서 20문제 이상을 풀어보니 어느정도 감이와서 쉽게 풀리는 것 같다.
	 * 다른 분들의 코드를 참고해서 몰랐던 것이나, 다른 방식들을 공부해보자. 
	 *
	 * 
	 */
	
	