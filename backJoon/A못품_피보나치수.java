package backJoon;

public class A��ǰ_�Ǻ���ġ�� {
    /*
    �Ǻ���ġ ���� 0�� 1�� �����Ѵ�. 0��° �Ǻ���ġ ���� 0�̰�, 1��° �Ǻ���ġ ���� 1�̴�.
    �� ���� 2��° ���ʹ� �ٷ� �� �� �Ǻ���ġ ���� ���� �ȴ�.

    �̸� ������ �Ẹ�� Fn = Fn-1 + Fn-2 (n �� 2)�� �ȴ�.
    n=17�϶� ���� �Ǻ���ġ ���� �Ẹ�� ������ ����.
    0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
    n�� �־����� ��, n��° �Ǻ���ġ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
     */

    public static void main(String[] args) {
        int zero = 0;
        int one = 1;


        System.out.println(pvnc(zero,one,3,1));

    }

    public static int pvnc(int i, int j, int n, int total) {

        int sum = i+j;
        i = j;
        j += 1;

        if(n == 1) {
            return sum;
        } else {
            n--;
        }

        return pvnc( i, j,  n, sum);
    }
}