package net.KikoZhao.cats_backend.service.impl;

import lombok.AllArgsConstructor;
import net.KikoZhao.cats_backend.DTO.CatDTO;
import net.KikoZhao.cats_backend.entity.Cat;
import net.KikoZhao.cats_backend.exception.ResourceNotFoundException;
import net.KikoZhao.cats_backend.mapper.CatMapper;
import net.KikoZhao.cats_backend.repository.CatRepository;
import net.KikoZhao.cats_backend.service.CatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatServiceImpl implements CatService {
    private CatRepository catRepository;

    @Override
    public CatDTO createCat(CatDTO catDTO) {
        Cat cat = CatMapper.mapToCat(catDTO);
        Cat savedCat = catRepository.save(cat);
        return CatMapper.mapToDTO(savedCat);
    }

    @Override
    public CatDTO getCatById(Long catId) {
        Cat cat = catRepository.findById(catId).orElseThrow(() ->
                new ResourceNotFoundException("Cat doesn't exist with given id: " + catId));
        return CatMapper.mapToDTO(cat);
    }

    @Override
    public List<CatDTO> getAllCats() {
        List<Cat> cats = catRepository.findAll();
        return cats.stream().map(CatMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CatDTO updateCat(Long catId, CatDTO updatedCat) {
        Cat cat = catRepository.findById(catId).orElseThrow(() ->
                new ResourceNotFoundException("Cat doesn't exist with given id: " + catId));
        cat.setFirstName(updatedCat.getFirstName());
        cat.setLastName(updatedCat.getLastName());
        cat.setEmail(updatedCat.getEmail());
        Cat updatedcat =  catRepository.save(cat);
        return CatMapper.mapToDTO(updatedcat);
    }

    @Override
    public void deleteCat(Long catId) {
        Cat cat = catRepository.findById(catId).orElseThrow(() ->
                new ResourceNotFoundException("Cat doesn't exist with given id: " + catId));
        catRepository.deleteById(catId);

    }
}
