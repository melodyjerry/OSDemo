package compute;

import java.util.List;

import mode.Mode;

/**
 * �ṩ������յȹ���
 * @author ֣˼��
 *
 */
public interface Root {
	/**
	 * ���������Ӧ����
	 * @return
	 */
	public List<Mode> request(List<Mode> inputList,List<Mode> freeList,int requestSize);
	/**
	 * ����ͷ���Ӧ����
	 * @return
	 */
	public List<Mode> release(List<Mode> inputList,List<Mode> freeList,int releaseSize);
}
