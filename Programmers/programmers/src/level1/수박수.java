package level1;

public class ���ڼ� {

	public static void main(String[] args) {
		/*
		 * 
		 * ���� ���� 
		 * ���̰� n�̰�, "���ڼ��ڼ��ڼ�...."�� ���� ������ �����ϴ� 
		 * ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ��ϼ���. �������
		 * 
		 * n�� 4�̸� "���ڼ���"�� �����ϰ� 3�̶�� "���ڼ�"�� �����ϸ� �˴ϴ�.
		 * 
		 * ���� ���� 
		 * n�� ���� 10,000������ �ڿ����Դϴ�.
		 */
		System.out.println(solution(12));

	}
    public static String solution(int n) {
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * 1. ���ڿ��� ���� n�� Ȱ��
    	 * 2. �ε����� ���ڰ� Ȧ�� => "��"
    	 * 3. �ε����� ���ڰ� ¦�� => "��"
    	 * 
    	 */
    	
    	String answer = "";
    	for(int i = 0; i < n; i++) {

    		answer = (i%2==0) ? answer+"��" : answer+"��";
//    		result += i % 2 == 0 ? "��" : "��";
    		// �ٸ� �� �ڵ忡�� �����Ͽ���.
    		// �� �ڵ忡�� �ߺ��Ǵ� ���� ����.
    		
    	}
    	
    	
        return answer;
    }
}

	class ���ڼ�_�ٸ���� {
		public String watermelon(int n){
    		
			return new String(new char [n/2+1]).replace("\0", "����").substring(0,n);
			// �˰��� �̶�� �ϴ� ��۰� 
			// �� char �迭�� �����ϸ� \0���� ���� �����ȴٴ� ���.
			// ���� ����߰ڴ�.
    }
}