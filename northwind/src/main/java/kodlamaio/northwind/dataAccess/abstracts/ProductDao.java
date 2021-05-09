package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Product;


//JpaRepository => EntityFrameworkBaseRepository
public interface ProductDao extends JpaRepository<Product,Integer>{

	
}
