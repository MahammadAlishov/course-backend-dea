package az.developia.compshopsemseddinsalehli.web.rest;

import az.developia.compshopsemseddinsalehli.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PutMapping(value = "/computers/{compId}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addOrUpdate(@PathVariable Long compId , @RequestBody MultipartFile file) {
        fileService.addOrUpdate(compId, file);
    }
}
