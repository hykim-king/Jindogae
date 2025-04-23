/**
 * Package Name : com.pcwk.ehr.member.vo <br/>
 * 파일명: memberVO.java <br/>
 * Description:  <br/>
 * Modification imformation : <br/> 
 * ------------------------------------------<br/>
 * 최초 생성일 : 2025-04-22<br/>
 *
 * ------------------------------------------<br/>
 * @author :user
 * @since  :2024-09-09
 * @version: 0.5
 */
package com.pcwk.ehr.member.vo;

public class MemberVO {
	private int NO;
	private String name;
	private int price;
	private int amount;

	public int getNO() {
		return NO;
	}
	public void setNO(int nO) {
		NO = nO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "MemberVO [NO=" + NO + ", name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
	

}
