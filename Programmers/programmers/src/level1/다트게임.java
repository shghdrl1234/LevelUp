package level1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class 다트게임 {

	public static void main(String[] args) {
		/*
		 * 카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 
		 * 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다. 
		 * 갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다.
		 * 다트 게임의 점수 계산 로직은 아래와 같다.
		 * 
		 * 다트 게임은 총 3번의 기회로 구성된다. 
		 * 
		 * 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다. 
		 * 
		 * 점수와 함께 Single(S),Double(D), Triple(T) 영역이 존재하고
		 * 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수^1 , 점수^2 , 점수^3)으로 계산된다. 
		 * 
		 * 옵션으로 스타상(*), 아차상(#)이 존재하며 
		 * 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 
		 * 아차상(#) 당첨 시 해당 점수는 마이너스된다. 
		 * 
		 * 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 
		 * 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고) 
		 * 
		 * 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 
		 * 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고) 
		 * 
		 * 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는
		 * -2배가 된다. (예제 5번 참고) 
		 * 
		 * Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다. 
		 * 
		 * 스타상(*),아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다. 
		 * 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
		 * 
		 * 입력 형식 
		 * "점수|보너스|[옵션]"으로 이루어진 문자열 3세트. 예) 1S2D*3T
		 * 
		 * 점수는 0에서 10 사이의 정수이다.
		 * 
		 * 보너스는 S, D, T 중 하나이다. 옵선은 *이나 # 중 하나이며, 없을 수도 있다. 
		 * 
		 * 출력 형식
		 * 3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다. 예) 37
		 * 
		 */

		System.out.println(solution("1S2D*3T"));
		
	}
	public static int solution(String dartResult) {
		/*
		 * 내가 문제 푸는 방법
		 * 
		 * 따로 스플릿 하지 않고 dartResult의 문자를 순회하여 값을 낼 것임.
		 * 
		 * 1. 다트를 던지면 점수,보너스,옵션을 얻을 수 있다.
		 * => 문자와 점수로 판독해야함. 
		 * => 라운드당 최대 2개의 문자와 2개의 숫자가 나옴.
		 * 
		 * 2. 보너스를 기준으로 보너스의 앞 인덱스가 점수이다.
		 * => 이 때, 앞자리가 0이면, 그 앞자리를 확인하고 앞자리가 숫자면 그 숫자까지가 점수. (단, 인덱스가 0 이상일 때만,)
		 * 
		 * 3. 보너스를 기준으로 바로 뒤 인덱스가 옵션이다.
		 * => 이 때, 뒷자리가 숫자가 나오면, 옵션이 없는 것이다.
		 * => 또 한, 뒷자리 인덱스가 없으면 옵션이 없는 마지막 라운드이다.
		 *
		 * 4. 각 라운드의 점수를 계산하는 3개의 int형 변수를 둔다.
		 * => 첫번째 라운드에서 *이 나오면 첫번째 점수 변수에만 2배한다. 
		 */
		
		int round = 0;
		
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		
		// 주어진 문자열 순회
		for(int i = 0; i < dartResult.length(); i++) {
			if(isStr(""+dartResult.charAt(i))) {
				round++; // 보너스 영역이 나오면 라운드 증가 하는 것으로 간주.
				
				// 인덱스 범위를 벗어나지 않으면서, 현재 보너스 영역 기준으로 두번째 앞자리가 1이면 점수는 10
				if(i>=2 &&dartResult.charAt(i-2) == '1') {
					
					if(round == 1) {
						num1 = bonus("10", dartResult.charAt(i));
					} else if(round == 2) {
						num2 = bonus("10", dartResult.charAt(i));
					} else if(round == 3) {
						num3 = bonus("10", dartResult.charAt(i));
					}
					
					// 그렇지 않으면 점수는 보너스 영역 바로 앞자리 수
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
		System.out.println("0 제곱 : " + (int) Math.pow(0, bonusValue));
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
//		 * 내가 문제 푸는 방법 (실패)
//		 * 
//		 * 1.영문자를 기준으로 그 앞까지 리스트로 저장, 영문자 판독 후, 리스트 값에 곱해줌.
//		 * 이후 다음 글자 파악해서 *또는 #이면 그만큼 또 점수를 추가함.
//		 * 이 때, 리스트가 첫번째면, *의 효과는 혼자 받는다.
//		 * 
//		 * 2. 이후 문자열을 소비된 문자열 만큼 자른다.
//		 * 
//		 * 3. 언제까지? 문자열 길이가 0이 될 때까지.
//		 * 
//		 * 4. 이후 리스트 값을 다 더한다.
//		 * 
//		 */
//        int answer = 0;
//        
//        ArrayList<Integer> arr = new ArrayList<Integer>();
//        String dart = dartResult;
//        
//        int zero = 0;
//        	for(int i = 0; i < dart.length(); i++) {
////        		System.out.println("현재 i까지 자른 문자 : "+ dart.substring(zero, i));
//        	
//        		if(isStr(""+(dart.charAt(i)))) {
//        		
//        			arr.add(Integer.valueOf(dart.substring(zero, i)));
////        			System.out.println("알파벳");
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

 class 다트게임_다른사람 {
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
     * 패턴을 적절히 사용하여 소스 코드 수를 줄였다. 
     *
     */
}
/*
 * 이전에 문제를 풀 때는 코드도 안 읽히고.. if문을 많이 사용하는게 맞나 싶었는데
 * 결국엔 if문을 많이 쓰는것도 맞았다.
 * 
 * 대신에 보기 쉽게 하기 위해 나는 클래스를 직접만들어 사용하였다.
 * 
 * 패턴에 대해 조금 더 확실히 공부해두는게 나을듯.
 */
 
 
 