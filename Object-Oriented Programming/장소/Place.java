package ���;
import java.util.ArrayList;
import java.util.Calendar;

import Animal.����;
import Main.Main;

public abstract class Place {	
	
	String where;
	protected  ���� []  animals = null;  //�ִ� 10������ ����!
	public int numOfAnimals=0;
	final int SIZE=10;
	
	public int getSize() {
		return this.SIZE;
	}
	
	public ���� [] getAnimals() {
		if (this.animals ==null || numOfAnimals==0) {
			System.out.println("���� ��������� �ʾҽ��ϴ�."); 
			return null;
		}
		return this.animals;
	}	
	public ���� getAnimal() {
		if (this.animals ==null || numOfAnimals==0) {
			System.out.println("���� ��������� �ʾҽ��ϴ�."); 
			return null;
		}
		int r=(int)(Math.random()*1000)% numOfAnimals;
    	return this.animals[r];
		
	}	
	//
	public ���� getAnimal(String name) {
		if (this.animals ==null || numOfAnimals==0) {
			System.out.println("���� ��������� �ʾҽ��ϴ�."); 
			return null;
		}
		for(���� ani:this.animals) {
			if(ani.�̸�.equals(name)) return ani;
		}
		return null;		
	}
	public boolean isHere(String name) {
		if (this.animals ==null) {
			System.out.println("���� ��������� �ʾҽ��ϴ�."); 
			return false;
		}
		for(���� ani:this.animals) {
			if(ani==null) break;
			if(name.equals(ani.�̸�)) {
				System.out.println(name+"�� ã�ҽ��ϴ�!");
				return true;
			}
		}
		System.out.println("�׷� ������ �����ϴ�!");
		return false;
	}
	public void  showAnimals() {
		
		System.out.print("(�� " + numOfAnimals+"����)");
		
		for(int i=0; i<this.animals.length; i++) {
			if(animals[i] != null) 	System.out.print(animals[i].�̸� + " ");
			else System.out.print(" x  ");
		}
		System.out.println();
		System.out.println("==========================================================================");
	
	}
	public static void  showAnimals(���� [] animals,int count) {
		
		System.out.print("(�� " + count +"����)");
		
		for(int i=0; i<animals.length; i++) {
			if(animals[i] != null) 	System.out.print(animals[i].�̸� + " ");
			else System.out.print(" x  ");
		}
		System.out.println();
		System.out.println("==========================================================================");
	
	}
	
	public void addAnimal(���� ani) {
		try{
			animals[numOfAnimals] =ani;
			numOfAnimals++;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("���Ӱ����� ������ ���� ���ֽ��ϴ�!");
		}	
		
	}	
	public  void removeAnimal(���� ani) {
		int i=0;
		for(i=0; i<numOfAnimals; i++) {
			if(animals[i] == ani) {
				animals[i]=null;
				break;
			}
		}			
		animals[i]= animals[numOfAnimals-1];
		animals[numOfAnimals-1]=null;
		numOfAnimals--;
	}

	public void ����Ǯ���ֱ�(���� ani) {
		removeAnimal(ani);
	}
	
	public int getAnimalNums() {
		return numOfAnimals;
	}
	public void setAnimalNums(int n) {
		this.numOfAnimals=n;
	}
}
