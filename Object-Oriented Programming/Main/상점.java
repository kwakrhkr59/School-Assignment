package Main;

import java.util.Scanner;
public class 상점 {
	private static 상점 store=null;
	private 상점() {}
	public static 상점 getInstance() {
		if(store==null) store=new 상점();
		return store;
	}
	
	public void show(사냥꾼 hunter) {
    	Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("객지프 상점에 어서오세요!");
		System.out.println("1.무기 강화 재료\t2.무기 수리 재료\t3.농장 관리자 고용\t4.동물원 관리자 고용\n0.상점 나가기");
		System.out.print("구매하고자 하는 재료나 서비스 번호를 입력하세요: ");
		int n=input.nextInt();
		if(n==0) {
			System.out.println("다음에 또 오세요!");
			return;
		}
		
		int price=getPrice(n);
		if(price==0) return;
		switch(n) {
			case 1:
			case 2:
				System.out.println("현재 최대 구매 가능 수량: "+hunter.getUserMoney()/price);
				System.out.printf("구매할 수량을 입력하세요: ");
				int cnt=input.nextInt();
				if(cnt<0) System.out.println("0보다 큰 정수로 입력하세요.");
				hunter.payMoney(cnt*price);
				hunter.plusItem(n, cnt);
				System.out.println("방문해주셔서 감사합니다!");
				break;
			case 3:
			case 4:
				System.out.println("관리자의 최대 고용 가능 인원은 1명입니다.");
				if(hunter.getEmployee(n)) {
					System.out.println("이미 관리자가 존재합니다."); 
					break;
				}
				System.out.printf("고용하시겠습니까?(Y/N): ");
				char ans=input.next().charAt(0);
				if(ans=='Y' || ans=='y') {
					hunter.setEmployee(n, true);
					hunter.payMoney(price);
					System.out.println("방문해주셔서 감사합니다!");
				}
				break;
			default:
				break;
		}
	}
    
    public int getPrice(int n) {
    	switch(n) {
    		case 1: 
    			System.out.println("무기 강화 재료: 무기의 경험치를 10만큼 올려준다.");
				System.out.println("가격: 100000원");
				return 10;
			case 2:
				System.out.println("무기 수리 재료: 무기의 내구도를 5만큼 올려준다.");
				System.out.println("가격: 10000원");
				return 1;
			case 3:
				System.out.println("농장 관리자: 동물농장에서 동물들이 탈출할 확률을 10%만큼 낮춰준다.");
				System.out.println("인건비: 1500000원");
				return 150;
			case 4:
				System.out.println("동물원 관리자: 동물농장에서 동물들이 탈출할 확률을 10%만큼 낮춰준다.");
				System.out.println("인건비: 2000000원");
				return 200;
			default:
				System.out.println("올바르지 않은 번호입니다.");
				return 0;
    	}
    }
}
