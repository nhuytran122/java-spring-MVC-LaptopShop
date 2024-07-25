package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.service.OrderService;

@AllArgsConstructor
@Controller
public class OrderController {

    private final OrderService orderService;
    
    @GetMapping("/admin/order")
    public String getOrderPage(Model model) {
        
        List<Order> orders = this.orderService.fetchOrders();
        model.addAttribute("orders", orders);
        return "admin/order/show";
    }
}
