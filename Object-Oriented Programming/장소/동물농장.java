package ���;


import Main.*;
import Animal.*;
import java.util.*;


public class �������� extends Place implements Escapeable{
	private static �������� instance = null;
	private int escapeProb=0;
	private ������ zoo=������.getInstance();
	
	private ��������() { 	//�⺻ 10����
		this.where = "��������";
		animals = new ����[10];
	}
	private ��������(int size) { 	//�⺻ 10����
		this.where = "��������";
		animals = new ����[size];
	}
	public static �������� getInstance() {
		if(instance==null) instance = new ��������();
		return instance;
	}
	public static �������� getInstance(int size) {
		if(instance==null) instance = new ��������(size);	
		return instance;
	}
	public void show() {
		System.out.println("==========================================================================");
		System.out.print("## �������忡 �ִ� ������ :");
		showAnimals(animals , numOfAnimals);
	}
	
	public boolean ����������(���� ani) {
		if(zoo.numOfAnimals==zoo.getSize()) {
			System.out.println("�������� �� �� ������ ���� �� �����ϴ�!");
			return false;
		}
		zoo.addAnimal(ani);		
		this.removeAnimal(ani);
		return true;
	}
	
	//���������� ��ǹ߻�!
	public void escape() {
		���� forest = ����.getInstance();
		Escapeable [] e = getAnimals();
		if(e==null) return;
		
		int attempt=(int)(Math.random()*100)%numOfAnimals;//�����ϰ� ó���ϰų�, �������� ���س��ų�~
		System.out.println("��ɲ��� ���� ���� "+attempt+"���� Ż�� �õ��� �־����ϴ�.");
		for(int i=0; i<attempt; i++) {
			int rand=(int)(Math.random()*100) % this.numOfAnimals;  
			���� ani=(����)e[rand];
	    	int r=(int)(Math.random()*1000)%100;
		
	    	if(r<ani.getPower()+escapeProb) {
	    		System.out.println(ani.�̸� + "�� �������忡�� Ż���߽��ϴ�!!");
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








