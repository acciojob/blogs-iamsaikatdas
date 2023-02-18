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
        User user = userRepository.findById(userId).get();
        Blog blog = new Blog(user,title,content);
        blog.setPubDate(new Date());
        userRepository.save(user); //Blog saved in repo by cascading
        user.getBlogList().add(blog);
        return blog;
    }

    public void deleteBlog(int blogId) {
        //delete blog and corresponding images
        blogRepository.deleteById(blogId);
    }
}