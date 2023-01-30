package level2;

import java.util.Arrays;

public class 구명보트 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 
		 * 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
		 * 
		 * 예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 
		 * 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 
		 * 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
		 * 
		 * 구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
		 * 
		 * 사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 
		 * 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
		 * 
		 * 제한사항 
		 * 무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다. 
		 * 각 사람의 몸무게는 40kg 이상 240kg 이하입니다. 
		 * 구명보트의 무게 제한은 40kg 이상 240kg 이하입니다. 
		 * 구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
		 */
		solution(new int[] {70,50,80,50,51,52,54,115,54,79,65},150);
		
	}
	public static int solution(int[] people, int limit) {
		/*
		 * 내가 문제 푸는 방법
		 * 1. 무게 순서대로 정렬을 한다.
		 * 2. 정렬된 배열에서 최소 무게와 최대 무게의 합이 limit보다 크면, 최대 무게는 혼자 구명보트를 탑승해야한다.
		 * => 태워보내고, 원소의 순서는 max에서 한 칸 앞으로 당겨온다.
		 * 3. limit보다 크지 않다면, 두 원소를 태워 보낸다.
		 */

		int answer = 0; 
		Arrays.sort(people);
		int min_index = 0;
		int max_index = people.length-1;
		
		while(max_index >= min_index) {
			if(people[max_index] + people[min_index] <= limit) {
				answer++;
				max_index--;
				min_index++;
			}
			else {
				answer++;
				max_index--;
			}
		}
        
        return answer;
    }
	
    public static int solution2(int[] people, int limit) {
        /*
         * 내가 문제 푸는 방법
         * 1. people을 순회하면서 두 원소의 합이 limit이 되면 해당 원소들을 삭제, 카운트 변수 1증가.
         * 2. 순회 했는데 100이 되는 원소들이 없다면, 두 원소의 합이 100 이하가 될 때 원소들 삭제, 카운트 변수 1증가.
         * 3. 그 이외는 원소 개수만큼 카운트
         */
    	int answer = 0;
    	for(int i = 0; i < people.length; i++) {
    		if(people[i] < 40) {
    			continue;
    		}
    		
    		for(int j = i+1; j < people.length; j++) {

    			if(people[j] < 40) {
    				continue;
    			}
    			
    			if(people[i] + people[j] == limit) {
    				answer ++;
    				people[i] = 0;
    				people[j] = 0;
    				break;
    			}
    		}
    	}
    	
    	for(int i = 0; i < people.length; i++) {
			if(people[i] < 40) {
    			continue;
    		}
    		
    		for(int j = i+1; j < people.length; j++) {

    			if(people[j] < 40) {
    				continue;
    			}
    			
    			if(people[i] + people[j] < limit) {
    				answer ++;
    				people[i] = 0;
    				people[j] = 0;
    				break;
    			}
    		}
    	}
    	
    	for(int i : people) {
    		if(i > 0) {
    			answer ++;
    		}
    	}
    	
    	return answer;
    }
}

class 구명보트_다른사람 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }
    /*
     * 이 분은 1인으로 태우는 방법에서 - 2인을 태우는 경우를 빼주었다.
     */
}

/*
 * 처음 시도하였을 때는 limit에 딱 맞게 몸무게를 합하기 위헤
 * 많은 반복문이 순회되었다.
 * 
 * 탐욕법은 현재 순간에서 가장 최적의 해를 구하는 것으로,
 * 많은 순회보다, 현재 선택에서 가장 효율적인 결과를 도출할 수 있도록 하는 것이다.
 * 
 * 반례는 찾지 못하였지만, 최초로 시도한 코드에서는 100을 맞출 때 소모되는 비용이 
 * 효율적이지 못하였다.
 * 
 */

