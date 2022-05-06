package az.developia.compshopsemseddinsalehli.repository;

import az.developia.compshopsemseddinsalehli.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepository extends JpaRepository<Computer , Long> {

    @Query(value = "select * from computers where user_id = :userId " , nativeQuery = true)
    List<Computer> getByUserId(@Param("userId") Long userId);
}
