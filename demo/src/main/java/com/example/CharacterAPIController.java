package com.example;
import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/characters")
public class CharacterAPIController {
    private final CharacterService characterService;

    public CharacterAPIController(CharacterService characterService) {
        this.characterService = characterService;
    }

    /**
     * Retreive all of the characters in the database
     * @return ResponseEntity containing a collection of all characters
     */
    @GetMapping("/")
    public ResponseEntity<Collection<Character>> getAllCharacters() {
        return ResponseEntity.ok(characterService.getAllCharacters());
    }

    /**
     * Retreive a character by their ID
     * @param id ID of character to retreive
     * @return ResponseEntity containing student if found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
        Character character = characterService.getCharacterById(id);
        if(character != null) {
            return ResponseEntity.ok(character);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Create a new character in the database
     * @param character Character object to be created
     * @return ResponseEntity containing the created character if successful, or a bad request status if not
     */
    @PostMapping("/")
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        Character createdCharacter = characterService.createCharacter(character);
        if(createdCharacter != null) {
            return ResponseEntity.ok(createdCharacter);
        } else {
            return ResponseEntity.badRequest().build();
        }   
    }

    /**
     * Endpoint to retrieve characters by rank
     * @param rank  Rank to search for
     * @return Characters with the specified rank
     */
    @GetMapping("/rank/{rank}")
    public ResponseEntity<List<Character>> getCharacterByRank(@PathVariable String rank) {
        return ResponseEntity.ok(characterService.searchCharactersByRank(rank));
    }


    /**
     * Endpoint to retrieve characters by technique
     * @param technique Technique to search for
     * @return Characters with the specified technique
     */
    @GetMapping("/technique/{technique}")
    public ResponseEntity<List<Character>> getCharacterByTechnique(@PathVariable String technique) {
        return ResponseEntity.ok(characterService.searchCharactersByTechnique(technique));
    }

    /**
     * Endpoint to search for characters by name
     * @param name Name to search for (partial matches allowed)
     * @return List of characters matching the search criteria
     */
    @GetMapping("/search")
    public ResponseEntity<List<Character>> searchCharactersByName(@RequestParam(required = false) String name) {
        List<Character> character;
        if (name != null) {
            character = characterService.searchCharactersByName(name);
        } else {
            character = characterService.getAllCharacters();
        }
        return ResponseEntity.ok(character);
    }
    

    /**
     * Endpoint to update an existing character
     * @param id ID of character to update
     * @param characterDetails Updated character information
     * @return ResponseEntity containing the updated character if successful
     */
    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character characterDetails) {
        Character updatedCharacter = characterService.updateCharacter(id, characterDetails);
        if(updatedCharacter != null) {
            return ResponseEntity.ok(updatedCharacter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint to delete a character by ID
     * @param id ID of character to delete
     * @return ResponseEntity with no content if deletion was successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.noContent().build();
    }


}
