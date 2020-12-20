package t3h.project.service;

import t3h.project.entities.CartEntity;

public interface CartService {
    void addCart(CartEntity c);
    void update(int user_id, long pro_id, int quantity);
    void deleteCart(int user_id, Long pro_id);
}
