package com.nitesh.springbootmultithreading.services;

import com.nitesh.springbootmultithreading.entities.User;
import com.nitesh.springbootmultithreading.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {

    Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    @Async
    public CompletableFuture<List<User>> saveUser(MultipartFile file) throws Exception {
        long startTime = System.currentTimeMillis();
        List<User> users = parseCsvFile(file);
        LOG.info("Saving list of users of size {} thread name {}", users.size(), Thread.currentThread().getName());
        users = repository.saveAll(users);
        long endTime = System.currentTimeMillis();
        LOG.info("Total time {}", endTime - startTime);
        return CompletableFuture.completedFuture(users);
    }

    @Async
    public CompletableFuture<List<User>> findAll() {
        LOG.info("Get list of users by {}", Thread.currentThread().getName());
        List<User> users = repository.findAll();
        return CompletableFuture.completedFuture(users);
    }

    private List<User> parseCsvFile(final MultipartFile file) throws Exception {
        final List<User> users = new ArrayList<>();
        try {
            try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    final String[] data = line.split(",");
                    final User user = new User();
                    user.setName(data[0]);
                    user.setEmail(data[1]);
                    user.setGender(data[2]);
                    users.add(user);
                }
            }
        } catch (Exception e) {

        }
        return users;
    }
}
