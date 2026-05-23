//package com.module3.SpringDataJPA.entities;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(
//        name = "products",
//        uniqueConstraints = {
//                @UniqueConstraint(name = "sku_unique", columnNames = {"sku"}),
//                @UniqueConstraint(name = "title_unique", columnNames = {"title_x"})
//
//        }
//)
//@Builder
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class ProductEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, length = 20)
//    private String sku;
//
//    @Column(name = "title_x")
//    private String title;
//
//    private BigDecimal price;
//
//    private Integer quantity;
//
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;
//}
