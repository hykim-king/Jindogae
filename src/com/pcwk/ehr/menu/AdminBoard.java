/**
 * Package Name : com.pcwk.ehr.menu <br/>
 * 파일명: adminBoard.java <br/>
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
package com.pcwk.ehr.menu;

import java.util.Scanner;

import com.pcwk.ehr.admin.dao.AdminDao;
import com.pcwk.ehr.cmn.CafeDiv;

public class AdminBoard {

	public static void board() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("┌────────────────────────────────────────────────────────┐");
			System.out.println("│ ① 메뉴 조회  ② 메뉴 등록  ③ 메뉴 수정 ④ 메뉴 삭제 ⑤ 프로그램 종료     	 │");
			System.out.println("└────────────────────────────────────────────────────────┘");
			System.out.print("어떤 프로그램을 할 지 선택하세요>");
			int search = scanner.nextInt();
			AdminDao i = new AdminDao();
			switch (search) {
			case 1:
				i.doRetrieve(null);
				break;
			case 2:
				i.doSave(null);
				break;
			case 3:
				i.doUpdate(null);
				break;
			case 4:
				i.doDelete(null);
				break;
			case 5:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("입력 오류 입니다.");
				System.out.println("다시 입력해 주세요.");

			}
		}
	}
}
