/**
 * Package Name : com.pcwk.ehr.menu <br/>
 * 파일명: MainBoard.java <br/>
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

import com.pcwk.ehr.cmn.Login;


/**
 * 
 */
public class MainBoard {
	public static void Board() {

		System.out.println("고객 모드에 오신걸 환영합니다!");
		System.out.println("🦮🐾 진돗개 카페에 오신걸 환영합니다! 🐾🦮");
		System.out.println("🍽️ 메뉴판: 🍽️");

		System.out.println("☕ 커피:");
		System.out.println("  - 아메리카노: $3.00");
		System.out.println("  - 라떼: $4.00");
		System.out.println("  - 카푸치노: $4.50");
		System.out.println("  - 모카: $4.50");

		System.out.println("🥤 음료:");
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
			System.out.println("┌────────────────────────────────────────────┐");
			System.out.println("│ ① 관리자 모드  ② 고객 모드   ③ 프로그램 종료      	     │");
			System.out.println("└────────────────────────────────────────────┘");
			System.out.print("모드를 선택하세요>");
			Login search = new Login();
			Menu menu = new Menu();
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				search.Login();//로그인으로 이동
				break;
			case 2:
				menu.MenuBoard();//메뉴판으로 이동
				break;
			case 3://프로그램 종료
				System.out.println("프로그램 종료");
				return;
			default://위 값 제외 입력시 다시 입력
				System.out.println("잘못 입력했습니다.");
				System.out.println("다시 입력해 주세요.");
			}

		}

	}


}


