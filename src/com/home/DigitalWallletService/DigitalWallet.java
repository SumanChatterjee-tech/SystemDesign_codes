package com.home.DigitalWallletService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DigitalWallet {

	public Map<String, User> users;

	public DigitalWallet() {
		this.users = new ConcurrentHashMap<>();
	}

	public void createUser(User user) {
		users.put(user.getId(), user);
	}

	public User getUser(String userId) {
		return users.get(userId);
	}

	public Account getAccount(String userID, String accountID) {
		return users.get(userID).getAccs().stream().filter(a -> a.id == accountID).findFirst().get();
	}

	public synchronized void transferFunnds(Account sourceAccount, Account destinationAccount, BigDecimal amount,
			Currency currency, Payment Senderpayment) throws Exception {
		if (sourceAccount.currency != currency) {
			amount = CurrencyConverter.convert(amount, currency, sourceAccount.currency);
		}
		if (Senderpayment.processPayment(amount, currency)) {
			sourceAccount.withdraw(amount);
			destinationAccount.deposit(amount);
		}

		String transactionId = generateTransactionId();
		Transaction transaction = new Transaction(transactionId, sourceAccount, destinationAccount, amount, currency);

		sourceAccount.addTransaction(transaction);
		destinationAccount.addTransaction(transaction);
	}

	private String generateTransactionId() {
		return "TXN" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}

	public List<Transaction> getTransactionHistory(Account account) {
		return account.transactions;
	}
}
