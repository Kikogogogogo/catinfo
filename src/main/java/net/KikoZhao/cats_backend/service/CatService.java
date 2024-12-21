package net.KikoZhao.cats_backend.service;

import net.KikoZhao.cats_backend.DTO.CatDTO;

import java.util.List;

public interface CatService {
    CatDTO createCat(CatDTO catDTO);
    CatDTO getCatById(Long catId);
    List<CatDTO> getAllCats();
    CatDTO updateCat(Long catId, CatDTO updatedCat);
    void deleteCat(Long catId);
}
