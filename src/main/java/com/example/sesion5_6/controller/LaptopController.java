package com.example.sesion5_6.controller;

import com.example.sesion5_6.entities.Laptop;
import com.example.sesion5_6.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {


    private LaptopRepository laptopRepository;
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAll() { return laptopRepository.findAll(); }

    @GetMapping("/api/laptops/{id}")
    @ApiOperation("Buscar un laptop por clave primaria")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if (laptopOpt.isPresent()) return ResponseEntity.ok(laptopOpt.get());
        else return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null) {
            System.out.println("Trying to update a non-existent laptop");
            ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            System.out.println("El libro no existe");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();

        return ResponseEntity.noContent().build();
    }




}

