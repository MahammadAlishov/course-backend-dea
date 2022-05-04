package az.developia.compshopsemseddinsalehli.service;

import az.developia.compshopsemseddinsalehli.dto.request.ComputerRequest;
import az.developia.compshopsemseddinsalehli.dto.response.ComputerResponse;

import java.util.List;

public interface ComputerService {

    List<ComputerResponse> getAll();

    Long add(ComputerRequest computerRequest);

    Long delete(Long id);

    ComputerResponse update(Long id , ComputerRequest computerRequest);

    ComputerResponse findById(Long id);
}
