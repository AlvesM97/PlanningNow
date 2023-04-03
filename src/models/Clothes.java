package models;

public class Clothes {

    private String size;
    private String color;
    private String name;
    private Float value;
    private String image;

    public Clothes(String size, String color, String name, Float value, String image) {
        this.size = size;
        this.color = color;
        this.name = name;
        this.value = value;
        this.image = image;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Float getValue() {
        return value;
    }
    
    public void setValue(Float value) {
        this.value = value;
    }
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

}
