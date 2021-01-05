package t3h.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import t3h.project.entities.CartEntity;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity, Integer> {
    @Query("SELECT p FROM CartEntity p WHERE p.user_id = ?1")
    List<CartEntity> getListCartByUserId(Integer id);

    @Query("SELECT count(p) FROM CartEntity p WHERE p.user_id = ?1 AND p.pro_id = ?2")
    int countProById(int user_id, Long pro_id);


    @Query("SELECT COUNT(p) FROM CartEntity p WHERE p.user_id = ?1 ")
    int countOrder(int id);

    @Query("DELETE FROM CartEntity WHERE user_id = 3")
    void deleteCartByUserId(int user_id);
}
