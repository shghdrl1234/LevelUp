package level1;

public class ¦����Ȧ�� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ���� num�� ¦���� ��� 
		 * "Even"�� ��ȯ�ϰ� Ȧ���� ��� "Odd"�� ��ȯ�ϴ� �Լ�, 
		 * solution�� �ϼ����ּ���.
		 * 
		 * ���� ���� 
		 * num�� int ������ �����Դϴ�. 0�� ¦���Դϴ�
		 * 
		 */
		System.out.println(solution(-11));
		
	}

	public static String solution(int num) {
		
		System.out.println(num%2+","+num/2);
		if(num == 0) {
			return "Even";
		}
		
		if(num%2 == 1 || num%2 == -1 ) {
			return "Odd";
		}
		
		return "Even";
	}
	

}

// �ٸ� ��� Ǯ��
class ¦����Ȧ��_�ٸ���� {
    public String solution(int num) {
        return num%2 == 0 ? new String("Even") : new String("Odd");
    }
}