package level1;

import java.util.ArrayList;
import java.util.List;

public class �����������Ǻ� {

	public static void main(String[] args) {
		/*
		 * ���� ����
		 * 
		 * ������ ���� ���� n�� ����, n�� � ���� ���� x�� �������� �ƴ��� �Ǵ��Ϸ� �մϴ�. 
		 * n�� ���� ���� x�� �����̶�� x+1�� ������
		 * �����ϰ�, n�� ���� ���� x�� ������ �ƴ϶�� -1�� �����ϴ� �Լ��� �ϼ��ϼ���.
		 * 
		 * ���� ����
		 * 
		 * n�� 1�̻�, 50000000000000 ������ ���� �����Դϴ�.
		 * 
		 */
		System.out.println(solution(12));

	}

	public static long solution(long n) {
		long answer = 0;
		
		// �ݺ����� ���ؼ�..
		
		
		for(int x = 1; x <=n; x++) {
			
			if(x*x == n) {
				
				return (x+1)*(x+1);
			}
			
		}

		return -1;
	}

//	   public static long solution(long n) {
//	        long answer = 0;
//	        // �μ� ���� ��, �迭�� �� ���� ����,
//	        // �迭�� ���̰� Ȧ�� �̸�, x+1 ��������,
//	        // �迭�� ���̰� ��� �̸�, -1 ����,
//	        
//	        // �迭�� ���̰� Ȧ���� ����%2+1�Ͽ� x�� ����.
//	        
//	        int i = 1;
//	        
//	        
//	        while(n>=i) {
//	        	
//	        	if(n%i == 0) {
//	        		
//	        	}
//	        	i++;
//	        }
//	        
//	        System.out.println(str);
//	        
//	        if(str.length()/2 == 0 ) {
//	        	
//	        	return -1;
//	        }
//	        	
//	        answer = Integer.valueOf(str.indexOf(str.length()%2+1));
//	        	
//	        return (answer+1)*(answer+1);
//	    }
}



class �����������Ǻ�_�ٸ���� {
  public long solution(long n) {
      if (Math.pow((int)Math.sqrt(n), 2) == n) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }

        return -1;
  }
}
