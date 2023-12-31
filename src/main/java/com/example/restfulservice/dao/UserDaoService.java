package com.example.restfulservice.dao;

import com.example.restfulservice.bean.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1,"Kevin", new Date(),"test1234","111111-1111111"));
        users.add(new User(2,"Tom", new Date(),"test1234","111111-1111111"));
        users.add(new User(3,"Jake", new Date(),"test1234","111111-1111111"));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++userCount);
        }

        if(user.getJoinDate() == null){
            user.setJoinDate(new Date());
        }

        users.add(user);

        return user;
    }

    public User findOne(Integer id){
        for(User user:users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(Integer id){
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}

