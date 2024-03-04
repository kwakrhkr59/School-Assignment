package Animal;
public class 뱀 extends 동물 {
    public 뱀(){
    	this.이름="슈슈뱀";
    	this.set사냥확률(20);  //뱀 사냥확률을 30%
    	this.setEXP(80);
    	this.setPower(15);
    }

    public 뱀(String name){    	
    	//공통적인 처리부분은 기본생성자에서 처리하고 호출해서 사용하자.
    	super(name);
    	this.이름= name;
    	this.set사냥확률(20);
    	this.setEXP(80);
    	this.setPower(15);
    }
    
    public 뱀(String name, int 사냥확률){
    	//변수에 직접 대입하는 방식도 가능하고, 아래처럼 호출하는 것도 가능
    	this(name);
    	this.set사냥확률(사냥확률);
    }
    public void 기어다니기(){
    	System.out.println(this.이름+"(이)가 슈~슈~ 이리저리 기어다닙니다.");
    	this.plusPower(3);
    }

    public void 똬리틀기(){
    	System.out.println("꽈리꽈리 꽈리를 틀어보자 슈슈~");
    	this.plusPower(-2);
    }

    public void 놀기(){
    	System.out.println("슈슈 ~ 슈슈~");
    	똬리틀기();
    }
    
    public void 재주부리기() {
    	기어다니기();
    	똬리틀기();
    }
}
