package az.developia.compshopsemseddinsalehli.web.rest;

import az.developia.compshopsemseddinsalehli.dto.request.ComputerRequest;
import az.developia.compshopsemseddinsalehli.dto.response.ComputerResponse;
import az.developia.compshopsemseddinsalehli.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/computers")
@RequiredArgsConstructor
public class ComputerController {

    private final ComputerService computerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long save(@RequestBody ComputerRequest computerRequest) {
        return computerService.add(computerRequest);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return computerService.delete(id);
    }

    @PutMapping("/{id}")
    public ComputerResponse update(@PathVariable Long id , @RequestBody ComputerRequest computerRequest) {
        return computerService.update(id , computerRequest);
    }

    @GetMapping("/{id}")
    public ComputerResponse findById(@PathVariable Long id) {
        return computerService.findById(id);
    }

    @GetMapping
    public List<ComputerResponse> getAll() {
        return computerService.getAll();
    }
}