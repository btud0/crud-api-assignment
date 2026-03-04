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



    @Column(nullable = false)
    private String description;

    private String rank;
    private String techniques;
    

    public Character() {
    // Default constructor
}

public Character(String name, String description, String rank, String techniques) {
    this.name = name;
    this.description = description;
    this.rank = rank;
    this.techniques = techniques;
}

public Character(Long characterId, String name, String description, String rank, String techniques) {
    this.characterId = characterId;
    this.name = name;
    this.description = description;
    this.rank = rank;
    this.techniques = techniques;
}

public Long getCharacterId() {
    return characterId;
    }


    public void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }       

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


