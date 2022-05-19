package az.developia.compshopsemseddinsalehli.repository;

import az.developia.compshopsemseddinsalehli.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

    @Query(value = "select * from basket where user_id = :userId " , nativeQuery = true)
    List<Basket> getByUserId(@Param("userId") Long userId);

    @Query(value = "select * from basket where computer_id = :compId" , nativeQuery = true)
    Basket getByComputerId(@Param("compId") Long compId);

    @Modifying
    @Transactional
    @Query(value = "delete from basket where computer_id = :compId" , nativeQuery = true)
    void deleteByCompId(@Param("compId") Long compId);

    @Modifying
    @Transactional
    @Query(value = "delete from basket where user_id = :userId" , nativeQuery = true)
    void deleteByUserId(@Param("userId") Long userId);
}
