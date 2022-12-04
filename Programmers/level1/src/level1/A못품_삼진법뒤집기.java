package level1;

public class A못품_삼진법뒤집기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 자연수 n이 매개변수로 주어집니다. 
		 * n을 3진법 상에서 앞뒤로 뒤집은 후, 
		 * 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
		 * 
		 * 제한사항 
		 * n은 1 이상 100,000,000 이하인 자연수입니다.
		 */
		
		solution(99999998);
	}

    public static int solution(int n) {
    	
    	/*
    	 * 내가 문제 푸는 방법
    	 * 1. n을 num에 저장, num을 3으로 나눴을 때
    	 * 1-1. 1보다 작으면 => 그 값을 total 값에 저장
    	 *   
    	 * 1-2. 1보다 크면 => num%3을 진행하여 나머지를 total값에 저장.(10의 cnt제곱 나머지)
    	 * 1-3. num/3의 값을 num값에 저장. cnt++
    	 * 1-3-1. num의 값이 3보다 작으면, total 값에 저장 (가장 아래부분)
    	 * 
    	 * 2. 배열과 반복문을 이용하여 앞 뒤를 뒤집고.
    	 * 3. 다시 반복문을 사용하여 10진법의 수로 만든다.
    	 * 
    	 */
    	long total =0;
    	int num = n;
    	int cnt = 0;
    	
    	if(num/3 < 1) {
    		// num은 3보다 작다, 그러므로 나머지만 남게된다.
    		total += num;
    	}
    	
    	while(num/3 >= 1) {
    		// num은 1보다 크거나 같다, 그러므로 "몫"과 "나머지"가 동시에 발생된다.
    		if(num%3 < 3) {
    			// 몫이 나온 관계로, 나머지를 따로 구해서 total값에 저장한다. 나머지는 3보다 클 수 없다.
    			total += Math.pow(10, cnt)*(num%3);
    			// 나머지 값은 반복한 횟수에 비례하여 자릿수 가지게 된다.
    			
    			num /= 3; cnt++;
    			// 몫이 있기때문에 다시 3을 나눠 준다. 즉, while 반복문에 조건에 사용되는 변수이다.
    			// 그리고 카운트도 한다.
    			
    			if(num/3 <1) {
    				// 이 위치에서 num/3이 1보다 작으면 반복문을 순회할 수 없다.
    				// 즉 마지막 계산 하나가 누락된다.
    				total += Math.pow(10, cnt)*(num);
    			}
    			
    		}
    		
    	}

    	
    	System.out.println("total : " + total + "(3)");
    	
    	// 222111212000121 => 121000212111222 로 바꾼다.
    	// 배열을 활용할 것인가?
    	
    	String totalStr = String.valueOf(total);
    	String[] arr = totalStr.split("");
    	
//    	String[] arr2 = arr;
    	String[] arr2 = new String[arr.length];
    	// 각 자리 수를 배열의 인덱스 값으로 저장함.

//    	for(int i = 0; i < arr.length; i++) {
//    		arr2[i] = arr[arr.length-i-1];
//    		System.out.println("arr2["+i+"] : "+arr2[i]);
//    	}
    	
    	
    	 int answer = 0;
    	for(int j = 0; j < arr.length; j++ ) {
    		answer += Integer.valueOf(arr[j])*(Math.pow(3, j));
    		System.out.println("arr["+j+"] : "+arr[j]);
    	}
    		System.out.println("10진수 값 : " + answer);
        return 134335209;
    }
}
