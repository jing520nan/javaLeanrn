package com.java.team.service;

import org.junit.rules.DisableOnDebug;
import org.w3c.dom.css.Counter;

import com.java.team.domain.Architect;
import com.java.team.domain.Designer;
import com.java.team.domain.Employee;
import com.java.team.domain.Programmer;

public class TeamService {
	private int counter;
	private final int MAX_MEMBER = 5;
	private Programmer[] team = new Programmer[MAX_MEMBER];
	private int total = 0;

	public TeamService() {
		super();
	}

	/**
	 * 
	 * @Description 获取开发中的所有成员
	 * @author nan-jing
	 * @version
	 * @date 2022年5月11日上午9:27:01
	 */
	public Programmer[] getTeam() {
		Programmer[] newteam = new Programmer[total];
		for (int i = 0; i < newteam.length; i++) {
			newteam[i] = team[i];
		}
		return newteam;
	}

	/**
	 * 
	 * @Description 添加团队成员
	 * @author nan-jing
	 * @version
	 * @throws TeamException
	 *             自定义异常类
	 * @date 2022年5月11日上午9:31:01
	 */
	public void addMember(Employee e) throws TeamException {
		if (total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
		if (!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		if (isExist(e)) {
			throw new TeamException("该成员已经在团队中，无法添加");
		}
		Programmer p = (Programmer) (e);
		if ("BUSY".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员工忙碌");
		} else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
			throw new TeamException("员工正在休假，无法添加");
		}
		int numberOfArch = 0, numberOfDes = 0, numOfPro = 0;
		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect) {
				numberOfArch++;
			} else if (team[i] instanceof Designer) {
				numberOfDes++;
			} else if (team[i] instanceof Programmer) {
				numOfPro++;
			}
		}
		if (p instanceof Architect) {
			if (numberOfArch >= 1) {
				throw new TeamException("队伍中已经存在一个架构师，无法添加");
			}
		} else if (p instanceof Designer) {
			if (numberOfDes >= 2) {
				throw new TeamException("队伍中已经存在两个设计师，无法添加");
			}
		} else if (p instanceof Programmer) {
			if (numOfPro >= 3) {
				throw new TeamException("队伍中已经存在三个程序员，无法添加");
			}
		}
		team[total] = p;
		total = total + 1;
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
	}

	/**
	 * 
	 * @Description 判断添加的成员是不是已经添加到队伍中了
	 * @author nan-jing
	 * @version
	 * @date 2022年5月11日上午9:55:36
	 */
	public boolean isExist(Employee e) {
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @Description 移除团队中的一个成员
	 * @author nan-jing
	 * @version
	 * @throws TeamException
	 * @date 2022年5月11日上午10:39:26
	 */
	public void removeMember(int memberId) throws TeamException {
		int i = 0;
		for(;i < total; i++){
			if (team[i].getMemberId() == memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		if (i == total) {
			throw new TeamException("没找到指定成员，无法删除");
		}

		for (int j = i + 1; j < total; j++) {
			team[j - 1] = team[j];
		}
		team[total - 1] = null;
		total--;
		
	}

//	/**
//	 * 
//	 * @Description 判断团队中是否存在要删除的成员
//	 * @author nan-jing
//	 * @version
//	 * @date 2022年5月11日上午10:42:33
//	 */
//	public boolean disExist(int id) {
//		for (int i = 0; i < total; i++) {
//			if (team[i].getMemberId() == id) {
//				return false;
//			}
//		}
//		return true;
//
//	}
}
