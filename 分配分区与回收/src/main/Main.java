package main;

import java.util.ArrayList;
import java.util.List;

import mode.Mode;

import compute.FF;
import compute.MF;
import compute.Root;

public class Main {

	public static int SUMSIZE = 512;				//�ڴ��ܴ�С
	public static List<Mode> testList = new ArrayList<Mode>();	//�ڴ�������
	public static List<Mode> freeList = new ArrayList<Mode>();	//���з���
	static int[] arrayNeed = {1300,1100,300,1150,1030,1040,1060,30};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * ��βΪ��־λ�������������뻹���ͷ�
		 * 0---------�ͷ�
		 * 1---------����
		 * 
		 */
		
		//��ʼ�����з�����
		Mode mode = new Mode(1, SUMSIZE, 0);
		freeList.add(mode);
		
//		Root test = new FF();
		Root test = new MF();
		System.out.println("���������������������������������������� ��ʼ״̬������������������������������������������");
		myPrint();
		
		for (int i = 0; i < arrayNeed.length; i++) {
//			System.out.println();
//			System.out.println();
			
			if (arrayNeed[i] > 1000){	//�����ڴ��
				System.out.println("����������������������������������������  ����"+ (arrayNeed[i]-1000) +"������������������������������������������");
				test.request(testList,freeList,arrayNeed[i]-1000);
			}
			else{ //�ͷ��ڴ�
				System.out.println("����������������������������������������  �ͷ�"+ arrayNeed[i] +"������������������������������������������");
				test.release(testList,freeList, arrayNeed[i]);
			}
			myPrint();
		}
		
	}
	public static void myPrint(){
//		System.out.println();
		System.out.println("���������������������з���������������������");
//		System.out.println();
		   System.out.println("|  ��ʼ��ַ   |   ��С       |");
		for (Mode tempMode : freeList) {
			System.out.printf("|  %5d  |  %5d  |",tempMode.getStartId(),tempMode.getSize() );
		    System.out.println();
		}
//		System.out.println();
		System.out.println("�������������������ѷ������������������������");
//		System.out.println();
		 System.out.println("|  ��ʼ��ַ   |   ��С       |");
		for (Mode tempMode : testList) {
			System.out.printf("|  %5d  |  %5d  |",tempMode.getStartId(),tempMode.getSize() );
			System.out.println();
		}
	}
	

}










