package az.developia.compshopsemseddinsalehli.repository;

import az.developia.compshopsemseddinsalehli.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order , Long> {

    @Query(value = "select * from orders where seller_id = :sellerId" , nativeQuery = true)
    List<Order> findBySellerId(@Param("sellerId") Long sellerId);
}
