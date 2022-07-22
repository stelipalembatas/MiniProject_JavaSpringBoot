package com.miniproject.demo.Controller;


import com.miniproject.demo.DTO.TransaksiDTO;
import com.miniproject.demo.Service.TransaksiService;
import com.miniproject.demo.model.DetailTransaksi;
import com.miniproject.demo.model.Transaksi;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Transaksi")
public class TransaksiController {
    @Autowired
    private TransaksiService transaksiService;

    @PostMapping
    public ResponseEntity<Object> createTransaksi(@RequestBody TransaksiDTO request){
        return transaksiService.create(request);
    }

    @GetMapping
    public ResponseEntity<?> listTransaksi(){
        List<Transaksi> transaksiList = transaksiService.findAll();
        return ResponseEntity.ok(transaksiList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> transaksiFindById(@PathVariable("id") Integer id){
        try {
            Transaksi transaksi = transaksiService.findById(id);
            return ResponseEntity.ok(transaksi);
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<?> updateTransaksi(@PathVariable("id") Integer id, @RequestBody Transaksi transaksi){
        try {
            Transaksi transaksiUpdated = transaksiService.update(id, transaksi);
            return ResponseEntity.ok(transaksiUpdated);
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteTransaksi(@PathVariable("id") Integer id){
        try {
            transaksiService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
