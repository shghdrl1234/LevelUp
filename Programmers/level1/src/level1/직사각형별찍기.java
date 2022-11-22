package level1;

import java.util.Scanner;

public class 직사각형별찍기 {
	
	/*
	 * 문제 설명 
	 * 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다. 
	 * 별(*) 문자를 이용해 가로의 길이가 n, 
	 * 세로의 길이가 m인 직사각형 형태를 출력해보세요.
	 * 
	 * 제한 조건 
	 * n과 m은 각각 1000 이하인 자연수입니다.
	 * 
	 */

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int i = 0; i < b; i++) {
        	for(int j = 0; j < a; j++) {
        		System.out.print("*");
        	}
        	System.out.println("");
        }

	}		


}

class 직사각형별찍기_다른사람 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<a; i++){
            sb.append("*");
        }
        for(int i=0; i<b; i++){
            System.out.println(sb.toString());
        }
        // stringBuilder를 사용함..
    }
}

/*
 * 2000명이 넘는 사람들이 내가 작성한 코드와 유사하게 만들었다.
 * 
 * 물론 이게 정석이라고 할수도 있겠지만, 더 많은 풀이법을 연구해봐야겠다.
 * 
 */

