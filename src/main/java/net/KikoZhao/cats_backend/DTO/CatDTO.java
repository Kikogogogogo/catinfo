package net.KikoZhao.cats_backend.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CatDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
