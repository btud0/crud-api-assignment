package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/characters")
public class CharacterUIController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/{id}")
    public String getCharacterById(@PathVariable Long id, Model model){
        Character character = characterService.getCharacterById(id);
        model.addAttribute("character", character);
        if (character != null) {
            return "details";
        } else {
            return "about";
        }
    }

    @GetMapping("/add")
    public String showForm(){
        return "new-character-form";
    }

    @GetMapping("/all")
    public String getAllCharacters(Model model){

        model.addAttribute("characterList", characterService.getAllCharacters());
        return "character-list";
    }

    @GetMapping("/updateForm/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Character character = characterService.getCharacterById(id);
        
        model.addAttribute("character", character);
        
        return "character-update";
}   

    @GetMapping("/search")
    public String searchCharactersByName(@RequestParam(required = false) String name, Model model) {
        if (name != null && !name.isBlank()) {
         model.addAttribute("characterList", characterService.searchCharactersByName(name));
      } else {
            model.addAttribute("characterList", characterService.getAllCharacters());
     }
    return "character-list";
}
    


    @GetMapping("/delete/{id}")
    public String deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return "redirect:/characters/all";
    }

        @PostMapping("/add")
    public String addCharacter(@ModelAttribute Character character,
                               @RequestParam("picture") MultipartFile picture) {
        characterService.createCharacter(character, picture);
        return "redirect:/characters/all";
    }

    @PostMapping("/update/{id}")
    public String updateCharacter(@PathVariable Long id,
                                  @ModelAttribute Character character,
                                  @RequestParam("picture") MultipartFile picture) {
        characterService.updateCharacter(id, character, picture);
        return "redirect:/characters/all";
    }
}
