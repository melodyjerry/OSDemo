package compute;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * �������м��㷨��⣬�������
 * @author ֣˼��
 *
 */
public class NeedList {
	
	public NeedList() {
	}
	/**
	 * ��ð�ȫ����
	 * @param arrayAlot	�ѷ������	
	 * @param arrayNeed	�������
	 * @param sulplus	ʣ����Դ
	 * @return
	 */
	public List<String> getSafeList(int arrayAlot[][],int arrayNeed[][],int sulplus[]){
		List<String> stringList = new ArrayList<String>();//��ȫ����
		boolean testAlot = false;//�ж��Ƿ�������	Ĭ��Ϊ��ȫ
		initPrint(arrayAlot,arrayNeed,sulplus);
		
		//* * * * * * * * * * * * * * * * * * * �����㷨 * * * * *  * * * * * * * * * * * * * * * * * 
 		//���������ܼ���
		for (int i = 0; i < arrayAlot.length; i++) {
			//����Ƿ�ִ������
			System.out.print("�Ƿ���Ҫִ������[1/0]��");
			Scanner in = new Scanner(System.in);
			String order = in.nextLine();
			while(!order.equals("1") && !order.equals("0")){
				System.out.print("ָ������������룬�Ƿ���Ҫִ������[1/0]��");
				order = in.next();
			}
			
			if (order.equals("1")){
				int[] request = isRequest(arrayAlot,arrayNeed,sulplus,stringList);
				if (request != null){ 	//���Ո����Է���
					System.out.println("������ȫ��������䣡");
					for (int n = 0; n < 4; n++)  sulplus[n]= sulplus[n] - request[n];//����
				}
			}
			
			testAlot = false;	//���ð�ȫ
			//ѡ����н��̽��з���
			int j = 0;
			int t = 0;
			for (j = 0; j < arrayNeed.length; j++) {
				
				for (t = 0; t < arrayNeed[0].length; t++)
					if (testAlot = (sulplus[t] < arrayNeed[j][t])) 
						//�൱�� sulplus[t] - arrayNeed[j][t] < 0
						//testAlot Ϊ�Ƿ�ȫ���������if�����Ĳ���ȫ
						break;	//�����������������������	testAlotΪtrue
				
				if (!testAlot)
					break;	//��������������������з���
			}
			if (testAlot) {	//û�п��Է����	����ȫ
				System.out.println("* ������ϣ� *");
				return stringList;
			}
			//��j���з��䣨Pj+1���̣�
			for (int k = 0; k < sulplus.length; k++) {
				//����ʣ����Դ
				sulplus[k] = sulplus[k] + arrayAlot[j][k];
				//������Դ��������Ϊ���100
				arrayNeed[j][k] = 100;
			}
			initPrint(arrayAlot,arrayNeed,sulplus);
			String tempString = "P" + (j + 1);
			stringList.add(tempString);
		}
		return stringList;
	}
	/**
	 * ����������
	 * @param arrayAlot
	 * @param arrayNeed
	 * @param sulplus
	 */
	private void initPrint(int[][] arrayAlot, int[][] arrayNeed, int[] sulplus) {
		System.out.println("���������������������������������������� ��ǰ������� ������������������������������������������");
		System.out.println("�������                                                   			�ѷ������						");
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
		System.out.print("ʣ����Դ��");
		for (int k = 0; k < sulplus.length; k++)	System.out.print( "   " + (char)('A'+k) + "-"+ sulplus[k]);
		System.out.println();
		System.out.println();
	}
	/**
	 * ִ��ÿ�η��������,������Ƿ��䣬����ӡ���а�ȫ����
	 */
	private int[] isRequest(int arrayAlot[][],int arrayNeed[][],int sulplus[],List<String> strings) {
		
		Scanner in = new Scanner(System.in);
		int n = 100;
		int request[] = new int[4];
		while(n <= 0 || n >= arrayAlot.length){
			System.out.print("��������Ҫ������̣���P1����������1  ��");
			n = in.nextInt();
		}
		System.out.print("�������������У��� 1 0 2 0���� P"+n+"������Ҫ����[A-1��B-0��C-2��D-0]:");
		for (int i = 0; i < 4; i++) {
			request[i] = in.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			sulplus[i] = sulplus[i] - request[i];	//ԇ����
			arrayNeed[n-1][i] = arrayNeed[n-1][i] - request[i];
			if (arrayNeed[n-1][i] < 0) 
				System.out.println("�������󳬳�ԭ������!");
			System.out.println(sulplus[i] + "  " + arrayNeed[n-1][i]);
		}
		
		boolean testAlot = false;//�ж��Ƿ�������	Ĭ��Ϊ��ȫ
		//���������ܼ���
		for (int i = 0; i < arrayAlot.length; i++) {
			testAlot = false;	//���ð�ȫ
			//ѡ����н��̽��з���
			int j = 0;
			int t = 0;
			for (j = 0; j < arrayNeed.length; j++) {
				
				for (t = 0; t < arrayNeed[0].length; t++)
					if (testAlot = (sulplus[t] < arrayNeed[j][t])) 
						//�൱�� sulplus[t] - arrayNeed[j][t] < 0
						//testAlot Ϊ�Ƿ�ȫ���������if�����Ĳ���ȫ
						break;	//�����������������������	testAlotΪtrue
				
				if (!testAlot)
					break;	//��������������������з���
			}
			if (testAlot) {	//û�п��Է����	����ȫ
				System.out.println("* �Է�����ϣ� *");
				return request;
			}
			//��j���з��䣨Pj+1���̣�
			for (int k = 0; k < sulplus.length; k++) {
				//����ʣ����Դ
				sulplus[k] = sulplus[k] + arrayAlot[j][k];
				//������Դ��������Ϊ���100
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
