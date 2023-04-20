package com.lma.ecommerce.DTO;



public class CategoryDTO {


    //Attributes
    private String name;

    private String imageURL;



    //Constructors
    public CategoryDTO() {
    }


    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
