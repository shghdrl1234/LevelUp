package level2;

import java.util.Arrays;

public class �ִ밪���ּҰ� {

	public static void main(String[] args) {

		/*
		 * ���� ���� 
		 * ���ڿ� s���� �������� ���е� ���ڵ��� ����Ǿ� �ֽ��ϴ�. 
		 * str�� ��Ÿ���� ���� �� �ּҰ��� �ִ밪�� ã�� 
		 * �̸� "(�ּҰ�) (�ִ밪)"������ ���ڿ��� ��ȯ�ϴ� �Լ�, solution�� �ϼ��ϼ���. 
		 * ������� s�� "1 2 3 4"��� "1 4"�� �����ϰ�, "-1 -2 -3 -4"��� "-4 -1"�� �����ϸ� �˴ϴ�.
		 * 
		 * ���� ���� 
		 * s���� �� �̻��� ������ �������� ���еǾ� �ֽ��ϴ�.
		 * 
		 */

		solution("-1 2 3 -4 -5 -6");
	}
	
	public static String solution(String s) {
	    /*
	     * ���� Ǫ�� ���
	     * 1. split���� �迭ȭ
	     * 2. sort
	     * 
	     */

		String answer = "";
        String[] arr = s.split(" ");
        int[] arr2 = new int[arr.length];
        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < arr.length; i++) {
        	arr2[i] = Integer.valueOf(arr[i]);
        }
        
        Arrays.sort(arr2);
        // ������������ ����
        
        
        answer = arr2[0] + " " + arr2[arr2.length-1];
        System.out.println(answer);
        return answer;
    }
	
}

class �ִ밪���ּҰ�_�ٸ���� {
    public String getMinMaxString(String str) {
        String[] tmp = str.split(" ");
        int min, max, n;
        min = max = Integer.parseInt(tmp[0]);
        for (int i = 1; i < tmp.length; i++) {
                n = Integer.parseInt(tmp[i]);
            if(min > n) min = n;
            if(max < n) max = n;
        }

        return min + " " + max;

    }

}


/*
 * 
 * ���� 2ġ��� �������� ����.
 * ���� 1�� ���� �� ��.
 * 
 * 
 * 
 */


