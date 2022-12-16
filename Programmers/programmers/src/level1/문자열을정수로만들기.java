package level1;

public class 문자열을정수로만들기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
		 * 
		 * 제한 조건 s의 길이는 1 이상 5이하입니다. s의 맨앞에는 부호(+, -)가 올 수 있습니다. s는 부호와 숫자로만 이루어져있습니다.
		 * s는 "0"으로 시작하지 않습니다.
		 */
		System.out.println(solution("-1234"));

		문자열을정수로만들기_다른사람 s = new 문자열을정수로만들기_다른사람();

		System.out.println(s.getStrToInt("+1532"));

	}

	static public int solution(String s) {
		int answer = 0;

		answer = Integer.valueOf(s);

		return answer;
	}
}

class 문자열을정수로만들기_다른사람 {
	public int getStrToInt(String str) {
		boolean Sign = true;
		int result = 0;
			System.out.println(str.length());
		for (int i = 0; i < str.length(); i++) {
			// 문자열의 길이를 기준으로 반복문 설정
			char ch = str.charAt(i);
			System.out.println(str.charAt(i));
			// char 타입으로 변환
			if (ch == '-') {
				Sign = false;
				// -부호는 boolean 타입의 false로 저장
			} else if (ch != '+') {
				result = result * 10 + ch - '0';
				System.out.println("result : " + result);
				// + 부호가 아닐떄 (-부호는 이미 나왔으므로, 일반 숫자를 의미)
				// 10을 곱하는 이유는 자릿수가 변경되기 때문.
			}
		}
//		return Sign ? 1 : -1 * result;
		return (Sign ? 1 : -1) * result;
	}
}

/*
 * 내가 만든 소스코드는 이미 나와있는 함수를 바로 사용한 것,
 * 다른 사람이 만든 것도 이미 나와있는 charAt() 등을 사용하였지만, 그나마 논리적인? 코드인 것 같음.
 * 
 * 그리고 다른 사람 코드를 동작 시킬때 오류가 났음.
 * 이유는 return 부분에 괄호가 제대로 안되어 있었다.
 * 
 * 최다 추천을 받은 코드였지만 5년 전 짜여진 코드라 현재 자바에서 제공하는 기능과 달라진 것일수도..
 * 아무튼 이제 코드 작성시 괄호를 잘 치자!
 */
