

/*
  this 와 this()
  this참조변수
  -this참조변수는 인스턴스(객체)가 바로 자기 자신의 멤버(변수,메소드..)를 참조하는데 사용하는 변수입니다.
   이러한 this참조변수는 해당 인스턴스(객체)의 주소를 가지고 있습니다. 
   
   
  
 
 */


/*
class Car{
	//변수
	//private 은닉변수 : 다른 클래스에서 변수를 볼 수 없게 한다.
	private String modelName; //변수를 선언할때 변수명 앞에 private단어를 붙이면 Car외부의 클래스에서 Car클래스 내부의 modelName변수에 접근x
	//car.modelName; 은닉변수이기 때문에 호출이 되지 않는다.
	private int modelYear;
	private String color;
	private int maxSpeed;
	private int currentSpeed;
	
	
	//생성자-역할 : new Car()객체 생성시..Car()생성자를 호출해 변수의 값들을 저장할 역할
	Car(String modelName, int modelYear, String color, int max){
		this.modelName= modelName;
		this.modelYear = modelYear;
		this.color = color;
		this.maxSpeed = max;
		//매개변수 max이름과 위의 객체변수 maxSpeed이름이 다를때는 
		//this는 생략가능하다
		this.currentSpeed = 0;
		
	}
	//위 예제처럼 생성자의 매개변수 이름과 인스턴스 변수이름이 같을 경우에는 인스턴스명 앞에 this참조변수를 붙여 구분해야만 한다.
	
	//이렇게 자바에서는 this참조변수를 사용하여 인스턴스 변수에 접근할 수 있다.
	//이러한 this변수를 사용할 수 있는 영역은 인스턴스 메소드 뿐이며, 클래스 메소드에서는 사용할 수 없다.
	//모든 인스턴스 메소드에는 this 참조변수가 숨겨진 지역변수로 존재하고 있다.
	
	
	*/
	
	/*
		this() 메소드
		-this()메소드는 생성자 내부에서만 호출해서 사용할 수 있으며, 같은 클래스의 내부에 존재하는 다른 생성자를 호출할 때 사용한다.
		-this()메소드에 인수를 전달하면, 생성자 중에서 생성자의 이름과 생성자의 매개변수개수가 일치하는 다른 생성자를 찾아서 호출해준다.
	
	
	*/
	class Car1{
		//변수
		//private 은닉변수 : 다른 클래스에서 변수를 볼 수 없게 한다.
		private String modelName; //변수를 선언할때 변수명 앞에 private단어를 붙이면 Car외부의 클래스에서 Car클래스 내부의 modelName변수에 접근x
		//car.modelName; 은닉변수이기 때문에 호출이 되지 않는다.
		private int modelYear;
		private String color;
		private int maxSpeed;
		private int currentSpeed;
		
		
		Car1(){ //두번째 생성자
			//다른 생성자를 호출하는 this()메소드 작성
			this("소나타", 2012, "검정", 160);
		}
		
		//첫번째 생성자
		//생성자-역할 : new Car()객체 생성시..Car()생성자를 호출해 변수의 값들을 저장할 역할
		Car1(String modelName, int modelYear, String color, int max){
			this.modelName= modelName;
			this.modelYear = modelYear;
			this.color = color;
			this.maxSpeed = max;
			//매개변수 max이름과 위의 객체변수 maxSpeed이름이 다를때는 
			//this는 생략가능하다
			this.currentSpeed = 0;
			
		}
	
		//자동차(new Car1()객체)에 대한 정보를 하나의 문자열로 만들어 반환
		public String getModel() {
			
			return this.modelYear + "년식" + this.modelName + " " + this.color;
			
		}
		
		
		
		
		
		}// car class
	
public class Test65 {

	public static void main(String[] args) {
		
		//new Car("투싼하이브리드", 2021, "팬텀블랙", 600);
		String car1Info	= new Car1().getModel();
		System.out.println(car1Info);
		
		/*
		 위 예제에서 매개변수를 가지는 첫번째 생성자는 this참조변수를 사용하여 인스턴스변수(객체변수)에 접근하고 있다.
		 또한, 매개변수를 가지지 않는 두번째 생성자는 내부에서  this()메소드를 이용하여 첫번째 생성자를 호출합니다.
		 이렇게 내부적으로 다른 생성자를 호출하여 인스턴스 변수를 초기화할 수 있다.
		 단, 한 생성자는 다른 생성자를 호출할 때에는 해당 생성자의 첫줄에서만 호출할 수 있다.
		 */
			
	}

}
