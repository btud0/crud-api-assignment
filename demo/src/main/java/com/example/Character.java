package com.example;
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

    private Long characterId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String description;

    private String rank;
    private String techniques;
    

    public Character() {
    // Default constructor
}

public Character(String name, String email, String description, String rank, String techniques) {
    this.name = name;
    this.email = email;
    this.description = description;
    this.rank = rank;
    this.techniques = techniques;
}

public Character(Long characterId, String name, String email, String description, String rank, String techniques) {
    this.characterId = characterId;
    this.name = name;
    this.email = email;
    this.description = description;
    this.rank = rank;
    this.techniques = techniques;
}

public long getCharacterID() {
    return characterId;
    }


    public void setCharacterID(long characterId) {
        this.characterId = characterId;
    }       

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setTechniques(String techniques) {
        this.techniques = techniques;
    }
    public String getTechniques() {
        return techniques;
    }   

}//end of class


