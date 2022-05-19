package az.developia.compshopsemseddinsalehli.service.impl;

import az.developia.compshopsemseddinsalehli.dto.request.OrderRequest;
import az.developia.compshopsemseddinsalehli.dto.response.OrderResponse;
import az.developia.compshopsemseddinsalehli.model.Order;
import az.developia.compshopsemseddinsalehli.repository.OrderRepository;
import az.developia.compshopsemseddinsalehli.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    
    @Override
    public List<OrderResponse> findBySellerId(Long sellerId) {
        List<OrderResponse> orders = orderRepository.findBySellerId(sellerId)
                .stream().map(order -> modelMapper.map(order, OrderResponse.class)).collect(Collectors.toList());
        return orders;
    }

    @Override
    public Long add(OrderRequest orderRequest) {
        Order savedOrder = orderRepository.save(modelMapper.map(orderRequest, Order.class));
        return orderRepository.save(savedOrder).getId();
    }
}
