package com.miniproject.demo.Controller;


import com.miniproject.demo.DTO.DetailTransaksiDTO;
import com.miniproject.demo.Service.DetailTransaksiService;
import com.miniproject.demo.model.DetailTransaksi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/detailtransaksi")
public class DetailTransaksiController {
    @Autowired
    private DetailTransaksiService detailTransaksiService;

    @PostMapping
    public ResponseEntity.BodyBuilder createDetailTransaksi(@RequestBody DetailTransaksiDTO detailTransaksiDTO){
        detailTransaksiService.create(detailTransaksiDTO);
        return ResponseEntity.ok();
    }

    @GetMapping
    public ResponseEntity<?> listDetailTransaksi(){
        List<DetailTransaksi> detailTransaksiList = detailTransaksiService.findAll();
        return ResponseEntity.ok(detailTransaksiList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detailTransaksiFindById(@PathVariable("id") Integer id){
        try {
            DetailTransaksi detailTransaksi = detailTransaksiService.findByIdDetTransaksi(id);
            return ResponseEntity.ok(detailTransaksi);
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<?> updateDetailTransaksi(@PathVariable("id") Integer id, @RequestBody DetailTransaksi detailTransaksi){
        try {
            DetailTransaksi detailTransaksiUpdated = detailTransaksiService.update(id, detailTransaksi);
            return ResponseEntity.ok(detailTransaksiUpdated);
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteDetailTransaksi(@PathVariable("id") Integer id){
        try {
            detailTransaksiService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
