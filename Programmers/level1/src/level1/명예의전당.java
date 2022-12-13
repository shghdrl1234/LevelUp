package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


public class �������� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * "���� ����"�̶�� TV ���α׷������� ���� 1���� ������ �뷡�� �θ���, 
		 * ��û�ڵ��� ���� ��ǥ���� �������� ������ �ο��մϴ�. 
		 * ���� �⿬�� ������ ������ ���ݱ��� �⿬ �������� ���� �� ���� k��° �̳��̸�
		 * �ش� ������ ������ ���� �����̶�� ��Ͽ� �÷� ����մϴ�. 
		 * �� ���α׷� ���� ���� �ʱ⿡ k�ϱ����� ��� �⿬ ������ ������ ���� ���翡 ������ �˴ϴ�. 
		 * 
		 * k�� �������ʹ� �⿬ ������ ������ ������ ���� ���� ����� k��° ������ ���� �������� �� ������, 
		 * �⿬ ������ ������ ���� ���翡 ������ �ǰ� ������ k��° ������ ������ ���� ���翡�� �������� �˴ϴ�.
		 * 
		 * �� ���α׷������� ���� "���� ����"�� ������ ������ ��ǥ�մϴ�. 
		 * 
		 * ���� ���, k = 3�̰�, 7�� ���� ����� ������ ������ [10, 100, 20, 150, 1, 100, 200]�̶��, 
		 * ���� ���翡�� ��ǥ�� ������ �Ʒ��� �׸��� ���� [10, 10, 10, 20, 20, 100, 100]�Դϴ�. 
		 * 
		 * ���� ���� ����� ������ ���� k, 1�Ϻ��� ������ ������ �⿬�� �������� ������ score�� �־����� ��, 
		 * ���� ��ǥ�� ���� ������ ������ ������ return�ϴ� solution �Լ��� �ϼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * 3 �� k �� 100 
		 * 7 �� score�� ���� �� 1,000 
		 * 0 �� score[i] �� 2,000
		 * 
		 * 
		 */

	}
    public int[] solution(int k, int[] score) {
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * 
    	 * ���� ���翡 ����Ǵ� ���� : K
    	 * �츮�� ���ؾ� �ϴ� �� ���� ���翡 ����� ���� �� ���� ���� ����.
    	 * 
    	 * 1. score[0] ~ score[k-1] ������ ���� �����̶�� ����Ʈ or �迭(���� honor)�� �߰� 
    	 * 2. score[k] ���ʹ� honor �迭���� ���� ���� �������� ũ��, �� ������ �����ϰ�, score[k]�� �μ�Ʈ
    	 * 3. �� �� ���� ���� ������ �̾Ƽ� ����.
    	 * 
    	 * -- ���� ���� �߻� --
    	 * ���� ���� ���� �����ϴ� ���� �ƴ϶�.
    	 * �� ȸ������ "honor" �迭 �� ���� ���� ������ �迭�� ����� �����ϴ� ����.
    	 * 
    	 * 1. �״��
    	 * 2. �״��, + ���� ���� "honor"������ �迭�� �ִ´�. ��, ���� for������ �̷�������
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

class ��������_�ٸ���� {
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
 *  ���� �ҽ��ڵ�� honor�� ������������ �����Ͽ� ������ �ε����� �����ϴ� ����� ����Ͽ���.
 * 
 *  ���� �ذ������ �� �ɸ��� �ʾ����� �ͼ����� ���� Collections Ŭ������ Ȱ���ϴٺ��� 
 *  collection.reverse()�� ����Ͽ� �� �� ���� �Ͽ���.
 *  
 *  ���� �ٸ� ���� �ۼ��� �ڵ�� ���ʹ� �ٸ��� ť�� Ȱ���Ͽ���.
 *  
 *  ���� ť�� ���� �ɵ��ְ� �������� ���Ͽ��µ� �� �� �غ��߰ڴ�.
 *  
 */
