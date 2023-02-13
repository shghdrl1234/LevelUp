package level2;

import java.util.ArrayList;
import java.util.List;

public class �������� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ������ ���ĺ� ���� 'A', 'E', 'I', 'O', 'U'���� ����Ͽ� ���� �� �ִ�, 
		 * ���� 5 ������ ��� �ܾ ���ϵǾ� �ֽ��ϴ�. 
		 * �������� ù ��° �ܾ�� "A"�̰�, �״����� "AA"�̸�, ������ �ܾ�� "UUUUU"�Դϴ�.
		 * 
		 * �ܾ� �ϳ� word�� �Ű������� �־��� ��, 
		 * �� �ܾ �������� �� ��° �ܾ����� return �ϵ��� solution �Լ��� �ϼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * word�� ���̴� 1 �̻� 5 �����Դϴ�. 
		 * word�� ���ĺ� �빮�� 'A', 'E', 'I', 'O', 'U'�θ� �̷�����ֽ��ϴ�.
		 * 
		 */
	}
	
    public int solution(String word) {
    	
    	/*
    	 * ���� Ǫ�� ��� 
    	 * 
    	 * ���� ������ 
    	 * 1. ���ĺ��� ������ ����Ѵ�.
    	 * 2. ���ڼ��� ���� ���� �ܾ ��������, �� ���̱����� ���ĺ��� ���ٸ� ���ڼ��� �� ���� ���� ���� �´�.
    	 * 
    	 * A AA AAA AAAA AAAAA  
    	 * E EA EAA EAAA EAAAA
    	 * I IA IAA IAAA IAAAA
    	 * O OA OAA OAAA OAAAA
    	 * U UA UAA UAAA UAAAA
    	 * 
    	 * 1���� : 5��  
    	 * 2���� : 5*5�� 25
    	 * 3���� : 5*5*5�� 125 
    	 * 4���� : 5*5*5*5�� 625
    	 * 5���� : 5*5*5*5*5�� 3125
    	 * => �� 3905.
    	 * 
    	 * A : 1
    	 * A? : 5�� 
    	 * A?? : 5*5�� 
    	 * A??? : 5*5*5��
    	 * A???? : 5*5*5*5��
    	 * => �ϳ��� ������ ���� �տ� �� ���� �������� 781���� �ܾ �������
    	 * 781*5 => 3905.
    	 * 
    	 * AA 1��
    	 * AA? 5��
    	 * AA?? 25�� 
    	 * AA??? 125��
    	 * 
    	 * ���� ù �ڸ��� ���ڰ� �޶��� ��� 781*n���� ���̰� ���Ե�.
    	 * A=>E�� �Ǹ�
    	 * 1������ 782�� ��.
    	 * 
    	 * �ι�° �ڸ��� ���ڰ� �޶��� ��� ������ ���� + 156*n��
    	 * AA���� AE
    	 * 
    	 * ����° �ڸ��� ���ڰ� �޶��� ��� ������ ���� + 31*n��
    	 * �׹�° �ڸ��� ���ڰ� �޶��� ��� ������ ���� + 6*n��
    	 * �ټ���° �ڸ��� ���ڰ� �޶��� ��� ������ ���� + 1*n��
    	 * 
    	 */
    	
    	// ��ü �ܾ��� ����.
    	int wlen = word.length();

    	int num = 0;
    	int alp = 0;
    	int answer = 0;
    	
    	for(int i =0; i < wlen; i++) {
    		
    		switch(i) {
    		case 0 : num = 781; break;
    		case 1 : num = 156; break;
    		case 2 : num = 31; break;
    		case 3 : num = 6; break;
    		case 4 : num = 1; break;
    		}
    		
    		switch(word.charAt(i)) {
    		case 'A' : alp = 0; break;
    		case 'E' : alp = 1; break;
    		case 'I' : alp = 2; break;
    		case 'O' : alp = 3; break;
    		case 'U' : alp = 4; break;
    		}
    		
    		answer += num*alp+1;
    	}
    	
        return answer;
    }
    
    /*
     * swich���� ����Ͽ� Ǯ����.
     * �ڵ尡 �������� �� ���� �� �ִ� ����� ã�� �ʹ�.
     * 
     * split�Լ��� ����Ͽ� �� �����ϰ� ��Ÿ�� �Ʒ��� �ڵ带 ��������.
     * 
     */

}

class ��������_�ٸ���� {
    public int solution(String word) {
        int answer = 0, per = 3905;
        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        return answer;
    }
}

class ��������_�ٸ����2 {
    
	List<String> list = new ArrayList<>();
    void dfs(String str, int len) {
        if(len > 5) return;
        list.add(str);
        for(int i = 0; i < 5; i++) dfs(str + "AEIOU".charAt(i), len + 1);
    }
    
    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }
}
/*
 * ���� Ž���� �̿��� ����̴�.
 */

