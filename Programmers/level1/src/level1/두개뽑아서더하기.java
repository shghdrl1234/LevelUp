package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class �ΰ��̾Ƽ����ϱ� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ���� �迭 numbers�� �־����ϴ�.
		 * numbers���� ���� �ٸ� �ε����� �ִ� �� ���� ���� �̾� ���ؼ� ���� �� �ִ� 
		 * ��� ���� �迭�� ������������ ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * numbers�� ���̴� 2 �̻� 100 �����Դϴ�. 
		 * numbers�� ��� ���� 0 �̻� 100 �����Դϴ�.
		 * 
		 * 
		 */

		solution(new int[] {1,2,3,4,5,6,7,8});
	}

    public static int[] solution(int[] numbers) {
    	
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * 1. ���� �ٸ� �ε����� �ִ� �� ���� ���� �̾� ���ϴ� ��
    	 * => �ε����� �ٸ����� ���� ������ ���� �� �ִ�.
    	 * => ��, ������ �ߺ��� ���� ���� �� �ִ�.
    	 * => �ߺ��� ���� �����.
    	 * 
    	 * 2. �迭�� �������� �־����.
    	 * => ���� ��� ���� �� �𸣴ϱ� ArrayList Ȱ�� 
    	 * 
    	 * 3. �������� ���� => sort Ȱ��
    	 * 
    	 * 
    	 * 1-2. �ߺ��� ���ִ°� ����.
    	 * => �ݺ����� ���� ���ؼ� ������ �ְ� ������ ���� �ʴ´�.
    	 */
  
        
        ArrayList<Integer> arr = new ArrayList(); 
        
        arr.add(0, numbers[0] + numbers[0]);
        System.out.println(arr.size());
        
        for(int i = 0 ; i < numbers.length-1; i++) {
    			// i�� 1�� ������, numbers.leght-1�� �� ������ i���� ������ j ���� �ֱ� ����.
        	
        	for(int j = i+1; j < numbers.length-i; j++) {
        		// j�� i ������ �ε����� ������ ����
        		
        		for(int k = 1; k < arr.size(); k++) {
        			
        		if(numbers[i] + numbers[j] != arr.get(k)) {
        			arr.add(k+1, numbers[i] + numbers[j]);
        		}
        		
        		}
        	}
        }
        
        int[] answer = new int[arr.size()];
        System.out.println("gd");
        int i = 0;
        while(i < arr.size()) {
        	answer[i] = arr.get(i);
        	i++;
        }
        
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	
}
