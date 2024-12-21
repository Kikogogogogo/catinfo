package net.KikoZhao.cats_backend.mapper;
import net.KikoZhao.cats_backend.DTO.CatDTO;
import net.KikoZhao.cats_backend.entity.Cat;
public class CatMapper {
    public static CatDTO mapToDTO(Cat cat) {
        return new CatDTO(cat.getId(),
                cat.getFirstName(),
                cat.getLastName(),
                cat.getEmail()
                );
    }
    public static Cat mapToCat(CatDTO catDTO) {
        return new Cat(
                catDTO.getId(),
                catDTO.getFirstName(),
                catDTO.getLastName(),
                catDTO.getEmail()
        );
    }
}
