package main;

import java.util.List;

import compute.NeedList;

/**
 * ������
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
		System.out.println("��ȫ����Ϊ��");
		for (String string : safeList) {
			System.out.print(string + " --> ");
		}
	}
	
	/**
	 * ��ʼ��
	 */
	private static void init() {
		/*
		 * �ѷ������			 		 * �������  				   	 * ��������
		 * 			A  B  C  D		 * 			A  B  C  D		 * 			A  B  C  D					
		 *  P1		2  0  1  1		 *  P1		1  1  2  0 		 *  P1		3  1  3  1 
		 * 	P2		7  2  0  0		 * 	P2		4  0  2  0		 * 	P2		11 2  2  0
		 * 	P3		5  2  0  3		 * 	P3		3  5  2  0		 * 	P3		8  7  2  3
		 * 	P4		2  5  5  3		 * 	P4		5  3  5  5		 * 	P4		7  8  10 8
		 * 	P5		0  5  8  6		 * 	P5		8  6  0  5 		 * 	P5		8  11 8  11 
		 * 
		 * 		��Դʣ�ࣺ		��Դ������	
		 * A�� 	  2		      18
		 * B��	  3			  17
		 * C��	  2			  16
		 * D:	  2			  15
		 * 
		 * ��ȫ���У�	P1 --> P2 --> P3 --> P5 --> P4
		 * 	P1		4  3  3  3		
		 * 	P2		11 5  3  3
		 * 	P3		16 7  3  6
		 * 	P5		16 12 11 12
		 * 	P4		18 17 16 15
		 * 	
		 * ��һ�μ�⣺	2 3 2 2 
		 * P1
		 * �ڶ��μ�⣺4 3 3 3
		 * P2
		 * �����μ�⣺11 5 3 3
		 * P3
		 * ���Ĵμ�⣺16 7 3 6
		 * P5
		 * ����μ�⣺18 12 11 12
		 * P4
		 * ���ʣ�ࣺ  18 17 16 15
		 * 
		 * ��1����ȡ��������һ�����飨�ѷ�������������ʣ����Դ���飩
		 * ��2��������������ж��Ƿ������������Ľ��̣�����ÿ��ʣ����Դ�������ڣ������裩
		 * ��3������������㣬���������Ϣ��������ϻ����쳣��������8��
		 * ��4����������򽫽��̱�Ŵ���һ�����飬
		 * 
		 * ��5������ִ����ϣ�ʣ����������ѷ�������ĳһ�У���ִ�н��̶�Ӧ��һ�У�
		 * ��6��ͬʱ�����������Ϊ100����󣬼��޷����㣩
		 * ��7������2��
		 * ��8������������У��˳�
		 */
		//�ѷ������
		int arrayAlot1[][] = {{2,0,1,1},
							 {7,2,0,0},
							 {5,2,0,3},
							 {2,5,5,3},
							 {0,5,8,6}};
		//���������
		int arrayNeed1[][] = {{1,1,2,0},
							 {4,0,2,0},
							 {3,5,2,0},
							 {5,3,5,5},
							 {8,6,0,5}};
		//ʣ����Դ
		int sulplus1[] = {2,3,2,2};
		//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
//		int sum[] = new int[sulplus.length];
//		//��ʣ����Դ��ӵ�����Դ��
//		for (int i = 0; i < sum.length; i++) {
//			sum[i] = sulplus[i];
//		}
//		//��������Դ��,�������
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
