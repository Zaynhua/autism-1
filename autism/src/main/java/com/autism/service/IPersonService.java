package com.autism.service;

import java.util.List;

import com.autism.model.Person;

public interface IPersonService {

    /**
     * 加载全部的person
     * @return
     */
    List<Person> loadPersons();
}