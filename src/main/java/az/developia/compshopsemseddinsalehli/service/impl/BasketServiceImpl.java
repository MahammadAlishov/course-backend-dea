package az.developia.compshopsemseddinsalehli.service.impl;

import az.developia.compshopsemseddinsalehli.dto.request.BasketRequest;
import az.developia.compshopsemseddinsalehli.dto.response.BasketResponse;
import az.developia.compshopsemseddinsalehli.enums.ExceptionCode;
import az.developia.compshopsemseddinsalehli.exception.NotFoundException;
import az.developia.compshopsemseddinsalehli.model.Basket;
import az.developia.compshopsemseddinsalehli.model.Computer;
import az.developia.compshopsemseddinsalehli.model.User;
import az.developia.compshopsemseddinsalehli.repository.BasketRepository;
import az.developia.compshopsemseddinsalehli.repository.ComputerRepository;
import az.developia.compshopsemseddinsalehli.repository.UserRepository;
import az.developia.compshopsemseddinsalehli.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
    private final UserRepository userRepository;
    private final ComputerRepository computerRepository;
    private final ModelMapper modelMapper;

    @Override
    public void delete(Long id) {
        basketRepository.findById(id).orElseThrow(()
                -> new NotFoundException(Basket.class, id, ExceptionCode.BASKET_NOT_FOUND.getCode()));

        basketRepository.deleteById(id);
    }

    @Override
    public Long add(BasketRequest basketRequest) {
        User user = userRepository.findById(basketRequest.getUserId())
                .orElseThrow(() -> new NotFoundException(User.class, basketRequest.getUserId(),
                        ExceptionCode.USER_NOT_FOUND.getCode()));

        Computer computer = computerRepository.findById(basketRequest.getCompId())
                .orElseThrow(() -> new NotFoundException(Computer.class, basketRequest.getCompId(),
                        ExceptionCode.COMPUTER_NOT_FOUND.getCode()));

        Basket existsBasketComputer = basketRepository.getByComputerId(computer.getId());

        if(existsBasketComputer == null) {
            Basket basketSaved = new Basket();
            basketSaved.setComputer(computer);
            basketSaved.setQuantity(basketRequest.getQuantity());
            basketSaved.setUser(user);
            return basketRepository.save(basketSaved).getId();
        } else {
            Long quantity = existsBasketComputer.getQuantity();
            existsBasketComputer.setQuantity(quantity + 1);
            basketRepository.save(existsBasketComputer);
            return existsBasketComputer.getId();
        }
    }

    @Override
    public BasketResponse update(Long id, BasketRequest basketRequest) {
        User user = userRepository.findById(basketRequest.getUserId())
                .orElseThrow(() -> new NotFoundException(User.class, basketRequest.getUserId() ,
                        ExceptionCode.USER_NOT_FOUND.getCode()));

        Computer computer = computerRepository.findById(basketRequest.getCompId())
                .orElseThrow(() -> new NotFoundException(Computer.class, basketRequest.getCompId(),
                        ExceptionCode.COMPUTER_NOT_FOUND.getCode()));

        Basket newBasket = Basket.builder()
                .id(id)
                .user(user)
                .quantity(basketRequest.getQuantity())
                .computer(computer).build();

        basketRepository.save(newBasket);

        return modelMapper.map(newBasket , BasketResponse.class);
    }

    @Override
    public List<BasketResponse> findByUserId(Long userId) {

        List<BasketResponse> baskets = basketRepository.getByUserId(userId).stream()
                .map(basket -> modelMapper.map(basket, BasketResponse.class)).collect(Collectors.toList());

        return baskets;
    }

    @Override
    public void deleteByCompId(Long compId) {
        basketRepository.deleteByCompId(compId);
    }

    @Override
    public void deleteByUserId(Long userId) {
        basketRepository.deleteByUserId(userId);
    }
}
