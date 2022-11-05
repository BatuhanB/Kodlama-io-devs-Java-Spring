package com.kodlama.kodlamaio.controllers;

import com.kodlama.kodlamaio.services.programmingLanguage.ProgrammingLanguageService;
import com.kodlama.kodlamaio.services.programmingLanguage.commands.CreateProgrammingLanguageDto;
import com.kodlama.kodlamaio.services.programmingLanguage.commands.UpdateProgrammingLanguageDto;
import com.kodlama.kodlamaio.services.programmingLanguage.queries.GetListProgrammingLanguageDto;
import com.kodlama.kodlamaio.services.programmingLanguage.queries.GetProgrammingLanguageByIdDto;
import com.kodlama.kodlamaio.services.programmingLanguage.queries.GetProgrammingLanguageByNameDto;
import com.kodlama.kodlamaio.services.programmingLanguage.queries.GetProgrammingLanguagesWithTechnologyDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/programminglanguages")
public class ProgrammingLanguageController {

    private final ProgrammingLanguageService service;

    public ProgrammingLanguageController(ProgrammingLanguageService service) {
        this.service = service;
    }

    @GetMapping("/getall")
    public List<GetListProgrammingLanguageDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/getallwithtechnologies")
    public List<GetProgrammingLanguagesWithTechnologyDto> getAllWithTechnologies(){
        return service.getAllWithTechnologies();
    }

    @GetMapping("/getbyid")
    public GetProgrammingLanguageByIdDto getById(@RequestParam Long id){
        return service.getById(id);
    }

    @GetMapping("/getbyname")
    public GetProgrammingLanguageByNameDto getByName(@RequestParam String name){
        return service.getByName(name);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProgrammingLanguageDto add(@RequestBody CreateProgrammingLanguageDto language) throws Exception{
        return service.createProgrammingLanguage(language);
    }

    @PutMapping("/update")
    public UpdateProgrammingLanguageDto update(@RequestBody UpdateProgrammingLanguageDto programmingLanguage, @RequestParam Long id) throws Exception{
        return service.update(programmingLanguage,id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
