package main;

import java.util.ArrayList;
import java.util.List;

import mode.Mode;

import compute.FF;
import compute.MF;
import compute.Root;

public class Main {

	public static int SUMSIZE = 512;				//内存总大小
	public static List<Mode> testList = new ArrayList<Mode>();	//内存分配情况
	public static List<Mode> freeList = new ArrayList<Mode>();	//空闲分区
	static int[] arrayNeed = {1300,1100,300,1150,1030,1040,1060,30};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 首尾为标志位用于区别是申请还是释放
		 * 0---------释放
		 * 1---------申请
		 * 
		 */
		
		//初始化空闲分区列
		Mode mode = new Mode(1, SUMSIZE, 0);
		freeList.add(mode);
		
//		Root test = new FF();
		Root test = new MF();
		System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ 初始状态　＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
		myPrint();
		
		for (int i = 0; i < arrayNeed.length; i++) {
//			System.out.println();
//			System.out.println();
			
			if (arrayNeed[i] > 1000){	//申请内存的
				System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝  分配"+ (arrayNeed[i]-1000) +"　＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
				test.request(testList,freeList,arrayNeed[i]-1000);
			}
			else{ //释放内存
				System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝  释放"+ arrayNeed[i] +"　＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
				test.release(testList,freeList, arrayNeed[i]);
			}
			myPrint();
		}
		
	}
	public static void myPrint(){
//		System.out.println();
		System.out.println("＊＊＊＊＊＊＊＊　空闲分区　＊＊＊＊＊＊＊＊");
//		System.out.println();
		   System.out.println("|  起始地址   |   大小       |");
		for (Mode tempMode : freeList) {
			System.out.printf("|  %5d  |  %5d  |",tempMode.getStartId(),tempMode.getSize() );
		    System.out.println();
		}
//		System.out.println();
		System.out.println("＊＊＊＊＊＊＊＊　已分配分区　＊＊＊＊＊＊＊＊");
//		System.out.println();
		 System.out.println("|  起始地址   |   大小       |");
		for (Mode tempMode : testList) {
			System.out.printf("|  %5d  |  %5d  |",tempMode.getStartId(),tempMode.getSize() );
			System.out.println();
		}
	}
	

}










