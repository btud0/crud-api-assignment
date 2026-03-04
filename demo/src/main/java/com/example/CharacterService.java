package com.example;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;


    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Character createCharacter(Character character) {
        return characterRepository.save(character);
    }
    
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }   

    public Character getCharacterById(Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    public Character updateCharacter(Long id, Character updatedCharacter) {
        return characterRepository.findById(id)
                .map(character -> {
                    character.setName(updatedCharacter.getName());
                    character.setDescription(updatedCharacter.getDescription());
                    character.setRank(updatedCharacter.getRank());
                    character.setTechniques(updatedCharacter.getTechniques());
                    return characterRepository.save(character);
                })
                .orElse(null);
    }


    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }

    public List<Character> searchCharactersByName(String name) {
        return characterRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Character> searchCharactersByRank(String rank) {
        return characterRepository.findByRank(rank);
    }

    public List<Character> searchCharactersByTechnique(String technique) {
        return characterRepository.findByTechniquesContaining(technique);
    }   




}
