package vn.hoidanit.laptopshop.service;

import org.springframework.stereotype.Service;

import java.util.List;
import lombok.AllArgsConstructor;
import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.CartRepository;
import vn.hoidanit.laptopshop.repository.CartDetailRepository;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@AllArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository; 
    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;

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

    public void handleAddProductToCart(String email, long productId){
        
        User user = this.userService.getUserByEmail(email);

        if(user != null){
            // check user đã có Cart chưa, nếu chưa -> tạo mới
            Cart cart = this.cartRepository.findByUser(user);
            if(cart == null){
                //tạo mới cảt
                Cart otherCart = new Cart();
                otherCart.setUser(user);
                otherCart.setSum(1);

                cart = this.cartRepository.save(otherCart);
            }

            //save cart_detail
            // tìm product by id
            Product p = this.productRepository.findById(productId);
           
            CartDetail cd = new CartDetail();
            cd.setCart(cart);
            cd.setProduct(p);
            cd.setPrice(p.getPrice());
            cd.setQuantity(1);

            this.cartDetailRepository.save(cd);
        }

        // lưu cart_detail
    }
}