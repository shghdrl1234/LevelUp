package level2;

import java.util.Stack;

public class �ֽİ��� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �� ������ ��ϵ� �ֽİ����� ��� �迭 prices�� �Ű������� �־��� ��, 
		 * ������ �������� ���� �Ⱓ�� �� �������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
		 * 
		 * ���ѻ��� 
		 * prices�� �� ������ 1 �̻� 10,000 ������ �ڿ����Դϴ�. 
		 * prices�� ���̴� 2 �̻� 100,000 �����Դϴ�.
		 * 
		 */
	}
	
    public int[] solution(int[] prices) {
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * 
    	 * prices�� [1,2,3,2] ���� �־����� ��
    	 * 1�� ������ ������ 1, 5�� ���� ������ �������� ����.
    	 * 2�� ������ ������ 2, 5�� ���� ������ �������� ����.
    	 * 3�� ������ ������ 3, 4�� �� �� ������ ������ => 1�ʰ� ���� ������.
    	 * 
    	 * prices�� ���� i�� �������� ���� ���Һ��� ���Ͽ��� ��, i���� ���� ���� ī��Ʈ �Ѵ�.
    	 * => return �� i��°�� ���� ��.
    	 * 
    	 */
    	
    	// ��� �迭�� ���̴� �־��� �迭�� ���̿� ����.
        int[] answer = new int[prices.length];
        
        // ��� �迭�� ���� �ϳ��� ���� �˱����� �迭 ������ ���غ����Ѵ�.
        // ��ȸ�ϸ鼭, ������ �������� ������ ������ break;
        for(int i = 0; i < answer.length; i++) {

        	for(int j = i+1; j < prices.length; j++) {
        		// i ���� 1�� �Ŀ� ������ ������ ����
        		// 1�� ���� ������ �����Ǿ��ٴ� ��.
        		// break ���� ��� �迭�� ��� ���� ���� ��Ų��.
        		if(prices[i] > prices[j]) {
                    answer[i] ++;
                    break;
                }
        		// �迭 ������ ���鼭 ������ ������ ��� �迭�� ��� ���� ��� �ø���.
                if(prices[i] <= prices[j]) {
        			answer[i]++;
        		}
            }
        }
        return answer;
    }
}

class �ֽİ���_�ٸ���� {
    public int[] solution(int[] prices) {
        int len = prices.length; 
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<len; i++){ // prices �迭�� ũ�⵿�� �ݺ� ����
            
            // �񱳴��stack �ε����� price���� ���� ������ �ε����� price������ �۴ٸ�
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){ 
                //stack���� �ش簪�� ���ְ�
                int idx = stack.pop();
                //answer �ε����� �󸶸��� ã�Ҵ��� �־��ش�. 
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
 * ���� ���� �ݺ����� ���Ͽ� Ǯ����.
 * �ش� ������ �������� Ǯ���� ��Ʈ�� �־��µ� ���� ���� ���� �ʾƼ�
 * �������� Ǯ���� ������� �ڵ鸦 ���� �Ǿ���.
 * 
 * ȿ���� ���߹ݺ����� ���Ҵ�. �������ε� ���� Ǯ���� ���̾��µ� �����ϴ� ���� �ʹ� ������� �� ����.
 */ 
