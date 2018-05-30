package com.example.GoodRecept;

public class Recept
{
    private long	id;
    private String	name;
    private String image;
    private String level;
    private String time;
    private String ingredients;
    private String make;





    public Recept() {}

    public Recept(long id, String name, String image, String level, String time, String ingredients, String make )
    {
        this.id		= id;
        this.name	= name;
        this.image = image;
        this.level = level;
        this.time = time;
        this.ingredients = ingredients;
        this.make = make;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image= image;
    }

    public String getImage() {
        return image;
    }

    public void setLevel(String level) {
        this.level= level;
    }

    public String getLevel() {
        return level;
    }

    public void setTime(String time) {
        this.time= time;
    }

    public String getTime() {
        return time;
    }

    public void setIngredients(String ingredients) {
        this.ingredients= ingredients;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setMake(String make) {
        this.make= time;
    }

    public String getMake() {
        return make;
    }


/*
    @Override
    public String toString() {
        return "Recept [id=" + this.id + ", name=" + this.name + ", image=" + this.image + ", level=" + this.level + ", time=" + this.time + ", ingredients=" + this.ingredients + ", make=" + this.make + "]";
    }
*/


//////////////////////////////data.txt String//////////////////////

    @Override
    public String toString() {
        return " {id=" + this.id + ", name=" + this.name + ", image=" + this.image + ", level=" + this.level + ", time=" + this.time + ", ingredients=" + this.ingredients + ", make=" + this.make + "},";
    }


}
