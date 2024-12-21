package net.KikoZhao.cats_backend.controller;
import lombok.AllArgsConstructor;
import net.KikoZhao.cats_backend.DTO.CatDTO;
import net.KikoZhao.cats_backend.service.CatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/cats")
public class CatController {
    private CatService catService;
    //Build Add Cat Rest API
    @PostMapping
    public ResponseEntity<CatDTO> createCat(@RequestBody CatDTO catDTO) {
        CatDTO savedCat = catService.createCat(catDTO);
        return new ResponseEntity<>(savedCat, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CatDTO> getCatById(@PathVariable("id") Long catid) {
        CatDTO catDTO = catService.getCatById(catid);
        return ResponseEntity.ok(catDTO);
    }
    @GetMapping
    public ResponseEntity<List<CatDTO>> getAllCats() {
        List<CatDTO> catDTOList = catService.getAllCats();
        return ResponseEntity.ok(catDTOList);
    }
    @PutMapping("{id}")
    public ResponseEntity<CatDTO> updateCat(@PathVariable("id") Long catid, @RequestBody CatDTO updatedCat) {
        CatDTO catDTO = catService.updateCat(catid, updatedCat);
        return ResponseEntity.ok(catDTO);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCat(@PathVariable("id") Long catid) {
        catService.deleteCat(catid);
        return ResponseEntity.ok("Cat is deleted successfully!");
    }
}
