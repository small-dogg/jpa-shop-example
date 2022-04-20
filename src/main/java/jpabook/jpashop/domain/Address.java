package jpabook.jpashop.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

  //공통으로 사용하는 엔티티에서 필드의 정의도 공통으로 작성할 수 있다.
  @Column(length = 10)
  private String city;
  @Column(length = 20)
  private String street;
  @Column(length = 5)
  private String zipcode;

  private void setCity(String city) {
    this.city = city;
  }

  private void setStreet(String street) {
    this.street = street;
  }

  private void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  //의미있는 비즈니스 메서드를 만들 수 있다.
  //값 타입을 의미하게 쓸 수 있는.. 객체 지향적으로 사용할 수 있는..
  // 실제 운영에서 모델링할때도 이렇게 씀..(Stereo Type (UML))
  public String fullAddress(){
    return getCity() + getStreet() + getZipcode();
  }


  //프록시일 때 값이 작성이 안되기 때문에, getter로 값을 호출하도록 equals를 작성해야함.
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(getCity(), address.getCity()) && Objects.equals(
        getStreet(), address.getStreet()) && Objects.equals(getZipcode(),
        address.getZipcode());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCity(), getStreet(), getZipcode());
  }
}
