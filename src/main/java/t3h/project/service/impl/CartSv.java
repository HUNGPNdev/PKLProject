package t3h.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t3h.project.entities.CartEntity;
import t3h.project.repository.CartRepository;
import t3h.project.service.CartService;

import java.util.List;

@Service
public class CartSv implements CartService {

    @Autowired
    CartRepository cartRp;

    @Override
    public void addCart(CartEntity c) {
        List<CartEntity> listCart = cartRp.getListCartByUserId(c.getUser_id());
        boolean a = true;
        for (CartEntity ca: listCart) {
            if (ca.getPro_id() == c.getPro_id()) {
                ca.setQuantity(ca.getQuantity()+1);
                cartRp.save(ca);
                a = false;
                break;
            }
        }
        if (a) {
            c.setQuantity(1);
            cartRp.save(c);
        }
    }

    @Override
    public void update(int user_id, long pro_id, int quantity) {
        CartEntity c = new CartEntity(user_id, pro_id, quantity);
        System.out.println(c);
        List<CartEntity> listCart = cartRp.getListCartByUserId(c.getUser_id());
        for (CartEntity ca: listCart) {
            if (ca.getPro_id() == pro_id) {
                ca.setQuantity(quantity);
                cartRp.save(ca);
                break;
            }
        }
    }

    @Override
    public void deleteCart(int user_id, Long pro_id) {
        List<CartEntity> listCart = cartRp.getListCartByUserId(user_id);
        for (CartEntity ca: listCart) {
            if (ca.getPro_id() == pro_id) {
                cartRp.deleteById(ca.getId());
            }
        }
    }
}
