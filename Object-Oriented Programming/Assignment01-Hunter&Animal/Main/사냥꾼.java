package Main;
import Animal.강아지;
import Animal.독수리;
import Animal.동물;
import Animal.뱀;
import Animal.상어;
import 장소.*;
import java.util.*;
public class 사냥꾼 {
	private int userEXP=0;
	private int userLevel=1;	
	private int count=0;
	private int money=100; //기본 100만원
	private 무기 weapon;
	private int[] items= {0,0};
	private boolean[] employee= {false, false};
	
	Scanner input=new Scanner(System.in);
	//동물[] 동물농장;
	동물농장 farm = 동물농장.getInstance();
	숲속 forest = 숲속.getInstance();
	동물원 zoo = 동물원.getInstance();

	
	public 사냥꾼() {
		System.out.println("########################################################");
		System.out.println(" 두둥 ! 숲속에 사냥꾼이 나타났습니다.! 이제사냥을 시작합니다.");
		System.out.println("########################################################");
		this.weapon=new 무기();
	} 
    
    public void showInfo() {
    	System.out.println("------------------------------------------------");
    	System.out.println("사냥꾼의 레벨: "+userLevel);
    	System.out.println("사냥꾼의 경험치: "+userEXP);
    	System.out.println("사냥꾼이 잡은 동물 수: "+count);
    	System.out.println("사냥꾼의 동물농장 크기 : " + farm.getSize());
    	System.out.println("사냥꾼의 money: " + this.money +"만원");    	
    	weapon.show();
    	System.out.println("------------------------------------------------");
    	System.out.println("동물농장에 있는 동물 수: " + farm.numOfAnimals);
    }
 
	public void  show() {
		System.out.println("==========================================================================");
		System.out.print("##  사냥꾼의 동물농장 :");	
		farm.showAnimals();
	}
	
    public boolean 사냥하기(동물 ani){    	
    	boolean signal = doRandom(ani);
    	return signal;
    }
    
    public boolean doRandom(동물 animal) {
    	int r=(int)(Math.random()*1000)% 100;
    	int prob=animal.get사냥확률()+weapon.getWeaponEffect();
    	weapon.plusWeaponCond(-1);
    	
    	if( r < prob ) {
    		System.out.println(animal.이름 + " 사냥하기 성공!");
    		return true;
    	}
    	else System.out.println(animal.이름 + " 사냥하기 실패!");    	
    	return false;
    }
    
    //장소별로 오버로딩 가능
    public void 랜덤사냥하기() throws InterruptedException{
    	
    	//1. 동물배열중에서 랜덤하게 아무거나 고르기 : getAnimal()
    
    	동물 ani = forest.getAnimal();
    	if(ani==null) return;
    	boolean sig=false;   
    	System.out.println(ani.이름+"을 사냥합니다.");
    	Thread.sleep(2000);
    	
    	//2. 동물에 따라 사냥확률 계산하기
    	if (ani instanceof 강아지) sig=사냥하기((강아지)ani);
    	else if (ani instanceof 뱀) sig=사냥하기((뱀)ani);
    	else if (ani instanceof 상어) sig=사냥하기((상어)ani);
    	else if (ani instanceof 독수리) sig=사냥하기((독수리)ani);

    	//3. 숲에서 removeAnimal(), 동물농장에 addAnimal() 
    	if(sig==true) {
    		successHunt(ani);
    	}    
    }
   
    public void 사냥할동물고르기() throws InterruptedException {
    	forest.show();
    	System.out.print("위 동물들 중 사냥할 동물을 선택하세요: ");
    	String name=input.nextLine();
    	System.out.println(name+"을 찾는 중입니다.");
    	Thread.sleep(3000);
    	
    	if(!forest.isHere(name)) {
    		System.out.println("존재하는 동물을 선택하세요.");
    		return;
    	}
    	Thread.sleep(2000);
    	boolean sig=false;  
    	
    	동물 ani=forest.getAnimal(name);
    	if (ani instanceof 강아지) sig=사냥하기((강아지)ani);
    	else if (ani instanceof 뱀) sig=사냥하기((뱀)ani);
    	else if (ani instanceof 독수리) sig=사냥하기((독수리)ani);
    	else if (ani instanceof 상어) sig=사냥하기((상어)ani);

    	//3. 숲에서 removeAnimal(), 동물농장에 addAnimal() 
    	if(sig==true) {
    		successHunt(ani);
    	}  
    }
    
    public void successHunt(동물 ani) throws InterruptedException {
    	forest.removeAnimal(ani);
		farm.addAnimal(ani);
		int exp=ani.getEXP();
		Thread.sleep(1000);
		System.out.println("[사냥 성공 보상]");
		System.out.println("경험치를 "+exp+" 얻었습니다.");
		System.out.println("money를 "+1+"만원 획득했습니다.");
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
    	System.out.println("!!레벨 업!!");
    	Thread.sleep(1000);
		System.out.println("축하합니다! 레벨이 "+level+"올랐습니다.");
		System.out.println("[레벨업 보상]");
		System.out.println("moeny를 10만원 획득했습니다.");
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
    		System.out.println("지불할 money가 부족합니다!");
    		System.out.println("현재 보유 money: "+this.money+"만원");
    	}
    	else {
    		plusUserMoney(-price);
    	}
    }
    
    //weapon
    public 무기 getWeapon() {
    	return weapon;
    }
    public void setWeapon(무기 w) {
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
    		System.out.println("아이템이 부족합니다");
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
