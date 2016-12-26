package main;

import java.util.List;

import compute.NeedList;

/**
 * 测试类
 * @author admin
 *
 */
public class Main {
	
	private static int arrayAlot[][];
 	private static int arrayNeed[][];
	private static int sulplus[];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		init();	
		NeedList list = new NeedList();
		List<String> safeList= list.getSafeList(arrayAlot, arrayNeed, sulplus);
		System.out.println("安全序列为：");
		for (String string : safeList) {
			System.out.print(string + " --> ");
		}
	}
	
	/**
	 * 初始化
	 */
	private static void init() {
		/*
		 * 已分配矩阵：			 		 * 尚需矩阵：  				   	 * 需求总量
		 * 			A  B  C  D		 * 			A  B  C  D		 * 			A  B  C  D					
		 *  P1		2  0  1  1		 *  P1		1  1  2  0 		 *  P1		3  1  3  1 
		 * 	P2		7  2  0  0		 * 	P2		4  0  2  0		 * 	P2		11 2  2  0
		 * 	P3		5  2  0  3		 * 	P3		3  5  2  0		 * 	P3		8  7  2  3
		 * 	P4		2  5  5  3		 * 	P4		5  3  5  5		 * 	P4		7  8  10 8
		 * 	P5		0  5  8  6		 * 	P5		8  6  0  5 		 * 	P5		8  11 8  11 
		 * 
		 * 		资源剩余：		资源总数：	
		 * A： 	  2		      18
		 * B：	  3			  17
		 * C：	  2			  16
		 * D:	  2			  15
		 * 
		 * 安全序列：	P1 --> P2 --> P3 --> P5 --> P4
		 * 	P1		4  3  3  3		
		 * 	P2		11 5  3  3
		 * 	P3		16 7  3  6
		 * 	P5		16 12 11 12
		 * 	P4		18 17 16 15
		 * 	
		 * 第一次检测：	2 3 2 2 
		 * P1
		 * 第二次检测：4 3 3 3
		 * P2
		 * 第三次检测：11 5 3 3
		 * P3
		 * 第四次检测：16 7 3 6
		 * P5
		 * 第五次检测：18 12 11 12
		 * P4
		 * 最后剩余：  18 17 16 15
		 * 
		 * （1）获取两个矩阵一个数组（已分配矩阵，尚需矩阵，剩余资源数组）
		 * （2）检索尚需矩阵，判断是否有满足条件的进程（必须每个剩余资源数均大于，其尚需）
		 * （3）如果均不满足，输出错误信息“分配完毕或者异常”，跳（8）
		 * （4）如果满足则将进程编号存入一个数组，
		 * 
		 * （5）待其执行完毕，剩余数组加上已分配矩阵的某一行（与执行进程对应的一行）
		 * （6）同时将需求矩阵置为100（最大，既无法满足）
		 * （7）跳（2）
		 * （8）输出所求序列，退出
		 */
		//已分配矩阵
		int arrayAlot1[][] = {{2,0,1,1},
							 {7,2,0,0},
							 {5,2,0,3},
							 {2,5,5,3},
							 {0,5,8,6}};
		//待分配矩阵
		int arrayNeed1[][] = {{1,1,2,0},
							 {4,0,2,0},
							 {3,5,2,0},
							 {5,3,5,5},
							 {8,6,0,5}};
		//剩余资源
		int sulplus1[] = {2,3,2,2};
		//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
//		int sum[] = new int[sulplus.length];
//		//将剩余资源添加到总资源中
//		for (int i = 0; i < sum.length; i++) {
//			sum[i] = sulplus[i];
//		}
//		//计算总资源数,纵向求和
//		for (int i = 0; i < arrayAlot1.length; i++) {
//			for (int j = 0; j < arrayAlot1[0].length; j++) {
//				sum[j] = sum[j] + arrayAlot1[i][j];  
//			}
//		}
		//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
		arrayAlot = arrayAlot1;  
		arrayNeed = arrayNeed1;
		sulplus = sulplus1;
	}

}
