package level1;

public class ���¼��ڴ��ϱ� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * 0���� 9������ ���� �� �Ϻΰ� ����ִ� ���� �迭 numbers�� �Ű������� �־����ϴ�. 
		 * numbers���� ã�� �� ���� 0���� 9������ ���ڸ� 
		 * ��� ã�� ���� ���� return �ϵ��� solution �Լ��� �ϼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * 1 �� numbers�� ���� �� 9 
		 * 0 �� numbers�� ��� ���� �� 9 
		 * numbers�� ��� ���Ҵ� ���� �ٸ��ϴ�.
		 */
		
		System.out.println(solution(new int[] {1,2,3,4,5,6,7,9}));

	}
	
    public static int solution(int[] numbers) {
       
    	/*
    	 * ���� ������ Ǯ��
    	 * 1. 0~9 ������ ���� ���ϰ�, numbes�� �ε����� ������ ��� ����.
    	 * 
    	 */
    	
    	int answer = 45;
    	
    	for(int i = 0; i < numbers.length; i++) {
    		answer -= numbers[i];
    	}
    	
        return answer;
    }

}

	class ���¼��ڴ��ϱ�_�ٸ���� {
	    public int solution(int[] numbers) {
	        int sum = 45;
	        for (int i : numbers) {
	            sum -= i;
	        }
	        return sum;
	    }
	    // ���� for�� �����.
	}
	
	/*
	 * 
	 * �� ������ ���������� �ٵ� �����߰�, �� �� ���� Ǭ ������ �߿�
	 * ���� ������� ��õ�� ���� �ڵ�� ���� ��������.
	 * 
	 */
	
	