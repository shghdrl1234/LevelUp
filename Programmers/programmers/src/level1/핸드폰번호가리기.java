package level1;

import java.util.Arrays;

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
		
		solution("01077416096");

	}
	
	   public static String solution(String phone_number) {
	        
		   // 1. ���ڿ��� �޾ƿ´�.
		   // 2. ���ڿ��� ���̸� ���Ѵ�.
		   // 3. ���ڿ��� ���̸� �������� �ڿ��� 4�ڸ� �����ϰ� *�� �ٲ۴�.
		   
		   String answer = "";
		   String[] num = phone_number.split("");
		   // ���ڿ��� ���� �ϳ��� ��� �迭�� �����.
		   
		   for(int i = 0; i < num.length; i++) {
			  
			   if(i < num.length-4) {
				   answer += "*";
				   // �ε��� ��ȣ�� �ڿ��� ���� 4�ڸ����� �ƴϸ� ����.
				   
			   } else {
				   answer += num[i];
				   // �ε��� ��ȣ�� �ڿ��� ���� 4�ڸ��� ��� ����.
			   }
		   }
		   System.out.println(answer);
	        return answer;
	    }

}

		class �ڵ�����ȣ������_�ٸ���� {
		  public String solution(String phone_number) {
			  // �� ���� char Ÿ�� �迭�� ������ �ذ��Ͽ���.
			  
		     char[] ch = phone_number.toCharArray();
		     // ���ڿ��� charŸ������ �ϳ��ϳ� �������.
		     
		     for(int i = 0; i < ch.length - 4; i ++){
		         ch[i] = '*';
		         // �ε��� ��ȣ�� �ڿ� 4�ڸ����� �ƴϸ� *�� ��������.
		     }
		     return String.valueOf(ch);
		     // chŸ�� �迭�� String���� ��ȯ�Ͽ� ��ȯ.
		  }
		}
