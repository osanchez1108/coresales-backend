package com.coresales.service.product.controller;

import com.coresales.service.product.model.Product;
import com.coresales.service.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin("http://localhost:5173")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> listar(){
        return ResponseEntity.ok(productService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(productService.obtenerPorId(id));
    }
    @PostMapping
    public ResponseEntity<Product> crear(@RequestBody Product request){
        Product response = productService.crear(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> actualizar (@PathVariable Long id, @RequestBody Product request){
        Product response = productService.actualizar(id, request);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping
    public ResponseEntity<Product> eliminar(@PathVariable Long id){
        productService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
