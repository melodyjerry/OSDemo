package mode;

/**
 * ��¼������Ϣ
 * @author ֣˼��
 *
 */
public class Mode {
	private int num;	//����
	private int size;	//��С
	private int startId;//��ʼ
	public Mode() {
	}
	public Mode(int num,int size,int startId) {
		this.num = num;
		this.size = size;
		this.startId = startId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStartId() {
		return startId;
	}
	public void setStartId(int startId) {
		this.startId = startId;
	}
	
	
}
