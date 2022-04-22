package hello.springpart2.order;

import hello.springpart2.discount.FixDiscountPolicy;
import hello.springpart2.member.Grade;
import hello.springpart2.member.Member;
import hello.springpart2.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository=new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository,new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        //createOrder 메소드의 리턴값 order중 할인 가격을바탕으로 테스트
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}