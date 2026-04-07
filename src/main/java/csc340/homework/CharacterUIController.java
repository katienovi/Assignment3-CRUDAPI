package csc340.homework;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping
     public String getAllCharacters(Model model) {
        model.addAttribute("characterList", characterService.getAllCharacters());
        return "character-list";
    }

    @GetMapping("/{id}")
    public String getCharacterById(@PathVariable Long id, Model model) {
    Character character = characterService.getCharacterByID(id);
    model.addAttribute("character", character);

    if (character != null) {
      return "character-details";
    } else {
      return "about";
    }
  }


  @GetMapping("/delete/{id}")
  public String deleteCharacter(@PathVariable Long id) {
    characterService.deleteCharacter(id);
    return "redirect:/characters";
  }

  @GetMapping("/add")
  public String showAddCharacterForm(Model model) {
    model.addAttribute("character", new Character());
    model.addAttribute("title", "Add New Character");
    return "new-character-form";
  }

  @PostMapping("/")
  public String addCharacter(Character character, MultipartFile picture) {
    Character newCharacter = characterService.createCharacter(character);
    if (newCharacter != null) {
      characterService.saveProfilePicture(newCharacter, picture);
      return "redirect:/characters/" + newCharacter.getCharacterID();
    } else {
      return "redirect:/characters/add?error=true";
    }
  }

  @PostMapping("/update/{id}")
  public String updateCharacter(@PathVariable Long id, Character updatedCharacter, MultipartFile picture) {
    Character character = characterService.updateCharacter(id, updatedCharacter);
    
    if (character != null) {
      characterService.saveProfilePicture(character, picture);
      return "redirect:/characters/" + character.getCharacterID();
    } else {
      return "redirect:/characters/" + id + "?error=true";
    }
  }

}
