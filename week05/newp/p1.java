package week05.newp;
import java.util.Scanner;

public class p1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		BankAccount[] bArray = new BankAccount[3];

		System.out.print("계좌 정보를 입력하세요: ");
		bArray[0] = new BankAccount(sc.next(), sc.nextInt());
		System.out.print("계좌 정보를 입력하세요: ");
		bArray[1] = new BankAccount(sc.next(), sc.nextInt());
		System.out.print("계좌 정보를 입력하세요: ");
		bArray[2] = new BankAccount(sc.next(), sc.nextInt());

		while (true) {
			printAccounts(bArray);
			System.out.print("업데이트 할 계좌번호를 입력하세요 (종료-0): ");
			int process = sc.nextInt();
			if (process == 0) {
				sc.close();
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
			}
			int accountNum = process - 1;

			System.out.print("원하는 작업은 선택하세요 (1-입금/2-출금): ");
			int bNum = sc.nextInt();

			switch (bNum) {
			case (1):
				System.out.print("입금액을 입력하세요: ");
				int dMoney = sc.nextInt();
				bArray[accountNum].deposit(dMoney);
				System.out.println("입금이 완료되었습니다.");
				break;

			case (2):
				System.out.print("출금액을 입력하세요: ");
				int wMoney = sc.nextInt();
				bArray[accountNum].withdraw(wMoney);
				System.out.println("출금이 완료되었습니다.");
				break;

			default:
				break;
			}

		}

	}

	private static void printAccounts(BankAccount[] bArray) {
		// TODO Auto-generated method stub
		System.out.println("현재 잔고현황입니다.");
		System.out.println("계좌번호\t계좌주\t잔고\t");
		for (int i = 0; i < bArray.length; i++) {
			System.out.print(i + 1);
			System.out.print(bArray[i] + "\n");
		}
	}
}
