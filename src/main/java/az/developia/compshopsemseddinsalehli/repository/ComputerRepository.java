package az.developia.compshopsemseddinsalehli.repository;

import az.developia.compshopsemseddinsalehli.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer , Long> {
}
