package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class H_index {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 
		 * 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고합니다. 
		 * 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
		 * 
		 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고
		 * 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
		 * 
		 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 
		 * 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
		 * 
		 * 제한사항 
		 * 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다. 
		 * 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
		 * 
		 * 
		 */
		
		solution(new int[]{3,0,6,1,5});

	}

	public static int solution(int[] citations) {
		
		/*
		 * 내가 문제 푸는 방법
		 * 
		 * 
		 * 1. "특정 값" 이라는 기준을 선정하여, citations의 요소들과 비교한다.
		 * => 특정 요소를 기준으로 큰 값이 특정 요소의 개수보다 많아야하고,
		 * => 특정 요소를 기준으로 나머지 요소의 값들이 특정요소보다 작아야한다.
		 * 
		 * 2. 그렇다면 특정요소는 무엇으로 잡아야 하나?
		 * => 반복문의 증감연산자를 통하여 citations에 접근한다. 순차적으로 특정요소를 선정하는 것이다.
		 * => 이후 if문을 통하여 특정 요소를 기준으로 큰 값들의 개수가, 특정 요소의 값보다 많은지 확인,
		 * => if문을 통하여 이외 나머지 요소들이 특정 요소의 값보다 작은지 확인.
		 * => 모두 만족하면 h의 값을 저장하는 변수에 저장.
		 * => 반복문을 통해 반복, 가장 큰 h 값을 찾는다.
		 * 
		 * => 하지만? 미리 내림차 순으로 정렬을 한다면?, 딱 한 번 true가 발생하면 끝이지 않는가?
		 * 
		 */
		
		// 정렬을 빠르게 하기 위해 LinkedList 객체 사용
		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		for(int i : citations) {
			ll.add(i);
		}
		
		// 내림차순으로 정렬
		Collections.sort(ll, new Desc());
		System.out.println(ll);
		
		// 접근 시간을 빠르게 하기 위해 ArrayList 객체 사용
		ArrayList<Integer> arr = new ArrayList<Integer>(ll);
		
		int answer = 0;
		int large = 0; // 특정 요소보다 큰 값을 가지는 요소의 개수
		for(int i = 1; i <= 10000; i++) {
			
			for(int j = 0; j < arr.size(); j++) {
				// 특정 요소의 값 이상이면 large 카운트, 그렇지 않으면 내부 반복문 종료
				// => 종료 후 외부 반복문 계속 진행, 나머지들의 개수가 특정 요소의 값보다 많은지 확인.
				if(i <= arr.get(j)) {
					large ++;
					System.out.println("기준 값 i : " + i + ", 현재 비교 대상 : " + arr.get(j) + ",large : " + large  );
				} else {
					break;
				}
			}
			
			if(i <= large) {
				answer = i;
				break;
			} else {
				large = 0;
			}
			
			
		}
		
		System.out.println(answer);
		
		return answer;
	}
}

class Desc implements Comparator<Integer>{
	
	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			
			return c1.compareTo(c2) * -1;
		
		}
		return -1;
	}
	
}


class H_index_다른사람 {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}

/*
 * 
 * 정렬을 위해 LinkedList를 사용했는데 작업 시간이 다른사람들의 소스코드보다 훨씬 커졌다.
 * 인덱스가 많아서 그런가 싶어서 검색을 해보았는데,
 * 
 * 첫 번째로 인덱스가 많아질 수록 중간 인덱스에 대한 수정, 삭제에 대한 작업시간이 ArrayList와 비교했을때
 * 접근 속도가 느려, 전체적인 작업시간이 느려질 수 있다는 정보를 얻었으며,
 * 
 * 두 번째로, 앞뒤를 비교하는 것에는 LinkedList를 사용하는 것이 더 효율적이라는 입장도 있었다.
 * 
 * 나는 정렬할 때만 LinkedList를 사용하였다.
 * 인덱스 관련해서는 LinkedList가 관여하지 않았다.
 * 
 * 결론은 내림차순으로 정렬을 하고 i=10000부터 0까지 시행한 것에 대해
 * 작업시간이 길어진 것으로 판단된다.
 * 
 * 
 * 
 * 
 * 
 */


