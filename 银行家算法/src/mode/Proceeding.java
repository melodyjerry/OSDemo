package mode;
/**
 * ��������ģ��
 * �ѷ��䣬
 * ����
 * @author ֣˼��
 *
 */
public class Proceeding {
	int allotResource[];	//�ѷ���
	int needResource;	//����
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
