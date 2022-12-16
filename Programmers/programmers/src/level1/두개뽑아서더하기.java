package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

		solution(new int[] {0,1,2,3,4,5,6,7,8});
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
  
        
        ArrayList<Integer> arr = new ArrayList<Integer>(); 
        
        
        for(int i = 0 ; i < numbers.length-1; i++) {
    			// i�� 1�� ������, numbers.leght-1�� �� ������ i���� ������ j ���� �ֱ� ����.
        	
        	for(int j = i+1; j < numbers.length; j++) {
        		// j�� i ������ �ε����� ������ ����
        		
        		int k = 0;
        		while(k < arr.size() && (numbers[i] + numbers[j] != arr.get(k))) {
        		// �� ���� ���� arr(k) ���� �ƴϸ� k�� ���ض�
        			System.out.println("i = " + i + ", j = " +j +", k = " + k);
        			System.out.println("arr.size() = " + arr.size());
        			k++;
        			// �߿��� ���� �ݺ����� ������, k�� ���� arr.size()�� ������.
        		}
        		
        		if(k == arr.size()) {
        			//k�� ��ġ�ϴ� ���� ���ٸ� k�� arr.size() ���� �Ǿ����
        			arr.add(k, numbers[i] + numbers[j]);
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
        
        Arrays.sort(answer);
        
        return answer;
    }
	
}

class �ΰ��̾Ƽ����ϱ�_�ٸ���� {
    public int[] solution(int[] numbers) {
       Set<Integer> set = new HashSet<>();

       for(int i=0; i<numbers.length; i++) {
           for(int j=i+1; j<numbers.length; j++) {
               set.add(numbers[i] + numbers[j]);
           }
       }

       return set.stream().sorted().mapToInt(Integer::intValue).toArray();
   }
}

/*
 * 
 * ��κ��� ������� hashSet �Ǵ� treeSet�� ����Ͽ���.
 * => ���� ���.
 * 
 * 
 * /
 */