package level1;

public class �ڿ���������迭�θ���� {

	public static void main(String[] args) {
		/*
		 * �ڿ��� n�� ������ �� �ڸ� ���ڸ� ���ҷ� ������ �迭 ���·� �������ּ���. 
		 * ������� n�� 12345�̸� [5,4,3,2,1]��
		 * �����մϴ�. 
		 * 
		 * ���� ���� 
		 * 
		 * n�� 10,000,000,000������ �ڿ����Դϴ�.
		 */
	}

	public int[] solution(long n) {
		
		// �ڿ����� �޾ƿ´�.
		// ���ڿ��� �ٲ� �� �迭�� ��´�.
		// �迭���� �ڸ� �ٲٴ� �ݺ��� ���.
		// ���� ������ �迭�� �ٽ� ��´�.
		
		String str = String.valueOf(n);
		String[] str2 = str.split("");
		int[] answer = new int[str2.length];
		
		int store = 0;
		for(int i = 0; i < str2.length; i++) {
			store = Integer.valueOf(str2[i]);
			answer[i] = Integer.valueOf(str2[str2.length-i-1]);
			answer[str2.length-i-1] = store;
		}
		
		return answer;
	}
	
}

class �ڿ���������迭�θ����_�ٸ����_������� {
    public int[] solution(long n) {
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
}
