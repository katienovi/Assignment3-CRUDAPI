package csc340.homework;


import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CharacterService {
    
    private final CharacterRepository characterRepository;
    private static final String UPLOAD_DIR = "src/main/resources/static/Images/";

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

    public void saveProfilePicture(Character character, MultipartFile profilePicture) {
    if (profilePicture == null || profilePicture.isEmpty()) {
      return;// No picture uploaded, skip saving
    }
    String originalFileName = profilePicture.getOriginalFilename();
    try {
      if (originalFileName != null && originalFileName.contains(".")) {
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = String.valueOf(character.getCharacterID()) + "." + fileExtension;
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        InputStream inputStream = profilePicture.getInputStream();

        Files.createDirectories(Paths.get(UPLOAD_DIR));// Ensure directory exists
        Files.copy(inputStream, filePath,
            StandardCopyOption.REPLACE_EXISTING);// Save picture file
        character.setProfilePicturePath(fileName);
        characterRepository.save(character);// Update student with picture path
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}


