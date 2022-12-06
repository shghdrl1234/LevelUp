package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A못품_실패율 {

	public static void main(String[] args) {
		/*
		 * 슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 
		 * 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다.
		 * 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
		 * 
		 * 이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 
		 * 역시 슈퍼 개발자라 대부분의 로직은 쉽게
		 * 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다.
		 *  오렐리를 위해 실패율을 구하는 코드를 완성하라.
		 * 
		 * 실패율은 다음과 같이 정의한다. 
		 * 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
		 * 
		 * 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 
		 * 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 
		 * 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 
		 * 배열을 return 하도록 solution 함수를 완성하라.
		 * 
		 * 제한사항 
		 * 스테이지의 개수 N은 1 이상 500 이하의 자연수이다. 
		 * stages의 길이는 1 이상 200,000 이하이다. 
		 * stages에는 1 이상 N + 1 이하의 자연수가 담겨있다. 
		 * 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다. 
		 * 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다. 
		 * 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다. 
		 * 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
		 * 
		 * 
		 */
		
		solution(5,new int[]{2,1,2,6,2,4,3,3});

	}
	
    public static double[] solution(int N, int[] stages) {
        /*
         * 내가 문제 푸는 방법
         * 
         * - a: 도달한 사람 
         * - b: 도달하지 못한 사람
         * - c: 전체 수
         * 
         * 1. 순회문 중 i와 statges의 원소를 비교해서, i보다 작거나 같은 수의 개수를 구함. (스테이지 클리어 못함) 
         * => 실패율 : c - i 이하의 개수 - b / a
         * 
         * 
         *
         */
    	double[] answer = new double[N];
    	
    	double challange = 0;
    	double ingOrClear = stages.length;

    	Map<Integer,Double> failure = new HashMap<Integer, Double>();
    	
    	for(int i = 1 ; i < N+1; i++) {
    		// 1~N 스테이지 까지 순회
    		
    		for(int j = 0; j < stages.length; j++) {
    			// 각 스테이지(i) 별로 순회하여 도달한 사람을 탐색.
    			
    			if(i == stages[j]) {
    				challange += 1;
    				// 현재 i 스테이지에 머물고 있다면 카운트.
    			}
    			
    		}
    		System.out.println(challange +", " + ingOrClear);
    		failure.put(i-1, (double) (challange/(ingOrClear)));
    		ingOrClear = ingOrClear-challange;
    		challange = 0;
    	}
    	System.out.println(failure);

    	List<Double> valueSet = new ArrayList<Double>(failure.values());
    	valueSet.sort(Double :: compareTo);
    	for(int i = 0; i < failure.size(); i++) {
    		answer[i] = valueSet.get(i);
    	}
    	System.out.println(Arrays.toString(answer));
        return  answer ;
    }

}
