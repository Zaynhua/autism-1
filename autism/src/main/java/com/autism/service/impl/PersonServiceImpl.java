package com.autism.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autism.mapper.PersonMapper;
import com.autism.model.Person;
import com.autism.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {

  @Autowired
  private PersonMapper personMapper;

  public List<Person> loadPersons() {
    // return this.personMapper.queryAll();
    return this.personMapper.selectAll();
  }

}
