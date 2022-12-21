package practice;

public class PracticeStringbuffer {

	public static void main(String[] args) {
		
//		StringBuffer sb = new StringBuffer();
//		sb.append("1122");
//		System.out.println(sb);
//		sb.delete(0, 2);
//		System.out.println(sb);
//		sb.append("1123");
//		System.out.println(sb);
//		sb.insert(3, "a");
//		System.out.println(sb);
//		
		StringBuffer sb = new StringBuffer("01");
		StringBuffer sb2 = sb.append(23);
		sb.append('4').append(56);
		
		StringBuffer sb3 = sb.append(78);
		sb3.append(9.0);
		
		// StringBuffer는 메서드 체이닝 가능
		
		String aa = "sdfasdf";
		
		
		
	}

}
