package level1;

public class ���￡���輭��ã�� {

	public static void main(String[] args) {
		/*
		 * 
		 * ���� ���� 
		 * String�� �迭 seoul�� element�� "Kim"�� ��ġ x�� ã��, 
		 * "�輭���� x�� �ִ�"�� String�� ��ȯ�ϴ� �Լ�, solution�� �ϼ��ϼ���. 
		 * seoul�� "Kim"�� ���� �� ���� ��Ÿ���� �߸��� ���� �ԷµǴ� ���� �����ϴ�.
		 * 
		 * ���� ���� 
		 * seoul�� ���� 1 �̻�, 1000 ������ �迭�Դϴ�. 
		 * seoul�� ���Ҵ� ���� 1 �̻�, 20 ������ ���ڿ��Դϴ�.
		 * "Kim"�� �ݵ�� seoul �ȿ� ���ԵǾ� �ֽ��ϴ�.
		 * 
		 */
	}
	
    public String solution(String[] seoul) {
    	
    	// 1. ��ġ X�� �ε����� ��ȣ
    	// 2. �ݺ����� ���Ͽ� ���� �� ����.
    	
    	// 2-1. Kim�� ã�Ƶ� ���ĸ� �ݺ��ؾ���. => �ð� ����
    	
        String answer = "";
        
        
        for(int i = 0; i<seoul.length; i++) {

        	if(seoul[i].equals("Kim")) {
        		answer = "�輭���� "+i+"�� �ִ�"; 
        	}
        }
        
        return answer;
    }
    
public String solution2(String[] seoul) {
    	
    	// 1. ��ġ X�� �ε����� ��ȣ
    	// 2. �ݺ����� ���Ͽ� ���� �� ����.
    	
    	// 2-1. Kim�� ã�Ƶ� ���ĸ� �ݺ��ؾ���. => �ð� ����
		// 2-2. while �ݸ����� �����Ѵٸ�?
    	
        String answer = "";
        
        int i = 0;
        while(!seoul[i].equals("Kim")) {
    	   
        	i++;
        }
        
        answer = "�輭���� "+i+"�� �ִ�";
        
        return answer;
    }

}


/*
 *  ���⼭ �߿��� ���� ���ڿ� �񱳴� ==�� �ƴ� String.equals() �޼��带 ����Ѵ�.
 * 
 * 
 * 
 */


