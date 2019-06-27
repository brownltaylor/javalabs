package taylorbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import taylorbank.models.Customer;


@CrossOrigin(origins ="http://localhost:4200")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
