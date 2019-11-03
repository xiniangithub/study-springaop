package com.wez.svc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    public Object save(Object person) throws Exception {
        if (person == null) {
            throw new Exception("非法参数，null");
        }
        return person;
    }

    public List<Object> queryAllPerson() {
        System.out.println("查询所有用户");
        return new ArrayList<Object>();

    }

    public Object queryById(String personId) {
        System.out.println("查询" + personId + "人员");
        return new Object();
    }

}
