package compute;

import java.util.ArrayList;
import java.util.List;

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
		List<String> stringList = new ArrayList<String>();
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
				System.out.println("�޿ɷ�����Դ���޷����ɰ�ȫ���У�");
				return null;
			}
			//��j���з��䣨Pj+1���̣�
			for (int k = 0; k < sulplus.length; k++) {
				//����ʣ����Դ
				sulplus[k] = sulplus[k] + arrayAlot[j][k];
				//������Դ��������Ϊ���100
				arrayNeed[j][k] = 100;
				
			}
			
			System.out.println("������������������������������������������" + i +"�η��䣪����������������������������������������");
			System.out.println("�ѷ������					�������                                                   ");
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
			System.out.print("ʣ����Դ��");
			for (int k = 0; k < sulplus.length; k++)	System.out.print( "   " + (char)('A'+k) + "-"+ sulplus[k]);
			System.out.println();
			System.out.println();
			String tempString = "P" + (j + 1);
			stringList.add(tempString);
		}
		return stringList;
	}
}
