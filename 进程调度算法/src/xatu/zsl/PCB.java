package xatu.zsl;
/**
 * 进程类
 * @author admin
 */
public class PCB {
//	private int arrowTime;	// 提交时间
	private int needTime;	// 需要时间时间
	private int priority;	// 优先级
	private int isRunning;	// 是否在运行
	private String name ;	//输入名称
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
