package csc340.homework;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    @Query(value = "SELECT s.* FROM characters s WHERE s.name like %?1%", nativeQuery = true)
    List<Character> findByName(String name);
    
    List<Character> findByLovedGift(String lovedGift);

    List<Character> findByMarriageStatus(String marriageStatus);
}

