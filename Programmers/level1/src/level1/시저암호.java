package level1;

import java.util.Arrays;

public class ������ȣ {

	/*
	 * ���� ���� 
	 * � ������ �� ���ĺ��� ������ �Ÿ���ŭ �о 
	 * �ٸ� ���ĺ����� �ٲٴ� ��ȣȭ ����� ���� ��ȣ��� �մϴ�. 
	 * 
	 * ���� ���
	 * "AB"�� 1��ŭ �и� "BC"�� �ǰ�, 3��ŭ �и� "DE"�� �˴ϴ�. 
	 * "z"�� 1��ŭ �и� "a"�� �˴ϴ�. 
	 * ���ڿ� s�� �Ÿ� n�� �Է¹޾� s�� n��ŭ �� ��ȣ���� ����� �Լ�, solution�� �ϼ��� ������.
	 * 
	 * ���� ����
	 * ������ �ƹ��� �о �����Դϴ�. 
	 * s�� ���ĺ� �ҹ���, �빮��, �������θ� �̷���� �ֽ��ϴ�. 
	 * s�� ���̴� 8000�����Դϴ�.
	 * n�� 1 �̻�, 25������ �ڿ����Դϴ�.
	 * 
	 */
	
	public static void main(String[] args) {
		solution("AZ",1);
		solution("az",1);

		
	}
	

    public static String solution(String s, int n) {
        
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * 
    	 * ! ������ �Ÿ���ŭ �о => "�Ÿ�"��� ǥ������ 1,2 ������ ���ڸ� ����
    	 * ! �ٸ� ���ĺ����� �ٲٴ� => ������ ���ڸ� ���ĺ����� �ٲ۴ٶ�.. char Ÿ������ ����
    	 * ! char Ÿ�� z�� ������ ��ȣ�� �´�. ���⼭ ������ ���ִ� ���.
    	 * 
    	 * 1. ���޹��� ���ڿ��� �� �迭�� �����. => toCharArray()
  		 *
    	 * 3. if���� �ξ�  90 < s[i]-n < 97 �� ��, 97 < s[i] <123 �� ���� ������
    	 * 4.  90 < s[i]-n < 97 �� ��, s[i] = n-s[i] + 64
    	 * 5.  97 < s[i]-n < 123 �� ��, s[i] = n-s[i] + 96
    	 * 
    	 */

    	String answer = "";
    	char[] ch = s.toCharArray();
    		
    	for(int i = 0 ; i < ch.length; i++) {
    	
    		if(ch[i] == ' ')  {
    			ch[i] = 32;
    			continue;
    		}

    		if('A' <= ch[i] && ch[i] <= 'Z') {
    			// �빮���϶�
    			if( ch[i]+n > 'Z') {
    				ch[i] = (char)(n-26+Integer.valueOf(ch[i]));
    			} else {
    				ch[i] = (char)(ch[i]+n);
    			}
    			
     		} else if( 'z' < ch[i] + n )  {
     			ch[i] = (char)(n-26+Integer.valueOf(ch[i]));
     		} else  {
     			ch[i] = (char)(ch[i]+n);
     		}
    		
    	}
    	
    	
    	answer = String.valueOf(ch, 0, ch.length);
    	System.out.println(answer);
    	
        return answer;
    }
    
    
}

class ������ȣ_�ٸ���� {
    String caesar(String s, int n) {
        String result = "";
	    n = n % 26;
	    for (int i = 0; i < s.length(); i++) {
	      char ch = s.charAt(i);
	      if (Character.isLowerCase(ch)) {
	        ch = (char) ((ch - 'a' + n) % 26 + 'a');
	      } else if (Character.isUpperCase(ch)) {
	        ch = (char) ((ch - 'A' + n) % 26 + 'A');
	      }
	      result += ch;
	    }
	        return result;
	    }
}


/*
 * 
 * �׷��� ������� �ʾ�����, �б����� Ȯ���ϰ� �������־����.
 * 
 */


