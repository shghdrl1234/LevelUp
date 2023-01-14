package level1;

public class A��ǰ_�Ҽ�ã�� {

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
		solution(10);
	}

    public static int solution(int n) {
     /*
      * ���� ���� Ǫ�� ���
      * 1. �Ҽ� = �ִ� ����� �ڱ� �ڽ�.
      * => 1���� n ���� ������ ���� �ִ� ������� ���Ѵ�.
      * => �ִ� �������, ������ ���� ������ ī��Ʈ
      * => �����佺�׳׽��� ä ����� ���.
      */
    	
    	int answer = 0;
    	
    	boolean[] prime = new boolean[n+1];
    	
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
	        
			// �̹� üũ�� �迭�̸� ���� �ݺ������� skip
			if(prime[i] == true) {
				continue;
			}
        
			// i �� ������� �ɷ��ֱ� ���� �ݺ���
			for(int j = i * i; j < prime.length; j = j+i) {
				prime[j] = true;
			}
		}
    	
    	for(int i = 0; i < prime.length; i++) {
			if(prime[i] == false) {	// �Ҽ�(false)�� ��� ���
				answer ++;
			}
		}
    	
    	return answer;
    }
    
}
    
