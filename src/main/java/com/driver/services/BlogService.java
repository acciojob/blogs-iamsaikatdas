package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Blog blog = new Blog();
        blog.setPubDate(date);

        //updating the blog details
        User user = userRepository.findById(userId).get();
        blog.setUser(user);
        blog.setTitle(title);
        blog.setContent(content);

        userRepository.save(user);
        blogRepository.save(blog);
        //Updating the userInformation and changing its blogs
        return blog;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        if (blogRepository.findById(blogId).get() == null) return;;
        blogRepository.deleteById(blogId);
    }
}
