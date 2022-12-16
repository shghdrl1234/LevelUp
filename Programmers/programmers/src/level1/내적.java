package level1;

import java.util.stream.IntStream;

public class ���� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ���̰� ���� �� 1���� ���� �迭 a, b�� �Ű������� �־����ϴ�. 
		 * a�� b�� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.
		 * 
		 * �̶�, a�� b�� ������ a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] �Դϴ�. 
		 * (n�� a, b�� ����)
		 * 
		 * ���ѻ��� 
		 * a, b�� ���̴� 1 �̻� 1,000 �����Դϴ�. 
		 * a, b�� ��� ���� -1,000 �̻� 1,000 �����Դϴ�.
		 */

		System.out.println(solution(new int[] {1,2,3,4,6}, new int[] {15,57,98,99,10} ));
	}
	
    public static int solution(int[] a, int[] b) {
    	
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * 1. �迭�� ���̸� Ȱ���Ѵ�.
    	 * 2. �ݺ��� ���.
    	 * 3. �ݺ��� �ܺο� ��ȸ�ϸ鼭 ���� ���� ���
    	 */
    	
        int answer = 0;
        
        for(int i = 0; i < a.length; i++) {
        	answer += a[i]*b[i];
        }
        return answer;
    }
	

}

class ����_�ٸ���� {
    public int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();
    }
}

/*
 * �������� �ۼ��� �ڵ带 ������ �� �ֵ��� �س���.
 * �ٸ� ����� �߿� ȿ�������� �𸣰����� �� �ٷ� �� ���� �����ͺ�. 
 */

