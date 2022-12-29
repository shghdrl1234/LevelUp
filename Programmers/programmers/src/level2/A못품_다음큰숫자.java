package level2;

public class A��ǰ_����ū���� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �ڿ��� n�� �־����� ��, n�� ���� ū ���ڴ� ������ ���� ���� �մϴ�.
		 * 
		 * ���� 1. n�� ���� ū ���ڴ� n���� ū �ڿ��� �Դϴ�. 
		 * ���� 2. n�� ���� ū ���ڿ� n�� 2������ ��ȯ���� �� 1�� ������ �����ϴ�. 
		 * ���� 3. n�� ���� ū ���ڴ� ���� 1, 2�� �����ϴ� �� �� ���� ���� �� �Դϴ�. 
		 * ���� �� 78(1001110)�� ���� ū ���ڴ� 83(1010011)�Դϴ�.
		 * 
		 * �ڿ��� n�� �Ű������� �־��� ��, n�� ���� ū ���ڸ� return �ϴ� solution �Լ��� �ϼ����ּ���.
		 * 
		 * ���� ���� 
		 * n�� 1,000,000 ������ �ڿ��� �Դϴ�.
		 * 
		 */

		solution(1000000);
		
	}
	
	public static int solution2(int n) {
		/*
		 * 1 - 1
		 * 2 - 10
		 * 3 - 11
		 * 4 - 100
		 * 5 - 101
		 * 6 - 110
		 * 7 - 111
		 * 8 - 1000
		 * 
		 */
		
		return 0;
	}
	
    public static int solution(int n) {
    	
    	/*
    	 * ���� Ǫ�� ���
    	 * 
    	 * 1. n�� 2�������� �ٲٰ�
    	 * 2. �ݺ����� ���Ͽ� 2������ 1�� ������ ���Ѵ�. num
    	 * 3. 1�� ���ϸ鼭 1�� ������ num�� ������ �� ���� �ݺ�.
    	 * 4. num�� �������� 10�������� ���� 
    	 * 
    	 * => ȿ���� �׽�Ʈ ����
    	 */
    	
    	
        int answer = 0;

        String binaNum = Integer.toBinaryString(n);
        System.out.println("binaNum : " + binaNum);
        int num = 0;
        for(int i = 0; i < binaNum.length(); i++) {
        	if(binaNum.charAt(i) == '1') {
        		num += 1;
        	}
        }
        

        int a = n+1;
        while(true) {
        	String binaNum2 = Integer.toBinaryString(a);
        
        	if(binaNum2.length()-binaNum2.replace(String.valueOf("1"),"").length() == num) {
        		break;
        	}
        	a++;
        }
        
        return a;
    }

}
