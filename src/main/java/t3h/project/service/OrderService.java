package t3h.project.service;

import t3h.project.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    void addOrder(int user_id, List<OrderDTO> od);
    List<OrderDTO> getListOrder(int user_id);
    List<OrderDTO> adminGetAllOrder();
}
