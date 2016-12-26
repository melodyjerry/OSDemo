package mode;
/**
 * 进程需求模型
 * 已分配，
 * 尚需
 * @author 郑思林
 *
 */
public class Proceeding {
	int allotResource[];	//已分配
	int needResource;	//尚需
	public Proceeding() {
	}
	
	public Proceeding(int[] allotResource, int needResource) {
		super();
		this.allotResource = allotResource;
		this.needResource = needResource;
	}

	public int[] getAllotResource() {
		return allotResource;
	}
	public void setAllotResource(int[] allotResource) {
		this.allotResource = allotResource;
	}
	public int getNeedResource() {
		return needResource;
	}
	public void setNeedResource(int needResource) {
		this.needResource = needResource;
	}
}
