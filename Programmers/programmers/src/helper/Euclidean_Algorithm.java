package helper;

public class Euclidean_Algorithm {
	/*
	 * 유클리드 알고리즘이며, 유클리드 호제법이라고 불린다.
	 * 
	 * 유클리드 알고리즘은 주어진 두 수 사이에 존재하는 최대공약수(GCD)를 구하는 알고리즘이다.
	 * 
	 * 1. 임의의 두 자연수 a,b가 주어졌을 때, 둥 중 큰 값이 a라고 가정한다.
	 * 2. a를 b로 나눈 나머지를 n이라고 하면 (a%b = n) 이다.
	 * 3. n 이 0 일때, b가 최대 공약수(GCD)이다.
	 * 4. 만약 n이 0이 아니라면, a에 b를 넣고, n을 b에 대입한 뒤 다시 2번부터 시작한다.
	 * 
	 * 즉, 원리는 유클리드 호제법의 원리는
	 * a를 b로 나눈 나머지를 r이라고 한다면 a,b의 최대공약수와 b,r의 최대공약수는 같다.
	 * 이 성질에 따라 a를 b로 나눈 나머지 r을 구하고, b를 r로 나눈 나머지로 r_1을 구한다.
	 * 나머지가 0이 될 때 나눈 수가 a,b의 최대 공약수가 된다.
	 * 
	 * 또한 유클리드 호제법으로 최대공약수를 구한 다음, 최소 공배수는 다은 식에 의해 구할 수 있다.
	 * 최소 공배수 : (a x b) / (최대 공약수)
	 * 
	 * ex) 60, 48의 최대 공약수  
	 * 60 % 48 = 12
	 * 48 % 12 = 0 // 최대 공약수 12
	 * 
	 * ex) 60, 48의 최소 공배수
	 * 60 x 48 / 12 = 240
	 * 
	 * 만약 수가 A,B,C 처럼 두 개 이상이 주어지면 최소 공배수는
	 * 1. A, B의 최소 공배수를 구한다.
	 * 2. 1에서 구한 (A, B의 최소 공배수)와 C의 최소 공배수를 구한다.
	 * 
	 * 유클리드 알고리즘은 반복문과 재귀를 이용하여 접근이 가능하다.
	 */
	
	//최대 공약수를 구하는 메서드, 재귀 호출을 사용하여 최종적으로 나머지가 0일때의 num2를 리턴한다.
	public static int GCD(int num1, int num2) {
		
		if(num1 % num2 == 0) {
			return num2;
		}
		
		return GCD(num2, num1 % num2);
	}
	
	// 배열로 여러개의 숫자가 주어졌을 때, 최소 공배수를 구하는 메서드
	public static int LCM(int[] arr) {
		if(arr.length == 1) {
			return arr[0];
		}
		
		int gcd = GCD(arr[0], arr[1]);
		int lcm = (arr[0] * arr[1]) / gcd;
		
		for(int i = 2; i < arr.length; i++) {
			gcd = GCD(lcm, arr[i]);
			lcm = (lcm * arr[i]) / gcd;
		}
		
		return lcm;
	}
	
	
	public static void main(String[] args) {
		System.out.println("최대 공약수 : " + GCD(15,10));
		System.out.println("최대 공배수 : " + 15*10 / GCD(15,10));
		
		System.out.println("최대 공배수 : " + LCM(new int[]{1,5,10,15,20}));
	}

}
