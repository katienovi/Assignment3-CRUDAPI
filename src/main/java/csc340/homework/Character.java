package csc340.homework;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "characters")

public class Character {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long characterID;

  @Column(nullable = false)
  public String name;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private String lovedGift;

  @Column(nullable = false)
  private String marriageStatus;

  private String profilePicturePath;

  public Character() {
  }

    public Character(String name, String description, String lovedGift, String marriageStatus){
        this.name = name;
        this.description = description;
        this.lovedGift = lovedGift;
        this.marriageStatus = marriageStatus;
    }

    public Character(Long characterId, String name, String description, String lovedGift, String marriageStatus){
        this.characterID = characterId;
        this.name = name;
        this.description = description;
        this.lovedGift = lovedGift;
        this.marriageStatus = marriageStatus;
    }

    public Long getCharacterID(){
        return characterID;
    }

    public void setCharacterID(Long characterID){
        this.characterID = characterID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getLovedGift(){
        return lovedGift;
    }

    public void setLovedGift(String lovedGift){
        this.lovedGift = lovedGift;
    }

    public String getMarriageStatus(){
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus){
        this.marriageStatus = marriageStatus;
    }

    public String getProfilePicturePath(){
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath){
        this.profilePicturePath = profilePicturePath;
    }

}