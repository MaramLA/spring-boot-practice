package com.spring_boot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {
    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers(){
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(@PathVariable  Integer id){
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PostMapping
    public void addingNewEngineer(@RequestBody  SoftwareEngineer softwareEngineer){
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @DeleteMapping("{id}")
    public void deleteEngineerById(@PathVariable  Integer id){
         softwareEngineerService.deleteEngineerById(id);
    }

    @PutMapping("{id}")
    public SoftwareEngineer updateEngineerById(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer){
        return softwareEngineerService.updateEngineerById(id, softwareEngineer);
    }

}
