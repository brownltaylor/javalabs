package taylorbank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import taylorbank.models.Withdrawl;

@CrossOrigin(origins ="http://localhost:4200")
public interface WithdrawlRepository extends CrudRepository<Withdrawl, Long> {
}
