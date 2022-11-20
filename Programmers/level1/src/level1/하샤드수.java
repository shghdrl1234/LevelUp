package level1;

public class 하샤드수 {

	public static void main(String[] args) {
		/*
		 * 
		 * 문제 설명 
		 * 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 
		 * 예를 들어 18의 자릿수 합은 1+8=9이고,
		 * 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 
		 * 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, 
		 * solution을 완성해주세요.
		 * 
		 * 제한 조건 
		 * x는 1 이상, 10000 이하인 정수입니다.
		 * 
		 */
		System.out.println(solution(157));

	}

	public static boolean solution(int x) {
		boolean answer = true;
		// 1. 받아온 파라미터의 각 자리 수의 값을 구해야함.
		// 2. 받아온 파라미터의 각 자리 수의 합을 저장해야함.
		// 3. 받아온 파라미터로 긱 자리 수의 합을 나누었을 때 나머지가 없어야함.

		// 1-1. string으로 변환 후, split을 활용하는 방식 => 너무 쉬워보임
		// 1-2. int 10으로 나눠서 남은 나머지 = 그 자리의 값인 것을 활용하는 방식

		int num = x;
		int total = 0;
		while (num >= 1) {
			// 양의 정수 x가 일의 자리 수가 될 경우, 10으로 나누면 소수점이 나옴.
			// 소수점이 나오기 전까지 진행.
			total += num % 10;
			System.out.println("if문 안들어옴");
			System.out.println(total);
			// 마지막 자리수를 순차적으로 더해주는 코드.
			// num 값은 한 자리수 낮춰지고, 마지막 자리수는 제거된다.
			num = num / 10;
		}

		if (x % total != 0) {
			// 파라미터 값에서 파라미터의 각 자리수를 더한 값을 나눴을때,
			// 나머지 값이 0이면 하샤드 수임.

			// 즉, 이 코드는 0이 아니므로 하샤드 수가 아니라는 코드.
			answer = false;

		}

		return answer;
	}
}

class 하샤드수_다른사람 {
	public boolean isHarshad(int num) {

		String[] temp = String.valueOf(num).split("");
		// 스플릿을 진행하여 배열에 저장

		int sum = 0;
		for (String s : temp) {
			sum += Integer.parseInt(s);
			// 배열의 길이에 따라 하나씩 parseInt 진행.
			// 각 값을 더해줌.
		}

		if (num % sum == 0) {
			return true;
		} else {
			return false;
		}
	}
}

/*
 * 스플릿도 생각했었는데 조금 더 생각하는 차원으로 풀기 위해 길게 풀어봤다.
 * 다른 사람들도 스플릿을 사용한 것을 보니 생각하는건 비슷한 모양인듯.
 * 
 * 초급 문제라 그런지 빠르게 넘어가려고 함.
 * 
 */


