package com.kodlama.kodlamaio.controllers;

import com.kodlama.kodlamaio.services.technology.TechnologyService;
import com.kodlama.kodlamaio.services.technology.commands.CreateTechnologyDto;
import com.kodlama.kodlamaio.services.technology.commands.UpdateTechnologyDto;
import com.kodlama.kodlamaio.services.technology.queries.GetListTechnologyDto;
import com.kodlama.kodlamaio.services.technology.queries.GetTechnologyByIdDto;
import com.kodlama.kodlamaio.services.technology.queries.GetTechnologyByNameDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/technologies")
public class TechnologyController {

    private final TechnologyService service;

    public TechnologyController(TechnologyService service) {
        this.service = service;
    }

    @GetMapping("/getall")
    public List<GetListTechnologyDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/getbyid")
    public GetTechnologyByIdDto getById(@RequestParam Long id) throws Exception {
        return service.getById(id);
    }

    @GetMapping("/getbyname")
    public GetTechnologyByNameDto getByName(@RequestParam String name) throws Exception {
        return service.getByName(name);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateTechnologyDto create(@RequestBody CreateTechnologyDto technologyDto) throws Exception{
        return service.create(technologyDto);
    }

    @PutMapping("/update")
    public UpdateTechnologyDto update(@RequestBody UpdateTechnologyDto technologyDto,@RequestParam Long id) throws Exception{
        return service.update(technologyDto,id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam Long id) throws Exception{
        service.delete(id);
    }


}
