/*
  6. 비트 연산자란?
  - 비트 연산자는 논리 연산자와 비슷하지만, 비트(bit)단위로 논리 연산을 할때 사용하는 연산자입니다.
  	또한 비트단위로 왼쪽이나 오른쪽으로 전체 비트를 이동하거나, 1의 보수를 만들 때도 사용합니다.
  
  	
  	- 비트 연산자 종류
  		
  		&			대응되는 비트가 모두 1이면 1을 반환한다. 다른 경우는 모두 0을 반환(비트 AND연산)
  		|			대응되는 비트 중에서 하나라도 1이 존재하면 1을 반환한다. 두 비트가 0일때는 0반환 (비트 OR연산)
  		^			대응되는 비트가 서로 다르면 1을 반환함, 서로 같으면 0을 반환한다. (비트 XOR연산)
  		-			비트가 1이면 0으로, 0이면 1로 반전시킴 (비트 NOT연산, 1의 보수)
  		<<			명시된 수만큼 비트들을 전부 왼쪽으로 이동 시킴 (left shift 연산)
  		>>			부호를 유지하면서 지정한 수만큼 비트를 전부 오른쪽으로 이동 시킴 (right shift 연산)
  		>>>			지정한 수 만큼 비트들 전부 오른쪽으로 이동 시키며, 새로운 비트는 전부 0이 된다. 
  
 */



public class Test12 {

	public static void main(String[] args) {
		int num1 = 8;
		int num2 = -8;
		
		System.out.println(" <<연산자에 의한 결과 : " + (num1 << 2));
		System.out.println(" >>연산자에 의한 결과  : " + (num2 >> 2));
		System.out.println(" >>>연산자에 의한 결과 : " + (num1 >>> 2));

	}

}
