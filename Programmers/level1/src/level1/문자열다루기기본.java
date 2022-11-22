package level1;

public class ���ڿ��ٷ��⺻ {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * ���ڿ� s�� ���̰� 4 Ȥ�� 6�̰�, 
		 * ���ڷθ� �������ִ��� Ȯ�����ִ� �Լ�, solution�� �ϼ��ϼ���. 
		 * ���� ��� s�� "a234"�̸� False�� �����ϰ� "1234"��� True�� �����ϸ� �˴ϴ�.
		 * 
		 * ���� ���� 
		 * s�� ���� 1 �̻�, ���� 8 ������ ���ڿ��Դϴ�.
		 * s�� ���� ���ĺ� ��ҹ��� �Ǵ� 0���� 9���� ���ڷ� �̷���� �ֽ��ϴ�.
		 * 
		 */
		
		System.out.println(solution("124"));
	}
	
	   public static boolean solution(String s) {
		   /*
		    * ���� ����Ǫ�� ���
		    * 1. ���ǹ��� ���� s�� ���� �Ǻ�.
		    * 2. ���ڰ� ������ true ��ȯ.
		    */
	
		   boolean answer = false;
		   
		   if(s.length() == 4 || s.length() == 6) {
			   
			   for(int i = 0; i < s.length(); i++) {
				   answer = true;	
				   
				   if(!(s.charAt(i) >= 48 && s.charAt(i) < 58)) {
					   return false;
				   }
			   }
			   
			   
		   }
		   
	        return answer;
	    }
	
	   public boolean ���ڿ��ٷ��⺻_�ٸ����(String s) {
		   if(s.length() == 4 || s.length() == 6){
			   try{
				   int x = Integer.parseInt(s);
				   return true;
			   } catch(NumberFormatException e){
				   return false;
			   }
		   }
		   else return false;
	   }
	   // try-catch�� �����.
}

/*
 * ���� �ƽ�Ű�ڵ带 Ȱ���Ͽ� Ǯ��Ҵ�.
 * ������ �ƽ�Ű�ڵ尡 �� ������ ���� �ʾ� �ð��� ��ƸԾ���.
 * 
 *  ���� 0~9 => ASCII 48~57
 *  �빮�� A~Z => ASCII 65~90
 *  �ҹ��� a~z => ASCII 97~122
 * 
 */