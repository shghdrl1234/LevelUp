package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ��ɰ��� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ���α׷��ӽ� �������� ��� ���� �۾��� ���� ���Դϴ�. 
		 * �� ����� ������ 100%�� �� ���񽺿� �ݿ��� �� �ֽ��ϴ�.
		 * 
		 * ��, �� ����� ���߼ӵ��� ��� �ٸ��� ������
		 * �ڿ� �ִ� ����� �տ� �ִ� ��ɺ��� ���� ���ߵ� �� �ְ�, 
		 * �̶� �ڿ� �ִ� ����� �տ� �ִ� ����� ������ �� �Բ� �����˴ϴ�.
		 * 
		 * ���� �����Ǿ�� �ϴ� ������� �۾��� ������ ���� ���� �迭 progresses�� 
		 * �� �۾��� ���� �ӵ��� ���� ���� �迭 speeds�� �־��� �� 
		 * �� �������� �� ���� ����� �����Ǵ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
		 * 
		 * ���� ���� 
		 * �۾��� ����(progresses, speeds�迭�� ����)�� 100�� �����Դϴ�. 
		 * �۾� ������ 100 �̸��� �ڿ����Դϴ�. �۾� �ӵ��� 100 ������ �ڿ����Դϴ�. 
		 * ������ �Ϸ翡 �� ���� �� �� ������, �Ϸ��� ���� �̷�����ٰ� �����մϴ�.
		 * ���� ��� �������� 95%�� �۾��� ���� �ӵ��� �Ϸ翡 4%��� ������ 2�� �ڿ� �̷�����ϴ�.
		 */

		solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
	}
	
    public static int[] solution(int[] progresses, int[] speeds) {
        /*
         * ���� ���� Ǫ�� ���
         * 1. progresses ù��° ��Һ��� 100�� �Ǿ�� ������ ���۵�.
         * => ù ��° ��Ұ� 100�� �Ǵ� ��, ���������� ��ġ�� ��ҵ��� 100�� ������ŭ ����.
         * 
         * 2.���� ������ ���� ���� progresses ��ҵ���� �ٽ� 100�� �Ǿ�� ������ ��. 
         * => ������ ������ ��Ҹ� �����ϰ�, ���� �߰��� 100�� �Ǿ��ִ� ��ҵ��� ������ŭ ����.
         * 
         * 3. �ݺ��Ͽ� progresses�� ������ ��Ұ� 100�� �� ������ ����.
         * => ��, rerutn �ؾ��ϴ� �Լ��� �����Ҵ��� �Ǹ� ����.
         *
         * => ���� ������ ��Ұ� 100�� �ѰԵǴ� ��� ������ ��.
         * => ���� ���� Ȱ��
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
    		
    		// progresses�� ��ȸ�ϸ�, ���� �ε��� ��ġ�� �ִ� speeds ��Ҹ� ����.
    		for(int j = 0; j < speedArr.size(); j++) {
    			arr.set(j, arr.get(j)+speedArr.get(j));
    		}
    		
    		// ù ��° ��ġ�� ��Ұ� 100�� ������, ������ ��ҵ鿡 100�� �Ѵ� ���� ã�� ����.
    		if(arr.get(0) >= 100) {
    			int cnt = 0;
    			int k = 0;
				
				for(int i = 0; i < arr.size(); i++) {

					//100���� ������ �ݺ��� ����
    				if(arr.get(i) < 100) {
    					break;
    				} else {
    				// 100���� ũ�� ����
	    				arr.remove();
	    				speedArr.remove();
	    				cnt ++;
	    				i--;
	    				k++;
    				}
    			}
				// ���� if������ break���� �����ִµ�, ���� arr�� ���̰� 1�� ���¿��� for���� 
				// �����ϸ� ���������� �߰��� ���� �ʴ´�.
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

class ��ɰ���_�ٸ���� {
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
     * ��Ʈ��..? ���� �ؾ��Ѵ�!!!
     * 
     */
}

class ��ɰ���_�ٸ����2 {
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
     * �Ϸ� ��¥�� ���� ����Ͽ� �ذ��� ����.
     * 
     */
}

/*
 * ���������� �ٸ� �е��� �ذ��� �������� ���� Ǭ �������
 * �ڵ嵵 ª�Ҵ�.
 * 
 * ��Ʈ���� ���� �����..
 */
