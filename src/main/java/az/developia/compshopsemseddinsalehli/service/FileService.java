package az.developia.compshopsemseddinsalehli.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void addOrUpdate(Long compId , MultipartFile file);

}
