package level1;

import java.util.ArrayList;

public class 푸드파이터대회 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 수웅이는 매달 주어진 음식을 빨리 먹는 푸드 파이트 대회를 개최합니다. 
		 * 이 대회에서 선수들은 1대 1로 대결하며, 매 대결마다 음식의 종류와 양이 바뀝니다. 
		 * 대결은 준비된 음식들을 일렬로 배치한 뒤, 한 선수는 제일 왼쪽에 있는 음식부터 오른쪽으로, 
		 * 다른 선수는 제일 오른쪽에 있는 음식부터 왼쪽으로 순서대로 먹는 방식으로 진행됩니다. 
		 * 중앙에는 물을 배치하고, 물을 먼저 먹는 선수가 승리하게 됩니다.
		 * 
		 * 이때, 대회의 공정성을 위해 두 선수가 먹는 음식의 종류와 양이 같아야 하며, 음식을 먹는 순서도 같아야 합니다.
		 * 또한, 이번 대회부터는 칼로리가 낮은 음식을 먼저 먹을 수 있게 배치하여 선수들이 음식을 더 잘 먹을 수 있게 하려고 합니다. 
		 * 이번 대회를 위해 수웅이는 음식을 주문했는데, 대회의 조건을 고려하지 않고 
		 * 음식을 주문하여 몇 개의 음식은 대회에 사용하지 못하게 되었습니다.
		 * 
		 * 예를 들어, 3가지의 음식이 준비되어 있으며, 칼로리가 적은 순서대로 
		 * 1번 음식을 3개, 2번 음식을 4개, 3번 음식을 6개 준비했으며, 물을 편의상 0번 음식이라고 칭한다면, 
		 * 두 선수는 1번 음식 1개, 2번 음식 2개, 3번 음식 3개씩을 먹게 되므로 음식의 배치는 "1223330333221"이 됩니다. 
         *
		 * 따라서 1번 음식 1개는 대회에 사용하지 못합니다.
		 * 
		 * 수웅이가 준비한 음식의 양을 칼로리가 적은 순서대로 나타내는 정수 배열 food가 주어졌을 때, 
		 * 대회를 위한 음식의 배치를 나타내는 문자열을 return 하는 solution 함수를 완성해주세요.
		 * 
		 * 제한사항 
		 * 2 ≤ food의 길이 ≤ 9 
		 * 1 ≤ food의 각 원소 ≤ 1,000 
		 * food에는 칼로리가 적은 순서대로 음식의 양이 담겨 있습니다. 
		 * food[i]는 i번 음식의 수입니다. 
		 * food[0]은 수웅이가 준비한 물의 양이며, 항상 1입니다. 
		 * 정답의 길이가 3 이상인 경우만 입력으로 주어집니다.
		 */

	}
	
    public String solution(int[] food) {
    	
    	/*
    	 * 
    	 * 내가 푸는 방법
    	 * 
    	 * 수웅이가 준비한 음식의 배열과, 음식 배치의 배열은 다르다.
    	 * 수웅이의 배열 food 각 인덱스의 수 => 수웅이가 준비한 음식[i] 의 수.
    	 * 
    	 * 1. 배열 food에서 food[0]을 제외하고 food[i]의 원소값은 짝수거나, 원소값보다 작은 짝수로 바꿔주기
    	 * 2. String 음식 배치의 길이는 홀수이며, 짝수로 만든 food[i]의 각 원소값*i +1 이다.
    	 * 3. String의 배치는 0~n-1까지는 오름차순, n = 0,  n+1 ~ 2n 까지는 내림차순.
    	 *
    	 * 3-1. String에 food[0]원소의 절반을 먼저 배치
    	 * 3-2. String에 food[i]원소의 절반을 먼저 배치
    	 * 3-3. String에 food[n]은 0을 배치
    	 * 3-4. String에 food[i]원소의 절반을 먼저 배치
    	 * 3-5. String에 food[0]원소의 절반을 먼저 배치
    	 */
    	String answer = "";
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	
    	for(int i : food) {
    		i -= (i%2 != 0) ? 1 : 0;
    		// food[i] 값이 홀수이면 그 값에 -1을 취한다.
    		
    		i /= 2;
    		// 애초에 반으로 잘라서 String에 순차적으로 대입하고, 나머지는 역순으로 붙일 생각.

    		arr.add(i);
    		// 가공된 food[i] 값을 arr에 저장.
    	}
    	
    	int total_length = 0;
    	
    	for(int i = 1; i < arr.size(); i++) {
    		// i는 0일 때는 시행 안되게 함.
    		
    		total_length += arr.get(i);
    		// 배치될 음식의 길이를 구해서 저장.
    	}
    	
    	// 이제 뭐해야 되나?
    	// 인덱스 번호가 낮은 것 부터 숫자대로 꺼내서 붙인다.
    	for(int i = 1; i < arr.size(); i++) {
    		
    		for(int j = 0; j < arr.get(i); j++) {
    			answer += ("" + i);
    		}
    	}

    	answer += "0";
    	
    	for(int i = arr.size()-1; i >= 1; i--) {
    		
    		for(int j = 0; j < arr.get(i); j++) {
    			answer += ("" + i);
    		}
    	}
    	
    	if(answer.length() >= 3) {
    		return answer;
    	}
    	
        
        return answer;
    }

}

	class 푸드파이터대회_다른사람 {
	    public String solution(int[] food) {
	        String answer = "0";
	
	        for (int i = food.length - 1; i > 0; i--) {
	            for (int j = 0; j < food[i] / 2; j++) {
	                answer = i + answer + i; 
	            }
	        }
	
	        return answer;
	    }
	}

	class 푸드파이터대회_다른사람2 {
	    public String solution(int[] food) {
	        StringBuilder builder = new StringBuilder();
	        for (int i=1; i<food.length; i++) {
	            int result = food[i] / 2;
	            builder.append(String.valueOf(i).repeat(result));
	        }
	        String answer = builder + "0";
	        return answer + builder.reverse();
	    }
	}


/*
 * 다른 사람의 첫번째 코드는 생각을 조금 달리하여 간결하게 나타낸 것이다.
 * 
 * 두번째 코드는 String 빌더의 reverse()메서드를 사용하였다.
 * 이 코드는 나의 코드와 작동하는 방법은 비슷하다고 생각함.
 * 
 * 하지만 String 빌더도 공부해자.
 * 
 * 
 * 
 */ 
