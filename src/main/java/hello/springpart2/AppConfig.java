package hello.springpart2;

import hello.springpart2.discount.FixDiscountPolicy;
import hello.springpart2.member.MemberService;
import hello.springpart2.member.MemberServiceImpl;
import hello.springpart2.member.MemoryMemberRepository;
import hello.springpart2.order.OrderService;
import hello.springpart2.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }


}
