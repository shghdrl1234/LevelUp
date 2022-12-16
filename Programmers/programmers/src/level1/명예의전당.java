package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


public class 명예의전당 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * "명예의 전당"이라는 TV 프로그램에서는 매일 1명의 가수가 노래를 부르고, 
		 * 시청자들의 문자 투표수로 가수에게 점수를 부여합니다. 
		 * 매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면
		 * 해당 가수의 점수를 명예의 전당이라는 목록에 올려 기념합니다. 
		 * 즉 프로그램 시작 이후 초기에 k일까지는 모든 출연 가수의 점수가 명예의 전당에 오르게 됩니다. 
		 * 
		 * k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k번째 순위의 가수 점수보다 더 높으면, 
		 * 출연 가수의 점수가 명예의 전당에 오르게 되고 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.
		 * 
		 * 이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다. 
		 * 
		 * 예를 들어, k = 3이고, 7일 동안 진행된 가수의 점수가 [10, 100, 20, 150, 1, 100, 200]이라면, 
		 * 명예의 전당에서 발표된 점수는 아래의 그림과 같이 [10, 10, 10, 20, 20, 100, 100]입니다. 
		 * 
		 * 명예의 전당 목록의 점수의 개수 k, 1일부터 마지막 날까지 출연한 가수들의 점수인 score가 주어졌을 때, 
		 * 매일 발표된 명예의 전당의 최하위 점수를 return하는 solution 함수를 완성해주세요.
		 * 
		 * 제한사항 
		 * 3 ≤ k ≤ 100 
		 * 7 ≤ score의 길이 ≤ 1,000 
		 * 0 ≤ score[i] ≤ 2,000
		 * 
		 * 
		 */

	}
    public int[] solution(int k, int[] score) {
    	/*
    	 * 내가 문제 푸는 방법
    	 * 
    	 * 명예의 전당에 등재되는 개수 : K
    	 * 우리가 구해야 하는 건 명예의 전당에 등재된 점수 중 가장 낮은 점수.
    	 * 
    	 * 1. score[0] ~ score[k-1] 까지는 명예의 전당이라는 리스트 or 배열(이하 honor)에 추가 
    	 * 2. score[k] 부터는 honor 배열에서 가장 낮은 점수보다 크면, 그 점수를 삭제하고, score[k]를 인서트
    	 * 3. 그 후 가장 낮은 점수를 뽑아서 리턴.
    	 * 
    	 * -- 착오 사항 발생 --
    	 * 가장 낮은 값을 리턴하는 것이 아니라.
    	 * 각 회차별로 "honor" 배열 중 가장 낮은 점수를 배열로 만들어 리턴하는 것임.
    	 * 
    	 * 1. 그대로
    	 * 2. 그대로, + 가장 낮은 "honor"점수를 배열에 넣는다. 즉, 같은 for문에서 이뤄져야함
    	 * 
    	 */
    	
    	ArrayList<Integer> honor = new ArrayList<Integer>();
    	
    	int[] answer = new int[score.length];
    	
    	for(int i = 0; i < k; i++) {
    		
    		if(i > score.length-1) {
    			break;
    		}
    		
    		honor.add(i, score[i]);
    		Collections.sort(honor, Collections.reverseOrder());
    		answer[i] = honor.get(i);
    	}
    	
    	Collections.sort(honor, Collections.reverseOrder());
    	
    	if(k < score.length) {
    		
    		for(int i = k; i < score.length; i++) {
    			
    			if(score[i] > honor.get(k-1)) {
    				honor.set(k-1, score[i]);
    				Collections.sort(honor, Collections.reverseOrder());
    	    		answer[i] = honor.get(k-1);
    			} else {
    				answer[i] = honor.get(k-1);
    			}
    			
    		}
    	}
    	
        return answer;
    }

}

class 명예의전당_다른사람 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num=0; num<score.length;num++) {
            queue.add(score[num]);
            if(queue.size()<=k) {
                answer[num]=queue.peek();
            }else {
                queue.remove();
                answer[num]=queue.peek();
            }
        }

        return answer;
    }
}

/*
 *  나의 소스코드는 honor을 내림차순으로 정렬하여 마지막 인덱스를 추출하는 방식을 사용하였다.
 * 
 *  문제 해결까지는 얼마 걸리지 않았지만 익숙하지 않은 Collections 클래스를 활용하다보니 
 *  collection.reverse()를 사용하여 몇 번 실패 하였다.
 *  
 *  또한 다른 분이 작성한 코드는 나와는 다르게 큐를 활용하였다.
 *  
 *  아직 큐에 대해 심도있게 공부하지 못하였는데 한 번 해봐야겠다.
 *  
 */
