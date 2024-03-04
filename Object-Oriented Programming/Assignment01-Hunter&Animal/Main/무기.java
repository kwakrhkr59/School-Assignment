package Main;
import java.util.*;
public class ���� {
	Scanner input=new Scanner(System.in);
	private int weaponLevel;
	private int weaponEXP;
	private int weaponCond;

	protected ����() {
		this.weaponLevel=1;
		this.weaponEXP=0;
		this.weaponCond=100;
	}
	
	public void show() {
		System.out.println("------------------------------------------------");
    	System.out.println("���� ����: "+getWeaponLevel());
    	System.out.println("���� ����ġ: "+getWeaponEXP());
    	System.out.println("���� ������: "+getWeaponCond());
	}
	
	public int getWeaponLevel() {
		return weaponLevel;
	}
	public void setWeaponLevel(int level) {
		this.weaponLevel=level;
	}
	public void plusWeaponLevel(int level) {
		if(level<0) {
			System.out.println("������ ������ ���� �� �����ϴ�.");
			return;
		}
		this.weaponLevel+=level;
	}
	
	public int getWeaponEXP() {
		return weaponEXP;
	}
	public void setWeaponEXP(int exp) {
		this.weaponEXP=exp;
	}
	public void plusWeaponEXP(int exp) {
		if(exp<0) {
			System.out.println("������ ����ġ�� ���� ���� �� �����ϴ�.");
			return;
		}
		this.weaponEXP+=exp;
		if(this.weaponEXP>=100) {
			int i;
			for(i=0; i<this.weaponEXP/100; i++)
				System.out.println("!!���� ������!!");
			plusWeaponLevel(i);
			this.weaponEXP%=100;
		}
	}
	
	public int getWeaponCond() {
		return weaponCond;
	}
	public void setWeaponCond(int cond) {
		this.weaponCond=cond;
	}
	public void plusWeaponCond(int cond) {
		this.weaponCond+=cond;
		this.weaponCond=Math.min(this.weaponCond, 100);
		if(this.weaponCond==100) {
			System.out.println("���� �������� �ִ뿡 ���߽��ϴ�.");
			return;
		}
		this.weaponCond=Math.max(this.weaponCond, 0);
	}
	
	public int getWeaponEffect() {
		return weaponLevel*weaponCond/100;
	}
	
	public boolean ���Ⱝȭ�ϱ�(int n) {
		show();
		System.out.println("��ȭ��ᰡ "+n+"�� ���ԵǾ����ϴ�.");
		System.out.print("���⸦ ��ȭ�Ͻðڽ��ϱ�?(Y/N)");
		char ans=input.next().charAt(0);
		if(ans=='Y'||ans=='y') {
			this.plusWeaponEXP(n*10);
			System.out.println("���� ��ȭ�� �����߽��ϴ�!");
			show();
			return true;
		}
		System.out.println("���� ��ȭ�� �����߽��ϴ�.");
		return false;
	}
	
	public boolean ��������ϱ�(int n) {
		show();
		System.out.println("������ᰡ "+n+"�� ���ԵǾ����ϴ�.");
		System.out.print("���⸦ �����Ͻðڽ��ϱ�?(Y/N)");
		char ans=input.next().charAt(0);
		if(ans=='Y'||ans=='y') {
			this.plusWeaponCond(n*5);
			System.out.println("���� ������ �����߽��ϴ�!");
			show();
			return true;
		}
		System.out.println("���� ������ �����߽��ϴ�.");
		return false;
	}
}
