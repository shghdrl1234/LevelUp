package level1;

public class �ڵ�����ȣ������ {

	public static void main(String[] args) {
		/*
		 * ���� ����
		 * ���α׷��ӽ� ������� �������� ��ȣ�� ���� 
		 * �������� ���� �� ������ ��ȭ��ȣ�� �Ϻθ� �����ϴ�. 
		 * 
		 * ��ȭ��ȣ�� ���ڿ� phone_number�� �־����� ��, 
		 * ��ȭ��ȣ�� �� 4�ڸ��� ������ ������ ���ڸ� 
		 * ���� *���� ���� ���ڿ��� �����ϴ� �Լ�,
		 * solution�� �ϼ����ּ���.
		 * 
		 * ���� ���� 
		 * phone_number�� ���� 4 �̻�, 20������ ���ڿ��Դϴ�.
		 * 
		 */

	}
	
	   public String solution(String phone_number) {
	        
		   // 1. ���ڿ��� �޾ƿ´�.
		   // 2. ���ڿ��� ���̸� ���Ѵ�.
		   // 3. ���ڿ��� ���̸� �������� �ڿ��� 4�ڸ� �����ϰ� *�� �ٲ۴�.
		   
		   String[] num = {phone_number};
		  
		   for(int i = 0; i < phone_number.length()-4; i++) {
			   num[i] = "*";
		   }
		   
		   
		   String answer = "";
	       	               
	        return answer;
	    }

}
