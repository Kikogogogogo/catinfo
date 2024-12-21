package net.KikoZhao.cats_backend.repository;

import net.KikoZhao.cats_backend.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {
}
