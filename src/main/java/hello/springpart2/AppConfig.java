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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memoryRepository());
    }

    @Bean
    public MemberRepository memoryRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memoryRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
