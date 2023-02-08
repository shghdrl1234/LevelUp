package level1;

import java.util.ArrayList;
import java.util.List;

public class �Ѹ��Ǿ�ȣ {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �� ���ڿ� s�� skip, �׸��� �ڿ��� index�� �־��� ��, ���� ��Ģ�� ���� ���ڿ��� ����� �մϴ�. 
		 * ��ȣ�� ��Ģ�� ������ �����ϴ�.
		 * 
		 * ���ڿ� s�� �� ���ĺ��� index��ŭ ���� ���ĺ����� �ٲ��ݴϴ�. 
		 * index��ŭ�� ���� ���ĺ��� z�� �Ѿ ��� �ٽ� a��
		 * ���ư��ϴ�. 
		 * skip�� �ִ� ���ĺ��� �����ϰ� �ǳʶݴϴ�. 
		 * ���� ��� s = "aukks", skip = "wbqd", index = 5�϶�, 
		 * a���� 5��ŭ �ڿ� �ִ� ���ĺ��� f���� [b, c, d, e, f]���� 'b'�� 'd'�� skip�� ���ԵǹǷ� ���� �ʽ��ϴ�.
		 * ���� 'b', 'd'�� �����ϰ� 'a'���� 5��ŭ �ڿ� �ִ� ���ĺ��� [c, e, f, g, h] ������ ���� 'h'�� �˴ϴ�. 
		 * ������ "ukks" ���� �� ��Ģ��� �ٲٸ� "appy"�� �Ǹ� ����� "happy"�� �˴ϴ�.
		 * 
		 * �� ���ڿ� s�� skip, �׸��� �ڿ��� index�� �Ű������� �־��� �� �� ��Ģ��� s�� ��ȯ�� ����� return�ϵ���
		 * solution �Լ��� �ϼ����ּ���. 
		 * 
		 *
		 * ���ѻ��� 10
		 * 5 �� s�� ���� �� 50 
		 * 1 �� skip�� ���� �� 10 
		 * s�� skip�� ���ĺ� �ҹ��ڷθ� �̷���� �ֽ��ϴ�. 
		 * skip�� ���ԵǴ� ���ĺ��� s�� ���Ե��� �ʽ��ϴ�. 
		 * 1 �� index �� 20
		 * 
		 */
		char v = 97;
		char v2 = 122;
		System.out.println(v2);	
		}
	
    public String solution(String s, String skip, int index) {
    	/*
    	 * ���� ���� Ǫ�� ���
    	 * s�� �� ���ڸ� split �Ͽ�, index��ŭ ���� ���� �ٲ۴�.
    	 * 
    	 * ���� �ϳ��� �ݺ����� ��ȸ�ϸ鼭 skip���� �ִ� ���ڿ� �ϳ��� ��ġ �� ������ ���ĺ��� -1�� ���ش�.
    	 * => ��, z�� �Ѿ�� a�� �ٽ� ���۵�. a 97 ~z 122 // �Ѿ�� �ٽ� skip�� ���� �ȿ� ������ �ǳ� �پ����.
    	 * => ������ ���ĺ��� char�� ����ȯ, index��ŭ �����ְ�, skip�� ��ġ�ϴ� ��ŭ -1 ���ش�.
    	 * => ���� ��� ���� char�� ���� 122���� ũ��, char���� 122�� ���ְ� 96�� ���Ѵ�. 
    	 *  
    	 * s�� split�� ��� �迭�� ���Ͽ� ���� �ݺ����� �����ϰ�, ���ڿ��� �����Ѵ�
    	 * 
    	 * 1. List�� �����Ͽ� ���ĺ��� �� ���� �ְ�
    	 * 2. skip�� ���Ե� ��ҵ��� List���� ����.
    	 * 3. index ��ŭ �ڿ� �ִ� ���ĺ� ���.
    	 * 
    	 */
    	String answer = "";
    	List<String> l = new ArrayList<String>();
    	
    	// ���ĺ� ����.
    	for(int i = 97; i <= 122; i++) {
    		l.add((char)i+"");
    	}
    	
    	// Skip�� ������ �ִ� ���ĺ� ����.
    	for(String str : skip.split("")) {
    		if(l.contains(str)) {
    		 l.remove(str);	
    		}
   		}
    	
    	String[] s2 = s.split("");
    	
    	for(int i = 0; i < s2.length; i++) {
    		
    		int j = l.indexOf(s2[i]) + index;

    		if(j > l.size()-1) {
    			j = j - l.size();
    			j = getIdx(l, j);
    		} else {
    			j = j+index;
    		}
    		
    		answer += l.get(j);
    	}
    	
        return answer;
    }

	private int getIdx(List<String> l, int j) {
		if(j > l.size()-1) {
			j = j - l.size();
			j = getIdx(l, j);
		}
		return j;
	}


}


class �Ѹ��Ǿ�ȣ_�ٸ���� {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }

        return answer.toString();
    }
}

class �Ѹ��Ǿ�ȣ_�ٸ����2 {
    public String solution(String s, String skip, int index) {
        char[] sArr = s.toCharArray();
        char[] skipArr = skip.toCharArray();
        ArrayList<Character> alphabet = new ArrayList<>();

        for(int i = 0 ; i <= 25 ; i++){
            alphabet.add((char)(i + 97));
        }
        for (char c : skipArr) {
            alphabet.remove(Character.valueOf(c));
        }

        int size = alphabet.size();
        for(int c=0; c < sArr.length ; c++) {
            int indexNum = alphabet.indexOf(Character.valueOf(sArr[c]))+index;
            indexNum = indexNum % size;
            sArr[c] = alphabet.get(indexNum);
        }

        String answer = new String(sArr);

        return answer;
    }
}

/*
 * �ֱ� ����Լ��� ���� ������ ���� Ǯ����, ����Լ��� �Ẹ�Ҵ�.
 * ��Ʈ�� ���۸� ����� ������� �ڵ嵵 Ȯ���غ��Ұ�,
 * ����Լ��� ���� ���� ������� �ڵ嵵 Ȯ���غ��Ҵ�.
 */ 
