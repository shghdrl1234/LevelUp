package level1;

public class ������ڰ������� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �ܾ� s�� ��� ���ڸ� ��ȯ�ϴ� �Լ�, solution�� ����� ������.
		 * �ܾ��� ���̰� ¦����� ��� �α��ڸ� ��ȯ�ϸ�
		 * �˴ϴ�.
		 * 
		 * ���ѻ��� 
		 * s�� ���̰� 1 �̻�, 100������ ��Ʈ���Դϴ�.
		 * 
		 */
		System.out.println(solution("a"));
	}
	
	public static String solution(String s) {
				
		/*
		 * ���� Ǫ�� ���
		 * 1. Ȧ�� �� ���, s ��ü ���̿��� 2������ +1
		 * 2. ¦�� �� ���, s ��ü ���̿��� 2���� ������, �� ���� ������ ��ħ. 
		 *  
		 */

		if(s.length() == 1) {
			return s;
		}
		
		String answer = (s.length()%2==0) ? ""+s.charAt(s.length()/2-1) + s.charAt(s.length()/2) : ""+s.charAt(s.length()/2);
		
		System.out.println("charAt : "+s.charAt(s.length()/2-1));
		System.out.println("charAt2 : "+s.charAt(s.length()/2));
		return answer;

		//	return s.substring((s.length()-1) / 2, s.length()/2 + 1);
		// �ٸ� ���� ���ϰ����θ� �ذ� ����.
		// ���� subString���� �ߴµ�, ���ڷ� ����ϴ� ���� 1�� �ۿ� ���ٰ� �����Ͽ� ������� ����.
		// ���⼭ s.length�� ¦����� 2���� ������ �����ǰ�, Ȧ����� 1���� ������ ������.
	}

}



  