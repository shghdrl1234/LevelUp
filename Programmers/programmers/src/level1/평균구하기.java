package level1;

public class ��ձ��ϱ� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ������ ��� �ִ� �迭 arr�� ��հ��� return�ϴ� �Լ�, solution�� �ϼ��غ�����.
		 * 
		 * ���ѻ��� 
		 * arr�� ���� 1 �̻�, 100 ������ �迭�Դϴ�. 
		 * arr�� ���Ҵ� -10,000 �̻� 10,000 ������ �����Դϴ�.
		 * 
		 */
		Solution s = new Solution();
			
		int[] a = {1,2,3,4};
		s.solution(a);
		System.out.println(s.solution(a));
	}
	
	
}

// �� Ǯ��
class Solution {
	
    public double solution(int[] arr) {
        
    	double answer = 0;
        
        for(int i = 0; i < arr.length; i++) {
        	answer += arr[i];
        }
        answer = answer/arr.length;
        
        return answer;
    }
}

// 