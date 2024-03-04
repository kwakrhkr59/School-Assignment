package Main;
import java.util.*;
public class 무기 {
	Scanner input=new Scanner(System.in);
	private int weaponLevel;
	private int weaponEXP;
	private int weaponCond;

	protected 무기() {
		this.weaponLevel=1;
		this.weaponEXP=0;
		this.weaponCond=100;
	}
	
	public void show() {
		System.out.println("------------------------------------------------");
    	System.out.println("무기 레벨: "+getWeaponLevel());
    	System.out.println("무기 경험치: "+getWeaponEXP());
    	System.out.println("무기 내구도: "+getWeaponCond());
	}
	
	public int getWeaponLevel() {
		return weaponLevel;
	}
	public void setWeaponLevel(int level) {
		this.weaponLevel=level;
	}
	public void plusWeaponLevel(int level) {
		if(level<0) {
			System.out.println("무기의 레벨은 낮출 수 없습니다.");
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
			System.out.println("무기의 경험치는 직접 낮출 수 없습니다.");
			return;
		}
		this.weaponEXP+=exp;
		if(this.weaponEXP>=100) {
			int i;
			for(i=0; i<this.weaponEXP/100; i++)
				System.out.println("!!무기 레벨업!!");
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
			System.out.println("무기 내구도가 최대에 달했습니다.");
			return;
		}
		this.weaponCond=Math.max(this.weaponCond, 0);
	}
	
	public int getWeaponEffect() {
		return weaponLevel*weaponCond/100;
	}
	
	public boolean 무기강화하기(int n) {
		show();
		System.out.println("강화재료가 "+n+"개 투입되었습니다.");
		System.out.print("무기를 강화하시겠습니까?(Y/N)");
		char ans=input.next().charAt(0);
		if(ans=='Y'||ans=='y') {
			this.plusWeaponEXP(n*10);
			System.out.println("무기 강화에 성공했습니다!");
			show();
			return true;
		}
		System.out.println("무기 강화에 실패했습니다.");
		return false;
	}
	
	public boolean 무기수리하기(int n) {
		show();
		System.out.println("수리재료가 "+n+"개 투입되었습니다.");
		System.out.print("무기를 수리하시겠습니까?(Y/N)");
		char ans=input.next().charAt(0);
		if(ans=='Y'||ans=='y') {
			this.plusWeaponCond(n*5);
			System.out.println("무기 수리에 성공했습니다!");
			show();
			return true;
		}
		System.out.println("무기 수리에 실패했습니다.");
		return false;
	}
}
