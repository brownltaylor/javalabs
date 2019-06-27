package taylorbank.privateControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import taylorbank.models.*;
import taylorbank.services.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/portal")
@CrossOrigin(origins = "http://localhost:4200")
public class BankController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private DepositService depositService;
    @Autowired
    private WithdrawlService withdrawlService;
    @Autowired
    private BillService billService;


    /*TODO: This is where customer actions will begin */

    @PostMapping(value = "/createCustomer")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
      customerService.createCustomer(customer);
      return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @PutMapping(value= "/{customerId}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer){
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(null, HttpStatus.OK);


    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> showAllCustomers(){
        Iterable<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping(value= "/{customerId}")
    public ResponseEntity<?> findCustomer(@PathVariable Long customer_id){
        Optional<Customer> customer = customerService.getCustomer(customer_id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /*TODO: This is where the bills endpoints will begin" */

    @GetMapping(value =("/{customerId}/bills"))
    public ResponseEntity<?> getBillsByCustomer(@PathVariable Long customer_id){
        Iterable<Bill> customer_bills = customerService.getBillsByCustomer(customer_id);
        return new ResponseEntity<>(customer_bills, HttpStatus.OK);
    }

    @GetMapping(value = "/{customerId}/bills/{billId}")
    public ResponseEntity<?> getBillById(Long bill_id){
        Optional<Bill> bill = billService.getBillById(bill_id);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @PostMapping(value = "/{customerId}/accounts/{accountId}/createBill")
    public ResponseEntity<?> createBill(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id, @RequestBody Bill bill){
        billService.createBill(account_id, bill);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping(value= "/{customerId}/accounts/{accountId}/bills/{billId}")
    public ResponseEntity<?> updateBill(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id, @PathVariable("billId") Long bill_id, Bill bill){
        billService.updateBill(bill);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping(value="/{customerId}/accounts/{accountId}/bills/{billId}")
    public ResponseEntity<?> deleteBill(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id, @PathVariable("billId") Long bill_id){
        billService.deleteBill(bill_id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }



    /* TODO: This is where the account actions will begin */

    @GetMapping(value = "/accounts")
    public ResponseEntity<?> getAllAccounts(){
        Iterable<Account> accounts = accountService.getAllAccounts();
        if(accounts == null) {
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "error fetching accounts");
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping(value = ("/{customerId}/accounts"))
    public ResponseEntity<?> getAccountsByCustomer(@PathVariable Long customer_id){
        Iterable<Account> accounts = customerService.getAccountsByCustomer(customer_id);

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping(value = "/{customerId}/accounts/{accountId}/customer")
    public ResponseEntity<?> getAccountOwner(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id){
       Customer customer = accountService.getAccountOwner(account_id);
       return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @GetMapping(value = "/{customerId}/accounts/{accountId}/bills")
    public ResponseEntity<?> getBillsByAccount(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id){
        Iterable<Bill> bills = accountService.getBillsByAccount(account_id);
        if(bills == null) {
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "error fetching bills");
        }
        return new ResponseEntity(bills, HttpStatus.OK);
    }

    @PostMapping(value = "/{customerId}/accounts/createAccount")
    public ResponseEntity<?> createAccount(@PathVariable Long customer_id, @RequestBody Account account){
        accountService.createAccount(customer_id, account);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
    @GetMapping(value = "/{customerId}/accounts/{accountId}")
    public ResponseEntity<?> getAccountById(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id){
        Optional<Account> account = accountService.getAccountById(account_id);
        if(account == null){
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "error fetching account");

        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }


    @PutMapping(value = "/{customerId}/accounts/{accountId}")
    public ResponseEntity<?> updateAccount(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id, @RequestBody Account account){
        accountService.updateAccount(account);
        if(account == null) {
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "Error");
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{customerId}/accounts/{accountId}")
    public ResponseEntity<?> deleteAccount(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id){
        accountService.deleteAccount(account_id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }



    /* TODO: This is where the deposit endpoints will begin */

    @GetMapping(value = "/{customerId}/accounts/{accountId}/deposits")
    public ResponseEntity<?> getDepositsByAccount(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id){
        Iterable<Deposit> deposits = accountService.getDepositsByAccount(account_id);
        return new ResponseEntity<>(deposits, HttpStatus.OK);
    }
    @GetMapping(value = "/{customerId}/accounts/{accountId}/deposits/{depositId}")
    public ResponseEntity<?> getDeposit(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id, @PathVariable("depositId") Long deposit_id){
        Optional<Deposit> deposit = depositService.getDepositById(deposit_id);
        return new ResponseEntity<>(deposit, HttpStatus.OK);
    }


    @PostMapping(value = "/{customerId}/accounts/{accountId}/createDeposit")
    public ResponseEntity<?> createDeposit(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id, @RequestBody Deposit deposit){
        depositService.createDeposit(account_id, deposit);
        return new ResponseEntity<>(null, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{customerId}/accounts/{accountId}/deposits/{depositId}")
    public ResponseEntity<?> updateDeposit(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id, @PathVariable("depositId") Long deposit_id, @RequestBody Deposit deposit){
        depositService.updateDeposit(account_id, deposit);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{customerId}/accounts/{accountId}/deposits/{depositId}")
    public ResponseEntity<?> deleteDeposit(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id, @PathVariable("depositId") Long deposit_id){
        depositService.deleteDeposit(account_id, deposit_id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    /*TODO: This is where the withdrawl endpoints will begin*/

    @GetMapping(value= "/{customerId}/accounts/{accountId}/withdrawls")
    public ResponseEntity<?> getWithdrawlsByAccount(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id){
        Iterable<Withdrawl> withdrawls =  accountService.getWithdrawlsByAccount(account_id);
        return new ResponseEntity<>(withdrawls, HttpStatus.OK);
    }

    @GetMapping(value = "/{customerId}/accounts/{accountId}/withdrawls/{withdrawlId}")
    public ResponseEntity<?> getWithdrawl(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id, @PathVariable("withdrawlId") Long withdrawl_id){
        Optional<Withdrawl> withdrawl = withdrawlService.getWithdrawlById(withdrawl_id);
        return new ResponseEntity<>(withdrawl, HttpStatus.OK);
    }

    @PostMapping(value = "/{customerId}/accounts/{accountId}/withdrawls/createWithdrawl")
    public ResponseEntity<?> createWithdrawl(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id, @RequestBody Withdrawl withdrawl){
        withdrawlService.createWithdrawl(account_id, withdrawl);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{customerId}/accounts/{accountId}/withdrawls/{withdrawlId}")
    public ResponseEntity<?> updateWithdrawl(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id, @PathVariable("withdrawlId") Long withdrawl_id, @RequestBody Withdrawl withdrawl){
        withdrawlService.updateWithdrawl(account_id, withdrawl);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{customerId}/accounts/{accountId}/withdrawls/{withdrawlId}")
    public ResponseEntity<?> deleteWithdrawl(@PathVariable("customerId") Long customer_id, @PathVariable("accountId") Long account_id, @PathVariable("withdrawlId") Long withdrawl_id){
        withdrawlService.deleteWithdrawl(account_id, withdrawl_id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
