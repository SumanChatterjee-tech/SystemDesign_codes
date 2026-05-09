package com.home.SplitwiseEasyToUnderstand;

import java.util.*;
import java.util.stream.Collectors;

public class SplitWiseService {
    private static SplitWiseService instance;
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Group> groups = new HashMap<>();

    private SplitWiseService() {}

    public static synchronized SplitWiseService getInstance() {
        if (instance == null) {
            instance = new SplitWiseService();
        }
        return instance;
    }

    // --- Setup Methods ---
    public User addUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getId(), user);
        return user;
    }

    public Group addGroup(String name, User owner ,List<User> members) {
        Group group = new Group(name,owner, members);
        groups.put(group.getGroupId(), group);
        return group;
    }

    public User getUser(String id) { return users.get(id); }
    public Group getGroup(String id) { return groups.get(id); }

    public synchronized Expense createExpense(String description, double totalAmount, User owner,
                                           List<User> selectedUser, SplitType splitType) throws Exception {
        SplitStrategy splitStrategy = SplitisFactory.getSplitFactory(splitType);
        List<Split> splits = splitStrategy.calculateSplit(owner, totalAmount, selectedUser);

        Expense expenses = new Expense(description, totalAmount, owner, splits);
        return expenses;
    }

    public synchronized void settleUp(User paidTo, User paidFrom, double paidToOwner){
        System.out.println("User "+ paidFrom.getName()+" wants to settle up with "+paidTo.getName());
        BalanceSheet paidToSheet = paidTo.getBalanceSheet();
        BalanceSheet paidFromSheet = paidFrom.getBalanceSheet();

        paidToSheet.settleUp(paidTo, -paidToOwner);
        paidFromSheet.settleUp(paidFrom, paidToOwner);
    }

    public List<Transaction> simplifyGroupDebts(String groupId){
        Group group = groups.get(groupId);
        if (group == null) throw new IllegalArgumentException("Group not found");

        // Calculate net balance for each member within the group context
        Map<User, Double> netBalances = new HashMap<>();
        for (User member : group.getMemebers()) {
            double balance = 0;
            for(Map.Entry<User, Double> entry : member.getBalanceSheet().getBalances().entrySet()) {
                // Consider only balances with other group members
                if (group.getMemebers().contains(entry.getKey())) {
                    balance += entry.getValue();
                }
            }
            netBalances.put(member, balance);
        }

        // Separate into creditors and debtors
        List<Map.Entry<User, Double>> creditors = netBalances.entrySet().stream()
                .filter(e -> e.getValue() > 0).collect(Collectors.toList());
        List<Map.Entry<User, Double>> debtors = netBalances.entrySet().stream()
                .filter(e -> e.getValue() < 0).collect(Collectors.toList());

        //Jara positive, beshi positive upore, 10, 7, 5, 3, 2
        //Jara negative, kom negative upore, -1, -5, -6, -9
        creditors.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        debtors.sort(Map.Entry.comparingByValue());

        List<Transaction> transactions = new ArrayList<>();
        int i = 0, j = 0;
        while (i < creditors.size() && j < debtors.size()) {
            Map.Entry<User, Double> creditor = creditors.get(i);
            Map.Entry<User, Double> debtor = debtors.get(j);

            double amountToSettle = Math.min(creditor.getValue(), -debtor.getValue());
            transactions.add(new Transaction(debtor.getKey(), creditor.getKey(), amountToSettle));

            creditor.setValue(creditor.getValue() - amountToSettle);
            debtor.setValue(debtor.getValue() + amountToSettle);

            if (Math.abs(creditor.getValue()) < 0.01) i++;
            if (Math.abs(debtor.getValue()) < 0.01) j++;
        }
        return transactions;
    }
}
