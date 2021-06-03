
//thank, dropship, scv < 기계유닛
//기계유닛을 묶어 주기 위해 Repairable 인터페이스 만들기

interface Repairable{
}


//dropship 을 제외한 나머지 유닛들은 Boardable인터페이스를 구현한다.

interface Boardable{
	
	
}

//marin과 medic은 사람이기 때문에 Healable인터페이스를 구현한다.

interface Healable{
	
	
}

//최고 조상 유닛 추상클래스 만들기
abstract class Unit{
	//유닛의 현재체력을 저장할 변수
	int hitpoint;
	//유닛의 최대체력을 한번 초기화해서 저장할 상수
	final int MAX_HP;
	//Unit객체 생성시 유닛의 최대체력을 초기화할 생성자
	public Unit(int hp) {
		MAX_HP = hp;
	}
	//추상메소드
	//각각의 유닛은 무브사운드와 어택사운드를 가지고 있지만, 유닛마다 다른 고유의 소리를 가지고 있기 때문에
	//미완성 메소드인 추상메소드를 작성해 놓자.
	
	public abstract void move_sound();
	//어택 사운드 기능의 추상메소드
	public abstract void attack_sound(); 
	

	//일반메소드
		//모두 같은 ok사운드는 그냥 일반메소드에 구현해준다.
		//(상속 받아서 다 같아져도 상관 없다고 판단)
	public void ok_sound() {
		System.out.println("OK");
		
	}
	
	
	
	
}//unit 추상 클래스 끝

//마린클래스 만들기 (unit추상클래스를 상속받고, 
					// 사람이기 때문에 Healable 인터페이스를 구현 받는다. dropship을 제외한 나머지 유닛이기 때문에 Boardable인터페이스 구현 받는다.

class Marine extends Unit implements Healable,Boardable {
	
	//마린의 최대 체력을 40으로 저장
	
	Marine() {
		super(40);
	}

	//메소드 오버라이딩
	@Override
	public void move_sound() {
		System.out.println("go go go");
		
	}

	@Override
	public void attack_sound() {
		System.out.println("fire");
	}
	
		
}

//메딕 클래스 만들기(unit 추상클래스 상속, 사람유닛이기 때문에 Healabe 인터페이스 구현, dropship유닛을 제외한 나머지 유닛에 해당하므로 Boardable 인터페이스 구현

class medic extends Unit implements Healable,Boardable {
	
	//메딕의 처음 최대체력 40으로 초기화할 생성자
	public medic() {
		super(40);
		
		
	}

	//Unit 추상클래스의 메소드를 메딕에 맞게 오버라이딩
	@Override
	public void move_sound() {
		System.out.println("메딕 간다");
	}

	@Override
	public void attack_sound() {
		System.out.println("메딕공격한다");
	}

	
	//유닛을 치료하는 기능의 일반 메소드
	//Healable 부모 인터페이스를 구현한 자식 객체들(marin, medic)을 매개변수로 받아서 치료
	public void heal(Healable r) {
		
		Unit u = (Unit)r;
		
		while (u.hitpoint != u.MAX_HP) {
			u.hitpoint++; //유닛의 현재 체력을 1씩 증가시켜 치료
			System.out.println("치료중...>" + u.hitpoint);
		}
		System.out.println("치료완료");
		
	}//heal 메소드 끝
}//medic

//SCV 클래스 만들기(unit 추상클래스 상속, 구현, dropship유닛을 제외한 나머지 유닛에 해당하므로 Boardable 인터페이스 구현,
//					기계유닛이므로 Repairable 인터페이스 구현)

class SCV extends Unit implements Boardable,Repairable{
	
	//처음 최대 체력 60으로 초기화할 생성자
	SCV() {
		super(60);
	}

	
	//Unit 추상클래스의 메소드를 SCV에 맞게 오버라이딩
	@Override
	public void move_sound() {
		System.out.println("wing");
	}

	@Override
	public void attack_sound() {
			System.out.println("zizic");
	}
	
	//유닛을 치료하는 기능의 메소드
	public void repair(Repairable r) {
		Unit u = (Unit)r;
		
		while(u.hitpoint != u.MAX_HP) {
			u.hitpoint++;
			System.out.println("수리중...>" + u.hitpoint);
		}
		//현재 체력이 최대체력과 같아 질때..수리완료
		System.out.println("수리완료");
	}//repair
}//SCV


//Tank클래스 만들기(unit 추상클래스 상속,dropship유닛을 제외한 나머지 유닛에 해당하므로 Boardable 인터페이스 구현,
//기계유닛이므로 Repairable 인터페이스 구현

class Tank extends Unit implements Boardable,Repairable {
	
	//tank의 최대 체력 150
	public Tank() {
		super(150);
	}

	@Override
	public void move_sound() {
		System.out.println("yes sir");
	}

	@Override
	public void attack_sound() {
		System.out.println("kwang");
	}
	
	//시저모드 기능의 소리를 나타내는 일반메소드
	
	public void mode_sound() {
		System.out.println("wung");
	}
	
	
}//tank



// Dropship 클래스 만들기 (unit 추상클래스 상속, 
//기계유닛에 속하므로 Repairable 인터페이스 구현,
//Dropship을 제외한 다른 유닛들을 태우기 위해 Boardable 인터페이스 구현)
class Dropship extends Unit implements Repairable,Boardable {
	
	public Dropship() {
		super(100);
	}

	@Override
	public void move_sound() {
		System.out.println("슝~");
	}

	@Override
	public void attack_sound() {
		System.out.println("덜컥");
	}

	public void mode_sound() {
		System.out.println("철커덕");
		
	}
	//유닛을 태우는 기능을 하는 일반 메소드 만들기
	public void tab(Boardable b) {
		System.out.println("태웠다");
		
	}
}//dropship


public class Test113 {

	public static void main(String[] args) {
	
		Marine m = new Marine();
		Tank t = new Tank();
		SCV s = new SCV();
		medic md = new medic();
		Dropship ds = new Dropship();
		
		System.out.println("마린 : 10데미지 손상!");
		
		m.hitpoint = 30; //마린의 현재체력 30
		
		System.out.println("메딕으로 마린을 치료해준다.");
		md.heal(m);
		m.ok_sound();
		m.move_sound();
		
		System.out.println("탱크 피해 10데미지 손상");
		t.hitpoint = 140;
		System.out.println("SCV로 탱크 치료중...");
		s.repair(t);
		t.ok_sound();
		t.move_sound();
		t.mode_sound();
		
		System.out.println("SCV의 현재 체력은 0이다. SCV객체로 치료");
		s.repair(s);
		s.ok_sound();
		s.move_sound();
		
	}

}
