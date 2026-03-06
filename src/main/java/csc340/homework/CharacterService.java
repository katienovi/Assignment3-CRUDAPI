package csc340.homework;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    public List<Character> getAllCharacters(){
        return characterRepository.findAll();
    }

    public Character createCharacter(Character character){
        return characterRepository.save(character);
    }

    public Character getCharacterByID(Long id){
        return characterRepository.findById(id).orElse(null);
    }

    public Character updateCharacter(Long id, Character updatedCharacter){
        return characterRepository.findById(id)
        .map(character -> {
            character.setName(updatedCharacter.getName());
            character.setDescription(updatedCharacter.getDescription());
            character.setLovedGift(updatedCharacter.getLovedGift());
            character.setMarriageStatus(updatedCharacter.getMarriageStatus());
            return characterRepository.save(character);
        })
        .orElse(null);
    }

    public void deleteCharacter(Long id){
        characterRepository.deleteById(id);
    }

    public List<Character> searchCharactersByName(String name){
        return characterRepository.findByName(name);
    }

    public List<Character> getCharacterByGift(String lovedGift){
        return characterRepository.findByLovedGift(lovedGift);
    }

    public List<Character> getCharacterbyMarriage(String marriageStatus){
        return characterRepository.findByMarriageStatus(marriageStatus);
    }

}
