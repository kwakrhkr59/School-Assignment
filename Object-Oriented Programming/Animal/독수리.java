package Animal;
public class ������ extends ���� {
    public int ����;

    public ������(){
    	this.�̸�="������";
    	this.set���Ȯ��(30);  //������ ���Ȯ���� 30%
    	this.setEXP(50);
    	this.setPower(7);
    }

    public ������(String name){    	
    	//�������� ó���κ��� �⺻�����ڿ��� ó���ϰ� ȣ���ؼ� �������.
    	super(name);
    	this.�̸�= name;
    	this.set���Ȯ��(30);
    	this.setEXP(50);
    	this.setPower(7);
    }
    
    public ������(String name, int ���Ȯ��){
    	//������ ���� �����ϴ� ��ĵ� �����ϰ�, �Ʒ�ó�� ȣ���ϴ� �͵� ����
    	this(name);
    	this.set���Ȯ��(���Ȯ��);
    }
    
    public void �����̱�(){
    	System.out.println(this.�̸�+"(��)�� �������� �ɾ�ϴ�.");
    }

    public void ����(){
    	System.out.println(this.�̸�+"(��)�� ���� ������ ���� ���ƴٴմϴ�.");
    }

    public void ���(){
    	System.out.println("�������� ���ƴٴϸ鼭 ��� ���� �������� ������ �ٺ��� �� �ð��� ���� ��������~");
    }
    
    public void ���ֺθ���() {
    	����();
    }
}
