package csc340.homework;

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
@RequestMapping("/api/characters")
public class CharacterApiController {
    private final CharacterService characterService;

    public CharacterApiController(CharacterService characterService){
        this.characterService = characterService;
    }

    
  /**
   * Endpoint to retrieve all characters.
   *
   * @return ResponseEntity containing a collection of all characters.
   */
  @GetMapping("/")
  public ResponseEntity<Collection<Character>> getAllCharacters() {
    return ResponseEntity.ok(characterService.getAllCharacters());
  }

  /**
   * Endpoint to retrieve a character by their ID.
   *
   * @param id The ID of the character to retrieve.
   * @return ResponseEntity containing the character if found, or a 404 Not Found
   *         status if not found.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
    Character character = characterService.getCharacterByID(id);
    if (character != null) {
      return ResponseEntity.ok(character);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  /**
   * Endpoint to create a new character.
   *
   * @param character The character object to create, provided in the request body.
   * @return ResponseEntity containing the created character if successful, or a 404
   *         Not Found status if creation fails.
   */
  @PostMapping("/")
  public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
    Character createdCharacter = characterService.createCharacter(character);
    if (createdCharacter != null) {
      return ResponseEntity.ok(createdCharacter);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  /**
   * Endpoint to retrieve students by their loved gifts.
   *
   * @param lovedGifts The loved gifts to filter students by, provided as a path variable.
   * @return ResponseEntity containing a collection of characters with the specified
   *         major.
   */
  @GetMapping("/gifts/{lovedGift}")
  public ResponseEntity<Collection<Character>> getCharactersByLovedGift(@PathVariable String lovedGift) {
    return ResponseEntity.ok(characterService.getCharacterByGift(lovedGift));
  }


  /**
   * Endpoint to search for characters by name. If the name parameter is provided,
   * it will return characters whose names contain the specified value. If the name
   * parameter is not provided, it will return all characters.
   *
   * @param name The name to search for, provided as a request parameter. This
   *             parameter is optional.
   * @return ResponseEntity containing a collection of characters that match the
   *         search criteria, or all students if no name is provided.
   */
  @GetMapping("/search")
  public ResponseEntity<Collection<Character>> searchCharactersByName(@RequestParam(required = false) String name) {
    List<Character> characters;
    if (name != null) {
      characters = characterService.searchCharactersByName(name);
    } else {
      characters = characterService.getAllCharacters();
    }
    return ResponseEntity.ok(characters);
  }

  /**
   * Endpoint to retrieve a student by their marriage status.
   *
   * @param marriageStatus The marriage status of the character to retrieve, provided as a
   *              request parameter.
   * @return ResponseEntity containing the character if found, or a 404 Not Found
   *         status if not found.
   */
  @GetMapping("/marriage/{marriageStatus}")
  public ResponseEntity<List<Character>> getCharacterByMarriage(@PathVariable String marriageStatus) {
    List<Character> character = characterService.getCharacterbyMarriage(marriageStatus);
    if (character != null) {
      return ResponseEntity.ok(character);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  /**
   * Endpoint to update an existing character by their ID.
   *
   * @param id             The ID of the character to update, provided as a path
   *                       variable.
   * @param updatedCharacter The updated character object, provided in the request
   *                       body.
   * @return ResponseEntity containing the updated character if successful, or a 404
   *         Not Found status if the character to update is not found.
   */
  @PutMapping("/{id}")
  public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character updatedCharacter) {
    Character character = characterService.updateCharacter(id, updatedCharacter);
    if (character != null) {
      return ResponseEntity.ok(character);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  /**
   * Endpoint to delete a character by their ID.
   *
   * @param id The ID of the character to delete, provided as a path variable.
   * @return ResponseEntity with no content if deletion is successful, or a 404
   *         Not Found status if the character to delete is not found.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
    characterService.deleteCharacter(id);
    return ResponseEntity.noContent().build();
  }

}

