package level1;

public class ���ڹ��ڿ������ܾ� {

	public static void main(String[] args) {
		/*
		 * �׿��� ���ε��� ���ڳ��̸� �ϰ� �ֽ��ϴ�. 
		 * �׿��� ���ε����� ���ڸ� �ǳ� �� �Ϻ� �ڸ����� ���ܾ�� �ٲ� ī�带 �ǳ��ָ� 
		 * ���ε��� �������ڸ� ã�� �����Դϴ�.
		 * 
		 * ������ ������ �Ϻ� �ڸ����� ���ܾ�� �ٲٴ� �����Դϴ�.
		 * 
		 * 1478 �� "one4seveneight" 
		 * 234567 �� "23four5six7" 
		 * 10203 �� "1zerotwozero3" �̷���
		 * ������ �Ϻ� �ڸ����� ���ܾ�� �ٲ�����ų�, Ȥ�� �ٲ��� �ʰ� �״���� ���ڿ� s�� �Ű������� �־����ϴ�. 
		 * s�� �ǹ��ϴ� ���� ���ڸ� return �ϵ��� solution �Լ��� �ϼ����ּ���.
		 * 
		 * ����� �� ���ڿ� �����Ǵ� ���ܾ�� ���� ǥ�� �����ϴ�.
		 * 
		 * ���ѻ��� 1 �� s�� ���� �� 50 s�� "zero" �Ǵ� "0"���� �����ϴ� ���� �־����� �ʽ��ϴ�. 
		 * return ���� 1 �̻�
		 * 2,000,000,000 ������ ������ �Ǵ� �ùٸ� �Է¸� s�� �־����ϴ�.
		 */

		solution("123zero32");
	}
	
    public static int solution(String s) {
    	
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * 
    	 * 1. replace �޼��� ���.
    	 * 2. �ݺ����� ���Ͽ� �� �������� ���������� �ٲ� �͵��� �����Ŵ
    	 * 3. ���� ���ڿ��� ���ڷ� �ٲ�
    	 */
    	int answer = 0;
    	String[] str = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    	String number = s;
    	
    	for(int i = 0; i < 10; i++) {
    		number = number.replace( str[i], String.valueOf(i));
    		System.out.println(number);
    	}
    	
    	answer = Integer.valueOf(number);
    	
        return answer;
    }

}

/*
 * Ǯ�̰� ��κ� ����Ͽ���.
 * 
 */
