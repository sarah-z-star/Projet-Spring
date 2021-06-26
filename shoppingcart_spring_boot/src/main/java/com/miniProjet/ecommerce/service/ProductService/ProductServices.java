package com.miniProjet.ecommerce.service.ProductService;

import java.util.List;

import com.miniProjet.ecommerce.Repository.CategoryRepo;
import com.miniProjet.ecommerce.Repository.ProductRepo;
import com.miniProjet.ecommerce.model.Category;
import com.miniProjet.ecommerce.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {

	@Autowired
	ProductRepo productRepo;
	@Autowired
	CategoryRepo cateRepo;
	
	public List<Products>getAllProducts(){
		return productRepo.findAll();
	}
	public List<Products>getProductsByCategory(String product_id){
		return productRepo.getByCategoryId(product_id);
	}
	
	public List<Category>getAllCategory(){
		return cateRepo.findAll();
	}
	
	public Products getProductsById(long productId) throws Exception {
		return productRepo.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
	}
}
