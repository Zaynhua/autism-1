package com.autism.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * person 实体
 * 
 * @author Administrator
 *
 */
@Table(name = "person")
public class Person {
  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;
  @Column(name = "age")
  private int age;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", name=" + name + "]";
  }
}
