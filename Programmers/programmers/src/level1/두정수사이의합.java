package level1;

public class �������������� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �� ���� a, b�� �־����� �� 
		 * a�� b ���̿� ���� ��� ������ ���� �����ϴ� �Լ�, solution�� �ϼ��ϼ���. 
		 * ���� ���
		 * a = 3, b = 5�� ���, 3 + 4 + 5 = 12�̹Ƿ� 12�� �����մϴ�.
		 * 
		 * ���� ���� 
		 * a�� b�� ���� ���� �� �� �ƹ� ���� �����ϼ���. 
		 * a�� b�� -10,000,000 �̻� 10,000,000 ������ �����Դϴ�.
		 *  a�� b�� ��Ұ���� ���������� �ʽ��ϴ�.
		 * 
		 */

	}

	public static long solution(int a, int b) {
		long answer = 0;
		
		
		if(Math.abs(a-b)==0) {
			// ���밪�� �������� ����.
			
			return a;
			// ���� �����Ƿ� a ��ȯ�ϴ� ������ ����.
		}
		
		for(int i = 0; i < Math.abs(a-b)+1; i++) {
			// a�� b ������(a,b ����)�� ���̸� �����ϰ� �ݺ��� ����
			
			if(a>b) {
				answer += (b+i);
				
			} else {
				answer += (a+i);
			}
			
		}
		
		return answer;
	}
}


class ��������������_�ٸ���� {

    public long solution(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }

    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }
    // ���� ������ ���������� ���..
}


/*
 * 
 * 
 * ���� ���ε� ������� �ʿ��ϱ��� ����.
 * 
 * 
 * 
 * /
 */