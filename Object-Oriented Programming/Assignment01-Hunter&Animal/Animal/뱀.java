package Animal;
public class �� extends ���� {
    public ��(){
    	this.�̸�="������";
    	this.set���Ȯ��(20);  //�� ���Ȯ���� 30%
    	this.setEXP(80);
    	this.setPower(15);
    }

    public ��(String name){    	
    	//�������� ó���κ��� �⺻�����ڿ��� ó���ϰ� ȣ���ؼ� �������.
    	super(name);
    	this.�̸�= name;
    	this.set���Ȯ��(20);
    	this.setEXP(80);
    	this.setPower(15);
    }
    
    public ��(String name, int ���Ȯ��){
    	//������ ���� �����ϴ� ��ĵ� �����ϰ�, �Ʒ�ó�� ȣ���ϴ� �͵� ����
    	this(name);
    	this.set���Ȯ��(���Ȯ��);
    }
    public void ���ٴϱ�(){
    	System.out.println(this.�̸�+"(��)�� ��~��~ �̸����� ���ٴմϴ�.");
    	this.plusPower(3);
    }

    public void �̸�Ʋ��(){
    	System.out.println("�ʸ��ʸ� �ʸ��� Ʋ��� ����~");
    	this.plusPower(-2);
    }

    public void ���(){
    	System.out.println("���� ~ ����~");
    	�̸�Ʋ��();
    }
    
    public void ���ֺθ���() {
    	���ٴϱ�();
    	�̸�Ʋ��();
    }
}
