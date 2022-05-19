package az.developia.compshopsemseddinsalehli.web.rest;

import az.developia.compshopsemseddinsalehli.dto.request.OrderRequest;
import az.developia.compshopsemseddinsalehli.dto.response.OrderResponse;
import az.developia.compshopsemseddinsalehli.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/users/{userId}")
    public List<OrderResponse> getBySellerId(@PathVariable Long userId) {
        return orderService.findBySellerId(userId);
    }

    @PostMapping
    public Long add(@RequestBody OrderRequest orderRequest) {
        return orderService.add(orderRequest);
    }
}
