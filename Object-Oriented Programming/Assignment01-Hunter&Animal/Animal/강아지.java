package Animal;
public class ������ extends ���� {
	
	//����Ʈ������
    public ������(){
    	this.�̸�="������";
    	this.set���Ȯ��(80);  //������ ���Ȯ���� 80%
    	this.setEXP(20);
    	this.setPower(5);
    }

    public ������(String name){    	
    	//�������� ó���κ��� �⺻�����ڿ��� ó���ϰ� ȣ���ؼ� �������.  
    	super(name);
    	this.�̸�= name;
    	this.set���Ȯ��(80);
    	this.setEXP(20);
    	this.setPower(5);
    }
    
    public ������(String name, int ���Ȯ��){
    	//������ ���� �����ϴ� ��ĵ� �����ϰ�, �Ʒ�ó�� ȣ���ϴ� �͵� ����
    	this(name);
    	this.set���Ȯ��(���Ȯ��);
    }
    
    public void �����̱�(){
    	
    }

    public void ���(){
    	System.out.println("�������� ���ӿ��� �پ�ϸ� ��ϴ� �۸۸�~");
    	����������();
    	�Ź߹���������();
    
    }
    public void ����������(){
    	System.out.println("������ �������? �۸�~");
    }

    public void �Ź߹���������(){
    	System.out.println("�Ź��� ���� ������ ������? �۸�~");
    }
    
    //����������
    public void ���ֺθ���(){
    	System.out.println("�۸�...�۸�....���� ���ָ� �θ��� ������ ");
    	System.out.println("������ ���ؼ� ���� ���� power�� �淯�� Ż���� �õ��ؾ���!");
    	plusPower(10);
      }

    

}
