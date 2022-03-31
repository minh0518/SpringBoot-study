package hello.springpart2;

import hello.springpart2.discount.DiscountPolicy;
import hello.springpart2.discount.FixDiscountPolicy;
import hello.springpart2.discount.RateDiscountPolicy;
import hello.springpart2.member.MemberRepository;
import hello.springpart2.member.MemberService;
import hello.springpart2.member.MemberServiceImpl;
import hello.springpart2.member.MemoryMemberRepository;
import hello.springpart2.order.OrderService;
import hello.springpart2.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memoryRepository());
    }

    private MemberRepository memoryRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memoryRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
