//package com.module3.SpringDataJPA.repositories;
//
//import com.module3.SpringDataJPA.entities.ProductEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
//    ProductEntity findByTitle(String title);
//
////    title starts with p
//
//    @Query("select e from ProductEntity e where e.title like ?1 or e.title like ?2")
//    List<ProductEntity> titleStartingWithP(@Param("p") String pattern, @Param("P") String Pattern);
//
//    List<ProductEntity> findByTitleOrderByPriceDesc(String title);
//
//    List<ProductEntity> findByOrderByPrice();
//}
