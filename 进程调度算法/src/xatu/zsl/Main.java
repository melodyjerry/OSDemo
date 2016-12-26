package xatu.zsl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * ���̵���
 * @author ֣˼��
 */
public class Main {
	static List<PCB> listPCB;
	static List<PCB> recordPCB;
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		listPCB = new ArrayList<PCB>();
		//����
		input();
		output(listPCB);
		//ʱ��Ƭ����
//		timePcb();
		//���
//		���ȼ�����
//		priorityPcb();
//		����ҵ����
		shortPcb();
//		output(recordPCB);
	}

	/**
	 * ����ҵ�����㷨����
	 */
	private static void shortPcb() {
		System.out.println("**********����ҵ����*************");
		recordPCB = listPCB;
		int time = 0;
		while(judge()){
			int i = getShortTime();
			time = time + recordPCB.get(i).getNeedTime();
			System.out.println("#############��ǰʱ��Ϊ �� " + time +"#################");
			PCB tempPcb = recordPCB.get(i);
			tempPcb.setNeedTime(0);
			tempPcb.setIsRunning(2);
			recordPCB.remove(i);
			recordPCB.add(i, tempPcb);
			output(recordPCB);
		}		
	}
	
	/**
	 * �õ���̵�ʱ��
	 * @return
	 */
	private static int getShortTime() {
		int shortTime = 0;
		int shot = 1000;//***����100λ�����
		int i = 0;
		for (PCB pcb : listPCB) {
			if (pcb.getNeedTime() > 0) {
				if (pcb.getPriority() < shot) {
					shot = pcb.getPriority();
					shortTime = i;
				}
			}
			i++;
		}
		return shortTime;
	}

	/**
	 * ʱ��Ƭ�����㷨����
	 */
	private static void timePcb() {
		System.out.println("**********ʱ��Ƭ����*************");
		System.out.println("������ʱ��Ƭ��תʱ��");
		int TIME = in.nextInt();
		recordPCB = listPCB;
		//������Ϣ��ʽ�� A�����ƣ� 1����Ҫʱ�䣩 2�����ȼ�)
		int time = 0;
		int i = 0;
		while(judge()){
			while(recordPCB.get(i%(recordPCB.size())).getNeedTime() == 0){
				i++;
				i = i%recordPCB.size();
			}
			PCB tempPcb = recordPCB.get(i);
			tempPcb.setNeedTime(tempPcb.getNeedTime()-TIME);
			tempPcb.setIsRunning(1);
			recordPCB.remove(i);
			recordPCB.add(i, tempPcb);
			i++;
			time+=TIME;
			initPCBIsRunning();
			output(recordPCB);
		}
	}

	/**
	 * ���ȼ������㷨����
	 */
	private static void priorityPcb(){
		System.out.println("**********���ȼ�*************");
		recordPCB = listPCB;
		int time = 0;
		while(judge()){
			int i = getMaxPriority();
			time = time + recordPCB.get(i).getNeedTime();
			System.out.println("#################��ǰʱ��Ϊ �� " + time +"#################");
			PCB tempPcb = recordPCB.get(i);
			tempPcb.setNeedTime(0);
			tempPcb.setIsRunning(2);
			recordPCB.remove(i);
			recordPCB.add(i, tempPcb);
			output(recordPCB);
		}
	}
	
	/**
	 * ����һ����ǰδ���е�������Ƚ���
	 * @return
	 */
	private static int getMaxPriority() {
		int max = 0;
		int maxPriority = 0;
		int i = 0;
		for (PCB pcb : listPCB) {
			if (pcb.getNeedTime() > 0) {
				if (pcb.getPriority() > maxPriority) {
					maxPriority = pcb.getPriority();
					max = i;
				}
			}
			i++;
		}
		return max;
	}

	/**
	 * ��ʼ����������״̬��ֵΪ0
	 */
	private static void initPCBIsRunning() {
		for (PCB tempPcb : listPCB) {
			if (tempPcb.getNeedTime() <= 0) {
				tempPcb.setIsRunning(2);
			}else{
				tempPcb.setIsRunning(0);
			}
			
		}
	}

	/**
	 * �жϵ�ǰ�������Ƿ�ִ�����
	 * @return
	 */
	private static boolean judge() {
		for (PCB tempPcb : recordPCB) {
			if (tempPcb.getNeedTime() > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �����Ϣ
	 */
	private static void output(List<PCB> listPCB) {
		System.out.println("����        ��Ҫʱ��           ���ȼ�          ״̬");
		for (PCB pcb : listPCB) {
			System.out.println(" " + pcb.getName()+"      " +pcb.getNeedTime()+  "        " +pcb.getPriority() +"      "+ getIsRunning(pcb));
		}
	}

	private static String getIsRunning(PCB pcb) {
		if (pcb.getIsRunning() == 1) {
			return "RUNNING";
		}else if(pcb.getIsRunning() == 2){
			return "FINISH";
		}
		else {
			return "NO RUNNING";
		}
	}

	/**
	 * ���������Ϣ
	 */
	private static void input() {
		
		//������Ϣ��ʽ�� A 1 2 3
		//����  �ύʱ��  ��Ҫʱ�� ���ȼ�
		System.out.println("������Ϣ��ʽ�� A�����ƣ� 1����Ҫʱ�䣩 2�����ȼ�)");
		
		for(int i = 0;i < 5;i++){
			PCB tempPCB = new PCB();
			String tempLing = in.nextLine();
			//��ȡ����һ����Ϣ��ͨ���ո�����з�
			String[] tempStr = tempLing.split(" ");
			//���зֵĸ���ÿ��Proces����
			tempPCB.setName(tempStr[0]);
	//		tempPCB.setArrowTime(Integer.parseInt(tempStr[1]));
			tempPCB.setNeedTime(Integer.parseInt(tempStr[1]));
			tempPCB.setPriority(Integer.parseInt(tempStr[2]));
			
			//������ӵ�������
			listPCB.add(tempPCB);
		}
		
	}
}


















