package com.wez.springaop;

import com.wez.svc.PersonService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPTest {

    @Test
    public void testAop() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        PersonService personService = (PersonService) context.getBean(PersonService.class);
//        personService.queryAllPerson();

//        personService.save(null);

        Object o = personService.queryById("10001");
        System.out.println(o);
    }



}
