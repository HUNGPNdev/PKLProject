package t3h.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import t3h.project.entities.CartEntity;
import t3h.project.entities.OrderEntity;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query("SELECT p FROM OrderEntity p WHERE p.order_user.user_id = ?1")
    List<OrderEntity> getListOrderByUserId(Long id);
}
