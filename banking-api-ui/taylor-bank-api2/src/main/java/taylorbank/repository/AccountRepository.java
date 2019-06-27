package taylorbank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import taylorbank.models.Account;

@CrossOrigin(origins ="http://localhost:4200")
public interface AccountRepository extends CrudRepository<Account, Long>  {
}
