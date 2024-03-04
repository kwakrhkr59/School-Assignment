package Animal;
public class 상어 extends 동물 {

	public 상어() {
		this.이름 = "샤크";
		this.set사냥확률(5);
		this.setEXP(150);
		this.setPower(10);
	}

	public 상어(String name) {
		// 공통적인 처리부분은 기본생성자에서 처리하고 호출해서 사용하자.
		super(name);
    	this.이름= name;
    	this.set사냥확률(5);
    	this.setEXP(150);
    	this.setPower(10);
	}

	public 상어(String name, int 사냥확률) {
		// 변수에 직접 대입하는 방식도 가능하고, 아래처럼 호출하는 것도 가능
		this(name);
		this.set사냥확률(사냥확률);
	}
    public void 헤엄치기(){
    	System.out.println(this.이름+"(이)가 헤엄을 칩니다. 첨벙첨벙");
    	this.plusPower(5);
    }

    public void 움직이기(){
    	System.out.println(this.이름+"(이)가 느릿느릿 움직입니다.");
    	this.plusPower(1);
    }

    public void 놀기(){
    	System.out.println("여기는 숲속이잖아! 나를 어서 바다로 보내줘!!!~ 상어상어");
    }
    
    public void 재주부리기() {
    	헤엄치기();
    }

}
