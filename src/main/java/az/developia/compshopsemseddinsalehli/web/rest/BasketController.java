package az.developia.compshopsemseddinsalehli.web.rest;

import az.developia.compshopsemseddinsalehli.dto.request.BasketRequest;
import az.developia.compshopsemseddinsalehli.dto.response.BasketResponse;
import az.developia.compshopsemseddinsalehli.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @PostMapping
    public Long add(@RequestBody BasketRequest basketRequest) {
        return basketService.add(basketRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        basketService.delete(id);
    }

    @PutMapping("/{id}")
    public BasketResponse update(@PathVariable Long id , @RequestBody BasketRequest basketRequest) {
        return basketService.update(id , basketRequest);
    }

    @GetMapping("/users/{userId}")
    public List<BasketResponse> findByUserId(@PathVariable Long userId) {
        return basketService.findByUserId(userId);
    }

    @DeleteMapping("/computers/{compId}")
    public void deleteByCompId(@PathVariable Long compId) {
        basketService.deleteByCompId(compId);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteByUserId(@PathVariable Long userId) {
        basketService.deleteByUserId(userId);
    }
}
