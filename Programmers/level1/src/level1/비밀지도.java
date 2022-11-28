package level1;

import java.util.Arrays;

public class ������� {

	public static void main(String[] args) {
		/*
		 * �׿��� ��� ���ε��� ������ ���ܳ��� ��Ҹ� �˷��� ��������� �տ� �־���. 
		 * �׷��� �� ��������� ���ڷ� ��ȣȭ�Ǿ� �־� ��ġ�� Ȯ���ϱ�
		 * ���ؼ��� ��ȣ�� �ص��ؾ� �Ѵ�. ������ ���� ��ȣ�� �ص��� ����� ������� �޸� �Բ� �߰��ߴ�.
		 * 
		 * 1. ������ �� ���� ���̰� n�� ���簢�� �迭 ���·�, 
		 *    �� ĭ�� "����"(" ") �Ǵ� "��"("#") �� ������ �̷���� �ִ�. 
		 * 2. ��ü ������ �� ���� ������ ���ļ� ���� �� �ִ�. ���� "���� 1"�� "���� 2"��� ����. 
		 *    ���� 1 �Ǵ� ���� 2 �� ��� �ϳ��� ���� �κ��� ��ü ���������� ���̴�. 
		 *    ���� 1�� ���� 2���� ��� ������ �κ��� ��ü ���������� �����̴�. 
		 * 3. "���� 1"�� "���� 2"�� ���� ���� �迭�� ��ȣȭ�Ǿ� �ִ�. 
		 * 4. ��ȣȭ�� �迭�� ������ �� �����ٿ��� �� �κ��� 1, ���� �κ��� 0���� ��ȣȭ���� �� 
		 * 	  ������� �������� �ش��ϴ� ���� �迭�̴�.
		 * 
		 * �׿��� ���ε��� ������ �տ� ���� �� �ֵ���, 
		 * ��������� ��ȣ�� �ص��ϴ� �۾��� ������ ���α׷��� �ۼ��϶�.
		 * 
		 * 
		 * �Է� ����
		 * �Է����� ������ �� �� ũ�� n �� 2���� ���� �迭 arr1, arr2�� ���´�.
		 *	
		 * 1 <= n <= 16
		 * arr1, arr2�� ���� n�� ���� �迭�� �־�����.
		 * ���� �迭�� �� ���� x�� �������� ��ȯ���� ���� ���̴� n �����̴�. ��, 0 <= x <= 2n - 1�� �����Ѵ�.
		 *	 
		 */
		int n = 3;
		int[] arr1 = {1,7,6};
		int[] arr2 = {7,2,6};
		solution(n, arr1, arr2);

	}
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        /*
         * ���� ���� Ǫ�� ���
         * 1. arr1�� arr2�� ��Ҹ� ���������� �����Ѵ�.
         * 
         * 2. �� ���� �����迭�� �����Ѵ�.
         * ex) arr1�� [9,10,3]�� �־�����   
         * [0] [100] 
         * [1] [101]
         * [2] [010]
         * �� ����.
         * 
         * 3. �� ��, arr1�� �� �ε����� ����� ���̴� n �̴�. arr1[i].length�� n�� �ƴϸ�
         * n-length ���� 0�� �߰��Ѵ�.
         * "00" + 100 
         * => ���ڿ��� ����������.
         * 
         * 2. arr1[i], arr2[i] ����� �� �ε������� ���Ͽ� 1�� �ϳ��� ������
         * # �׷��� �ʰ� �� �� 0�̶��  " "���� ��ȯ 
         * => char ������ ��
         * 
         * 3. i = 0 ~ n ���� ��ȸ.
         * 
         */
    	
    	String[] answer = new String[n];
    	String[][] bin_arr1 = new String[n][1];
    	String[][] bin_arr2 = new String[n][1];
    	
    	int i = 0;
    	while(i < arr1.length) {
    		bin_arr1[i][0] = Integer.toBinaryString(arr1[i]);
    		bin_arr2[i][0] = Integer.toBinaryString(arr2[i]);
    		
    		// arr1�� arr2�� i��° ���� ���� ������
    		// �����迭 [i] �ε����� ������.
    		
    		System.out.println("i ũ�� : " + i);
    		System.out.println("bin_arr1["+i+"][0] : " + bin_arr1[i][0]);
    		System.out.println("bin_arr2["+i+"][0] : " + bin_arr2[i][0]);   		

    		System.out.println("n-bin_arr1[i][0].length() = "+ (n-bin_arr1[i][0].length()));
    		System.out.println("n-bin_arr2[i][0].length() = "+ (n-bin_arr2[i][0].length()));

    		if(bin_arr1[i][0].length() <= n) {
    			// ����� ���̰� n���� �۴ٸ�, �� ���̸�ŭ ����� �տ� 0�� ���ض�
    			for(int j = 0; j < n-Integer.toBinaryString(arr1[i]).length(); j++) {
    				bin_arr1[i][0] = "" + "0"+ "" +bin_arr1[i][0];
					System.out.println("j = "+ 0);
					System.out.println(bin_arr1[i][0].length());
    			}
    		}
    			
			if(bin_arr2[i][0].length() <= n) {
				// ����� ���̰� n���� �۴ٸ�, �� ���̸�ŭ ����� �տ� 0�� ���ض�
				for(int k = 0; k < n-Integer.toBinaryString(arr2[i]).length(); k++) {
					bin_arr2[i][0] = "" +"0" +""+ bin_arr2[i][0];
				}	
    		}
			System.out.println("if �� / bin_arr1["+i+"][0] : " + bin_arr1[i][0]);
			System.out.println("if �� / bin_arr2["+i+"][0] : " + bin_arr2[i][0]);			
			
			for(int l = 0; l <= n-1; l++) {
				// arr1[i], arr2[i]�� �� ��Һ� ���ڿ�����, �ϳ��� �迭���� ���ڿ��� �ε����� 1�� ���� ������
				// �ٸ� �迭�� 1�� �����.
				if(bin_arr1[i][0].charAt(l) == '1' || bin_arr2[i][0].charAt(l) == '1') {
					bin_arr1[i][0] = bin_arr1[i][0].substring(0, l) + "#" + bin_arr1[i][0].substring(l+1) ;
					bin_arr2[i][0] = bin_arr2[i][0].substring(0, l) + "#" + bin_arr2[i][0].substring(l+1);
				} else {
					bin_arr1[i][0] = bin_arr1[i][0].substring(0, l) + " " + bin_arr1[i][0].substring(l+1);
					bin_arr2[i][0] = bin_arr2[i][0].substring(0, l) + " " + bin_arr2[i][0].substring(l+1);
				}
				System.out.println("bin_arr1["+i+"][0] : " + bin_arr1[i][0]);
				System.out.println("bin_arr2["+i+"][0] : " + bin_arr2[i][0]);
			}

			i++;
    	}
    	
    	for(int m = 0 ; m < answer.length; m++) {
    		answer[m] = bin_arr1[m][0];
    	}
    	
        return answer;
    }

}

class �������_�ٸ���� {
	  public String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] result = new String[n];
	       
	        for (int i = 0; i < n; i++) {
	            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
	            // or ������, �� ���� �ϳ��� 1 �̸�, 1�� �´�.
	            // => �־��� ������ �ϳ��� true�� true.
	            // true => 1�̶�� ��.
	        }

	        for (int i = 0; i < n; i++) {
	            result[i] = String.format("%" + n + "s", result[i]);
	            result[i] = result[i].replaceAll("1", "#");
	            result[i] = result[i].replaceAll("0", " ");
	        }

	        return result;
	    }
	}

/*
 * ���� �迭�� Ǭ ����� ���� ������.
 * ����Լ� �� �پ��� �͵��� ����Ͽ� Ǯ����.
 * 
 *  �� �κп� ���ؼ��� ���� �ϵ��� �ϰ�, �ϴ� ���� Ǯ �� �����ؾ��� ����,
 *  �迭 �ε����� ���̷� �ݺ����� ������ ��, �ݺ��� ���뿡 �迭 ���̰� �ٲ�� �Ǹ�
 *  �ݺ������� ���Ǻ��� ���� �������� �ʾҴ�. �̸� ����ϱ� ����
 *  ������ų �� �ִ� �迭�� ã�Ƽ� ����������Ѵ�. 
 * 
 */