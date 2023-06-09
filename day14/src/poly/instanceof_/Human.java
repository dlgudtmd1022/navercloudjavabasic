package poly.instanceof_;

public class Human {

	private String name;
	private int age;
	
	// 생성자를 만들어주세요
	
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 만약 void 파라미터로 생성자 호출 시 
	// "nonmae", 0을 이름과 나이로 초기화 하는 생성자도 만들어주세요.
	
	public Human() {
		this("no name", 0); // 아래 두줄을 한줄로 표현 가능(기능은 동일) 
//		this.name = "no name";
//		this.age = 0;
	}
	
	// showInfo()을 만들어주세요. 이름과 나이를 콘솔에 찍어줍니다.

	public void showInfo() {
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);
		System.out.println("--------------------");
	}
	
	
}
