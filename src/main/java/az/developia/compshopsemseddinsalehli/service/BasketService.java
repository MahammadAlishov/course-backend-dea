package az.developia.compshopsemseddinsalehli.service;

import az.developia.compshopsemseddinsalehli.dto.request.BasketRequest;
import az.developia.compshopsemseddinsalehli.dto.response.BasketResponse;
import java.util.List;

public interface BasketService {

    void delete(Long id);

    Long add(BasketRequest basketRequest);

    BasketResponse update(Long id , BasketRequest basketRequest);

    List<BasketResponse> findByUserId(Long userId);

    void deleteByCompId(Long compId);

    void deleteByUserId(Long userId);
}
