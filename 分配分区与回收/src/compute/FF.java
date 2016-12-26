package compute;

import java.util.List;

import main.Main;
import mode.Mode;

/**
 * 首次适应算法，FF 
 * @author 郑思林
 *
 */
public class FF implements Root{

	@Override
	public List<Mode> request(List<Mode> inputList,List<Mode> freeList, int requestSize) {
		//差找空闲分区队列，第一个满足条件的内存
		boolean sign = false;
		for (Mode freeMode : freeList) {
			if(freeMode.getSize() >= requestSize){	//找到满足条件的立刻跳转，并及时分配
				//更新空闲分区列
				Mode tempMode1 = new Mode(freeMode.getNum(), 
						freeMode.getSize()-requestSize, freeMode.getStartId()+requestSize);
				freeList.remove(freeMode);
				freeList.add(tempMode1);
				
				//更新分配情况
				Mode tempMode2 = new Mode(inputList.size()+1, requestSize, freeMode.getStartId());
				inputList.add(tempMode2);
				sign = true;
				break;
			}
		}
		if (!sign) System.out.println("未找到合适的空闲分区,无法分配！");
		//更新主函数里的
		//集合排序
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
		//查找对应分配的内存
		for (Mode inputMode : inputList) 
			if(inputMode.getSize() == releaseSize)
				releaseMode = inputMode;
				
		/* 分情况讨论内存分配情况
		 * 只看该释放单元和空闲分区的关系，
		 * 
		 * 1. 上有空闲分区即（空闲分区的起始地址加上size == 释放分区的起始地址）
		 * 2. 下右空闲分区即（空闲分区的起始地址 == 释放分区的起始地址加上size）
		 * 3. 上下都有空闲分区，同时满足 1,2
		 * 4. 上下均无空闲分区，同时不满足1.2
		 */
		if (releaseMode == null) {
			System.out.println("未检测到需释放内存块！");
			return null;
		}else{
			inputList.remove(releaseMode);
		}
		
		Mode statrId1 = null;
		Mode statrId2 = null;
		for (Mode freeMode : freeList) {
			if (judge(releaseMode, freeMode)) 	//下面有空闲快
				statrId2 = freeMode;

			if (judge(freeMode, releaseMode)) 	//上面有空闲快
				statrId1 = freeMode;
		}	
		//情况1
		if(statrId1 != null && statrId2 == null){
			Mode tempMode = new Mode(statrId1.getNum(), statrId1.getSize() + releaseSize, statrId1.getStartId());
			freeList.remove(statrId1);
			freeList.add(statrId1.getNum(), tempMode);
		}
		//情况2
		if(statrId2 != null && statrId1 == null){
			Mode tempMode = new Mode(statrId2.getNum(), statrId2.getSize() + releaseSize, releaseMode.getStartId());
			freeList.remove(statrId2);
			freeList.add(statrId2.getNum(), tempMode);
		}
		//情况3
		if(statrId1 != null && statrId2 != null){
			Mode tempMode = new Mode(statrId1.getNum(), statrId1.getSize() + releaseSize + statrId2.getSize(), statrId1.getStartId());
			freeList.remove(statrId1);
			freeList.remove(statrId2);
			freeList.add(statrId1.getNum(), tempMode);
		}
		//情况4
		if(statrId2 == null && statrId1 == null){
			Mode tempMode = new Mode(releaseMode.getNum(), releaseSize,releaseMode.getStartId());
			freeList.add(tempMode);
		}
		
		//集合排序
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
	 * 返回 oneMode 是否 在 otherMode 前
	 * @param oneMode
	 * @param otherMode
	 * @return
	 */
	public boolean judge(Mode oneMode,Mode otherMode){
		return oneMode.getStartId()+oneMode.getSize() == otherMode.getStartId();
	}
}









