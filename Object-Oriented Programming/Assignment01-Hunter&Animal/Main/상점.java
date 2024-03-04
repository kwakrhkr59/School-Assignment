package Main;

import java.util.Scanner;
public class ���� {
	private static ���� store=null;
	private ����() {}
	public static ���� getInstance() {
		if(store==null) store=new ����();
		return store;
	}
	
	public void show(��ɲ� hunter) {
    	Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("������ ������ �������!");
		System.out.println("1.���� ��ȭ ���\t2.���� ���� ���\t3.���� ������ ���\t4.������ ������ ���\n0.���� ������");
		System.out.print("�����ϰ��� �ϴ� ��ᳪ ���� ��ȣ�� �Է��ϼ���: ");
		int n=input.nextInt();
		if(n==0) {
			System.out.println("������ �� ������!");
			return;
		}
		
		int price=getPrice(n);
		if(price==0) return;
		switch(n) {
			case 1:
			case 2:
				System.out.println("���� �ִ� ���� ���� ����: "+hunter.getUserMoney()/price);
				System.out.printf("������ ������ �Է��ϼ���: ");
				int cnt=input.nextInt();
				if(cnt<0) System.out.println("0���� ū ������ �Է��ϼ���.");
				hunter.payMoney(cnt*price);
				hunter.plusItem(n, cnt);
				System.out.println("�湮���ּż� �����մϴ�!");
				break;
			case 3:
			case 4:
				System.out.println("�������� �ִ� ��� ���� �ο��� 1���Դϴ�.");
				if(hunter.getEmployee(n)) {
					System.out.println("�̹� �����ڰ� �����մϴ�."); 
					break;
				}
				System.out.printf("����Ͻðڽ��ϱ�?(Y/N): ");
				char ans=input.next().charAt(0);
				if(ans=='Y' || ans=='y') {
					hunter.setEmployee(n, true);
					hunter.payMoney(price);
					System.out.println("�湮���ּż� �����մϴ�!");
				}
				break;
			default:
				break;
		}
	}
    
    public int getPrice(int n) {
    	switch(n) {
    		case 1: 
    			System.out.println("���� ��ȭ ���: ������ ����ġ�� 10��ŭ �÷��ش�.");
				System.out.println("����: 100000��");
				return 10;
			case 2:
				System.out.println("���� ���� ���: ������ �������� 5��ŭ �÷��ش�.");
				System.out.println("����: 10000��");
				return 1;
			case 3:
				System.out.println("���� ������: �������忡�� �������� Ż���� Ȯ���� 10%��ŭ �����ش�.");
				System.out.println("�ΰǺ�: 1500000��");
				return 150;
			case 4:
				System.out.println("������ ������: �������忡�� �������� Ż���� Ȯ���� 10%��ŭ �����ش�.");
				System.out.println("�ΰǺ�: 2000000��");
				return 200;
			default:
				System.out.println("�ùٸ��� ���� ��ȣ�Դϴ�.");
				return 0;
    	}
    }
}
