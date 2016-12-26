package xatu.zsl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * 进程调度
 * @author 郑思林
 */
public class Main {
	static List<PCB> listPCB;
	static List<PCB> recordPCB;
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		listPCB = new ArrayList<PCB>();
		//输入
		input();
		output(listPCB);
		//时间片调度
//		timePcb();
		//输出
//		优先级调度
//		priorityPcb();
//		短作业优先
		shortPcb();
//		output(recordPCB);
	}

	/**
	 * 短作业调度算法测试
	 */
	private static void shortPcb() {
		System.out.println("**********短作业优先*************");
		recordPCB = listPCB;
		int time = 0;
		while(judge()){
			int i = getShortTime();
			time = time + recordPCB.get(i).getNeedTime();
			System.out.println("#############当前时间为 ： " + time +"#################");
			PCB tempPcb = recordPCB.get(i);
			tempPcb.setNeedTime(0);
			tempPcb.setIsRunning(2);
			recordPCB.remove(i);
			recordPCB.add(i, tempPcb);
			output(recordPCB);
		}		
	}
	
	/**
	 * 得到最短的时间
	 * @return
	 */
	private static int getShortTime() {
		int shortTime = 0;
		int shot = 1000;//***假设100位最大数
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
	 * 时间片调度算法测试
	 */
	private static void timePcb() {
		System.out.println("**********时间片调度*************");
		System.out.println("请输入时间片轮转时间");
		int TIME = in.nextInt();
		recordPCB = listPCB;
		//输入信息格式： A（名称） 1（需要时间） 2（优先级)
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
	 * 优先级调度算法测试
	 */
	private static void priorityPcb(){
		System.out.println("**********优先级*************");
		recordPCB = listPCB;
		int time = 0;
		while(judge()){
			int i = getMaxPriority();
			time = time + recordPCB.get(i).getNeedTime();
			System.out.println("#################当前时间为 ： " + time +"#################");
			PCB tempPcb = recordPCB.get(i);
			tempPcb.setNeedTime(0);
			tempPcb.setIsRunning(2);
			recordPCB.remove(i);
			recordPCB.add(i, tempPcb);
			output(recordPCB);
		}
	}
	
	/**
	 * 返回一个当前未运行的最大优先进程
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
	 * 初始化，给运行状态赋值为0
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
	 * 判断当前进程中是否执行完毕
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
	 * 输出信息
	 */
	private static void output(List<PCB> listPCB) {
		System.out.println("名称        需要时间           优先级          状态");
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
	 * 输入进程信息
	 */
	private static void input() {
		
		//输入信息格式： A 1 2 3
		//名称  提交时间  需要时间 优先级
		System.out.println("输入信息格式： A（名称） 1（需要时间） 2（优先级)");
		
		for(int i = 0;i < 5;i++){
			PCB tempPCB = new PCB();
			String tempLing = in.nextLine();
			//获取输入一行信息，通过空格进行切分
			String[] tempStr = tempLing.split(" ");
			//讲切分的赋给每个Proces对象
			tempPCB.setName(tempStr[0]);
	//		tempPCB.setArrowTime(Integer.parseInt(tempStr[1]));
			tempPCB.setNeedTime(Integer.parseInt(tempStr[1]));
			tempPCB.setPriority(Integer.parseInt(tempStr[2]));
			
			//将其添加到集合中
			listPCB.add(tempPCB);
		}
		
	}
}


















