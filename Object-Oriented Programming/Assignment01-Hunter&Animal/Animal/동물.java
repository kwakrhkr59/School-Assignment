package Animal;
import Main.*;

public abstract class ���� implements Playable, Workable, Escapeable {
    public String �̸�;
    private int ���Ȯ��;
    
    private int power;
    private int EXP;

    public ����(){
    	System.out.println("������ �Ѹ��� �����մϴ� : ");
    }

    public ����(String �̸�){
    	
    	this.�̸�=�̸�;
    	System.out.println(this.�̸� +"�̶�� �̸��� ���� ������ �Ѹ��� �����մϴ�.");
    }

    public int get���Ȯ��(){
        return this.���Ȯ��;
    }

    public void set���Ȯ��(int ���Ȯ��){
    	this.���Ȯ�� = ���Ȯ��;
    }   
    
    public int getEXP() {
    	return this.EXP;
    }
    
    public void setEXP(int exp) {
    	this.EXP=exp;
    }
	
    public int getPower() {
    	return this.power;
    }
    
    public void setPower(int power) {
    	this.power=power;
    }
    
	public void plusPower(int power) {
		this.power+=power;
		this.power=Math.min(this.power, 100);
		this.power=Math.max(this.power, 0);
	}

	public abstract void ���();

    public void �Ա�(){
    	System.out.println("�������� �꿡�� Ǯ�� ���Ծ��");
    }

    public void �ڱ�(){
    }

    public void �����̱�(){
    }

    public void show(){
    	
    }

}
