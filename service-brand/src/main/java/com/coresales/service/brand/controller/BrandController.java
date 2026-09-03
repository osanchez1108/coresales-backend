package com.coresales.service.brand.controller;

import com.coresales.service.brand.model.Brand;
import com.coresales.service.brand.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
@CrossOrigin("http://localhost:5173")
public class BrandController {
    private final BrandService marcaService;

    public BrandController(BrandService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public ResponseEntity<List<Brand>> listar(){
        return  ResponseEntity.ok(marcaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> obtenerId(@PathVariable Integer id){
        return  ResponseEntity.ok(marcaService.obtenerId(id));
    }

    @PostMapping
    public ResponseEntity<Brand> crear(@RequestBody Brand request){
        Brand response = marcaService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public  ResponseEntity<Brand> actualizar(@PathVariable Integer id, @RequestBody Brand request){
        Brand response = marcaService.actualizar(id, request);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping
    public ResponseEntity<Brand> eliminar(@PathVariable Integer id){
        marcaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
