package exception.custom;

public class MainClass {

	public static void main(String[] args) {
		Account acc = new Account();
		acc.deposit(10000);
		System.out.println(new StringBuffer("입금후 잔액 : ").append(acc.getBalance()).append("원"));
	try {
		acc.withdraw(100000);
	}catch (BalanceInsufficientException e) {
		/*
		 * 예외 클래스가 제공하는 getMessage() 메서드는
		 * 예외의 원인 메시지를 String 타입으로 리턴합니다.
		 * 자바 표준 API에서 제공하는 다양한 예외클래스들은
		 * 각각의 예외 원인 메시지가 기본적으로 객체 안에
		 * 저장되어 있습니다. 
		 */
	System.err.println(e.getMessage());
	} catch(DepositMinusMoneyException e) {
		System.err.println(e.getMessage());
	}
	System.out.println(new StringBuffer("출금 후 잔액 : ").append(acc.getBalance()).append("원"));
	
	}
}
