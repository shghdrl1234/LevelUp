package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ������� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ���� ����� ��� ���ڸ� �����ϰ� �ֽ��ϴ�. 
		 * ����� ���¿� ���� 1������ k�������� ������ �з��ϸ�, k���� �ֻ�ǰ�� ����̰� 1���� ����ǰ�� ����Դϴ�. 
		 * ��� �� ������ ������ ������ ���� �����˴ϴ�.
		 * 
		 * �� ���ڿ� ����� m���� ��� �����մϴ�.
		 *  
		 * ���ڿ� ��� ��� �� ���� ���� ������ p (1 �� p �� k)���� ���, ��� �� ������ ������ p * m �Դϴ�. 
		 * 
		 * ���� ����� ������ ���� ����� �Ⱦ��� ��, ���� �� �ִ� �ִ� ������ ����ϰ��� �մϴ�.
		 * (����� ���� �����θ� �Ǹ��ϸ�, ���� ����� �����ϴ�)
		 * 
		 * ���� ���, k = 3, m = 4, ��� 7���� ������ [1, 2, 3, 1, 2, 3, 1]�̶��, 
		 * ������ ���� [2, 3, 2, 3]���� ������ ��� ���� 1���� ����� �Ǹ��Ͽ� �ִ� ������ ���� �� �ֽ��ϴ�.
		 * 
		 * (���� ��� ����) x (�� ���ڿ� ��� ��� ����) x (������ ����) = 2 x 4 x 1 = 8 
		 * 
		 * ����� �ִ� ���� k, �� ���ڿ� ���� ����� �� m, ������� ���� score�� �־����� ��, 
		 * ���� ����� ���� �� �ִ� �ִ� ������ return�ϴ� solution �Լ��� �ϼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * 3 �� k �� 9 3 �� m �� 10 
		 * 7 �� score�� ���� �� 1,000,000 
		 * 1 �� score[i] �� k 
		 * ������ �߻����� �ʴ� ��쿡�� 0�� return ���ּ���.
		 * 
		 * 
		 */
		
//		solution1(3,4,new int[] {1, 2, 3, 1, 2, 3, 1});
		solution1(4,3,new int[] {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2});
		
	}
	public static int solution1(int k, int m, int[] score) {
		/*
		 * 1. �ڽ��ȿ� �ִ� ���� ǰ���� �������� ����.
		 * 2. ���� ǰ�� ���� �� ��� �ְ� ǰ���� �ִ´�.
		 * 
		 */
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i : score) {
			arr.add(i);
		}
		
		arr.sort(Comparator.reverseOrder());
		
		int answer = 0;
		int num = score.length;
		int box=9;
		
		for(int j = 0; j < score.length; j+=m) {
			System.out.println(m);
			if(num >= m ) {
				for(int i = 0; i < m; i++) {
					if(arr.get(score.length-num+i) < box) {
						box = arr.get(score.length-num+i);
					}
				}
				num -= m;
				answer += box*m;
				box=9;
				
			}
		}
		
		System.out.println(answer);
		return answer;
	}
	
		
    public static int solution(int k, int m, int[] score) {
    	/*
    	 * ���� Ǫ�� ���
    	 * 
    	 * - �ְ��� k�� �ڽ��� ���� ���� m��, score�� �ε��� ���� Ȱ���Ͽ� ������ Ǭ��.
    	 * - �ְ��� k�� ��ġ�ϴ� score[i]�� ������ ã�´�.
    	 * - ���� ���� �������� �پ��ְ� ��������.
    	 * - [4, 4, 4, 3] [3, 3, 3, 1] => ���� 4
    	 * - [4, 4, 4, 1] [3, 3, 3, 3] => ���� 4
    	 *
    	 * 1. ������������ ����
    	 * 2. 0���� score.length/����, m++ �ݺ�
    	 * 3. 0~3 �ε��� ����, K*4�� ���ٸ� k, �۰ų� (k-1)�� ���ٸ� k-1 .. answer�� ����.
    	 * 3-1. �־��� k ���� �𸣱� ������ ���ǹ��� �ݺ������� �����������
    	 * 3-2. switch - case ���� �ϴ� ����غ���
    	 * 4. �� �߿� ���� ���� ���� ũ�⸦ answer�� ����.
    	 * 
    	 */
    	
    	int[] arr = score.clone();
    	Arrays.sort(arr); // ������������ ����
    	int answer = 0;
    	
    	for(int i = arr.length-1; i >= 0;) {
    		
    		if(i>2) {
    		
    			for(int j = i; j > i-4; j--) {
    			
    			if(arr[j-m+1] < arr[j-m+2] ) {
    				answer += arr[j-m+1]*4;
    			}
    		}
    		
    		}
    		
    		System.out.println("i = "+ i+", answer = " + answer);
		
    		
    		i -= m;
    	}
    	
        return answer;
    }

}


class �������_�ٸ���� {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i = score.length; i >= m; i -= m){
            answer += score[i - m] * m;
        }

        return answer;
    }
    /*
     * for������ ��� �۾��� �� ���� ������Ѽ� �ڵ带 �ּ�ȭ ���״�.
     */
}



