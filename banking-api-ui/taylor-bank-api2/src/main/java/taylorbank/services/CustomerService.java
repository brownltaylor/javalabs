package taylorbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import taylorbank.error.ResourceNotFoundException;
import taylorbank.models.Account;
import taylorbank.models.Bill;
import taylorbank.models.Customer;
import taylorbank.repository.AccountRepository;
import taylorbank.repository.BillRepository;
import taylorbank.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BillRepository billRepository;



    public Iterable<Account> getAccountsByCustomer(Long customer_id) {
        Iterable<Account> accounts = accountRepository.findAll();
        Customer targetCustomer = customerRepository.findById(customer_id).get();
        ArrayList<Account> customer_accounts = new ArrayList<Account>();
        for (Account account : accounts) {
            if (account.getCustomer().getCustomer_id() == customer_id) {
                customer_accounts.add(account);
            }
        }
        return customer_accounts;
    }

    public Iterable<Bill> getBillsByCustomer(Long customer_id) {
        Iterable<Bill> bills = billRepository.findAll();
        Iterable<Account> accounts = accountRepository.findAll();
        ArrayList<Bill> customer_bills = new ArrayList<>();
        ArrayList<Account> customer_accounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getCustomer().getCustomer_id() == customer_id) {
                customer_accounts.add(account);
            }
            for (Bill bill : bills) {
                for (Account customer_account : customer_accounts) {
                    if (bill.getAccount_id() == customer_account.getId()) {
                        customer_bills.add(bill);
                    }
                }
            }
        }
    return customer_bills;
    }

    public Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(Long customer_id){
        Optional<Customer> customer = customerRepository.findById(customer_id);

        if(!customer.isPresent())
            throw new ResourceNotFoundException("id-" + customer_id);

        return customer;

    }
    public void createCustomer(Customer customer){

            customerRepository.save(customer);


    }
    public void updateCustomer(Customer customer){
        customerRepository.save(customer);

    }
}
