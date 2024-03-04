package 장소;


import Main.*;
import Animal.*;
import java.util.*;


public class 동물농장 extends Place implements Escapeable{
	private static 동물농장 instance = null;
	private int escapeProb=0;
	private 동물원 zoo=동물원.getInstance();
	
	private 동물농장() { 	//기본 10마리
		this.where = "동물농장";
		animals = new 동물[10];
	}
	private 동물농장(int size) { 	//기본 10마리
		this.where = "동물농장";
		animals = new 동물[size];
	}
	public static 동물농장 getInstance() {
		if(instance==null) instance = new 동물농장();
		return instance;
	}
	public static 동물농장 getInstance(int size) {
		if(instance==null) instance = new 동물농장(size);	
		return instance;
	}
	public void show() {
		System.out.println("==========================================================================");
		System.out.print("## 동물농장에 있는 동물들 :");
		showAnimals(animals , numOfAnimals);
	}
	
	public boolean 동물보내기(동물 ani) {
		if(zoo.numOfAnimals==zoo.getSize()) {
			System.out.println("동물원이 꽉 차 동물을 보낼 수 없습니다!");
			return false;
		}
		zoo.addAnimal(ani);		
		this.removeAnimal(ani);
		return true;
	}
	
	//동물원에서 사건발생!
	public void escape() {
		숲속 forest = 숲속.getInstance();
		Escapeable [] e = getAnimals();
		if(e==null) return;
		
		int attempt=(int)(Math.random()*100)%numOfAnimals;//랜덤하게 처리하거나, 마리수를 정해놓거나~
		System.out.println("사냥꾼이 없는 동안 "+attempt+"번의 탈출 시도가 있었습니다.");
		for(int i=0; i<attempt; i++) {
			int rand=(int)(Math.random()*100) % this.numOfAnimals;  
			동물 ani=(동물)e[rand];
	    	int r=(int)(Math.random()*1000)%100;
		
	    	if(r<ani.getPower()+escapeProb) {
	    		System.out.println(ani.이름 + "이 동물농장에서 탈출했습니다!!");
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








