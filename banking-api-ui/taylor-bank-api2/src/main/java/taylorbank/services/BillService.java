package taylorbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taylorbank.models.Account;
import taylorbank.models.Bill;
import taylorbank.repository.AccountRepository;
import taylorbank.repository.BillRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Bill> getBillById(Long bill_id) {
        return billRepository.findById(bill_id);
    }

    public void createBill(Long account_id, Bill bill) {
        billRepository.save(bill);
        bill.setAccount_id(account_id);
    }

    public void updateBill(Bill bill) {
        billRepository.save(bill);
    }

    public void deleteBill(Long bill_id) {
        billRepository.deleteById(bill_id);
    }

    public Iterable<Bill> getBillsByAccount(Long account_id) {
        Iterable<Bill> bills = billRepository.findAll();
        ArrayList<Bill> account_bills = new ArrayList<>();
        for (Bill bill : bills) {
            if (account_id == bill.getAccount_id()) {
                account_bills.add(bill);
            }
        }
        return account_bills;
    }
}
