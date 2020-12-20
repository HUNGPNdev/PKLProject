package t3h.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import t3h.project.entities.BannerEntity;

import java.util.List;

public interface BannerRepository extends JpaRepository<BannerEntity, Long> {

    @Query("select b from BannerEntity b where b.status = true")
    List<BannerEntity> getStatusTrue();
}
