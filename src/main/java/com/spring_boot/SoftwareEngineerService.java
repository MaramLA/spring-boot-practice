package com.spring_boot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers(){
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(()-> new IllegalStateException(id + " not found"));
    }

    public void deleteEngineerById(Integer id) {
        boolean exists = softwareEngineerRepository.existsById((id));
        if(!exists){
            throw new IllegalStateException(id + "not found");
        }
         softwareEngineerRepository.deleteById(id);
    }

    public SoftwareEngineer updateEngineerById(Integer id, SoftwareEngineer softwareEngineer) {
        SoftwareEngineer engineer = softwareEngineerRepository.findById(id).orElseThrow(()->new IllegalStateException(id+" not found"));
        engineer.setName(softwareEngineer.getName());
        engineer.setTechStack(softwareEngineer.getTechStack());
        return softwareEngineerRepository.save(engineer);

    }
}
