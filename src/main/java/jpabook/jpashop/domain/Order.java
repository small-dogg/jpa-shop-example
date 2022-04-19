package jpabook.jpashop.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ORDERS")
public class Order extends BaseEntity{

  @Id
  @GeneratedValue
  @Column(name = "ORDER_ID")
  private Long id;

  //관계형 DB 맞춤 설계
  // 객체 지향 스럽지 않음... 객체 그래프가 끊김..
//  private Long memberId;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "MEMBER_ID")
  private Member member;

  @OneToMany(mappedBy = "order", cascade = ALL)
  private List<OrderItem> orderItems = new ArrayList();

  private LocalDateTime orderDate;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  //Delivery 비즈니스 로직이 복잡하거나, 라이프 사이클을 따로 관리해야한다면 영속성 전이를 하지 않는 편이 낫다.
  @OneToOne(fetch = LAZY, cascade = ALL)
  @JoinColumn(name = "DELIVERY_ID")
  private Delivery delivery;

  //연관관계 편의 메서드
  public void addOrderItem(OrderItem orderItem) {
    orderItems.add(orderItem);
    orderItem.setOrder(this);
  }
}
