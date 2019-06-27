package taylorbank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import taylorbank.models.Deposit;

@CrossOrigin(origins ="http://localhost:4200")
public interface DepositRepository extends CrudRepository<Deposit, Long>{


}
