package taylorbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import taylorbank.models.*;
import taylorbank.repository.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private WithdrawlRepository withdrawlRepository;
    @Autowired
    private BillRepository billRepository;

    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id){
        return accountRepository.findById(id);
    }

    public void createAccount(Long customer_id, Account account){
        accountRepository.save(account);
        Customer customer = customerRepository.findById(customer_id).get();
        account.setCustomer(customer);
    }

    public void updateAccount(Account account){
        accountRepository.save(account);

    }

    public void deleteAccount(Long account_id){
        accountRepository.deleteById(account_id);
    }

    public Customer getAccountOwner(Long account_id) {
        Optional<Account> account = accountRepository.findById(account_id);
        Customer customer = account.get().getCustomer();
        return customer;
    }

    public Iterable<Deposit> getDepositsByAccount(Long account_id){
        Account account = accountRepository.findById(account_id).get();
        Iterable<Deposit> deposits = depositRepository.findAll();
        ArrayList<Deposit> account_deposits = new ArrayList<>();
        for(Deposit deposit : deposits) {
            if (deposit.getAccount_id() == account.getId()) {
                account_deposits.add(deposit);
            }
        }
        return account_deposits;

    }

    public Iterable<Withdrawl> getWithdrawlsByAccount(Long account_id){
        Account account = accountRepository.findById(account_id).get();
        Iterable<Withdrawl> withdrawls = withdrawlRepository.findAll();
        ArrayList<Withdrawl> account_withdrawls = new ArrayList<>();
        for(Withdrawl withdrawl : withdrawls) {
            if (account.getId() == withdrawl.getAccount_id()) {
                account_withdrawls.add(withdrawl);
            }
        }
        return account_withdrawls;
    }


    public Iterable<Bill> getBillsByAccount(Long account_id){
        Iterable<Bill> bills = billRepository.findAll();
        ArrayList<Bill> account_bills = new ArrayList<>();
        for(Bill bill : bills) {
            if (bill.getAccount_id() == account_id) {
                account_bills.add(bill);
            }
        }
        return account_bills;
    }



}


