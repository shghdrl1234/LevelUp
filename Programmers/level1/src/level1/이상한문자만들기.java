package level1;

public class 이상한문자만들기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 
		 * 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
		 * 각 단어의 짝수번째 알파벳은 대문자로, 
		 * 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
		 * 
		 * 제한 사항 
		 * 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다. 
		 * 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
		 * 
		 */
		System.out.println(solution("   tRy hello   dd WORLD  sdf asdf abc cde "));

	}
	
    public static String solution(String s) {
    	
    	/*
    	 * 내가 문제 푸는 방법
    	 * 1. 문자열 안의 단어들 사이에는 공백이 있음 => split 활용하여 배열로 만듦.
    	 * 2. 배열의 각 인덱스 값(문자열)에서 문자열의 길이, 문자열의 순서를 활용하여 반복문 사용.
    	 * 
    	 * 2-1. 문자열 s 는 한 개 이상의 단어로 되어있다. => 스플릿으로 자르기
    	 * 2-2. 문자열 내부의 각 단어들 하나 이상의 공백문자로 구분되어있다. => 공백 개수는 유지해라.
    	 * 2-3. 단어의 짝수번째 글자는 대문자, 홀수째는 소문자로 만들어야한다. => 최소 소문자로 정렬, 이후 순서에 따라 대문자로 뱐환.
    	 * 
    	 */
    	String answer = "";
    	String[] word = s.split(" ",-1);
    	// 문자열 " "을 분기점으로 각 단어들이 배열로 저장됨.
    	for(int i = 0; i < word.length; i++) {
    		
    		word[i] = word[i].toLowerCase();
    		// 각각 단어들이 저장된 배열 전부, 소문자를 취해준다. 애초에 일부가 대문자 일 수도 있다.
    		System.out.println("============word " + i +  "번============");
    		
    		String[] wordStr = word[i].split("");
    		// 단어의 문자열 하나 하나가 인덱스로 저장됨.
    		
				for(int k = 0; k < wordStr.length; k+=2) {
					// 단어의 문자 하나하나 인덱스를 파악하여 짝수 인덱스는 대문자로 바꿈.
					wordStr[k] = wordStr[k].toUpperCase();
					System.out.println("word["+i+"]의 값 : "+word[i]+", wordStr["+(k)+"]의 값 : " + wordStr[k]);
				}
				
				word[i] = "";
				for(int y = 0; y < wordStr.length; y++) {
					// 각 인덱스별로 새로만들어진 단어를 저장.
						word[i] += wordStr[y];
				}

    	}
    	System.out.println("====================");

    	int num = 0;
    	while(word[num].equals("")) {
    		// 처음으로 공백이 안나오는 단어를 찾는다.
    		num++;
    	}
    	
    	for(int i = num; i < word.length; i++ ) {
    		// 처음이 공백이 아닌 단어부터 시작.
    		if(i != word.length-1) {
    			answer += word[i] + " ";
    			System.out.println("word[" + i + "]의 값 : " + word[i]);
    		} else if(!word[i].equals("")){
    			answer += word[i];
    			System.out.println("word[" + i + "]의 값 : " + word[i]);
    		}
    	}
        return answer;
    }

}

	class 이상한문자만들기_다른사람 {
	  public String solution(String s) {

	        String answer = "";
	        int cnt = 0;
	        String[] array = s.split("");
	        // 문자열을 한 글자씩 쪼개서 배열에 저장.

	        for(String ss : array) {
	        	// 향상된 for문으로 순회
	            cnt = ss.contains(" ") ? 0 : cnt + 1;
	            // 공백이 있으면 0으로 초기화, 공백이 없으면 카운트(즉,단어의 길이)
	            
	            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase(); 
	            // answer에 저장하는 시점에 공백 개수로 
	        }
	      return answer;
	  }
	}

	/*
	 * 
	 * 이번 문제는 유독 시간이 많이 걸렸다.
	 * 
	 * 이유는 조건을 제대로 이해하지 않고 풀어서인데..
	 * 
	 * 명확한 조건을 유추할 수 있는 실력을 가져야겠다.
	 * 
	 * /
	 */
	