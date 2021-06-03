
//thank, dropship, scv < 기계유닛
//기계유닛을 묶어 주기 위해 Repairable 인터페이스 만들기

interface Repairable{
}
//내 필기 : 인터페이스가 조건의 역할을 하고 있음, ( s.repair(m); m은 전달 받을 수 없다. , Repairable 인터페이스를 부모로 하여 구현받지 않았기 때문에, )를 보면, 인터페이스를 통해
//접근을 제한 할 수 있다. 모두 다같이 unit을 상속 받았지만 인터페이스로 인해 제한 받았다.



class Unit{
	//유닛의 현재체력을 저장할 변수
	int hitpoint;
	//유닛의 최대체력을 한번 초기화해서 저장할 상수
	final int MAX_HP;
	//Unit객체 생성시 유닛의 최대체력을 초기화할 생성자
	public Unit(int hp) {
		MAX_HP = hp;
	}
	
}

//GroundUnit 클래스 만들기 Unit 클래스 상속받기
class GroundUnit extends Unit {
	
	//지상유닛의 최대체력을 초기화
	public GroundUnit(int hp) {
		super(hp);
	}
}


//탱크 지상유닛 Tank클래스 만들기 < 지상유닛이기 때문에 GroundUnit 클래스를 상속 받고, 기계화 유닛이기 때문에 Repairable 인터페이스를 구현 받는다.

class Tank extends GroundUnit implements Repairable{
	
	public Tank() {
		//Tank의 최대 체력 150
		super(150);
		//최대 체력과 현재체력을 똑같이 만들어 주기
		hitpoint = MAX_HP;
	}
	
	//Tank 문자열 반환할 메소드 
	public String toString() {
		return "Tank";
	}
	
}


//SCV 지상유닛 클래스 만들기 <   지상유닛이기 때문에 GroundUnit 클래스를 상속 받고, 기계화 유닛이기 때문에 Repairable 인터페이스를 구현 받는다.
class SCV extends GroundUnit implements Repairable{
	
	SCV() {
		//SCV의 최대 체력 60초기화
		super(60);
		//현재체력을 최대체력과 같게 만든다.
		hitpoint = MAX_HP;
	}
	
	//유닛(Tank,dropship, scv)을 치료하는 기능의 메소드
	void repair(Repairable r) {//Repairable r의 값에 Tank,dropship, scv중 하나의 값이 들어가므로 unit으로 업캐스팅이 가능해진다.
		Unit u= (Unit)r; // 실제 위 3개의 객체중 하나 
		//아래 메소드를 작성하기 위해 업캐스팅을 해줬음
		 
		//매개변수 r로 전달받아 u변수에 저장된 tank또는 dropship또는 scv객체의 현재체력이
		//최대 체력과 같지 않을 동안만(피가 줄어들어 있으면) 반복해서 치료하자.
		while (u.hitpoint != u.MAX_HP) {
			//hp증가(치료하자)
			u.hitpoint++;
		}
		System.out.println(u.toString() + "의 수리가 끝났습니다.");
		
	}
	
}

//지상유닛인 마린클래스 만들기 < 지상유닛이기 때문에  GroundUnit 클래스 상속받기

class Marine extends GroundUnit{
	//생성자
	public Marine() {
		super(40);
		hitpoint = MAX_HP;
	}
	
}

//공중유닛들을 묶어서 표현하기 위한 AirUnit 클래스 만들기 < Unit 클래스 상속받기

class AirUnit extends Unit{
	//생성자 :  공중유닛의 최대체력 초기화
	public AirUnit(int hp) {
		super(hp);
	}
}



//공중유닛중에서 dropShip 클래스 만들기 < 공유닛이므로  AirUnit 클래스 상속받기
								//	< 기계유닛이므로 Repairable 인터페이스 구현받기

class dropship extends AirUnit implements Repairable {
	
	//드랍쉡 유닛의 현재 체력 125저장
	dropship() {
		super(125);
		hitpoint = MAX_HP;
	}

	
	public String toString() {
		return "dropship";
	}
	
	
	
}

public class Test112 {

	public static void main(String[] args) {
	
		Tank t = new Tank();
		dropship d = new dropship();

		Marine m = new Marine();
		SCV s = new SCV();
		
		s.repair(t); //scv가 tank 객체를 수리하도록 한다. 
		s.repair(d); //scv가 dropship 객체를 수리하도록 한다. 
		
		//s.repair(m); m은 전달 받을 수 없다. , Repairable 인터페이스를 부모로 하여 구현받지 않았기 때문에, repair메소드 호출시
		//marine 객체를 전달하여 사용할 수 없다.
		

	}

}
