package level1;

import java.util.ArrayList;

public class A��ǰ_�ܹ��Ÿ���� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �ܹ��� ���Կ��� ���� �ϴ� ����� �ܹ��Ÿ� �����ϴ� ���� �մϴ�. 
		 * �Բ� ���� �ϴ� �ٸ� �������� �ܹ��ſ� �� ��Ḧ �������ָ� 
		 * ������ ������� ����� �տ� �Ʒ������� ���� ���̰� �ǰ�, 
		 * ����� ������ �°� �׿��� �ϼ��� �ܹ��Ÿ� ���� �Ű� ������ �ϰ� �˴ϴ�.
		 * 
		 * ����� ���ϴ� ���Դ� ������ ����(�Ʒ�������, �� - ��ä - ��� - ��)�� ���� �ܹ��Ÿ� ������ �մϴ�. 
		 * ����� ���� ������ ������ ������ ����� �����ϴ� ���� �� ��ᰡ �߰������� ������ ���� ������, 
		 * ����� ���̴� �����Ͽ� ��ᰡ ���� �׿��� ���� ��������� ���� �����ϴ�.
		 * 
		 * ���� ���, 
		 * ����� �տ� ���̴� ����� ������ [��ä, ��, ��, ��ä, ���, ��, ��ä, ���, ��]�� ��, 
		 * ����� ���� ��° ��ᰡ �׿��� ��, �� ��° ������ ���� ��° ��Ḧ �̿��Ͽ� �ܹ��Ÿ� �����ϰ�, 
		 * 
		 * ��ȩ ��° ��ᰡ �׿��� ��, �� ��° ���� �ϰ� ��° ������ 
		 * ��ȩ ��° ��Ḧ �̿��Ͽ� �ܹ��Ÿ� �����մϴ�. ��, 2���� �ܹ��Ÿ� �����ϰ� �˴ϴ�.
		 * 
		 * ������� �������� ����� ������ ��Ÿ���� ���� �迭 ingredient�� �־����� ��, 
		 * ����� �����ϴ� �ܹ����� ������ return �ϵ��� solution �Լ��� �ϼ��Ͻÿ�.
		 * 
		 * ���ѻ���
		 * 1 �� ingredient�� ���� �� 1,000,000 ingredient�� ���Ҵ� 1, 2, 3 �� �ϳ��� ���̸�, 
		 * ������� ��, ��ä, ��⸦ �ǹ��մϴ�.
		 * 
		 */
		System.out.println(solution(new int[] {1,2,1,2,3,1,3,1,2,3}));

	}
	
    public static int solution(int[] ingredient) {
    	
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * �� = 1, ��ä = 2, ��� = 3
    	 * 
    	 * ! ������� 1 2 3 1 �̶�� ���� ��������� �ذ�.
    	 * ! �迭�� ���̴� �ּ� 4���� �Ѵ�.
    	 * ! 1 2 3 1�� ������� ������, �� �ε��� ���� �������鼭, ���� ���� 1 �߰�.
    	 * 
    	 * 
    	 */
  
        int answer = 0;
    	
    	String buger = "";
    	
//    	for(int i : ingredient) {
//    		buger += i;
//    	}
//    	System.out.println(buger);
    	// ���ڿ��� ��ȯ.
    	
    	ArrayList<String> str = new ArrayList<String>(buger.length());
    	
    	for(int j : ingredient) {
    		
    		str.add(String.valueOf(j));
    		buger += j;
    		// ArrayList�� ����
    	}
    	System.out.println("str : " + str);
    	System.out.println("buger : "+ buger);
    	
    	while(buger.indexOf("1231") != -1) {
    		// 1231�� ���ӵȴٸ�
    		
    		int indexNum = buger.indexOf("1231");
    		// �� �ε����� ��ġ�� ã��
    		
    		
    			str.remove(indexNum);
    			str.remove(indexNum);
    			str.remove(indexNum);
    			str.remove(indexNum);
    			// str�� arrayList���� �����Ѵ�. => �ܹ��� �ϳ� �Ϸ�.
    		
    		answer += 1;
    		
    		buger = "";
        	
        	for(String i : str) {
        		buger += i;
        	}
    		// ���ڿ��� �ٽ� ������ ���ش�.
    	}
    	
    	buger.indexOf("1231");
    	
        return answer;
    }
	
}
