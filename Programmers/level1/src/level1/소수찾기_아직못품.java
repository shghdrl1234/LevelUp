package level1;

public class �Ҽ�ã��_������ǰ {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * 1���� �Է¹��� ���� n ���̿� �ִ� �Ҽ��� ������ ��ȯ�ϴ� �Լ�, solution�� ����� ������.
		 * 
		 * �Ҽ��� 1�� �ڱ� �ڽ����θ� ���������� ���� �ǹ��մϴ�. (1�� �Ҽ��� �ƴմϴ�.)
		 * 
		 * ���� ���� 
		 * n�� 2�̻� 1000000������ �ڿ����Դϴ�.
		 * 
		 * 
		 */

	}

    public int solution(int n) {
     /*
      * ���� ���� Ǫ�� ���
      * 1. n�� 1���� n���� �������� �������� ������ �ʴ� ���� 1�� n�� �����.
      * 
      */
    	int num = n;
    	int a = 0;
    	int answer = 0;
    	
    	for(int i = 2; i <= n; i++) {
    		
    		int j = 1;
    		while(j < i) {
    			
    			if(i%j == 0) {
    				a += 1;
    			}
    			j++;
    		}
    		
    		if(a == 2 ) {
    			answer += 1;
    		}
    			a=0;	
    		}
    	
        return answer;
    }
	
}
