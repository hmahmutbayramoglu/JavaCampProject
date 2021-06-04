package kodlamaio.northwind.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.ErrorResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService{
	
	private ProductDao productDao; 

	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		
		var data = this.productDao.findAll();
		if(1==1) {
					return new SuccessDataResult<List<Product>>(data, "Veri Listelendi");
		}
			return new ErrorDataResult<List<Product>>("Veri Listelenemedi");
	 

	}
	

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		var data = this.productDao.findAll(pageable).getContent();
		
		return new SuccessDataResult<List<Product>>(data, "Veri Sayfalandı");
	}

	
	@Override
	public DataResult<List<Product>> getAllSorted(boolean ranking) {
	
		Sort sort;
		if(ranking) {
			 sort = Sort.by(Sort.Direction.ASC, "productName");
		}
		else {
			 sort = Sort.by(Sort.Direction.DESC, "productName");
		}
	 
		var data = this.productDao.findAll(sort);
		
		return new SuccessDataResult<List<Product>>(data, "Data ASC Listelendi");
		
	}
	
	
	@Override
	public Result add(Product product) {
		 
		if(1==1) {
				this.productDao.save(product);
				return new SuccessResult("Ürün Eklendi");
		}
		return new ErrorResult("Ürün Eklendi");
	
	}

	
	@Override
	public DataResult<Product> getByProductName(String productName) {
		
		var data = this.productDao.getByProductName(productName);
        return new SuccessDataResult<Product>(data, "Veri Listelendi");
 
			 
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		
		var data = this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId);
        return new SuccessDataResult<Product>(data, "Veri Listelendi");
 
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		
		var data = this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId);
        return new SuccessDataResult<List<Product>>(data, "Veri Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		
		var data = this.productDao.getByCategoryIn(categories);
        return new SuccessDataResult<List<Product>>(data, "Veri Listelendi");
        
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		
		var data = this.productDao.getByProductNameContains(productName);
        return new SuccessDataResult<List<Product>>(data, "Veri Listelendi");
        
    
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		
		var data = this.productDao.getByProductNameStartsWith(productName);
        return new SuccessDataResult<List<Product>>(data, "Veri Listelendi");
        
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		
		var data = this.productDao.getByNameAndCategory(productName, categoryId);
        return new SuccessDataResult<List<Product>>(data, "Veri Listelendi");
        
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		
		var data = this.productDao.getProductWithCategoryDetails();
 		return new SuccessDataResult<List<ProductWithCategoryDto>>(data, "Veri Listelendi DTO");
 
	}




}
