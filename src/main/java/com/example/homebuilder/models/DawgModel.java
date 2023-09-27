package com.example.homebuilder.models;

public class DawgModel {


    private String name;
    private String gender;
    private String breed;
    private String size;
    private String colour;
    private String family;

    public DawgModel (String name, String gender, String breed, String size, String colour, String family) {
        this.name = name;
        this.gender = gender;
        this.breed = breed;
        this.size = size;
        this.colour = colour;
        this.family = family;
    }

    public void setName (String name) {this.name = name;}
    public String getName () {return name;}
    public void setGender (String gender) {this.gender = gender;}
    public String getGender () {return gender;}
    public void setBreed (String breed) {this.breed = breed;}
    public String getBreed () {return breed;}
    public void setSize (String size) {this.size = size;}
    public String getSize () {return size;}
    public void setColour (String colour) {this.colour = colour;}
    public String getColour () {return colour;}
    public void setFamily (String family) {this.family = family;}
    public String getFamily () {return family;}
}
