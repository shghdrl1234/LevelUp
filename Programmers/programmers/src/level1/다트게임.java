package level1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ��Ʈ���� {

	public static void main(String[] args) {
		/*
		 * īī���� ���Ӻ��� �Ϲݱ� �ű� ���񽺷� ��Ʈ ������ ����ϱ�� �ߴ�. 
		 * ��Ʈ ������ ��Ʈ�ǿ� ��Ʈ�� �� ���� ���� �� ������ �հ�� �Ƿ��� �ܷ�� ��������, ��ΰ� ������ ��� �� �ִ�. 
		 * �� �Ի��� ������ �ڵ� �Ƿ��� �����޾� ������ �ٽ� �κ��� ���� ��� ������ �ð� �Ǿ���.
		 * ��Ʈ ������ ���� ��� ������ �Ʒ��� ����.
		 * 
		 * ��Ʈ ������ �� 3���� ��ȸ�� �����ȴ�. 
		 * 
		 * �� ��ȸ���� ���� �� �ִ� ������ 0������ 10�������̴�. 
		 * 
		 * ������ �Բ� Single(S),Double(D), Triple(T) ������ �����ϰ�
		 * �� ���� ��÷ �� �������� 1����, 2����, 3���� (����^1 , ����^2 , ����^3)���� ���ȴ�. 
		 * 
		 * �ɼ����� ��Ÿ��(*), ������(#)�� �����ϸ� 
		 * ��Ÿ��(*) ��÷ �� �ش� ������ �ٷ� ���� ���� ������ �� 2��� �����. 
		 * ������(#) ��÷ �� �ش� ������ ���̳ʽ��ȴ�. 
		 * 
		 * ��Ÿ��(*)�� ù ��° ��ȸ������ ���� �� �ִ�. 
		 * �� ��� ù ��° ��Ÿ��(*)�� ������ 2�谡 �ȴ�. (���� 4�� ����) 
		 * 
		 * ��Ÿ��(*)�� ȿ���� �ٸ� ��Ÿ��(*)�� ȿ���� ��ø�� �� �ִ�. 
		 * �� ��� ��ø�� ��Ÿ��(*) ������ 4�谡 �ȴ�. (���� 4�� ����) 
		 * 
		 * ��Ÿ��(*)�� ȿ���� ������(#)�� ȿ���� ��ø�� �� �ִ�. �� ��� ��ø�� ������(#)�� ������
		 * -2�谡 �ȴ�. (���� 5�� ����) 
		 * 
		 * Single(S), Double(D), Triple(T)�� �������� �ϳ��� �����Ѵ�. 
		 * 
		 * ��Ÿ��(*),������(#)�� �������� �� �� �ϳ��� ������ �� ������, �������� ���� ���� �ִ�. 
		 * 0~10�� ������ ���� S, D, T, *, #�� ������ ���ڿ��� �Էµ� �� �������� ��ȯ�ϴ� �Լ��� �ۼ��϶�.
		 * 
		 * �Է� ���� 
		 * "����|���ʽ�|[�ɼ�]"���� �̷���� ���ڿ� 3��Ʈ. ��) 1S2D*3T
		 * 
		 * ������ 0���� 10 ������ �����̴�.
		 * 
		 * ���ʽ��� S, D, T �� �ϳ��̴�. �ɼ��� *�̳� # �� �ϳ��̸�, ���� ���� �ִ�. 
		 * 
		 * ��� ����
		 * 3���� ��ȸ���� ���� ���� �հ迡 �ش��ϴ� �������� ����Ѵ�. ��) 37
		 * 
		 */

		System.out.println(solution("1S2D*3T"));
		
	}
	public static int solution(String dartResult) {
		/*
		 * ���� ���� Ǫ�� ���
		 * 
		 * ���� ���ø� ���� �ʰ� dartResult�� ���ڸ� ��ȸ�Ͽ� ���� �� ����.
		 * 
		 * 1. ��Ʈ�� ������ ����,���ʽ�,�ɼ��� ���� �� �ִ�.
		 * => ���ڿ� ������ �ǵ��ؾ���. 
		 * => ����� �ִ� 2���� ���ڿ� 2���� ���ڰ� ����.
		 * 
		 * 2. ���ʽ��� �������� ���ʽ��� �� �ε����� �����̴�.
		 * => �� ��, ���ڸ��� 0�̸�, �� ���ڸ��� Ȯ���ϰ� ���ڸ��� ���ڸ� �� ���ڱ����� ����. (��, �ε����� 0 �̻��� ����,)
		 * 
		 * 3. ���ʽ��� �������� �ٷ� �� �ε����� �ɼ��̴�.
		 * => �� ��, ���ڸ��� ���ڰ� ������, �ɼ��� ���� ���̴�.
		 * => �� ��, ���ڸ� �ε����� ������ �ɼ��� ���� ������ �����̴�.
		 *
		 * 4. �� ������ ������ ����ϴ� 3���� int�� ������ �д�.
		 * => ù��° ���忡�� *�� ������ ù��° ���� �������� 2���Ѵ�. 
		 */
		
		int round = 0;
		
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		
		// �־��� ���ڿ� ��ȸ
		for(int i = 0; i < dartResult.length(); i++) {
			if(isStr(""+dartResult.charAt(i))) {
				round++; // ���ʽ� ������ ������ ���� ���� �ϴ� ������ ����.
				
				// �ε��� ������ ����� �����鼭, ���� ���ʽ� ���� �������� �ι�° ���ڸ��� 1�̸� ������ 10
				if(i>=2 &&dartResult.charAt(i-2) == '1') {
					
					if(round == 1) {
						num1 = bonus("10", dartResult.charAt(i));
					} else if(round == 2) {
						num2 = bonus("10", dartResult.charAt(i));
					} else if(round == 3) {
						num3 = bonus("10", dartResult.charAt(i));
					}
					
					// �׷��� ������ ������ ���ʽ� ���� �ٷ� ���ڸ� ��
				} else { 
					
					if(round == 1) {
						num1 = bonus(""+dartResult.charAt(i-1), dartResult.charAt(i));
					} else if(round == 2) {
						num2 = bonus(""+dartResult.charAt(i-1), dartResult.charAt(i));
					} else if(round == 3) {
						num3 = bonus(""+dartResult.charAt(i-1), dartResult.charAt(i));
					}
					
				}
//				System.out.println("num1 : " + num1);
//				System.out.println("num2 : " + num2);
//				System.out.println("num3 : " + num3);
				
				if(i+1<dartResult.length() && dartResult.charAt(i+1) == '*') {
					
					if(round == 1) {
						num1 *= 2;
					} else if(round == 2) {
						num1 *= 2;
						num2 *= 2;
					} else if(round == 3) {
						num2 *= 2;
						num3 *= 2;
					}
					
				} else if(i+1<dartResult.length() && dartResult.charAt(i+1) == '#') {
					
					if(round == 1) {
						num1 = -num1;
					} else if(round == 2) {
						num2 = -num2;
					} else if(round == 3) {
						num3 = -num3;
					}
					
				}
			}
		}
		return num1+num2+num3;
	}
	
	public static int bonus(String num, char bonus) {
		int bonusValue =0;
		System.out.println(num);
		if(bonus == 'S') {
			bonusValue =1;
		} else if(bonus == 'D') {
			bonusValue =2;
		} else if((bonus == 'T')) {
			bonusValue =3;
		}
		System.out.println("0 ���� : " + (int) Math.pow(0, bonusValue));
		System.out.println("-0 : " + 0*2);
		return (int) Math.pow(Integer.valueOf(num), bonusValue);
	}
	
	public static boolean isStr(String str) {
		
		return str.matches("[A-Z]{1}");
	}
	
	public static boolean isSc(String str) {
		
		return str.matches("[*#]{1}");
	}
	
//	public static int solution2(String dartResult) {
//		
//		/*
//		 * ���� ���� Ǫ�� ��� (����)
//		 * 
//		 * 1.�����ڸ� �������� �� �ձ��� ����Ʈ�� ����, ������ �ǵ� ��, ����Ʈ ���� ������.
//		 * ���� ���� ���� �ľ��ؼ� *�Ǵ� #�̸� �׸�ŭ �� ������ �߰���.
//		 * �� ��, ����Ʈ�� ù��°��, *�� ȿ���� ȥ�� �޴´�.
//		 * 
//		 * 2. ���� ���ڿ��� �Һ�� ���ڿ� ��ŭ �ڸ���.
//		 * 
//		 * 3. ��������? ���ڿ� ���̰� 0�� �� ������.
//		 * 
//		 * 4. ���� ����Ʈ ���� �� ���Ѵ�.
//		 * 
//		 */
//        int answer = 0;
//        
//        ArrayList<Integer> arr = new ArrayList<Integer>();
//        String dart = dartResult;
//        
//        int zero = 0;
//        	for(int i = 0; i < dart.length(); i++) {
////        		System.out.println("���� i���� �ڸ� ���� : "+ dart.substring(zero, i));
//        	
//        		if(isStr(""+(dart.charAt(i)))) {
//        		
//        			arr.add(Integer.valueOf(dart.substring(zero, i)));
////        			System.out.println("���ĺ�");
//        			switch(dart.charAt(i)) {
//        			
//        			case 'D': arr.set(arr.size()-1,(int)Math.pow((arr.get(arr.size()-1)),(2))); 
//        			case 'T': arr.set(arr.size()-1,(int)Math.pow((arr.get(arr.size()-1)),(3)));
//	        		
//        			}
//	        	
//        		}
//        		
//        		if(isSc(""+dart.charAt(i)) && arr.size() == 1) {
//        			switch(dart.charAt(i)) {
//        			case '*': arr.set(arr.size()-1,(arr.get(arr.size()-1))*2); 
//        			case '#': arr.set(arr.size()-1,-(arr.get(arr.size()-1))); 
//        			}
//        			
//        		} else if(isSc(""+dart.charAt(i))){
//        			switch(dart.charAt(i)) {
//        			case '*': arr.set(arr.size()-2,(arr.get(arr.size()-2))*2); arr.set(arr.size()-1,(arr.size()-1)*2); 
//        			case '#': arr.set(arr.size()-1,-(arr.get(arr.size()-1))); 
//        			}
//        		}
//	        	
//        		if(i != 0) {
//        			zero += 1;
//        		}
//        		
////        		System.out.println("i = "+ i +", zero = " + zero);
//        		System.out.println(arr);
//        	}
//        
//        	
//        	for(int i : arr) {
//        		answer += i;
//        	}
//        
//        	return answer;
//        }
	

}

 class ��Ʈ����_�ٸ���� {
    static int[] sum = new int[3];
    static int solution(String msg){
        String reg = "([0-9]{1,2}[S|T|D][*|#]{0,1})";
        Pattern p = Pattern.compile(reg+reg+reg);
        Matcher m = p.matcher(msg);
        m.find();
        for(int i=1; i<=m.groupCount(); i++){
            Pattern p1 = Pattern.compile("([0-9]{1,2})([S|T|D])([*|#]{0,1})");
            Matcher m1 = p1.matcher(m.group(i));
            m1.find();
            sum[i-1] = (int)Math.pow(Integer.parseInt(m1.group(1)), getpow(m1.group(2)));
            setting(i,m1.group(3));
        }
        return(sum[0]+ sum[1]+ sum[2]);
    }
    static void setting(int idx, String msg){
        if(msg.equals("*")){
            sum[idx - 1] *= 2;
            if(idx > 1 ){
                sum[idx - 2] *=2;
            }
        }
        else if(msg.equals("#")){
            sum[idx - 1] *=-1 ;
        }
    }
    static int getpow(String mag){
        if(mag.equals("S")){
            return 1; 
        }
        else if(mag.equals("D")){
            return 2;
        }
        else {
            return 3;
        }
    }
    
    /*
     * ������ ������ ����Ͽ� �ҽ� �ڵ� ���� �ٿ���. 
     *
     */
}
/*
 * ������ ������ Ǯ ���� �ڵ嵵 �� ������.. if���� ���� ����ϴ°� �³� �;��µ�
 * �ᱹ�� if���� ���� ���°͵� �¾Ҵ�.
 * 
 * ��ſ� ���� ���� �ϱ� ���� ���� Ŭ������ ��������� ����Ͽ���.
 * 
 * ���Ͽ� ���� ���� �� Ȯ���� �����صδ°� ������.
 */
 
 
 