package backJoon;

public class ���丮�� {

    /*
        0���� ũ�ų� ���� ���� N�� �־�����. �� ��, N!�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

        �Է� : ù° �ٿ� ���� N(0 <= N <= 12)�� �־�����.

        ��� : ù° �ٿ� N!�� ����Ѵ�.
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

