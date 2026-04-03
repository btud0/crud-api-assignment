package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/demo/src/main/resources/static/";

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Character createCharacter(Character character, MultipartFile picture) {
        if (picture != null && !picture.isEmpty()) {
            try {
                String filename = picture.getOriginalFilename();
                Path path = Paths.get(UPLOAD_DIR + filename);
                Files.write(path, picture.getBytes());
                character.setImageUrl(filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return characterRepository.save(character);
    }

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    public Character getCharacterById(Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    public Character updateCharacter(Long id, Character updatedCharacter, MultipartFile picture) {
        if (picture != null && !picture.isEmpty()) {
            try {
                String filename = picture.getOriginalFilename();
                Path path = Paths.get(UPLOAD_DIR + filename);
                Files.write(path, picture.getBytes());
                updatedCharacter.setImageUrl(filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return characterRepository.findById(id)
                .map(character -> {
                    character.setName(updatedCharacter.getName());
                    character.setDescription(updatedCharacter.getDescription());
                    character.setRank(updatedCharacter.getRank());
                    character.setTechniques(updatedCharacter.getTechniques());
                    if (updatedCharacter.getImageUrl() != null) {
                        character.setImageUrl(updatedCharacter.getImageUrl());
                    }
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
