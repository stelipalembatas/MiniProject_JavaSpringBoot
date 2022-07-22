package com.miniproject.demo.Controller;


import com.miniproject.demo.Service.TransportasiService;
import com.miniproject.demo.model.Transportasi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Transportasi")
public class TransportasiController {
    @Autowired
    private TransportasiService transportasiService;

    @PostMapping
    public ResponseEntity<?> createTransportasi(@RequestBody Transportasi transportasi){
        Transportasi transportasiCreated = transportasiService.createTransportasi(transportasi);
        return ResponseEntity.ok(transportasiCreated);
    }

    @GetMapping
    public ResponseEntity<?> listTransportasi(){
        List<Transportasi> transportasiList = transportasiService.findAllTransportasi();
        return ResponseEntity.ok(transportasiList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> transportasiById(@PathVariable("id") Integer id){
        try {
            Transportasi transportasi = transportasiService.findByIdTransportasi(id);
            return ResponseEntity.ok(transportasi);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateTransportasi(@PathVariable("id") Integer id, @RequestBody Transportasi transportasi){
        try {
            Transportasi transportasiUpdated = transportasiService.updateTransportasi(id, transportasi);
            return ResponseEntity.ok(transportasiUpdated);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransportasi(@PathVariable("id") Integer id) {
        try {
            transportasiService.deleteTransportasi(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
