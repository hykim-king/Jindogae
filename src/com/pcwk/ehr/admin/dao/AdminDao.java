/**
 * Package Name : com.pcwk.ehr.admin.dao <br/>
 * 파일명: AdminDao.java <br/>
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
package com.pcwk.ehr.admin.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.pcwk.ehr.admin.vo.AdminVO;
import com.pcwk.ehr.cmn.CafeDiv;

public class AdminDao implements CafeDiv<AdminVO> {
	public static final String CAFE_DATA = ".\\data\\cafe.csv";// CSV파일 읽는 과정
	private List<AdminVO> admin = new ArrayList<AdminVO>();

	public AdminDao() {
		getAdminReadFile(CAFE_DATA);
	}

	private List<AdminVO> getAdminReadFile(String path) {
		try (BufferedReader reader = new BufferedReader(new FileReader(path));) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);

				String[] dataArr = line.split(",");//,기준으로 정렬
				int no = Integer.parseInt(dataArr[0]);	 //첫 번째 NO로 설정
				String name = dataArr[1];			  	 //두 번째 NAME으로 설정
				int price = Integer.parseInt(dataArr[2]);//세 번째 PRICE로 설정

				AdminVO adminVO = new AdminVO(no, name, price);
				admin.add(adminVO);//화면 출력
			}
//			System.out.println("추가 확인");
//			for (AdminVO vo : admin) {
//				System.out.println(vo);
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return admin;

	}

	@Override
	public int doSave(AdminVO dto) {

		return 0;
	}

	@Override
	public List<AdminVO> doRetrieve(AdminVO dto) {

		return new ArrayList<AdminVO>(admin);//admin에 들어있는 리스트 불러와 읽기
	}

	@Override
	public int doUpdate(AdminVO dto) {

		return 0;
	}

	@Override
	public int doDelete(AdminVO dto) {
		int beforeSize = admin.size();//beforeSize 변수에 admin.size() 값 저장
		
		admin.removeIf(vo -> vo.getNo()==dto.getNo());//NO 기준으로 삭제
		
		if(beforeSize == admin.size()) {//삭제할 것이 없을 때
			System.out.println("삭제 대상 없음: no = "+dto.getNo());
			return 0;
		}
		
		try(PrintWriter writer = new PrintWriter(CAFE_DATA)){
			for(AdminVO vo : admin) {//삭제한 후 리스트에서 변수값 다시 받아서 다시 정렬
				writer.println(vo.getNo()+"," + vo.getName()+","+ vo.getPrice()+",");
			}
		} catch (IOException e) {		
			e.printStackTrace();
			return 0;
		}
		System.out.println("삭제 완료: no=" +dto.getNo());
		return 1;
	}
	
	

}
