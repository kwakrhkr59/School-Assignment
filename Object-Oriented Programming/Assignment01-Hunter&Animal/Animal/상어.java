package Animal;
public class ��� extends ���� {

	public ���() {
		this.�̸� = "��ũ";
		this.set���Ȯ��(5);
		this.setEXP(150);
		this.setPower(10);
	}

	public ���(String name) {
		// �������� ó���κ��� �⺻�����ڿ��� ó���ϰ� ȣ���ؼ� �������.
		super(name);
    	this.�̸�= name;
    	this.set���Ȯ��(5);
    	this.setEXP(150);
    	this.setPower(10);
	}

	public ���(String name, int ���Ȯ��) {
		// ������ ���� �����ϴ� ��ĵ� �����ϰ�, �Ʒ�ó�� ȣ���ϴ� �͵� ����
		this(name);
		this.set���Ȯ��(���Ȯ��);
	}
    public void ���ġ��(){
    	System.out.println(this.�̸�+"(��)�� ����� Ĩ�ϴ�. ÷��÷��");
    	this.plusPower(5);
    }

    public void �����̱�(){
    	System.out.println(this.�̸�+"(��)�� �������� �����Դϴ�.");
    	this.plusPower(1);
    }

    public void ���(){
    	System.out.println("����� �������ݾ�! ���� � �ٴٷ� ������!!!~ �����");
    }
    
    public void ���ֺθ���() {
    	���ġ��();
    }

}
