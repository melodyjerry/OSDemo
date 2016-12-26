package compute;

import java.util.List;

import mode.Mode;

/**
 * 提供申请回收等功能
 * @author 郑思林
 *
 */
public interface Root {
	/**
	 * 完成请求响应工作
	 * @return
	 */
	public List<Mode> request(List<Mode> inputList,List<Mode> freeList,int requestSize);
	/**
	 * 完成释放响应工作
	 * @return
	 */
	public List<Mode> release(List<Mode> inputList,List<Mode> freeList,int releaseSize);
}
