package level1;

public class ���ڿ��������θ���� {

	public static void main(String[] args) {
		/*
		 * ���� ���� ���ڿ� s�� ���ڷ� ��ȯ�� ����� ��ȯ�ϴ� �Լ�, solution�� �ϼ��ϼ���.
		 * 
		 * ���� ���� s�� ���̴� 1 �̻� 5�����Դϴ�. s�� �Ǿտ��� ��ȣ(+, -)�� �� �� �ֽ��ϴ�. s�� ��ȣ�� ���ڷθ� �̷�����ֽ��ϴ�.
		 * s�� "0"���� �������� �ʽ��ϴ�.
		 */
		System.out.println(solution("-1234"));

		���ڿ��������θ����_�ٸ���� s = new ���ڿ��������θ����_�ٸ����();

		System.out.println(s.getStrToInt("+1532"));

	}

	static public int solution(String s) {
		int answer = 0;

		answer = Integer.valueOf(s);

		return answer;
	}
}

class ���ڿ��������θ����_�ٸ���� {
	public int getStrToInt(String str) {
		boolean Sign = true;
		int result = 0;
			System.out.println(str.length());
		for (int i = 0; i < str.length(); i++) {
			// ���ڿ��� ���̸� �������� �ݺ��� ����
			char ch = str.charAt(i);
			System.out.println(str.charAt(i));
			// char Ÿ������ ��ȯ
			if (ch == '-') {
				Sign = false;
				// -��ȣ�� boolean Ÿ���� false�� ����
			} else if (ch != '+') {
				result = result * 10 + ch - '0';
				System.out.println("result : " + result);
				// + ��ȣ�� �ƴҋ� (-��ȣ�� �̹� �������Ƿ�, �Ϲ� ���ڸ� �ǹ�)
				// 10�� ���ϴ� ������ �ڸ����� ����Ǳ� ����.
			}
		}
//		return Sign ? 1 : -1 * result;
		return (Sign ? 1 : -1) * result;
	}
}

/*
 * ���� ���� �ҽ��ڵ�� �̹� �����ִ� �Լ��� �ٷ� ����� ��,
 * �ٸ� ����� ���� �͵� �̹� �����ִ� charAt() ���� ����Ͽ�����, �׳��� ������? �ڵ��� �� ����.
 * 
 * �׸��� �ٸ� ��� �ڵ带 ���� ��ų�� ������ ����.
 * ������ return �κп� ��ȣ�� ����� �ȵǾ� �־���.
 * 
 * �ִ� ��õ�� ���� �ڵ忴���� 5�� �� ¥���� �ڵ�� ���� �ڹٿ��� �����ϴ� ��ɰ� �޶��� ���ϼ���..
 * �ƹ�ư ���� �ڵ� �ۼ��� ��ȣ�� �� ġ��!
 */
