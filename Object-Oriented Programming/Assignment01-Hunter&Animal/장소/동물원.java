package ���;


import Main.*;
import Animal.*;


public class ������ extends Place implements  Workable, Escapeable{
	private static ������ instance = null;	
	private int escapeProb=0;
	
	private ������() { 	//�⺻ 10����
		this.where = "������";
		animals = new ����[SIZE];
	}
	public static ������ getInstance() {
		
		if(instance==null) instance = new ������();
		return instance;
	}
	
	public void show() {
		System.out.println("==========================================================================");
		System.out.print("## �������� �ִ� ������ :");
		
		showAnimals(animals , numOfAnimals);
		
	}

	//������ �������� ���ֺθ���� �� ����Ŭ�������� ������ �����ϼ���
	public void work() {
		System.out.println("�������� ���������� ���� �մϴ�.");
		System.out.println("���ָ� �η��� ���� ���� ���� Ż���� �� �־��.");		
		Workable [] w = getAnimals();  // Workable �� ������� �����ϵ��� ����
	
		for(int i=0; i<numOfAnimals; i++) {			
			w[i].���ֺθ���();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	
	//���������� ��ǹ߻�!
	public void escape() {	
		���� forest = ����.getInstance();
		Escapeable [] e = getAnimals();
		if(e==null) return;
		
		int attempt=(int)(Math.random()*100)%numOfAnimals;
		System.out.println("��ɲ��� ���� ���� "+attempt+"���� Ż�� �õ��� �־����ϴ�.");
		for(int i=0; i<attempt; i++) {
			int rand=(int)(Math.random()*100) % this.numOfAnimals;  
			���� ani=(����)e[rand];
	    	int r=(int)(Math.random()*1000)%100;
		
	    	if(r<ani.getPower()+escapeProb) {
	    		System.out.println(ani.�̸� + "�� ���������� Ż���߽��ϴ�!!");
	    		forest.addAnimal(ani);
	    		e[rand].escape();
	    		this.removeAnimal(ani);
	    	} 
	    	else System.out.println(ani.�̸� +"�� Ż�⿡ �����߽��ϴ�.�� ");
		}
	}
	
	public int getEscapeProb() {
		return escapeProb;
	}
	public void setEscapeProb(int prob) {
		this.escapeProb=prob;
	}
}








