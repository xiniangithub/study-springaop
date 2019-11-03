package com.wez.svc;

import java.util.List;

public interface PersonService {

    Object save(Object person) throws Exception;

    List<Object> queryAllPerson();

    Object queryById(String personId);

}
