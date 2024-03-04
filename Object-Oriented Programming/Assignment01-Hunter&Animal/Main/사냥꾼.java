package Main;
import Animal.������;
import Animal.������;
import Animal.����;
import Animal.��;
import Animal.���;
import ���.*;
import java.util.*;
public class ��ɲ� {
	private int userEXP=0;
	private int userLevel=1;	
	private int count=0;
	private int money=100; //�⺻ 100����
	private ���� weapon;
	private int[] items= {0,0};
	private boolean[] employee= {false, false};
	
	Scanner input=new Scanner(System.in);
	//����[] ��������;
	�������� farm = ��������.getInstance();
	���� forest = ����.getInstance();
	������ zoo = ������.getInstance();

	
	public ��ɲ�() {
		System.out.println("########################################################");
		System.out.println(" �ε� ! ���ӿ� ��ɲ��� ��Ÿ�����ϴ�.! ��������� �����մϴ�.");
		System.out.println("########################################################");
		this.weapon=new ����();
	} 
    
    public void showInfo() {
    	System.out.println("------------------------------------------------");
    	System.out.println("��ɲ��� ����: "+userLevel);
    	System.out.println("��ɲ��� ����ġ: "+userEXP);
    	System.out.println("��ɲ��� ���� ���� ��: "+count);
    	System.out.println("��ɲ��� �������� ũ�� : " + farm.getSize());
    	System.out.println("��ɲ��� money: " + this.money +"����");    	
    	weapon.show();
    	System.out.println("------------------------------------------------");
    	System.out.println("�������忡 �ִ� ���� ��: " + farm.numOfAnimals);
    }
 
	public void  show() {
		System.out.println("==========================================================================");
		System.out.print("##  ��ɲ��� �������� :");	
		farm.showAnimals();
	}
	
    public boolean ����ϱ�(���� ani){    	
    	boolean signal = doRandom(ani);
    	return signal;
    }
    
    public boolean doRandom(���� animal) {
    	int r=(int)(Math.random()*1000)% 100;
    	int prob=animal.get���Ȯ��()+weapon.getWeaponEffect();
    	weapon.plusWeaponCond(-1);
    	
    	if( r < prob ) {
    		System.out.println(animal.�̸� + " ����ϱ� ����!");
    		return true;
    	}
    	else System.out.println(animal.�̸� + " ����ϱ� ����!");    	
    	return false;
    }
    
    //��Һ��� �����ε� ����
    public void ��������ϱ�() throws InterruptedException{
    	
    	//1. �����迭�߿��� �����ϰ� �ƹ��ų� ���� : getAnimal()
    
    	���� ani = forest.getAnimal();
    	if(ani==null) return;
    	boolean sig=false;   
    	System.out.println(ani.�̸�+"�� ����մϴ�.");
    	Thread.sleep(2000);
    	
    	//2. ������ ���� ���Ȯ�� ����ϱ�
    	if (ani instanceof ������) sig=����ϱ�((������)ani);
    	else if (ani instanceof ��) sig=����ϱ�((��)ani);
    	else if (ani instanceof ���) sig=����ϱ�((���)ani);
    	else if (ani instanceof ������) sig=����ϱ�((������)ani);

    	//3. ������ removeAnimal(), �������忡 addAnimal() 
    	if(sig==true) {
    		successHunt(ani);
    	}    
    }
   
    public void ����ҵ�������() throws InterruptedException {
    	forest.show();
    	System.out.print("�� ������ �� ����� ������ �����ϼ���: ");
    	String name=input.nextLine();
    	System.out.println(name+"�� ã�� ���Դϴ�.");
    	Thread.sleep(3000);
    	
    	if(!forest.isHere(name)) {
    		System.out.println("�����ϴ� ������ �����ϼ���.");
    		return;
    	}
    	Thread.sleep(2000);
    	boolean sig=false;  
    	
    	���� ani=forest.getAnimal(name);
    	if (ani instanceof ������) sig=����ϱ�((������)ani);
    	else if (ani instanceof ��) sig=����ϱ�((��)ani);
    	else if (ani instanceof ������) sig=����ϱ�((������)ani);
    	else if (ani instanceof ���) sig=����ϱ�((���)ani);

    	//3. ������ removeAnimal(), �������忡 addAnimal() 
    	if(sig==true) {
    		successHunt(ani);
    	}  
    }
    
    public void successHunt(���� ani) throws InterruptedException {
    	forest.removeAnimal(ani);
		farm.addAnimal(ani);
		int exp=ani.getEXP();
		Thread.sleep(1000);
		System.out.println("[��� ���� ����]");
		System.out.println("����ġ�� "+exp+" ������ϴ�.");
		System.out.println("money�� "+1+"���� ȹ���߽��ϴ�.");
		plusUserEXP(exp);
		money+=1;
		count++;
    }
    
    //user
    public int getUserEXP(){
    	return this.userEXP;
    }

    public void setUserEXP(int exp){
    	this.userEXP=exp;
    }
    
    public void plusUserEXP(int exp) throws InterruptedException {
    	this.userEXP+=exp;
    	if(this.userEXP>=100) {
    		this.plusUserLevel((this.userEXP+exp)/100);
    	}
    }
    
    public int getUserLevel(){
    	return this.userLevel;
    }

    public void setUserLevel(int level){
    	this.userLevel=level;
    }
    
    public void plusUserLevel(int level) throws InterruptedException {
    	System.out.println("-----------------------------------------------------------------------");
    	Thread.sleep(1000);
    	System.out.println("!!���� ��!!");
    	Thread.sleep(1000);
		System.out.println("�����մϴ�! ������ "+level+"�ö����ϴ�.");
		System.out.println("[������ ����]");
		System.out.println("moeny�� 10���� ȹ���߽��ϴ�.");
		Thread.sleep(1000);
    	this.userLevel+=level;
    	this.userEXP%=100;
    	money+=10;
    	showInfo();
    }
    
    //money
    public int getUserMoney() {
    	return money;
    }
    
    public void setUserMoney(int money) {
    	this.money=money;
    }
    
    public void plusUserMoney(int money) {
    	this.money+=money;
    }
    
    public void payMoney(int price) {
    	if(price>this.money) {
    		System.out.println("������ money�� �����մϴ�!");
    		System.out.println("���� ���� money: "+this.money+"����");
    	}
    	else {
    		plusUserMoney(-price);
    	}
    }
    
    //weapon
    public ���� getWeapon() {
    	return weapon;
    }
    public void setWeapon(���� w) {
    	this.weapon=w;
    }
    
    //item
    public int getItem(int n) {
    	return this.items[n-1];
    }
    public void setItem(int n) {
    	this.items[n-1]=n;
    }
    public void plusItem(int n, int cnt) {
    	if(this.items[n-1]+cnt<0) {
    		System.out.println("�������� �����մϴ�");
    		return;
    	}
    	this.items[n-1]+=cnt;
    }
    
    //employee
    public boolean getEmployee(int n) {
    	return this.employee[n-3];
    }
    
    public void setEmployee(int n, boolean b) {
    	if(b) {
	    	if(n==3) farm.setEscapeProb(-10);
	    	else if(n==4) zoo.setEscapeProb(-10);
    	}
    	this.employee[n-3]=b;
    }
}
