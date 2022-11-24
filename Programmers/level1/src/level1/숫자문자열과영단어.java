package level1;

public class 숫자문자열과영단어 {

	public static void main(String[] args) {
		/*
		 * 네오와 프로도가 숫자놀이를 하고 있습니다. 
		 * 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 
		 * 프로도는 원래숫자를 찾는 게임입니다.
		 * 
		 * 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
		 * 
		 * 1478 → "one4seveneight" 
		 * 234567 → "23four5six7" 
		 * 10203 → "1zerotwozero3" 이렇게
		 * 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. 
		 * s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
		 * 
		 * 참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.
		 * 
		 * 제한사항 1 ≤ s의 길이 ≤ 50 s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다. 
		 * return 값이 1 이상
		 * 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.
		 */

		solution("123zero32");
	}
	
    public static int solution(String s) {
    	
    	/*
    	 * 내가 문제 푸는 방법
    	 * 
    	 * 1. replace 메서드 사용.
    	 * 2. 반복문을 통하여 각 과정별로 순차적으로 바뀐 것들을 저장시킴
    	 * 3. 이후 문자열을 숫자로 바꿈
    	 */
    	int answer = 0;
    	String[] str = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    	String number = s;
    	
    	for(int i = 0; i < 10; i++) {
    		number = number.replace( str[i], String.valueOf(i));
    		System.out.println(number);
    	}
    	
    	answer = Integer.valueOf(number);
    	
        return answer;
    }

}

/*
 * 풀이가 대부분 비슷하였음.
 * 
 */
