package jpabook.jpashop.domain;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery extends BaseEntity{
  @Id @GeneratedValue
  private long id;

  @OneToOne(mappedBy = "delivery", fetch = LAZY)
  private Order order;

  private String city;

  private String street;

  private String zipcode;

  private DeliveryStatus status;
}
