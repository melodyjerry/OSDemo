package mode;

/**
 * ��Դ��
 * ʣ�࣬
 * �ܹ���
 * @author ֣˼��
 *
 */
public class Resource {
	int sumResource;	//����Դ��
	int sulplusResource;//ʣ��
	public Resource() {
	}
	
	public Resource(int sumResource, int sulplusResource) {
		this.sumResource = sumResource;
		this.sulplusResource = sulplusResource;
	}
	public int getSumResource() {
		return sumResource;
	}
	public void setSumResource(int sumResource) {
		this.sumResource = sumResource;
	}
	public int getSulplusResource() {
		return sulplusResource;
	}
	public void setSulplusResource(int sulplusResource) {
		this.sulplusResource = sulplusResource;
	}
}
