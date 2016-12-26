package compute;

import java.util.List;

import main.Main;
import mode.Mode;

/**
 * �״���Ӧ�㷨��FF 
 * @author ֣˼��
 *
 */
public class FF implements Root{

	@Override
	public List<Mode> request(List<Mode> inputList,List<Mode> freeList, int requestSize) {
		//���ҿ��з������У���һ�������������ڴ�
		boolean sign = false;
		for (Mode freeMode : freeList) {
			if(freeMode.getSize() >= requestSize){	//�ҵ�����������������ת������ʱ����
				//���¿��з�����
				Mode tempMode1 = new Mode(freeMode.getNum(), 
						freeMode.getSize()-requestSize, freeMode.getStartId()+requestSize);
				freeList.remove(freeMode);
				freeList.add(tempMode1);
				
				//���·������
				Mode tempMode2 = new Mode(inputList.size()+1, requestSize, freeMode.getStartId());
				inputList.add(tempMode2);
				sign = true;
				break;
			}
		}
		if (!sign) System.out.println("δ�ҵ����ʵĿ��з���,�޷����䣡");
		//�������������
		//��������
		for (int i = 0; i < freeList.size(); i++) {
			for (int j = i; j < freeList.size(); j++) {
				if(freeList.get(i).getStartId() > freeList.get(j).getStartId()){
					Mode mode1 = freeList.get(i);
					Mode mode2 = freeList.get(j);
					freeList.remove(mode1);
					freeList.add(i, mode2);
					freeList.remove(mode2);
					freeList.add(j, mode1);
				}
			}
		}
		Main.freeList = freeList;
		Main.testList = inputList;
		return null;
	}

	@Override
	public List<Mode> release(List<Mode> inputList,List<Mode> freeList, int releaseSize) {
		Mode releaseMode = null;
		//���Ҷ�Ӧ������ڴ�
		for (Mode inputMode : inputList) 
			if(inputMode.getSize() == releaseSize)
				releaseMode = inputMode;
				
		/* ����������ڴ�������
		 * ֻ�����ͷŵ�Ԫ�Ϳ��з����Ĺ�ϵ��
		 * 
		 * 1. ���п��з����������з�������ʼ��ַ����size == �ͷŷ�������ʼ��ַ��
		 * 2. ���ҿ��з����������з�������ʼ��ַ == �ͷŷ�������ʼ��ַ����size��
		 * 3. ���¶��п��з�����ͬʱ���� 1,2
		 * 4. ���¾��޿��з�����ͬʱ������1.2
		 */
		if (releaseMode == null) {
			System.out.println("δ��⵽���ͷ��ڴ�飡");
			return null;
		}else{
			inputList.remove(releaseMode);
		}
		
		Mode statrId1 = null;
		Mode statrId2 = null;
		for (Mode freeMode : freeList) {
			if (judge(releaseMode, freeMode)) 	//�����п��п�
				statrId2 = freeMode;

			if (judge(freeMode, releaseMode)) 	//�����п��п�
				statrId1 = freeMode;
		}	
		//���1
		if(statrId1 != null && statrId2 == null){
			Mode tempMode = new Mode(statrId1.getNum(), statrId1.getSize() + releaseSize, statrId1.getStartId());
			freeList.remove(statrId1);
			freeList.add(statrId1.getNum(), tempMode);
		}
		//���2
		if(statrId2 != null && statrId1 == null){
			Mode tempMode = new Mode(statrId2.getNum(), statrId2.getSize() + releaseSize, releaseMode.getStartId());
			freeList.remove(statrId2);
			freeList.add(statrId2.getNum(), tempMode);
		}
		//���3
		if(statrId1 != null && statrId2 != null){
			Mode tempMode = new Mode(statrId1.getNum(), statrId1.getSize() + releaseSize + statrId2.getSize(), statrId1.getStartId());
			freeList.remove(statrId1);
			freeList.remove(statrId2);
			freeList.add(statrId1.getNum(), tempMode);
		}
		//���4
		if(statrId2 == null && statrId1 == null){
			Mode tempMode = new Mode(releaseMode.getNum(), releaseSize,releaseMode.getStartId());
			freeList.add(tempMode);
		}
		
		//��������
		for (int i = 0; i < freeList.size(); i++) {
			for (int j = i; j < freeList.size(); j++) {
				if(freeList.get(i).getStartId() > freeList.get(j).getStartId()){
					Mode mode1 = freeList.get(i);
					Mode mode2 = freeList.get(j);
					freeList.remove(mode1);
					freeList.add(i, mode2);
					freeList.remove(mode2);
					freeList.add(j, mode1);
				}
			}
		}
		
		Main.freeList = freeList;
		Main.testList = inputList;
		return null;
	}
	
	/**
	 * ���� oneMode �Ƿ� �� otherMode ǰ
	 * @param oneMode
	 * @param otherMode
	 * @return
	 */
	public boolean judge(Mode oneMode,Mode otherMode){
		return oneMode.getStartId()+oneMode.getSize() == otherMode.getStartId();
	}
}









