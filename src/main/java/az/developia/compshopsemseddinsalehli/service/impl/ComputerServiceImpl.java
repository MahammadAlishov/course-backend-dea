package az.developia.compshopsemseddinsalehli.service.impl;

import az.developia.compshopsemseddinsalehli.dto.request.ComputerRequest;
import az.developia.compshopsemseddinsalehli.dto.response.ComputerResponse;
import az.developia.compshopsemseddinsalehli.enums.ExceptionCode;
import az.developia.compshopsemseddinsalehli.exception.NotFoundException;
import az.developia.compshopsemseddinsalehli.model.Computer;
import az.developia.compshopsemseddinsalehli.model.User;
import az.developia.compshopsemseddinsalehli.repository.ComputerRepository;
import az.developia.compshopsemseddinsalehli.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ComputerResponse> getAll() {
        List<ComputerResponse> all = computerRepository.findAll().stream().map(computer -> modelMapper
                .map(computer, ComputerResponse.class)).collect(Collectors.toList());
        return all;
    }

    @Override
    public Long add(ComputerRequest computerRequest) {
        User user = userRepository.findById(computerRequest.getUserId())
                .orElseThrow(() -> new NotFoundException(User.class, computerRequest.getUserId(),
                        ExceptionCode.USER_NOT_FOUND.getCode()));

        Computer newComp = Computer.builder()
                .cpu(computerRequest.getCpu())
                .brand(computerRequest.getBrand())
                .model(computerRequest.getModel())
                .diskCapacity(computerRequest.getDiskCapacity())
                .diskType(computerRequest.getDiskType())
                .ram(computerRequest.getRam())
                .user(user)
                .image(computerRequest.getImage())
                .sellerName(computerRequest.getSellerName())
                .sellerPhone(computerRequest.getSellerPhone())
                .content(computerRequest.getContent())
                .compNew(computerRequest.getCompNew())
                .price(computerRequest.getPrice()).build();

        Computer savedComputer = computerRepository.save(newComp);
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
        User user = userRepository.findById(computerRequest.getUserId())
                .orElseThrow(() -> new NotFoundException(User.class, computerRequest.getUserId(),
                        ExceptionCode.USER_NOT_FOUND.getCode()));

        computerRepository.findById(id).orElseThrow(() -> new NotFoundException(Computer.class , id ,
                ExceptionCode.COMPUTER_NOT_FOUND.getCode()));

        Computer newComputer = Computer.builder()
                .id(id)
                .image(computerRequest.getImage())
                .brand(computerRequest.getBrand())
                .model(computerRequest.getModel())
                .price(computerRequest.getPrice())
                .ram(computerRequest.getRam())
                .cpu(computerRequest.getCpu())
                .diskCapacity(computerRequest.getDiskCapacity())
                .diskType(computerRequest.getDiskType())
                .content(computerRequest.getContent())
                .compNew(computerRequest.getCompNew())
                .user(user)
                .sellerPhone(computerRequest.getSellerPhone())
                .sellerName(computerRequest.getSellerName()).build();

        computerRepository.save(newComputer);

        return modelMapper.map(newComputer , ComputerResponse.class);
    }

    @Override
    public List<ComputerResponse> findByUserId(Long userId) {

        List<ComputerResponse> computers = computerRepository.getByUserId(userId).stream()
                .map(comps -> modelMapper.map(comps , ComputerResponse.class)).collect(Collectors.toList());

        return computers;
    }

    @Override
    public ComputerResponse findById(Long id) {
        Computer computer = computerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Computer.class, id,
                ExceptionCode.COMPUTER_NOT_FOUND.getCode()));


        return modelMapper.map(computer , ComputerResponse.class);
    }
}