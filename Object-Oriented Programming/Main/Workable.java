package Main;

public interface Workable {
	//���ָ� �θ� ��  hp, power, money ��  ������ �����غ����?
	//���ֺθ����� ������ �����غ�����.  �� �����鿡�� �����ϴ� ���� ��Ģ������
	//�������� ����� default �޼ҵ�� �߰��ص� �˴ϴ�.

	public default void ���ֺθ���() {
		System.out.println("������ (�⺻������) ���ָ� �θ��ϴ�.");
	}
	public default void work() {
		System.out.println("������ (�⺻������) ���� �մϴ�.");
	}
}
