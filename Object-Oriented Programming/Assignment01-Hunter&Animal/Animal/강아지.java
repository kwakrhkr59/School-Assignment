package Animal;
public class 강아지 extends 동물 {
	
	//디폴트생성자
    public 강아지(){
    	this.이름="강아지";
    	this.set사냥확률(80);  //강아지 사냥확률을 80%
    	this.setEXP(20);
    	this.setPower(5);
    }

    public 강아지(String name){    	
    	//공통적인 처리부분은 기본생성자에서 처리하고 호출해서 사용하자.  
    	super(name);
    	this.이름= name;
    	this.set사냥확률(80);
    	this.setEXP(20);
    	this.setPower(5);
    }
    
    public 강아지(String name, int 사냥확률){
    	//변수에 직접 대입하는 방식도 가능하고, 아래처럼 호출하는 것도 가능
    	this(name);
    	this.set사냥확률(사냥확률);
    }
    
    public void 움직이기(){
    	
    }

    public void 놀기(){
    	System.out.println("강아지가 숲속에서 뛰어나니며 놉니다 멍멍멍~");
    	인형물어뜯기();
    	신발물고도망가기();
    
    }
    public void 인형물어뜯기(){
    	System.out.println("인형을 물어뜯어볼까? 멍멍~");
    }

    public void 신발물고도망가기(){
    	System.out.println("신발을 물고 도망을 가볼까? 멍멍~");
    }
    
    //동물원에서
    public void 재주부리기(){
    	System.out.println("멍멍...멍멍....나는 재주를 부리는 강아지 ");
    	System.out.println("열심히 일해서 돈도 벌고 power도 길러서 탈출을 시도해야지!");
    	plusPower(10);
      }

    

}
