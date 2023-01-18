package 정렬알고리즘;

public class CountingSort {

	/* 카운팅 정렬은 수많은 정렬 알고리즘 중 시간복잡도가 O(n)으로 엄청난 성능을 보여주는 알고리즘이다.
	 * 
	 * 카운팅 정렬의 기본 매커니즘은 아주 단순하다. 
	 * 데이터의 값이 몇 번 나왔는지를 세주는 것이다.
	 * 말 그대로 Counting 하는 것이다.
	 * 
	 * Array1를 한 번 순회하면서 각 index의 값이 나올 때 마다 해당 값을 index로 하는 
	 * Array2의 값을 1 증가 시킨다.
	 * 
	 * Array2의 배열은 각 값의 개수가 담겨있는 배열이 된다.
	 * Array2[0] => 0이라는 데이터의 개수
	 * Array2[0] => 1이라는 데이터의 개수
	 * 
	 * 그 이후, Array2의 각 값을 누적합으로 변환시킨다.
	 * 
	 * Array[1] = Array[1] + Array[0]
	 * Array[2] = Array[2] + Array[1]
	 * ...
	 * 
	 * 이렇게 되면 기존의 데이터를 가지고 있는 Array와
	 * 각 데이터들을 선별하여 누적합을 만든 Array2가 있다.
	 * 
	 * 이 배열을 가지고 최종 정렬 배열을 만들 것이다.
	 * 
	 * Array의 배열의 마지막 인덱스부터 시작하며, 인덱스의 해당 원소의 값이
	 * Array2의 배열의 인덱스를 가리킨다. 
	 * (Array의 9번 인덱스의 값이 3이면 Array2의 3번 인덱스를 찾아간다.)
	 * 
	 * 이후, 지목된 Array2의 인덱스의 원소 값을 1만큼 감소 시키고,
	 * 그 값이 새로운 Array3의 인덱스를 가리키고, 그 인덱스의 값은 이 과정이 시작된
	 * Array의 값이 된다.
	 * 
	 * 이렇게 하면 총 3개의 배열이 필요하다.
	 * 1. 최초 데이터가 저장된 배열.
	 * 2. 각 데이터를 카운팅하는 배열. => 이후 누적 합을 만들어줌.
	 * 3. 1,2 배열을 활용하며 정렬된 값을 만들어주는 배열.
	 * 
	 * 이 과정 자체가 두 수를 비교하는 과정이 없기 때문에 빠른 배치가 가능하다.
	 * 하지만, 전체 과정을 보다보면 단점이 눈에 들어온다.
	 * 
	 * 배열이 3개가 필요하다는 점.
	 * Array의 Max 값의 수가 커지면 Counting 배열의 크기가 그 만큼 커진다는 점.
	 * 
	 * Array의 원소는 10개도 안되는데 max값이 1000만이 넘어버리면, Array2의 크기가 1000만이 넘어가게된다.
	 * 또한 그만큼 연산도 진행하게 된다.
	 * 
	 * 시간복잡도가 다른 정렬에 비해 성능이 좋지만, 잘 안쓰이게되는 이유다.
	 * 
	 * 적절한 상황에 따라 쓰면 매우 효율적일 것이다.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		int[] array = new int[20]; // 주어진 데이터 : 20개
		int[] counting = new int[11]; // 데이터의 범위 : 0 ~ 10개
		int[] result = new int[20]; // 정렬된 배열

		for(int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*11);
		}
		
		for(int i = 0; i < array.length; i++) {
			// array의 value 값과 같은 counting의 index의 값을 1 증가 
			counting[array[i]]++;
		}
		
		for(int i = 1; i < counting.length; i++) {
			// 누적 합 해주기
			counting[i] += counting[i-1];
		}
		
		for(int i = array.length-1; i >= 0; i-- ) {
			int value = array[i];
			counting[value]--;
			result[counting[value]] = value;
		}
		
		System.out.println("array[], 정렬 전");
		for(int i : array) {
			System.out.print( i + "\s" );
		}
		
		System.out.println("\r \r"+ "result[], 정렬 후");
		for(int i : result) {
			System.out.print( i + "\s" );
		}
		

	}
	

}
