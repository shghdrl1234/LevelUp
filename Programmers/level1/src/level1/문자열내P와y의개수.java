package level1;

public class ���ڿ���P��y�ǰ��� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �빮�ڿ� �ҹ��ڰ� �����ִ� ���ڿ� s�� �־����ϴ�. 
		 * s�� 'p'�� ������ 'y'�� ������ ���� ������ True, �ٸ���
		 * False�� return �ϴ� solution�� �ϼ��ϼ���. 
		 * 'p', 'y' ��� �ϳ��� ���� ���� �׻� True�� �����մϴ�. ��,
		 * ������ ���� �� �빮�ڿ� �ҹ��ڴ� �������� �ʽ��ϴ�.
		 * 
		 * ���� ��� s�� "pPoooyY"�� true�� return�ϰ� 
		 * "Pyy"��� false�� return�մϴ�.
		 * 
		 * ���ѻ��� ���ڿ� 
		 * s�� ���� : 50 ������ �ڿ��� 
		 * ���ڿ� s�� ���ĺ����θ� �̷���� �ֽ��ϴ�.
		 * 
		 */
		
		System.out.println(solution("as"));

	}
	// 1. ���ø��� ���� �迭�� ����.
	// 2. �� �ε����� ���ǹ����� ���Ͽ� P,p,Y,y ������ switch-case������ �ۼ�.
	
    static boolean solution(String s) {
        boolean answer = true;
        
        String[] str = s.split("");
        
        int total_P = 0;
        int total_Y = 0;
        
        for(int i = 0; i < str.length; i++) {
        
        	switch(str[i]) {
        	
	        	case "P" : total_P++; break;
	        	
	        	case "p" : total_P++; break;
	        	
	        	case "Y" : total_Y++; break;
	        	
	        	case "y" : total_Y++; break;
	        	
	        	default : System.out.println(i+"��° �õ�, ��ġ�ϴ� ���ڰ��� �����ϴ�.");
        	}
        	
        }
        	if(total_P != total_Y) {
        		answer = false;
        	} 

        return answer;
    }
	
}



class ���ڿ���P��y�ǰ���_�ٸ���� {
    boolean solution(String s) {
        s = s.toUpperCase(); //��ü �빮�ڷ� �������

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }
}
