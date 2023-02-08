package level1;

import java.util.ArrayList;
import java.util.List;

public class 둘만의암호 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 두 문자열 s와 skip, 그리고 자연수 index가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다. 
		 * 암호의 규칙은 다음과 같습니다.
		 * 
		 * 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다. 
		 * index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로
		 * 돌아갑니다. 
		 * skip에 있는 알파벳은 제외하고 건너뜁니다. 
		 * 예를 들어 s = "aukks", skip = "wbqd", index = 5일때, 
		 * a에서 5만큼 뒤에 있는 알파벳은 f지만 [b, c, d, e, f]에서 'b'와 'd'는 skip에 포함되므로 세지 않습니다.
		 * 따라서 'b', 'd'를 제외하고 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다. 
		 * 나머지 "ukks" 또한 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.
		 * 
		 * 두 문자열 s와 skip, 그리고 자연수 index가 매개변수로 주어질 때 위 규칙대로 s를 변환한 결과를 return하도록
		 * solution 함수를 완성해주세요. 
		 * 
		 *
		 * 제한사항 10
		 * 5 ≤ s의 길이 ≤ 50 
		 * 1 ≤ skip의 길이 ≤ 10 
		 * s와 skip은 알파벳 소문자로만 이루어져 있습니다. 
		 * skip에 포함되는 알파벳은 s에 포함되지 않습니다. 
		 * 1 ≤ index ≤ 20
		 * 
		 */
		char v = 97;
		char v2 = 122;
		System.out.println(v2);	
		}
	
    public String solution(String s, String skip, int index) {
    	/*
    	 * 내가 문제 푸는 방법
    	 * s의 각 글자를 split 하여, index만큼 더한 수로 바꾼다.
    	 * 
    	 * 문자 하나당 반복문을 순회하면서 skip내에 있는 글자와 하나씩 일치 할 때마나 알파벳을 -1씩 해준다.
    	 * => 단, z를 넘어가면 a로 다시 시작됨. a 97 ~z 122 // 넘어가서 다시 skip의 범위 안에 들어오면 건너 뛰어야함.
    	 * => 임의의 알파벳을 char로 형변환, index만큼 더해주고, skip과 일치하는 만큼 -1 해준다.
    	 * => 연산 결과 나온 char의 값이 122보다 크면, char에서 122을 뺴주고 96을 더한다. 
    	 *  
    	 * s를 split한 모든 배열에 한하여 같은 반복문을 진행하고, 문자열을 연걸한다
    	 * 
    	 * 1. List를 구현하여 알파벳을 다 집어 넣고
    	 * 2. skip에 포함된 요소들을 List에서 삭제.
    	 * 3. index 만큼 뒤에 있는 알파벳 출력.
    	 * 
    	 */
    	String answer = "";
    	List<String> l = new ArrayList<String>();
    	
    	// 알파벳 저장.
    	for(int i = 97; i <= 122; i++) {
    		l.add((char)i+"");
    	}
    	
    	// Skip이 가지고 있는 알파벳 삭제.
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


class 둘만의암호_다른사람 {
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

class 둘만의암호_다른사람2 {
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
 * 최근 재귀함수에 대한 문제를 많이 풀었고, 재귀함수를 써보았다.
 * 스트링 버퍼를 사용한 사람들의 코드도 확인해보았고,
 * 재귀함수를 쓰지 않은 사람들의 코드도 확인해보았다.
 */ 
