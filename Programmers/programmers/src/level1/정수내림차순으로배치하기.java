package level1;

import java.util.Arrays;

public class ���������������ι�ġ�ϱ� {

	public static void main(String[] args) {
		/*
		 * 
		 * ���� ���� 
		 * �Լ� solution�� ���� n�� �Ű������� �Է¹޽��ϴ�. 
		 * n�� �� �ڸ����� ū�ͺ��� ���� ������ ������ ���ο� ������ �������ּ���. 
		 * ������� n�� 118372�� 873211�� �����ϸ� �˴ϴ�.
		 * 
		 * ���� ���� 
		 * n�� 1�̻� 8000000000 ������ �ڿ����Դϴ�.
		 * 
		 * 
		 */
		System.out.println(solution(118372));
	}

	   public static  long solution(long n) {
	        long answer = 0;
	        
	        // 1. ���ڿ� �迭, ���ø��� �ݺ��� Ȱ��. => ��������.
	        // 2. ������ �����θ� Ǯ���. n/10 �̷� �͵� Ȱ��..?
	        
	        long num = n;

	        // 1�� �ڸ� �ڸ��� => 1
	        // 10�� �ڸ� �ڸ��� => 2
	        
	        int i = 0;
	        while(num >= 1) {
	        	// 1���� ũ�ų� ���� ���̸� ���۵�.
	        	
	        	num = num/10;
	        	i++;
	        }
	        // �迭�� ũ�⸦ ������ �ֱ� ���� �ݺ���. ��� �ָԱ��� ���̱� ������.

	        int[] numArr = new int[i];
	        // ������ �迭�� �����ߴ�. long Ÿ���� �ƴ� ������, �迭�� ���� �� ���̱� ������
	        // �� �ڸ����� �������� �Ǳ� �����̴�.
	        
	        num = n;
	        i = 0;
	        while(num >= 1) {
	        	System.out.println("num: "+ num);
	        	System.out.println("num/10: "+ num/10);
	        	numArr[i] = (int) (num%10);
	        	System.out.println("�ε���: "+ numArr[i]);

	        	num = (long) (num/10);
	        	// long Ÿ�� �̱� ������, / �����ڷ� �Ͽ��� �Ҽ��� �Ʒ��� ������� ���´�.
	        	// �׷��� ������ ������ ���� �� ���ؼ�, �������� �����Ѵ�.

	        	i++;
	        }
	        // ���� ���� �迭�� ������.
	       
	        int store = 0;
	        for(int j = 0; j < numArr.length-1; j++) {
	        	for(i = 0; i < numArr.length-1; i++) {
		        	if(numArr[i] < numArr[i+1]) {
			        	store = numArr[i];
			        	numArr[i] = numArr[i+1];
			        	numArr[i+1] = store;
		        	}
	        	}
	        }
	        
	        
	        for(i = 0; i < numArr.length; i++) {
	        	
	        		answer += Math.pow(10,(numArr.length-i-1))*numArr[i];
	        		System.out.println(answer);
	        	}
	       
	        return answer;
	    }
	
}

	class ���������������ι�ġ�ϱ�_�ٸ���� {
	  public long solution(long n) {
	        String[] list = String.valueOf(n).split("");
	        // ������ �޾ƿͼ� ���ø� �� �迭�� ����
	        
	        Arrays.sort(list);
	      

	        StringBuilder sb = new StringBuilder();
	        for (String aList : list) sb.append(aList);

	        return Long.parseLong(sb.reverse().toString());
	  }
	}


	class ���������������ι�ġ�ϱ�_�ٸ����_2 {
	    String res = "";
	    
	    public int reverseInt(int n){
	        res = "";
	        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
	        return Integer.parseInt(res);
	    }
	}
	
	