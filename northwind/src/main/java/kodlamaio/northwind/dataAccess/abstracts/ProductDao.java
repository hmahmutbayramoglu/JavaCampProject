package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;


//JpaRepository => EntityFrameworkBaseRepository
public interface ProductDao extends JpaRepository<Product,Integer>{

	//isime göre => "getByProductName" hazır getiriyo
	//getBy=> önemli
	//Bunlar Hazır
	Product  getByProductName(String productName);
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String ProductName);
	
	List<Product> getByProductNameStartsWith(String ProductName);
	
	
	//Kendi Sorgularımız
	//Select * from products where product_name ="bardak" and category_id = 2
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName , int categoryId);

}
