/**
 * Package Name : com.pcwk.ehr.member.dao <br/>
 * 파일명: MemberDao.java <br/>
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
package com.pcwk.ehr.member.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.pcwk.ehr.cmn.CafeDiv;
import com.pcwk.ehr.member.vo.MemberVO;


public class MemberDao implements CafeDiv<MemberVO> {
	
	@Override
	public int  doSave(MemberVO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> doRetrieve(MemberVO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doUpdate(MemberVO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDelete(MemberVO dto) {
		
		return 0;
	}

}
