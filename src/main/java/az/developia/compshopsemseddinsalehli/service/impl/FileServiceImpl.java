package az.developia.compshopsemseddinsalehli.service.impl;
import az.developia.compshopsemseddinsalehli.service.FileService;
import lombok.RequiredArgsConstructor;
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

    private final static String FOLDER_LOCATION = System.getProperty("user.home")+"/Desktop/";

    @Override
    public String addOrUpdate(MultipartFile file) {

        Path path = Paths.get(FOLDER_LOCATION + file.getOriginalFilename());

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

        return img;
    }

}
