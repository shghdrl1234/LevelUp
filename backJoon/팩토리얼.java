package backJoon;

public class 팩토리얼 {

    /*
        0보다 크거나 같은 정수 N이 주어진다. 이 떄, N!을 출력하는 프로그램을 작성하시오.

        입력 : 첫째 줄에 정수 N(0 <= N <= 12)가 주어진다.

        출력 : 첫째 줄에 N!을 출력한다.
     */

    public static void main(String[] args) {
        int answer = 1;
        int i =10;

        System.out.println(factorial(answer, i));
    }

    public static int factorial(int answer, int i) {

        if(i == 1) {
            return answer;
        } else {
            answer *= i;
            i-=1;
        }
        return factorial(answer, i);
    }
}

