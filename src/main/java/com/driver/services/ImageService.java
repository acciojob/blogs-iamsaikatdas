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

    public Image addImage(Integer blogId, String description, String dimensions){
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

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        List<Image> image = imageRepository2.getAllImage();

        Image image1= new Image();
        int count =0;
        for (Image c: image){
            if ( image1.getDimension() == screenDimensions){
                count++;
            }
        }
        return count;
    }
}
