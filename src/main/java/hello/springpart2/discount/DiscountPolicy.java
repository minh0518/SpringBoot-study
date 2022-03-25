package hello.springpart2.discount;

import hello.springpart2.member.Member;

public interface DiscountPolicy {

    //할인 대상으로 할인된 금액을 리턴해줌
    int discount(Member member, int price);

}
