package level1;

public class ������ϱ� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * � �������� �ֽ��ϴ�. 
		 * �� �������� ������ ���ʴ�� ���� ���� �迭 absolutes�� 
		 * �� �������� ��ȣ�� ���ʴ�� ���� �Ҹ��� �迭 signs�� �Ű������� �־����ϴ�. 
		 * ���� �������� ���� ���Ͽ� return �ϵ��� solution �Լ��� �ϼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * absolutes�� ���̴� 1 �̻� 1,000 �����Դϴ�. 
		 * absolutes�� ��� ���� ���� 1 �̻� 1,000 �����Դϴ�.
		 * signs�� ���̴� absolutes�� ���̿� �����ϴ�. 
		 * signs[i] �� ���̸� absolutes[i] �� ���� ������ �������,
		 * �׷��� ������ �������� �ǹ��մϴ�.
		 * 
		 */

	}
	
    public int solution(int[] absolutes, boolean[] signs) {
        
    	/*
    	 * ���� �����ϴ� Ǯ��
    	 * 
    	 * 1. true�� ���, false�� ����
    	 * 2. �迭�� ���̴� absolutes�� signs�� �����ϴ�, �ݺ��� ����ϱ� �����ϴ�.
    	 * 3-1. signs�� ���� ���� String �迭�� ����� �ְ�
    	 * 3-2. �Ǵ� �ݺ��� ������ ��ȣ�� ���� ���ļ�, ���.
    	 * 4. �ݺ����� ���Ͽ� ���Ѵ�.
    	 * 
    	 */
    	int answer = 0;
    	for(int i = 0; i < signs.length; i++) {
    		
    		if(signs[i]) {
    			// ��� �̸�
    			answer += absolutes[i];
    			
    		} else {
    			// �� ��, �� �����̴�. (0�� �հ迡 �־� ���� �ٲ��� ���Ѵٰ� �Ǵ�.)
    			answer -= absolutes[i];
    		}
    	}
    	
        return answer;
    }

}

	class ������ϱ�_�ٸ���� {
	    public int solution(int[] absolutes, boolean[] signs) {
	        int answer = 0;
	        for (int i=0; i<signs.length; i++)
	            answer += absolutes[i] * (signs[i]? 1: -1);
	        // ����ϰ� ������.
	        return answer;
	    }
	}
	
	/*
	 * ���� ������ ���� ���� ���.
	 * 
	 * 
	 */
	
	
	