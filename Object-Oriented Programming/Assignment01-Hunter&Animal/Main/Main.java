package Main;
import java.util.Scanner;

import Animal.������;
import Animal.������;
import Animal.����;
import Animal.��;
import Animal.���;
import ���.��������;
import ���.������;
import ���.����;

//�������� �� ��ü�迭 �ǽ��� ���� �׽�Ʈ 
public class Main {

	public static void menu����() {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("���ӿ� ��������\t:  1.������\t2.��\t3.������\t\t4.���\t9.��������   ");
		System.out.println("����Ϸ� ����\t: 11.��������ϱ�\t12.����ҵ�������");
		System.out.println("�����ϱ�\t\t  21.���ӿ���?\t22.�������忡��?\t23.����������? ");
		System.out.println("���� ����\t\t: 31.���Ӻ���\t32.�������庸��\t33.����������\t34.��� ����");
		System.out.println("����� �޴�\t\t: 41.�� ���� ����\t42.���� Ǯ���ֱ�\t43.���������� ���� ������");
		System.out.println("��Ÿ �޴�\t: 51.��������\t52.���� ��ȭ�ϱ�\t53.���� �����ϱ�\t0.����");
		System.out.println("-----------------------------------------------------------------------");
	}
 

    public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
    	Scanner input = new Scanner(System.in);
    	���� forest = ����.getInstance();
    	������ zoo = ������.getInstance();
    	�������� farm = ��������.getInstance();
    	���� store=����.getInstance();
    	
		int menu =0; 
		
		//��ɲ� ����
		��ɲ� hunter = new ��ɲ�();
		hunter.showInfo();
		���� weapon=hunter.getWeapon();
		
		//������ �Ѹ��� ����  �� ���!
		������ d = new ������("�����");
		forest.addAnimal(d);
		hunter.��������ϱ�();

		//�޴��� ���۽�Ű��
		System.out.println("------------------------------------------------------");
		System.out.println("�޴��� ���۽�Ű��");
		int i=0;
		while(true) {
			
			menu����();
			System.out.print("menu: ");
			menu= input.nextInt();
			if(menu==0) {
				System.out.println("���α׷� ����!");
				break;
			}			
			switch (menu) {
				//���ӿ� ���� ����
				case 1:
					forest.addAnimal(new ������("�����" + (i++)));
					break;
				case 2:
					forest.addAnimal(new ��("������" + (i++)));
					break;
				case 3:
					forest.addAnimal(new ������("��������" + (i++)));
					break;
				case 4:
					forest.addAnimal(new ���("��ũ" + (i++)));
					break;		
				case 9:
					int rand=(int)(Math.random()*100)%4+1;
					switch(rand) {
						case 1:
							forest.addAnimal(new ������("�����" + (i++)));
							break;
						case 2:
							forest.addAnimal(new ��("������" + (i++)));
							break;
						case 3:
							forest.addAnimal(new ������("��������" + (i++)));
							break;
						case 4:
							forest.addAnimal(new ���("��ũ" + (i++)));
							break;	
					}
					break;
				
				//����Ϸ� ����
				case 11:
					if(farm.numOfAnimals==farm.getSize()) {
						System.out.println("���������� �� �� ����� �� �� �����ϴ�!");
						break;
					}
					hunter.��������ϱ�();
					break;
				case 12:
					if(farm.getAnimalNums()==0) {
						System.out.println("���� ������ �����ϴ�!");
						break;
					}
					if(farm.numOfAnimals==farm.getSize()) {
						System.out.println("���������� �� �� ����� �� �� �����ϴ�!");
						break;
					}
					hunter.����ҵ�������();
					break;
				
				//�����ϱ�
				case 21: //����Ȱ������- ���()
					forest.���();
					break;
				case 22:// ��������Ȱ������ - Ż��õ�!
					farm.escape();
					break;
				case 23: //������ Ȱ������ - ���ϱ�();	
					zoo.work();
					System.out.println("-----------------------------------------------------------------------");
					zoo.escape();
					break;
					
				//���º���
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
					
				//����� �޴�
				case 41:
					hunter.showInfo();
					farm.show();
					break;
				case 42:
					if(farm.getAnimalNums()==0) {
						System.out.println("���� ������ �����ϴ�!");
						break;
					}
					
					farm.showAnimals();
					System.out.print("� ������ Ǯ���ٱ��?: ");
					String name42=input.next();
					if(farm.isHere(name42)) {
						���� ani=farm.getAnimal(name42);
						farm.����Ǯ���ֱ�(ani);
						System.out.println(name42+"��(��) Ǯ���ݴϴ�.");
					}
					break;
				case 43:
					if(farm.getAnimalNums()==0) {
						System.out.println("���� ������ �����ϴ�!");
						break;
					}
					
					farm.showAnimals();
					System.out.print("� ������ �������?: ");
					String name43=input.next();
					if(farm.isHere(name43)) {
						���� ani=farm.getAnimal(name43);
						if(farm.����������(ani)) {
							System.out.println(name43+"��(��) ���������� ���½��ϴ�.");
							System.out.println(name43+"��(��) ������ 50������ �޾ҽ��ϴ�!");
							hunter.plusUserMoney(50);
						}
					}
					break;
				
				//��Ÿ �޴�
				case 51:
					store.show(hunter);
					break;
				case 52:
					System.out.println("���� �����ϰ� �ִ� ��ȭ��� ����: "+hunter.getItem(1));
					if(hunter.getItem(1)==0) {
						System.out.println("��ȭ�� �� �ִ� ��ᰡ �����ϴ�!");
						break;
					}
					System.out.print("������ ����� ������ �Է��ϼ���: ");
					int n52=input.nextInt();
					if(hunter.getItem(1)<n52) {
						System.out.println("���� ���� ��ᰡ �����մϴ�.");
						break;
					}
					if(weapon.���Ⱝȭ�ϱ�(n52)) hunter.plusItem(1, -n52); 
					break;
					
				case 53:
					System.out.println("���� �����ϰ� �ִ� ������� ����: "+hunter.getItem(2));
					if(hunter.getItem(2)==0) {
						System.out.println("������ �� �ִ� ��ᰡ �����ϴ�!");
						break;
					}
					System.out.print("������ ����� ������ �Է��ϼ���: ");
					int n53=input.nextInt();
					if(hunter.getItem(2)<n53) {
						System.out.println("���� ���� ��ᰡ �����մϴ�.");
						break;
					}
					if(weapon.��������ϱ�(n53)) hunter.plusItem(2, -n53); 
					break;
					
				default:
					System.out.println("�׷� �޴��� �����ϴ�.");
					break;	
				}				
		}
    }
}
