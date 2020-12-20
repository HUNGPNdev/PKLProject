package t3h.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import t3h.project.entities.ProductEntity;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p WHERE p.category.cata_id = ?1")
    List<ProductEntity> getProductEntityByCateId(Long id);

}
