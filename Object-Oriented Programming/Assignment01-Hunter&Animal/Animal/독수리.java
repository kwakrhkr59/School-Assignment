package Animal;
public class 독수리 extends 동물 {
    public int 날개;

    public 독수리(){
    	this.이름="독수리";
    	this.set사냥확률(30);  //독수리 사냥확률을 30%
    	this.setEXP(50);
    	this.setPower(7);
    }

    public 독수리(String name){    	
    	//공통적인 처리부분은 기본생성자에서 처리하고 호출해서 사용하자.
    	super(name);
    	this.이름= name;
    	this.set사냥확률(30);
    	this.setEXP(50);
    	this.setPower(7);
    }
    
    public 독수리(String name, int 사냥확률){
    	//변수에 직접 대입하는 방식도 가능하고, 아래처럼 호출하는 것도 가능
    	this(name);
    	this.set사냥확률(사냥확률);
    }
    
    public void 움직이기(){
    	System.out.println(this.이름+"(이)가 느릿느릿 걸어갑니다.");
    }

    public void 날기(){
    	System.out.println(this.이름+"(이)가 넓은 날개로 훨훨 날아다닙니다.");
    }

    public void 놀기(){
    	System.out.println("여기저리 날아다니면서 놀고 싶은 독수리가 오늘은 바빠서 놀 시간이 없음 수리수리~");
    }
    
    public void 재주부리기() {
    	날기();
    }
}
