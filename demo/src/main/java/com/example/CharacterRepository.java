package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findByNameContainingIgnoreCase(String name);

    @Query("SELECT c FROM Character c WHERE c.rank = ?1")
    List<Character> findByRank(String rank);    

    @Query("SELECT c FROM Character c WHERE c.techniques LIKE %?1%")
    List<Character> findByTechniquesContaining(String technique);

    Character findByEmail(String email);
}
