package level2;

public class ¦���������ϱ� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ¦���� �����ϱ��, ���ĺ� �ҹ��ڷ� �̷���� ���ڿ��� ������ �����մϴ�. 
		 * ���� ���ڿ����� ���� ���ĺ��� 2�� �پ� �ִ� ¦�� ã���ϴ�. 
		 * 
		 * �״���, �� ���� ������ ��, �յڷ� ���ڿ��� �̾� ���Դϴ�. 
		 * �� ������ �ݺ��ؼ� ���ڿ��� ��� �����Ѵٸ� ¦���� �����ϱⰡ ����˴ϴ�. 
		 * ���ڿ� S�� �־����� ��, ¦���� �����ϱ⸦ ���������� ������ �� �ִ��� ��ȯ�ϴ� �Լ��� �ϼ��� �ּ���. 
		 * 
		 * ���������� ������ �� ������ 1��, �ƴ� ��� 0�� �������ָ� �˴ϴ�.
		 * 
		 * ���� ���, ���ڿ� S = baabaa ���
		 * 
		 * b aa baa �� bb aa �� aa �� �� ������ ���ڿ��� ��� ������ �� �����Ƿ� 1�� ��ȯ�մϴ�.
		 * 
		 * ���ѻ��� 
		 * ���ڿ��� ���� : 1,000,000������ �ڿ��� 
		 * ���ڿ��� ��� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
		 * 
		 */

		solution("abbabbsnnsnnsnnbannannannadndnsnsnsssnsndn");
		
	}
	
    public static int solution(String s){
    	
    	/*
    	 * ���� Ǫ�� ���
    	 * 1. �� ���ڿ��� �ε����� ���ϰ�, ���� ���ڸ� ����.
    	 * 2. ���Ž�, ���� ���̰� 2 �پ�����, ���������ڿ� ���� ������ ���� -1 ���ش�.
    	 * 3. �׸��� �� ��ġ�� �������� �ε��� ��.
    	 * 
    	 */
        int answer = 0;
        
       StringBuilder sb = new StringBuilder(s);
        
        for(int i = 0; i < sb.length()-1; i++) {
        	System.out.println("���� �� : "  + i);
        	System.out.println("���� �� : "+ sb);
        	if(sb.charAt(i) == sb.charAt(i+1)) {
        		sb.replace(i, i+2, "");
        		i-=2;
        		System.out.println("���� �� : "  + i);
        		System.out.println("���� �� : "+ sb);
        	}
        }
        if(sb.length() == 0) {
        	answer = 1;
        }
        
        return answer;
    }

}
