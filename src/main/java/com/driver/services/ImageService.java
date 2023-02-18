package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions) {
        //add an image to the blog
        Blog blog = blogRepository2.findById(blogId).get();

        Image image = new Image();
        image.setBlog(blog);
        image.setDescription(description);
        image.setDimension(dimensions);

        blogRepository2.save(blog);
        imageRepository2.save(image);
        return image;

    }

    public void deleteImage(Integer id) {
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        String[] scrArray = screenDimensions.split("X"); //A=Length   X    B=Br
        Image image = imageRepository2.findById(id).get();
        System.out.println(image + " image dimension 1");

        String imageDimensions = image.getDimension();
        String[] imgArray = imageDimensions.split("X");
        System.out.println(imageDimensions + " image dimension 2");

        int scrl = Integer.parseInt(scrArray[0]); //A -- > integer
        int scrb = Integer.parseInt(scrArray[1]); //B -- > integer

        int imgl = Integer.parseInt(imgArray[0]); //A -- > integer
        int imgb = Integer.parseInt(imgArray[1]); //B -- > integer

        return no_Images(scrl, scrb, imgl, imgb);

    }
    private int no_Images(int scrl, int scrb, int imgl, int imgb) {
        int lenC = scrl / imgl; //
        int lenB = scrb / imgb;
        return lenC * lenB;
    }
}