package level2;

import java.util.Arrays;
import java.util.Comparator;

public class A못품_피로도 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * XX게임에는 피로도 시스템(0 이상의 정수로 표현합니다)이 있으며, 
		 * 일정 피로도를 사용해서 던전을 탐험할 수 있습니다. 
		 * 이때, 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"와 
		 * 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다.
		 * 
		 * "최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며, 
		 * "소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다. 
		 * 예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 유저의 현재 남은
		 * 피로도는 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 20이 소모됩니다.
		 * 
		 * 이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 
		 * 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다. 
		 *
		 * 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 
		 * 2차원 배열 dungeons 가 매개변수로 주어질 때, 
		 * 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.
		 * 
		 * 제한사항
		 * k는 1 이상 5,000 이하인 자연수입니다.
		 * dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
		 * dungeons의 가로(열) 길이는 2 입니다. 
		 * dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
		 * "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다. 
		 * "최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다. 
		 * 서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.
		 * 
		 */

	}
	
    public int solution(int k, int[][] dungeons) {
    	/*
    	 * 내가 문제 푸는 방법
    	 * 
    	 * 조건 : 탐험 할 수 있는 최대 던전 수를 구하라.
    	 * 
    	 * 1. 각 던전의 소모 피로도를 고려한다.
    	 * 
    	 * 2. 각 던전의 최소 필요 피로도를 고려한다.
    	 * 
    	 * 3. 각 던전 출입시 현재 피로도 k에서 해당 던전의 소모 피로도만큼 감소 시킨다.
    	 * 
    	 * => 소모 피로도가 가장 작은 던전부터 탐험한다.
    	 * => 소모 피로도가 가장 작은 던전의 최소 필요 피로도를 충족하지 못할 시 다음으로 소모 피로도가 적은 던전을 탐험한다.
    	 * => 언제까지? 던전을 못 돌 때 까지.
    	 * 
    	 * => 한 던전은 한 번 밖에 돌지 못한다.
    	 */
    	int health = k;
    	
    	//던전 탐험수
    	int explore = 0;
    	
    	int[][] arr = dungeons.clone();
    	
    	// 던전 조건을 2차 원소의 값을 기준으로 오름차순 정렬
    	Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0]));
    	
    	
    	while(true) {
    		int cnt = 0;
    		
    		for(int i = 0; i < arr.length; i++) {
    			
    			// 피로도가 최소필요 피로도보다 크면 시행
    			if(health >= arr[i][0]) {
    				// 탐험 횟수 증가, 피로도 감소
    				explore ++;
    				cnt ++;
    				health -= arr[i][1];
    			}
    		}
    		
    		if(cnt == 0) {
    			break;
    		}
    	}
    	
    	
        return explore;
    }

}
