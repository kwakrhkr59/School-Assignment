package ���;


import Animal.������;
import Animal.������;
import Animal.����;
import Animal.��;
import Animal.���;
import Main.Playable;

public class ���� extends Place implements Playable  {
	private  static ���� instance = null;	
	
	private ����() { 	//�⺻ 10����		
		this.where = "����";
		animals = new ����[10];
	}	
	
	public static ���� getInstance() {
		
		if(instance==null) instance = new ����();
		return instance;
	}	

	
	public void show() {
		System.out.println("==========================================================================");
		System.out.print("##  �� �ӿ� �ִ� ������ :");
		
		showAnimals(animals, numOfAnimals);		
	}	
	
	public  void ���() {
		Playable [] p = getAnimals();  //Playable�� �����ϵ��� ����
		if(p==null) return;
		System.out.println("�������� �� �ӿ��� �����Ӱ� �پ��ϴ�.");		
		System.out.println("��ɵ� �մϴ�.");		
		
		for(int i=0; i< numOfAnimals; i++) {
			System.out.printf("[%2d] :",i);
			p[i].���();	   //p[i].�� �����ϸ� ���() �� ���δ�.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}	
}
