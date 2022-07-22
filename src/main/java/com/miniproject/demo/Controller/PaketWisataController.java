package com.miniproject.demo.Controller;


import com.miniproject.demo.Service.PaketWisataService;
import com.miniproject.demo.model.PaketWisata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TempatWisata")
public class PaketWisataController {
    @Autowired
    private PaketWisataService paketWisataService;

    @PostMapping
    public ResponseEntity<?> createPaketWisata(@RequestBody PaketWisata paketWisata) {
        PaketWisata wisataCreated = paketWisataService.create(paketWisata);
        return ResponseEntity.ok(wisataCreated);
    }

    @GetMapping
    public ResponseEntity<?> listPaketWisata() {
        List<PaketWisata> paketWisataList = paketWisataService.findAll();
        return ResponseEntity.ok(paketWisataList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> paketWisataById(@PathVariable("id") Integer id) {
        try {
            PaketWisata paketWisata = paketWisataService.findById(id);
            return ResponseEntity.ok(paketWisata);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePaketWisata(@PathVariable("id") Integer id, @RequestBody PaketWisata paketWisata){
        try {
            PaketWisata paketWisataUpdated = paketWisataService.update(id, paketWisata);
            return ResponseEntity.ok(paketWisataUpdated);
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaketWisata(@PathVariable("id") Integer id) {
        try {
            paketWisataService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
