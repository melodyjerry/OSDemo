package mode;

/**
 * 记录分区信息
 * @author 郑思林
 *
 */
public class Mode {
	private int num;	//区号
	private int size;	//大小
	private int startId;//起始
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
