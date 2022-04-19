package jpabook.jpashop.domain;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Book extends Item{
  private String author;
  private String isbn;
}
