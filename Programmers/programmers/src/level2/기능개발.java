package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 
		 * 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
		 * 
		 * 또, 각 기능의 개발속도는 모두 다르기 때문에
		 * 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 
		 * 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
		 * 
		 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 
		 * 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 
		 * 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
		 * 
		 * 제한 사항 
		 * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다. 
		 * 작업 진도는 100 미만의 자연수입니다. 작업 속도는 100 이하의 자연수입니다. 
		 * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
		 * 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
		 */

		solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
	}
	
    public static int[] solution(int[] progresses, int[] speeds) {
        /*
         * 내가 문제 푸는 방법
         * 1. progresses 첫번째 요소부터 100이 되어야 배포가 시작됨.
         * => 첫 번째 요소가 100이 되는 날, 연속적으로 위치한 요소들이 100인 개수만큼 배포.
         * 
         * 2.이후 배포가 되지 않은 progresses 요소들부터 다시 100이 되어야 배포가 됨. 
         * => 이전에 배포된 요소를 제외하고, 새로 추가로 100이 되어있는 요소들의 개수만큼 배포.
         * 
         * 3. 반복하여 progresses의 마지막 요소가 100이 될 때까지 진행.
         * => 즉, rerutn 해야하는 함수는 동적할당이 되면 좋다.
         *
         * => 가장 앞쪽의 요소가 100이 넘게되는 경우 배포가 됨.
         * => 선입 선출 활용
         */
    	
    	LinkedList<Integer> arr = new LinkedList<Integer>();
    	LinkedList<Integer> speedArr = new LinkedList<Integer>();
    	ArrayList<Integer> disArr = new ArrayList<Integer>();
    	
    	for(int i : progresses) {
    		arr.add(i);
    	}
    	
    	for(int i : speeds) {
    		speedArr.add(i);
    	}
    	
    	while(true) {
    		
    		// progresses를 순회하며, 같은 인덱스 위치에 있는 speeds 요소를 더함.
    		for(int j = 0; j < speedArr.size(); j++) {
    			arr.set(j, arr.get(j)+speedArr.get(j));
    		}
    		
    		// 첫 번째 위치한 요소가 100이 넘으면, 인접한 요소들에 100이 넘는 것을 찾아 배포.
    		if(arr.get(0) >= 100) {
    			int cnt = 0;
    			int k = 0;
				
				for(int i = 0; i < arr.size(); i++) {

					//100보다 작으면 반복문 종료
    				if(arr.get(i) < 100) {
    					break;
    				} else {
    				// 100보다 크면 삭제
	    				arr.remove();
	    				speedArr.remove();
	    				cnt ++;
	    				i--;
	    				k++;
    				}
    			}
				// 위의 if문에서 break위에 적어주는데, 만약 arr의 길이가 1인 상태에서 for문에 
				// 진입하면 마지막에는 추가가 되지 않는다.
				disArr.add(cnt);
    			
    		}
    		
    		if(arr.size() == 0) {
    			break;
    		}
    		
    	}
    	
    	int[] answer = new int[disArr.size()];
    	
    	 
    	for(int i = 0; i < disArr.size(); i++) {
    		answer[i] = disArr.get(i);
    	}
    	
        return answer;
    }

}

class 기능개발_다른사람 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
    
    /*
     * 스트림..? 공부 해야한다!!!
     * 
     */
}

class 기능개발_다른사람2 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
    /*
     * 완료 날짜를 먼저 계산하여 해결한 문제.
     * 
     */
}

/*
 * 전반적으로 다른 분들이 해결한 문제들은 내가 푼 방법보다
 * 코드도 짧았다.
 * 
 * 스트림을 빨리 배우자..
 */
