package level1;

import java.util.Arrays;

public class K��°�� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, k��°�� �ִ� ���� ���Ϸ� �մϴ�.
		 * 
		 * ���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��
		 * array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�. 
		 * 1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�. 
		 * 2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�. 
		 * 
		 * �迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��, c
		 * ommands�� ��� ���ҿ� ���� �ռ� ������ ������ �������� �� ���� ����� �迭�� ��� 
		 * return �ϵ��� solution �Լ��� �ۼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * array�� ���̴� 1 �̻� 100 �����Դϴ�. 
		 * array�� �� ���Ҵ� 1 �̻� 100 �����Դϴ�. 
		 * commands�� ���̴� 1 �̻� 50 �����Դϴ�. commands�� �� ���Ҵ� ���̰� 3�Դϴ�.
		 * 
		 */
		int[] a = {1, 5, 2, 6, 3, 7, 4};
		int[][] b = {{2,5,3},{4,4,1},{1,7,3}};
		solution(a,b);
	}
    public static int[] solution(int[] array, int[][] commands) {
        
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * 1. array�� i���� j���� �ڸ���.
    	 * 1-2. commands�� 2�� �迭�̴�. �ݺ����� ������ �� ���� �����ؾ���.
    	 * 
    	 * 2. sort ����Ͽ� ������ �� ����
    	 * 3. ������� �迭���� k ��° ����
    	 * 
    	 */
    	
    	int[][] com = commands.clone();
    	int[] array_for = new int[array.length];
    	int[] answer = new int[com.length];
    	
    	int i =0;
    	int j =0;
    	int k =0;
    	
    	int cnt = 0;
    	while(cnt < com.length ) {
    		
    		i = com[cnt][0];
    		j = com[cnt][1];
    		k = com[cnt][2];
    		array_for = new int[j-i+1];
    		
    		System.out.println("========== cnt : " + cnt + " =============");
    		for(int t = i-1; t < j; t++ ) {
    			// ���⼭ array�� �߶����.
    			array_for[t-i+1] = array[t];
    			// �ε��� ��ȣ 0���� ���������� �ֱ�.
    			System.out.println("array_for["+(t-i+1)+"] : " + array_for[t-i+1]);
    		}
    		Arrays.sort(array_for);
    		// ������ ������ ����
    		System.out.println(Arrays.toString(array_for));
    		
    		answer[cnt] = array_for[k-1];

    		System.out.println("array_for["+k+"] : " + array_for[k-1]);
    		
    		System.out.println("answer["+cnt+"] : " + answer[cnt]);
    		System.out.println();
    		
    		cnt++;
    	}
    	
    	
        return answer;
    }
}

class K��°��_�ٸ���� {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}


/*
 * ���� �ڵ带 �ۼ��ϸ鼭 ��������
 * �ۼ��ϴ� �� ������ �򰥸��� �ȵȴٴ� ���̴�.
 * 
 * ��� ������ �ڵ尡 ��� �����ϴ����, �ּ��� �� �����ϰ� ��߰ڴ�.
 * �ڵ��� Ʋ�� ����� ��Ҵµ� �������� �����ϴ� �������� ������ ��, �ð��� ��ü�Ǿ���.
 * int[] answer = new int[com.length]; �� �κп��� com.lenght�� �ƴ� com[0].length�� �����.
 * �Ϻδ� ����ó���� �Ǿ�����.. �쿬�� ��, ��ü���� ���̸� ���Ϸ��� com.legnth�� ����߾�� �ߴ�.
 * 
 * �׸��� ���̺귯���� ����� �ٸ� ���� �ڵ嵵 �����Դ�.
 * �ڵ尡 ���������Ƿ� �������� ����. copyOfRange�� �˾ƺ���.
 * 
 * ���� ��۵鿡���� ���̺귯���� ������ �������� ������ �ۼ��ϴ� �͵� ū ������ �ȴٰ� �Ѵ�.
 * 
 * �� �� ���� �� ��ƺ��� �ʹ�.
 * 
 * 
 */


