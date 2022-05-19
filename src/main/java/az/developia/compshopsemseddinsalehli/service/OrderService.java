package az.developia.compshopsemseddinsalehli.service;

import az.developia.compshopsemseddinsalehli.dto.request.OrderRequest;
import az.developia.compshopsemseddinsalehli.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {

    List<OrderResponse> findBySellerId(Long id);

    Long add(OrderRequest orderRequest);
}
