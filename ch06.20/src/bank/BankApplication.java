package bank;

import java.util.Scanner;

public class BankApplication {
	
	static Scanner sc = new Scanner(System.in);
	private static Account[] accounts = new Account[100];

	public static void main(String[] args) {
		
		boolean run = true;
		
		while(run) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("1. ���»��� | 2. ���¸�� | 3. ���� | 4. ��� | 5. ����");
			System.out.println("----------------------------------------------------------------");
			System.out.print("�޴� ���� > ");
			
			String menu = sc.nextLine();
			if ( menu.equals("1") ) {
				createAccount();
			} else if ( menu.equals("2") ){
				accountList();
			}else if ( menu.equals("3") ){
				inputMoney();
			}else if ( menu.equals("4") ){
				outMoney();
			}else if ( menu.equals("5") ){
				run = false;
				System.out.println( "���α׷��� ����Ǿ����ϴ�." );
				break;
			} else {
				System.out.println( "�޴� �Է��� �߸��Ǿ����ϴ�.\n�ٽ� �Է����ּ���." );
			}
		
		}
	} //main
	
	private static void createAccount() {
		System.out.println("------------------");
		System.out.println("      ���»���");
		System.out.println("------------------");
		
		System.out.print("���¹�ȣ: ");
		String num = sc.nextLine();
		System.out.print("������: ");
		String owner = sc.nextLine();
		System.out.print("�ʱ��Աݾ�: ");
		int firstMoney = Integer.parseInt(sc.nextLine());
		
		Account newAccount = new Account(num, owner, firstMoney);
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				accounts[i] = newAccount;
				System.out.println("���: ���°� �����Ǿ����ϴ�.");
				break;
			}
		}
	}
	
	private static void accountList() {
		System.out.println("-------------------");
		System.out.println("      ���� ���");
		System.out.println("-------------------");
		
		for(int i=0; i<accounts.length; i++) {
			Account account = accounts[i];
			if(account != null) {
				System.out.print("���¹�ȣ: ");
				System.out.print(account.getAccountNumber());
				System.out.print(" / ������: ");
				System.out.print(account.getOwner());
				System.out.print(" / �� ���ݾ�: ");
				System.out.print(account.getMoney());
				System.out.println();
			} else  {
				System.out.println("������ ���°� �����ϴ�.");
				break;
			}
		}
	}
	
	private static void inputMoney() {
		System.out.println("-------------------");
		System.out.println("      �Ա�");
		System.out.println("-------------------");
		
		System.out.print("���¹�ȣ: ");
		String num = sc.nextLine();
		System.out.print("���ݾ�: ");
		int money = Integer.parseInt(sc.nextLine());
		
		Account account = findAccount(num);
		if(account == null) {
			System.out.println("���: �ش��ϴ� ���°� �����ϴ�.");
			return;
		}
		account.setMoney(account.getMoney() + money);
		System.out.println("���: ������ �����Ǿ����ϴ�.");

	}
	
	private static void outMoney() {
		System.out.println("-------------------");
		System.out.println("      ���");
		System.out.println("-------------------");
		
		System.out.print("���¹�ȣ: ");
		String num = sc.nextLine();
		System.out.print("��ݾ�: ");
		int money = Integer.parseInt(sc.nextLine());
		
		Account account = findAccount(num);
		if(account == null) {
			System.out.println("���: �ش��ϴ� ���°� �����ϴ�.");
			return;
		}
		account.setMoney(account.getMoney() - money);
		System.out.println("���: ����� �����Ǿ����ϴ�.");

	}
	
	private static Account findAccount (String accountNumber){
		Account account = null;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				String accountList = accounts[i].getAccountNumber();
				if (accountList.equals(accountNumber)) {
					account = accounts[i];
					break;
				}
			}
		}
		return account;
	}
	

}
