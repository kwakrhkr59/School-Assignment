package Animal;
import Main.*;

public abstract class 동물 implements Playable, Workable, Escapeable {
    public String 이름;
    private int 사냥확률;
    
    private int power;
    private int EXP;

    public 동물(){
    	System.out.println("동물을 한마리 생성합니다 : ");
    }

    public 동물(String 이름){
    	
    	this.이름=이름;
    	System.out.println(this.이름 +"이라는 이름을 가진 동물을 한마리 생성합니다.");
    }

    public int get사냥확률(){
        return this.사냥확률;
    }

    public void set사냥확률(int 사냥확률){
    	this.사냥확률 = 사냥확률;
    }   
    
    public int getEXP() {
    	return this.EXP;
    }
    
    public void setEXP(int exp) {
    	this.EXP=exp;
    }
	
    public int getPower() {
    	return this.power;
    }
    
    public void setPower(int power) {
    	this.power=power;
    }
    
	public void plusPower(int power) {
		this.power+=power;
		this.power=Math.min(this.power, 100);
		this.power=Math.max(this.power, 0);
	}

	public abstract void 놀기();

    public void 먹기(){
    	System.out.println("동물들이 산에서 풀을 뜯어먹어요");
    }

    public void 자기(){
    }

    public void 움직이기(){
    }

    public void show(){
    	
    }

}
