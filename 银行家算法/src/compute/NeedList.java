package compute;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		List<String> stringList = new ArrayList<String>();//安全序列
		boolean testAlot = false;//判断是分配条件	默认为安全
		initPrint(arrayAlot,arrayNeed,sulplus);
		
		//* * * * * * * * * * * * * * * * * * * 核心算法 * * * * *  * * * * * * * * * * * * * * * * * 
 		//几个进程跑几次
		for (int i = 0; i < arrayAlot.length; i++) {
			//添加是否执行请求
			System.out.print("是否需要执行请求[1/0]：");
			Scanner in = new Scanner(System.in);
			String order = in.nextLine();
			while(!order.equals("1") && !order.equals("0")){
				System.out.print("指令错误重新输入，是否需要执行请求[1/0]：");
				order = in.next();
			}
			
			if (order.equals("1")){
				int[] request = isRequest(arrayAlot,arrayNeed,sulplus,stringList);
				if (request != null){ 	//提出請求可以分配
					System.out.println("该请求安全，给予分配！");
					for (int n = 0; n < 4; n++)  sulplus[n]= sulplus[n] - request[n];//分配
				}
			}
			
			testAlot = false;	//重置安全
			//选择可行进程进行分配
			int j = 0;
			int t = 0;
			for (j = 0; j < arrayNeed.length; j++) {
				
				for (t = 0; t < arrayNeed[0].length; t++)
					if (testAlot = (sulplus[t] < arrayNeed[j][t])) 
						//相当于 sulplus[t] - arrayNeed[j][t] < 0
						//testAlot 为是否安全，满足这个if条件的不安全
						break;	//不满足分配条件，不够分配	testAlot为true
				
				if (!testAlot)
					break;	//满足分配条件，跳出进行分配
			}
			if (testAlot) {	//没有可以分配的	不安全
				System.out.println("* 分配完毕！ *");
				return stringList;
			}
			//对j进行分配（Pj+1进程）
			for (int k = 0; k < sulplus.length; k++) {
				//更新剩余资源
				sulplus[k] = sulplus[k] + arrayAlot[j][k];
				//尚需资源，将其设为最大100
				arrayNeed[j][k] = 100;
			}
			initPrint(arrayAlot,arrayNeed,sulplus);
			String tempString = "P" + (j + 1);
			stringList.add(tempString);
		}
		return stringList;
	}
	/**
	 * 输出分配情况
	 * @param arrayAlot
	 * @param arrayNeed
	 * @param sulplus
	 */
	private void initPrint(int[][] arrayAlot, int[][] arrayNeed, int[] sulplus) {
		System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊ 当前分配情况 ＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
		System.out.println("需求矩阵：                                                   			已分配矩阵：						");
		System.out.println(" 	  A   B   C   D				 	  A   B   C   D");
		for (int i1 = 0; i1 < arrayAlot.length; i1++) {
			System.out.print("P" + (i1+1)+"\t");
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
	}
	/**
	 * 执行每次分配的请求,请求的是分配，并打印可行安全序列
	 */
	private int[] isRequest(int arrayAlot[][],int arrayNeed[][],int sulplus[],List<String> strings) {
		
		Scanner in = new Scanner(System.in);
		int n = 100;
		int request[] = new int[4];
		while(n <= 0 || n >= arrayAlot.length){
			System.out.print("请输入需要请求进程，如P1进程则输入1  ：");
			n = in.nextInt();
		}
		System.out.print("请输入请求序列，如 1 0 2 0，即 P"+n+"进程需要请求[A-1，B-0，C-2，D-0]:");
		for (int i = 0; i < 4; i++) {
			request[i] = in.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			sulplus[i] = sulplus[i] - request[i];	//試分配
			arrayNeed[n-1][i] = arrayNeed[n-1][i] - request[i];
			if (arrayNeed[n-1][i] < 0) 
				System.out.println("输入请求超出原先需求!");
			System.out.println(sulplus[i] + "  " + arrayNeed[n-1][i]);
		}
		
		boolean testAlot = false;//判断是分配条件	默认为安全
		//几个进程跑几次
		for (int i = 0; i < arrayAlot.length; i++) {
			testAlot = false;	//重置安全
			//选择可行进程进行分配
			int j = 0;
			int t = 0;
			for (j = 0; j < arrayNeed.length; j++) {
				
				for (t = 0; t < arrayNeed[0].length; t++)
					if (testAlot = (sulplus[t] < arrayNeed[j][t])) 
						//相当于 sulplus[t] - arrayNeed[j][t] < 0
						//testAlot 为是否安全，满足这个if条件的不安全
						break;	//不满足分配条件，不够分配	testAlot为true
				
				if (!testAlot)
					break;	//满足分配条件，跳出进行分配
			}
			if (testAlot) {	//没有可以分配的	不安全
				System.out.println("* 试分配完毕！ *");
				return request;
			}
			//对j进行分配（Pj+1进程）
			for (int k = 0; k < sulplus.length; k++) {
				//更新剩余资源
				sulplus[k] = sulplus[k] + arrayAlot[j][k];
				//尚需资源，将其设为最大100
				arrayNeed[j][k] = 100;
			}
			String tempString = "P" + (j + 1);
			strings.add(tempString);
		}
		if (strings.size() == 5){
			for (String str : strings) 
				System.out.print(str + " --> ");
			return request;
		} else return null;
	}
}
