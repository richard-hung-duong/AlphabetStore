package mum.edu.alphabetstore.repository;

import mum.edu.alphabetstore.domain.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

	@Cacheable("product")
	Product findOne(String name);

	Product save(Product var1);

	@Query("select p.productId from Product p")
	List<String> getProductsIds();
	
	@Query("select p from Product p order by p.activeDate ASC")
	List<Product> findProductsByDate();
	
	@Query("select p from Product p order by p.unitPrice ASC")
	List<Product> findProductsByPrice();
	
	@Query("select p from Product p where p.category.name=:category")
	List<Product> getProductsByCategory(@Param("category") String category);
	
}
