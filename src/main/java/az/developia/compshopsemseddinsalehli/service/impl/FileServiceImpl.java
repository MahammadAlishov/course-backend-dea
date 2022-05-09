package az.developia.compshopsemseddinsalehli.service.impl;

import az.developia.compshopsemseddinsalehli.enums.ExceptionCode;
import az.developia.compshopsemseddinsalehli.exception.NotFoundException;
import az.developia.compshopsemseddinsalehli.model.Computer;
import az.developia.compshopsemseddinsalehli.repository.ComputerRepository;
import az.developia.compshopsemseddinsalehli.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final ComputerRepository computerRepository;

    @Value(value = "${file.location}")
    private String folderLocation;

    @Override
    public void addOrUpdate(Long compId , MultipartFile file) {
        Computer computer = computerRepository.findById(compId)
                .orElseThrow(() -> new NotFoundException(Computer.class, compId,
                        ExceptionCode.COMPUTER_NOT_FOUND.getCode()));

        Path path = Paths.get(folderLocation + file.getOriginalFilename());

        String img = "";
        if(!Files.exists(path)) {
            Path path1 = null;
            try {
                path1 = Files.createFile(path);
                img = Files.write(path1, file.getBytes(), StandardOpenOption.APPEND).toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            img = path.toString();
        }

        computer.setImage(img);
        computerRepository.save(computer);

    }

}
