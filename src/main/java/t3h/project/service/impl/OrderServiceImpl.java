package t3h.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import t3h.project.dto.OrderDTO;
import t3h.project.entities.OrderEntity;
import t3h.project.repository.OrderRepository;
import t3h.project.repository.ProductRepository;
import t3h.project.repository.UserRepository;
import t3h.project.service.CartService;
import t3h.project.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRp;

    @Autowired
    ProductRepository proRp;

    @Autowired
    UserRepository userRp;

    @Autowired
    CartService cartSv;

    @Autowired
    JavaMailSender mailler;

    @Override
    public void addOrder(int user_id, List<OrderDTO> od) {
        long millis=System.currentTimeMillis();
        long u_id = user_id;
        for(OrderDTO o: od) {
            OrderEntity order = new OrderEntity(o.getCount(), o.getPrice() * o.getCount(), o.getImage(),
                    userRp.findById(u_id).get(), proRp.findById(o.getPro_id()).get(), new java.sql.Date(millis));
            orderRp.save(order);
            cartSv.deleteCart(user_id, o.getPro_id());
        }

        for(OrderDTO o: od) {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom("c1909i2bkap@gmail.com");
            msg.setTo(userRp.findById(u_id).get().getEmail());
            msg.setSubject("THÔNG BÁO ĐẶT HÀNG");
            msg.setText("ĐƠn hàng của bạn đã đặt thành công! Chúng tôi sẽ sớm liên hệ với bạn theo thông tin!");
            mailler.send(msg);
            break;
        }
    }

    @Override
    public List<OrderDTO> getListOrder(int user_id) {
        long id = user_id;
        List<OrderDTO> ol = new ArrayList<>();
        for(OrderEntity o: orderRp.getListOrderByUserId(id)) {
            int qtt = (int) o.getQuantity();
            ol.add(new OrderDTO(o.getOrder_id(), qtt, o.getTotal_price(), o.getImage(), o.getPro_id().getPro_name()));
        }
        return ol;
    }

    @Override
    public List<OrderDTO> adminGetAllOrder() {
        List<OrderDTO> ol = new ArrayList<>();
        for(OrderEntity o: orderRp.findAll()) {
            int qtt = (int) o.getQuantity();
            ol.add(new OrderDTO(o.getOrder_id(), qtt, o.getTotal_price(), o.getImage(), o.getPro_id().getPro_name(), o.getOrder_user().getName()));
        }
        return ol;
    }
}
