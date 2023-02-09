package level2;

import java.util.Stack;

public class 주식가격 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 
		 * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
		 * 
		 * 제한사항 
		 * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다. 
		 * prices의 길이는 2 이상 100,000 이하입니다.
		 * 
		 */
	}
	
    public int[] solution(int[] prices) {
    	/*
    	 * 내가 문제 푸는 방법
    	 * 
    	 * prices가 [1,2,3,2] 으로 주어졌을 때
    	 * 1초 시점의 가격은 1, 5초 까지 가격이 떨어지지 않음.
    	 * 2초 시점의 가격은 2, 5초 까지 가격이 떨어지지 않음.
    	 * 3초 시점의 가격은 3, 4초 일 때 가격이 떨어짐 => 1초간 가격 유지됨.
    	 * 
    	 * prices의 원소 i를 기준으로 다음 원소부터 비교하였을 때, i보다 작을 때를 카운트 한다.
    	 * => return 할 i번째의 값이 됨.
    	 * 
    	 */
    	
    	// 결과 배열의 길이는 주어진 배열의 길이와 같다.
        int[] answer = new int[prices.length];
        
        // 결과 배열의 원소 하나의 값을 알기위해 배열 끝까지 비교해봐야한다.
        // 순회하면서, 가격이 떨어지는 시점이 있으면 break;
        for(int i = 0; i < answer.length; i++) {

        	for(int j = i+1; j < prices.length; j++) {
        		// i 에서 1초 후에 가격이 떨어진 것은
        		// 1초 동안 가격이 유지되었다는 말.
        		// break 전에 결과 배열의 요소 값을 증가 시킨다.
        		if(prices[i] > prices[j]) {
                    answer[i] ++;
                    break;
                }
        		// 배열 끝까지 가면서 가격이 오르면 결과 배열의 요소 값을 계속 올린다.
                if(prices[i] <= prices[j]) {
        			answer[i]++;
        		}
            }
        }
        return answer;
    }
}

class 주식가격_다른사람 {
    public int[] solution(int[] prices) {
        int len = prices.length; 
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<len; i++){ // prices 배열의 크기동안 반복 진행
            
            // 비교대상stack 인덱스의 price값이 현재 비교중인 인덱스의 price값보다 작다면
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){ 
                //stack에서 해당값은 빼주고
                int idx = stack.pop();
                //answer 인덱스에 얼마만에 찾았는지 넣어준다. 
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        System.out.println(stack);
        
        while(!stack.isEmpty()){
            int leftIdx = stack.pop();
            answer[leftIdx] = len-leftIdx-1;
        }
        
        return answer;
    }
}

/*
 * 나는 이중 반복문을 통하여 풀었다.
 * 해당 문제는 스택으로 풀어보라고 힌트를 주었는데 도통 감이 오지 않아서
 * 스택으로 풀었던 사람들의 코들를 보게 되었다.
 * 
 * 효율은 이중반복문이 좋았다. 스택으로도 쉽게 풀리는 것이었는데 생각하는 것이 너무 힘들었던 것 같다.
 */ 
