package level2;

public class 카펫 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 
		 * 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
		 * 
		 * Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 
		 * 전체 카펫의 크기는 기억하지 못했습니다.
		 * 
		 * Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 
		 * 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
		 * 
		 * 제한사항 
		 * 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다. 
		 * 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다. 
		 * 
		 * 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
		 * 
		 */
		solution(24,24);
	}
	
    public static int[] solution(int brown, int yellow) {
    	/*
    	 * 내가 문제 푸는 방법
    	 * y가 + 2 => b가
    	 * y세 + 2 => b세
    	 * 
    	 * brown = b가 x b세 - (y가 - y세)
    	 * yellow = y가 x y세
    	 * 
    	 * brown = (yellow의 가로+2) x (yellow의 세로+2) - yellow
    	 * brown = 2(yellow의가로 + yellow의세로) +4
    	 *
    	 * 
    	 * 
    	 * 
    	 */
    	
    	int[] answer = new int[2];	
    	
    	// b세
    	z :
    	for(int i = 3; i <= 2499; i++ ) {
    		
    		// b가 
    		for(int j = 3; j <= (brown+yellow)/i; j++) {
    			System.out.println("세로 : " + j + ", 가로 : " + i);
    			
    			if(j > i ) {
    				break;
    			}
    			
    			if(brown == 2*(i+j)-4) {
    				answer[0] = i;
    				answer[1] = j;
    				break z;
    			}
    			
    		}
    	}
    	

        return answer;
    }
}

class 카펫_다른사람 {
    public int[] solution(int brown, int yellow) {
        int a = (brown+4)/2;
        int b = yellow+2*a-4;
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
        return answer;
        // 근의공식 이용
    }
}

/*
 * 많은 사람들이 대게 나와 비슷하게 풀었다.
 * 가로와 세로를 어떻게 표현할 지, 각 길이의 최소값은 무엇인지 생각하면
 * 쉽게 풀린다. 
 *
 */
