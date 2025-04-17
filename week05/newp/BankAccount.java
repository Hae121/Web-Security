package week05.newp;

public class BankAccount {
	private String owner; // 계좌주 이름
	private int balance; // 은행잔고

	public BankAccount() {
		this.owner = "모름";
		this.balance = -1;

	}

	public BankAccount(String owner, int balance) {
		this.owner = owner;
		this.balance = balance;
	}

	public String toString() {
		String rslt= "\t";
		rslt+= owner +"\t";
		rslt+= balance +"\t";
		return rslt;
	}
	
	public void setOwner(String owner){
		this.owner=owner;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getOwner() {
		return owner;
	}
	public String getBalance() {
		return owner;
	}
	public void deposit(int m) {
		this.balance -= m;
	}
	public void withdraw(int m) {
		this.balance += m;
	}
}
