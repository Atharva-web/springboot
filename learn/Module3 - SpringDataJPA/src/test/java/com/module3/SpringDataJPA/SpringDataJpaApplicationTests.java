//package com.module3.SpringDataJPA;
//
//import com.module3.SpringDataJPA.repositories.ProductRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class SpringDataJpaApplicationTests {
//
//	@Autowired
//	private ProductRepository productRepository;
//
////	public SpringDataJpaApplicationTests(ProductRepository productRepository) {
////		this.productRepository = productRepository;
////	}
//
//	@Test
//	void contextLoads() {
//	}
////
////	@Test
////	void testRepository() {
////		ProductEntity productEntity = ProductEntity.builder()
////				.sku("Nestle")
////				.title("poppins")
////				.price(BigDecimal.valueOf(23))
////				.quantity(12)
////				.build();
////		System.out.println(productRepository.save(productEntity));
////	}
//
//	@Test
//	void testGetRepository() {
//		System.out.println(productRepository.findAll());
//	}
//
//	@Test
//	void testGetProductByTitle() {
//		System.out.println(productRepository.findByTitle("Pepsi"));
//	}
//
//	@Test
//	void testGetProductByTitleP() {
//		System.out.println(productRepository.titleStartingWithP("p%", "P%"));
//	}
//}
