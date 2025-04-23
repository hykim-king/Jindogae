/**
 * Package Name : com.pcwk.ehr.menu <br/>
 * 파일명: Menu.java <br/>
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
import com.pcwk.ehr.member.dao.MemberDao;
import com.pcwk.ehr.member.vo.MemberVO;

public class Menu {
	
	public static void MenuBoard() {
		AdminDao dao = new AdminDao();
		MemberDao i = new MemberDao();
		
		System.out.println("고객 모드에 오신걸 환영합니다!");
		System.out.println("🦮🐾 진돗개 카페에 오신걸 환영합니다! 🐾🦮");
		System.out.println("🍽️ 메뉴판: 🍽️");

		System.out.println("☕ 커피:");
		System.out.println("  - 아메리카노: $3.00");
		System.out.println("  - 라떼: $4.00");
		System.out.println("  - 카푸치노: $4.50");
		System.out.println("  - 모카: $4.50");

		System.out.println("🥤 음료s:");
		System.out.println("  - 아이스티: $2.50");
		System.out.println("  - 레모네이드: $3.00");
		System.out.println("  - 스무디: $4.00");

		System.out.println("🍰 디저트:");
		System.out.println("  - 쿠키: $3.50");
		System.out.println("  - 치즈케이크: $4.00");
		System.out.println("  - 티라미수: $4.50");

		System.out.println("🍨 아이스크림:");
		System.out.println("  - 바닐라: $2.50");
		System.out.println("  - 초코: $2.50");
		System.out.println("  - 딸기: $2.50");

		System.out.println("🐾 진돗개 카페에 와주셔서 감사합니다! 🐾");

		
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("┌────────────────────────────────────────┐");
			System.out.println("│ ① 메뉴 선택  ② 메뉴 삭제  ③ 프로그램 종료	         │");
			System.out.println("└────────────────────────────────────────┘");
			System.out.print("어떤 프로그램을 할 지 선택하세요>");
			int select = scanner.nextInt();
			switch (select) {
			case 1: // 메뉴선택
				while (true) {
					System.out.println("===== 고객 메뉴 선택 =====");

					MemberVO vo = new MemberVO();
					int result = i.doSave(vo);

					if (result == 1) {
						System.out.println("메뉴가 성공적으로 등록되었습니다.");
					} else {
						System.out.println("메뉴 등록에 실패했습니다.");
					}
					break;
				}
				break;
			case 2: // 메뉴삭제
			case 3:
				System.out.println("프로그램 종료!");
				return;

			default: 
				System.out.println("다시 선택해주세요.");

			}
		}
	}

}


