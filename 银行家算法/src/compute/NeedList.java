package compute;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用银行家算法求解，需求矩阵
 * @author 郑思林
 *
 */
public class NeedList {
	public NeedList() {
	}
	/**
	 * 获得安全序列
	 * @param arrayAlot	已分配矩阵	
	 * @param arrayNeed	尚需矩阵
	 * @param sulplus	剩余资源
	 * @return
	 */
	public List<String> getSafeList(int arrayAlot[][],int arrayNeed[][],int sulplus[]){
		List<String> stringList = new ArrayList<String>();
		//几个进程跑几次
		for (int i = 0; i < arrayAlot.length; i++) {	
			//选择可行进程进行分配
			int j = 0;
			int t = 0;
			for (j = 0; j < arrayNeed.length; j++) {
				for (t = 0; t < arrayNeed[0].length; t++)
					if (sulplus[t] < arrayNeed[j][t]) 
						break;	//不满足分配条件，不够分配
				
				if (t >= arrayNeed[0].length)
					break;	//满足分配条件，跳出进行分配
			}
			if (j >= arrayNeed.length) {	//没有可以分配的
				System.out.println("无可分配进程。");
				return stringList;
			}
			//对j进行分配（Pj+1进程）
			for (int k = 0; k < sulplus.length; k++) {
				//更新剩余资源
				sulplus[k] = sulplus[k] + arrayAlot[j][k];
				//尚需资源，将其设为最大100
				arrayNeed[j][k] = 100;
				
			}
			
			System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊第" + i +"次分配＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
			System.out.println("已分配矩阵：					需求矩阵：                                                   ");
			System.out.println(" 		 A   B   C   D				 	  A   B   C   D");
			for (int i1 = 0; i1 < arrayAlot.length; i1++) {
				System.out.print("P" + (i1+1)+"\t\t");
				for (int j1 = 0; j1 < arrayAlot[0].length; j1++) {
					System.out.printf("%3d ",arrayNeed[i1][j1]);
				}
				System.out.print("\t\t\tP" + (i1+1) + "\t");
				for (int j1 = 0; j1 < arrayAlot[0].length; j1++) {
					System.out.printf("%3d ",arrayAlot[i1][j1]);
				}
				System.out.println();
			}
			System.out.print("剩余资源：");
			for (int k = 0; k < sulplus.length; k++)	System.out.print( "   " + (char)('A'+k) + "-"+ sulplus[k]);
			System.out.println();
			System.out.println();
			String tempString = "P" + (j + 1);
			stringList.add(tempString);
		}
		return stringList;
	}
}
