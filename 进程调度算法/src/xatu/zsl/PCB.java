package xatu.zsl;
/**
 * ������
 * @author admin
 */
public class PCB {
//	private int arrowTime;	// �ύʱ��
	private int needTime;	// ��Ҫʱ��ʱ��
	private int priority;	// ���ȼ�
	private int isRunning;	// �Ƿ�������
	private String name ;	//��������
//	public int getArrowTime() {
//		return arrowTime;
//	}
//	public void setArrowTime(int arrowTime) {
//		this.arrowTime = arrowTime;
//	}
	public int getNeedTime() {
		return needTime;
	}
	public void setNeedTime(int needTime) {
		this.needTime = needTime;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getIsRunning() {
		return isRunning;
	}
	public void setIsRunning(int isRunning) {
		this.isRunning = isRunning;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
