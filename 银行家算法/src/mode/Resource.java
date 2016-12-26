package mode;

/**
 * 资源类
 * 剩余，
 * 总共，
 * @author 郑思林
 *
 */
public class Resource {
	int sumResource;	//总资源数
	int sulplusResource;//剩余
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
