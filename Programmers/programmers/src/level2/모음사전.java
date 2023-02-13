package level2;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 
		 * 길이 5 이하의 모든 단어가 수록되어 있습니다. 
		 * 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
		 * 
		 * 단어 하나 word가 매개변수로 주어질 때, 
		 * 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
		 * 
		 * 제한사항 
		 * word의 길이는 1 이상 5 이하입니다. 
		 * word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져있습니다.
		 * 
		 */
	}
	
    public int solution(String word) {
    	
    	/*
    	 * 내가 푸는 방법 
    	 * 
    	 * 사전 순서는 
    	 * 1. 알파벳의 순서를 고려한다.
    	 * 2. 글자수가 작은 것의 단어를 기준으로, 그 길이까지의 알파벳이 같다면 글자수가 더 적은 것이 먼저 온다.
    	 * 
    	 * A AA AAA AAAA AAAAA  
    	 * E EA EAA EAAA EAAAA
    	 * I IA IAA IAAA IAAAA
    	 * O OA OAA OAAA OAAAA
    	 * U UA UAA UAAA UAAAA
    	 * 
    	 * 1글자 : 5개  
    	 * 2글자 : 5*5개 25
    	 * 3글자 : 5*5*5개 125 
    	 * 4글자 : 5*5*5*5개 625
    	 * 5글자 : 5*5*5*5*5개 3125
    	 * => 총 3905.
    	 * 
    	 * A : 1
    	 * A? : 5개 
    	 * A?? : 5*5개 
    	 * A??? : 5*5*5개
    	 * A???? : 5*5*5*5개
    	 * => 하나의 모음을 가장 앞에 둔 것을 기준으로 781개의 단어가 만들어짐
    	 * 781*5 => 3905.
    	 * 
    	 * AA 1개
    	 * AA? 5개
    	 * AA?? 25개 
    	 * AA??? 125개
    	 * 
    	 * 가장 첫 자리의 문자가 달라질 경우 781*n개의 차이가 나게됨.
    	 * A=>E가 되면
    	 * 1번에서 782가 됨.
    	 * 
    	 * 두번째 자리의 문자가 달라질 경우 이전의 차이 + 156*n개
    	 * AA에서 AE
    	 * 
    	 * 세번째 자리의 문자가 달라질 경우 이전의 차이 + 31*n개
    	 * 네번째 자리의 문자가 달라질 경우 이전의 차이 + 6*n개
    	 * 다섯번째 자리의 문자가 달라질 경우 이전의 차이 + 1*n개
    	 * 
    	 */
    	
    	// 전체 단어의 길이.
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
     * swich문을 사용하여 풀었다.
     * 코드가 생각보다 길어서 줄일 수 있는 방법을 찾고 싶다.
     * 
     * split함수를 사용하여 더 간단하게 나타낸 아래의 코드를 참조하자.
     * 
     */

}

class 모음사전_다른사람 {
    public int solution(String word) {
        int answer = 0, per = 3905;
        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        return answer;
    }
}

class 모음사전_다른사람2 {
    
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
 * 완전 탐색을 이용한 방법이다.
 */

