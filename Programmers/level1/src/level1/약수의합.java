package level1;

public class ������� {

	public static void main(String[] args) {
		/*
		 * ���� ���� ���� n�� �Է¹޾� n�� ����� ��� ���� ���� �����ϴ� �Լ�, 
		 * solution�� �ϼ����ּ���. 
		 * 
		 * ���� ���� 
		 * n�� 0 �̻� 3000������ �����Դϴ�.
		 * 
		 * 
		 */
		
		System.out.println(solution(12));

	}

	
	  public static int solution(int n) {

		  int total=0;
		  for(int i = 1; i <= n; i++) {
			  if(n%i ==0) {
				  total += i;
			  }
		  }
		  
		  return total;
	  }
}
