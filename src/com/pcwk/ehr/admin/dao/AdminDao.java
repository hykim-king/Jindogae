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
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pcwk.ehr.admin.vo.AdminVO;
import com.pcwk.ehr.cmn.CafeDiv;

public class AdminDao implements CafeDiv<AdminVO> {
	public static final String CAFE_DATA = ".\\data\\cafe.csv";// csv 경로 저장
	private List<AdminVO> admin = new ArrayList<AdminVO>();// 리스트 만들기
	Scanner scanner = new Scanner(System.in);
	
	public AdminDao() {
		getAdminReadFile(CAFE_DATA);//파일 읽기
	}

	private List<AdminVO> getAdminReadFile(String path) {
		try (BufferedReader reader = new BufferedReader(new FileReader(path));) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);

				String[] dataArr = line.split(",");//, 기준으로 나누기
				int no = Integer.parseInt(dataArr[0]);//첫번째를 no로 설정
				String name = dataArr[1];//두번째를 메뉴명으로 설정
				int price = Integer.parseInt(dataArr[2]);//세번째를 가격으로 설정

				AdminVO adminVO = new AdminVO(no, name, price);
				admin.add(adminVO);//vo를 호출해서 admin에 저장
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

		return admin;//csv파일 읽기

	}

	@Override
	public int doSave(AdminVO dto) {
		int result = 0;
		boolean addMore = true;

		while (addMore) {
			
			// 1. 관리자는 음료명과 가격을 등록한다.
			// 이름은 중복되면 안되며, 이미 존재하는 음료명은 등록 불가함.
			System.out.print("제품명을 입력하세요> ");
			String inputName = scanner.nextLine();
			// 이름이 중복되면 안됨.
			if (inputName.isEmpty()) {
				System.out.println("메뉴 이름은 필수입니다.");
				continue;
			}

			dto.setName(inputName); // setName음료명 저장

			int input = 0;
			while (true) {
				System.out.print("제품 가격을 입력하세요> ");
				String inputPrice = scanner.nextLine();
				try {

					input = Integer.parseInt(inputPrice);
					if (input <= 0) {
						System.out.println("가격은 0보다 커야 합니다.");
						continue;
					}
					break; // 정상 입력이면 루프 탈출
				} catch (NumberFormatException e) {
					System.out.println("가격에는 숫자만 넣으세요.");
				}
			}
			dto.setPrice(input);// setPrice가격 저장
			admin.add(dto);

			// CSV 저장
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAFE_DATA, true));
					BufferedReader reader = new BufferedReader(new FileReader(CAFE_DATA));

			) {

				int lineCount = 1;
				while (reader.readLine() != null) {
					lineCount++;
				}
				dto.setNo(lineCount);

				writer.write(String.format("%d,%s,%d\n", dto.getNo(), dto.getName(), dto.getPrice()));

			} catch (IOException e) {
				System.out.println("파일 저장 실패: " + e.getMessage());
			}

			System.out.println("메뉴가 등록되었습니다: " + dto.getName());
			result = 1;

			// 다음 메뉴 등록 여부 확인
			System.out.print("다른 메뉴를 추가하시겠습니까? (Y/N): ");
			String answer = scanner.nextLine();
			if (!answer.equalsIgnoreCase("Y")) {
				System.out.println("메뉴 등록을 종료합니다.");
				addMore = false;
			}
		}
		return result; // 등록 성공


	}

	@Override
	public List<AdminVO> doRetrieve(AdminVO dto) {

		return new ArrayList<AdminVO>(admin);//admin에 저장된 리스트 불러오기
	}

	@Override
	public int doUpdate(AdminVO dto) {
		boolean flag = false;
        List<String[]> lines = new ArrayList<>();

        // 1. 사용자 입력 받기.
        System.out.println("조회할 음료 no를 입력해주세요.");
        String inputNo = scanner.nextLine().trim();
        System.out.print("새로운 가격을 입력하세요: ");
        int inputPrice = 0;
        try {
            inputPrice = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("숫자로 입력해 주세요.");
            
        }

        // 2. 파일 읽기
        try (BufferedReader reader = new BufferedReader(new FileReader(CAFE_DATA))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                // 메뉴 이름이 일치하면 가격 수정
                if (parts.length == 3 && parts[0].trim().equals(inputNo)) {
                    parts[2] = String.valueOf(inputPrice);
                    flag = true;
                }

                // 리스트에 저장
                lines.add(parts);
            }

        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + e.getMessage());
            return 0;
        } catch (IOException e1) {
            System.out.println("파일 읽기 오류: " + e1.getMessage());
            return 0;
        }

     // 3. 변경 사항 저장
        if (flag) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAFE_DATA))) {
            	 for (String[] row : lines) {
                     // 배열을 ","로 연결하는 문자열 만들기
                     String csvLine = row[0] + "," + row[1] + "," + row[2];
                     writer.write(csvLine);
                     writer.newLine(); // 줄바꿈
                 }
                System.out.printf("음료명 : %s, 가격 : %d원%n", inputNo, inputPrice);
                System.out.println("업데이트가 완료되었습니다.");
                return 1;
            } catch (IOException e) {
                System.out.println("파일 저장 중 오류 발생: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("해당 이름의 음료를 찾을 수 없습니다.");
            return 0;
        }

	}

	@Override
	public int doDelete(AdminVO dto) {
		int beforeSize = admin.size();//beforeSize에 원래 size 저장
		
		admin.removeIf(vo -> vo.getNo()==dto.getNo());//번호기준으로 삭제
		
		if(beforeSize == admin.size()) {//원래사이즈가 beforeSize랑 같다면 삭제 x
			System.out.println("삭제 대상 없음: no = "+dto.getNo());
			return 0;
		}
		  // 삭제 후 번호 갱신
	    for (int i = 0; i < admin.size(); i++) {
	        admin.get(i).setNo(i + 1); // 번호 1부터 다시 세팅
	    }
	    
		try(PrintWriter writer = new PrintWriter(CAFE_DATA)){
			for(AdminVO vo : admin) {
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
