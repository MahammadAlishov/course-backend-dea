package az.developia.compshopsemseddinsalehli.service.impl;

import az.developia.compshopsemseddinsalehli.dto.request.ComputerRequest;
import az.developia.compshopsemseddinsalehli.dto.response.ComputerResponse;
import az.developia.compshopsemseddinsalehli.enums.ExceptionCode;
import az.developia.compshopsemseddinsalehli.exception.NotFoundException;
import az.developia.compshopsemseddinsalehli.model.Computer;
import az.developia.compshopsemseddinsalehli.repository.ComputerRepository;
import az.developia.compshopsemseddinsalehli.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComputerServiceImpl implements ComputerService {

    private final ComputerRepository computerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ComputerResponse> getAll() {
        List<ComputerResponse> all = computerRepository.findAll().stream().map(computer -> modelMapper
                .map(computer, ComputerResponse.class)).collect(Collectors.toList());
        return all;
    }

    @Override
    public Long add(ComputerRequest computerRequest) {
        Computer savedComputer = computerRepository
                .save(modelMapper.map(computerRequest, Computer.class));
        return savedComputer.getId();
    }

    @Override
    public Long delete(Long id) {
        Computer deletedComputer = computerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Computer.class, id,
                ExceptionCode.COMPUTER_NOT_FOUND.getCode()));

        computerRepository.deleteById(deletedComputer.getId());

        return deletedComputer.getId();
    }

    @Override
    public ComputerResponse update(Long id, ComputerRequest computerRequest) {

        computerRepository.findById(id).orElseThrow(() -> new NotFoundException(Computer.class , id ,
                ExceptionCode.COMPUTER_NOT_FOUND.getCode()));

        Computer newComputer = Computer.builder()
                .id(id)
                .image("img")
                .brand(computerRequest.getBrand())
                .model(computerRequest.getModel())
                .price(computerRequest.getPrice())
                .ram(computerRequest.getRam())
                .cpu(computerRequest.getCpu())
                .diskCapacity(computerRequest.getDiskCapacity())
                .diskType(computerRequest.getDiskType())
                .sellerPhone(computerRequest.getSellerPhone())
                .sellerName(computerRequest.getSellerName()).build();

        computerRepository.save(newComputer);

        return modelMapper.map(newComputer , ComputerResponse.class);
    }

    @Override
    public ComputerResponse findById(Long id) {
        Computer computer = computerRepository.findById(id).orElseThrow(() -> new NotFoundException(Computer.class, id,
                ExceptionCode.COMPUTER_NOT_FOUND.getCode()));

        return modelMapper.map(computer , ComputerResponse.class);
    }
}