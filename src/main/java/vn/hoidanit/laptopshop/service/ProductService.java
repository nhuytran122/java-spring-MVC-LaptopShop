package vn.hoidanit.laptopshop.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

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

    public List<Product> fetchProducts() {
        return this.productRepository.findAll();
    }

    public Optional<Product> getProductByID(long id) {
        return this.productRepository.findById(id);
    }

    public void deleteById(long id) {
        this.productRepository.deleteById(id);
    }

    public void handleAddProductToCart(String email, long productId, HttpSession session) {

        User user = this.userService.getUserByEmail(email);

        if (user != null) {
            // check user đã có Cart chưa, nếu chưa -> tạo mới
            Cart cart = this.cartRepository.findByUser(user);
            if (cart == null) {
                // tạo mới cảt
                Cart otherCart = new Cart();
                otherCart.setUser(user);
                otherCart.setSum(0);

                cart = this.cartRepository.save(otherCart);
            }

            // save cart_detail
            // tìm product by id
            Optional<Product> productOptional = this.productRepository.findById(productId);
            if (productOptional.isPresent()) {
                Product product = productOptional.get();

                // check product đã từng được thêm vào cart trước đó hay chưa
                CartDetail oldDetail = this.cartDetailRepository.findByCartAndProduct(cart, product);

                if (oldDetail == null) {
                    CartDetail cd = new CartDetail();
                    cd.setCart(cart);
                    cd.setProduct(product);
                    cd.setPrice(product.getPrice());
                    cd.setQuantity(1);

                    this.cartDetailRepository.save(cd);

                    // update sum of cart
                    int s = cart.getSum() + 1;
                    cart.setSum(s);
                    this.cartRepository.save(cart);
                    session.setAttribute("sum", s);
                } else {
                    oldDetail.setQuantity(oldDetail.getQuantity() + 1);
                    this.cartDetailRepository.save(oldDetail);
                }
            }
        }
    }

    public Cart fetchCartByUser(User user) {
        return this.cartRepository.findByUser(user);
    }

    public void handleRemoveCartDetail(long cartDetailId, HttpSession session) {
        CartDetail cartDetail = this.cartDetailRepository.findById(cartDetailId);
        Cart cart = cartDetail.getCart();

        // delete cart-detail
        this.cartDetailRepository.deleteById(cartDetailId);

        if (cart.getSum() > 1) {
            // update current cart
            int s = cart.getSum() - 1;
            cart.setSum(s);
            session.setAttribute("sum", s);
            this.cartRepository.save(cart);
        } else {
            // delete cart (sum = 1)
            this.cartRepository.deleteById(cart.getId());
            session.setAttribute("sum", 0);
        }

    }
}