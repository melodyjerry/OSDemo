package compute;

import java.util.List;

import main.Main;
import mode.Mode;

/**
 * �����Ӧ�㷨
 * @author ֣˼��
 *
 */
public class MF implements Root{

	@Override
	public List<Mode> request(List<Mode> inputList,List<Mode> freeList, int requestSize) {
		Mode minFreeMode = new Mode(0,1000,0); 
		boolean sign = false;
		//���ҿ��з������У�����������С���ڴ�
		for (Mode freeMode : freeList) 
			if(freeMode.getSize() > requestSize && freeMode.getSize() < minFreeMode.getSize()){
				minFreeMode = freeMode;
				sign = true;
			}
		if (!sign) System.out.println("δ�ҵ����ʵĿ��з���,�޷����䣡");
		Mode tempMode1 = new Mode(minFreeMode.getNum(), 
				minFreeMode.getSize()-requestSize, minFreeMode.getStartId()+requestSize);
		freeList.remove(minFreeMode);
		freeList.add(tempMode1);
		
		//���·������
		Mode tempMode2 = new Mode(inputList.size()+1, requestSize, minFreeMode.getStartId());
		inputList.add(tempMode2);
		//�������������
		Main.freeList = freeList;
		Main.testList = inputList;
		return null;
	}

	@Override
	public List<Mode> release(List<Mode> inputList,List<Mode> freeList, int releaseSize) {
		//�����ͷ��㷨һ����ֱ�ӵ�����һ������
		FF test = new FF();
		test.release(inputList, freeList, releaseSize);
		return null;
	}
	
}
