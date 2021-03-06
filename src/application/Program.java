package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data:");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account acc = new Account(number, holder, initialBalance, withdrawLimit);
			
			System.out.print("\nEnter amount for withdraw: ");
			double withdraw = sc.nextDouble();
	
			acc.withdraw(withdraw);
			
			System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
		} catch(DomainException e) {
			System.out.println(e.getMessage());
		} catch(RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		sc.close();
	}
}