package level1;

import java.util.Arrays;

public class ���ڿ������������ι�ġ�ϱ� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ���ڿ� s�� ��Ÿ���� ���ڸ� ū�ͺ��� ���� ������ ������ 
		 * ���ο� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���. 
		 * s�� ���� ��ҹ��ڷθ� �����Ǿ� ������, �빮�ڴ� �ҹ��ں��� ���� ������ �����մϴ�.
		 * 
		 * ���� ���� 
		 * str�� ���� 1 �̻��� ���ڿ��Դϴ�.
		 */System.out.println(solution("Zbcdefg"));

	}
	   public static String solution(String s) {
	        
		   /*
		    * ���� ���� Ǫ�� ���
		    * 1. ���ڿ� ��.
		    * 2. sort ����ϱ� �����ϴ�. => �������� ���� ��
		    * 3. �迭�� �����´�.
		    */
		   
		   String[] str = s.split("");
		   Arrays.sort(str);
		   
		   String answer = String.join("",str);
		   
		   String answer2 = "";
		   
		   for(int i = s.length()-1; i >=0; i--) {
			   answer2 += answer.charAt(i);
		   }
		   
	        return answer2;
	    }

}

	 class ���ڿ������������ι�ġ�ϱ�_�ٸ���� {
		
	    public String reverseStr(String str){
	    	char[] sol = str.toCharArray();
	    	Arrays.sort(sol);
	    return new StringBuilder(new String(sol)).reverse().toString();
	    }
	}

	 
	 /*
	  * �ϴ� �� ������ Ǯ�鼭 �˻��� �� �ߴ�.
	  * 
	  * 1. String Ÿ���� �迭�� ���ڿ��� ��ȯ�ϴ� String.join(�迭���� �߰��� ����,�迭)
	  * 
	  * �� ���� ���� Ǯ�̿� ������ ���� ���� �е��� ���� ��̴�.
	  * �ʱ� ���� �� Ǯ�� �� ���� ���� �غ����� ����.
	  * 
	  * 
	  */
	 
	 
	 
	 