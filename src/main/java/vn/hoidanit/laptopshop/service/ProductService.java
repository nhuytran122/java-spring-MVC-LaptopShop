package vn.hoidanit.laptopshop.service;

import org.springframework.stereotype.Service;

import java.util.List;
import lombok.AllArgsConstructor;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@AllArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(Product pr) {
        return this.productRepository.save(pr);
    }

    public List<Product> fetchProducts(){
        return this.productRepository.findAll();
    }

    public Product getProductByID(long id){
        return this.productRepository.findById(id);
    }

    public void deleteById(long id) {
        this.productRepository.deleteById(id);
    }
}