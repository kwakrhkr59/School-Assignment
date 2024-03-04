package 장소;


import Main.*;
import Animal.*;


public class 동물원 extends Place implements  Workable, Escapeable{
	private static 동물원 instance = null;	
	private int escapeProb=0;
	
	private 동물원() { 	//기본 10마리
		this.where = "동물원";
		animals = new 동물[SIZE];
	}
	public static 동물원 getInstance() {
		
		if(instance==null) instance = new 동물원();
		return instance;
	}
	
	public void show() {
		System.out.println("==========================================================================");
		System.out.print("## 동물원에 있는 동물들 :");
		
		showAnimals(animals , numOfAnimals);
		
	}

	//동물원 동물들의 재주부리기는 각 동물클래스에서 적절히 구현하세요
	public void work() {
		System.out.println("동물들이 동물원에서 일을 합니다.");
		System.out.println("재주를 부려서 돈을 많이 벌면 탈출할 수 있어요.");		
		Workable [] w = getAnimals();  // Workable 한 기능으로 접근하도록 설정
	
		for(int i=0; i<numOfAnimals; i++) {			
			w[i].재주부리기();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	
	//동물원에서 사건발생!
	public void escape() {	
		숲속 forest = 숲속.getInstance();
		Escapeable [] e = getAnimals();
		if(e==null) return;
		
		int attempt=(int)(Math.random()*100)%numOfAnimals;
		System.out.println("사냥꾼이 없는 동안 "+attempt+"번의 탈출 시도가 있었습니다.");
		for(int i=0; i<attempt; i++) {
			int rand=(int)(Math.random()*100) % this.numOfAnimals;  
			동물 ani=(동물)e[rand];
	    	int r=(int)(Math.random()*1000)%100;
		
	    	if(r<ani.getPower()+escapeProb) {
	    		System.out.println(ani.이름 + "이 동물원에서 탈출했습니다!!");
	    		forest.addAnimal(ani);
	    		e[rand].escape();
	    		this.removeAnimal(ani);
	    	} 
	    	else System.out.println(ani.이름 +"이 탈출에 실패했습니다.ㅜ ");
		}
	}
	
	public int getEscapeProb() {
		return escapeProb;
	}
	public void setEscapeProb(int prob) {
		this.escapeProb=prob;
	}
}








