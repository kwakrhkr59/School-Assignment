package Main;
import java.util.Scanner;

import Animal.강아지;
import Animal.독수리;
import Animal.동물;
import Animal.뱀;
import Animal.상어;
import 장소.동물농장;
import 장소.동물원;
import 장소.숲속;

//동물생성 및 객체배열 실습을 위한 테스트 
public class Main {

	public static void menu보기() {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("숲속에 동물생성\t:  1.강아지\t2.뱀\t3.독수리\t\t4.상어\t9.랜덤생성   ");
		System.out.println("사냥하러 가기\t: 11.랜덤사냥하기\t12.사냥할동물고르기");
		System.out.println("관리하기\t\t  21.숲속에서?\t22.동물농장에서?\t23.동물원에서? ");
		System.out.println("상태 보기\t\t: 31.숲속보기\t32.동물농장보기\t33.동물원보기\t34.모두 보기");
		System.out.println("사용자 메뉴\t\t: 41.내 정보 보기\t42.동물 풀어주기\t43.동물원으로 동물 보내기");
		System.out.println("기타 메뉴\t: 51.상점가기\t52.무기 강화하기\t53.무기 수리하기\t0.종료");
		System.out.println("-----------------------------------------------------------------------");
	}
 

    public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
    	Scanner input = new Scanner(System.in);
    	숲속 forest = 숲속.getInstance();
    	동물원 zoo = 동물원.getInstance();
    	동물농장 farm = 동물농장.getInstance();
    	상점 store=상점.getInstance();
    	
		int menu =0; 
		
		//사냥꾼 생성
		사냥꾼 hunter = new 사냥꾼();
		hunter.showInfo();
		무기 weapon=hunter.getWeapon();
		
		//강아지 한마리 생성  후 사냥!
		강아지 d = new 강아지("흰둥이");
		forest.addAnimal(d);
		hunter.랜덤사냥하기();

		//메뉴로 동작시키기
		System.out.println("------------------------------------------------------");
		System.out.println("메뉴로 동작시키기");
		int i=0;
		while(true) {
			
			menu보기();
			System.out.print("menu: ");
			menu= input.nextInt();
			if(menu==0) {
				System.out.println("프로그램 종료!");
				break;
			}			
			switch (menu) {
				//숲속에 동물 생성
				case 1:
					forest.addAnimal(new 강아지("댕댕이" + (i++)));
					break;
				case 2:
					forest.addAnimal(new 뱀("슈슈뱀" + (i++)));
					break;
				case 3:
					forest.addAnimal(new 독수리("수리수리" + (i++)));
					break;
				case 4:
					forest.addAnimal(new 상어("샤크" + (i++)));
					break;		
				case 9:
					int rand=(int)(Math.random()*100)%4+1;
					switch(rand) {
						case 1:
							forest.addAnimal(new 강아지("댕댕이" + (i++)));
							break;
						case 2:
							forest.addAnimal(new 뱀("슈슈뱀" + (i++)));
							break;
						case 3:
							forest.addAnimal(new 독수리("수리수리" + (i++)));
							break;
						case 4:
							forest.addAnimal(new 상어("샤크" + (i++)));
							break;	
					}
					break;
				
				//사냥하러 가기
				case 11:
					if(farm.numOfAnimals==farm.getSize()) {
						System.out.println("동물농장이 꽉 차 사냥을 할 수 없습니다!");
						break;
					}
					hunter.랜덤사냥하기();
					break;
				case 12:
					if(farm.getAnimalNums()==0) {
						System.out.println("아직 동물이 없습니다!");
						break;
					}
					if(farm.numOfAnimals==farm.getSize()) {
						System.out.println("동물농장이 꽉 차 사냥을 할 수 없습니다!");
						break;
					}
					hunter.사냥할동물고르기();
					break;
				
				//관리하기
				case 21: //숲속활동보기- 놀기()
					forest.놀기();
					break;
				case 22:// 동물농장활동보기 - 탈출시도!
					farm.escape();
					break;
				case 23: //동물원 활동보기 - 일하기();	
					zoo.work();
					System.out.println("-----------------------------------------------------------------------");
					zoo.escape();
					break;
					
				//상태보기
				case 31:
					forest.show();
					break;
				case 32:
					hunter.show();
					break;
				case 33:
					zoo.show();
					break;
				case 34:
					forest.show();
					farm.show();
					zoo.show();
					break;
					
				//사용자 메뉴
				case 41:
					hunter.showInfo();
					farm.show();
					break;
				case 42:
					if(farm.getAnimalNums()==0) {
						System.out.println("아직 동물이 없습니다!");
						break;
					}
					
					farm.showAnimals();
					System.out.print("어떤 동물을 풀어줄까요?: ");
					String name42=input.next();
					if(farm.isHere(name42)) {
						동물 ani=farm.getAnimal(name42);
						farm.동물풀어주기(ani);
						System.out.println(name42+"을(를) 풀어줍니다.");
					}
					break;
				case 43:
					if(farm.getAnimalNums()==0) {
						System.out.println("아직 동물이 없습니다!");
						break;
					}
					
					farm.showAnimals();
					System.out.print("어떤 동물을 보낼까요?: ");
					String name43=input.next();
					if(farm.isHere(name43)) {
						동물 ani=farm.getAnimal(name43);
						if(farm.동물보내기(ani)) {
							System.out.println(name43+"을(를) 동물원으로 보냈습니다.");
							System.out.println(name43+"을(를) 보내고 50만원을 받았습니다!");
							hunter.plusUserMoney(50);
						}
					}
					break;
				
				//기타 메뉴
				case 51:
					store.show(hunter);
					break;
				case 52:
					System.out.println("현재 보유하고 있는 강화재료 수량: "+hunter.getItem(1));
					if(hunter.getItem(1)==0) {
						System.out.println("강화할 수 있는 재료가 없습니다!");
						break;
					}
					System.out.print("투입할 재료의 개수를 입력하세요: ");
					int n52=input.nextInt();
					if(hunter.getItem(1)<n52) {
						System.out.println("현재 보유 재료가 부족합니다.");
						break;
					}
					if(weapon.무기강화하기(n52)) hunter.plusItem(1, -n52); 
					break;
					
				case 53:
					System.out.println("현재 보유하고 있는 수리재료 수량: "+hunter.getItem(2));
					if(hunter.getItem(2)==0) {
						System.out.println("수리할 수 있는 재료가 없습니다!");
						break;
					}
					System.out.print("투입할 재료의 개수를 입력하세요: ");
					int n53=input.nextInt();
					if(hunter.getItem(2)<n53) {
						System.out.println("현재 보유 재료가 부족합니다.");
						break;
					}
					if(weapon.무기수리하기(n53)) hunter.plusItem(2, -n53); 
					break;
					
				default:
					System.out.println("그런 메뉴는 없습니다.");
					break;	
				}				
		}
    }
}
