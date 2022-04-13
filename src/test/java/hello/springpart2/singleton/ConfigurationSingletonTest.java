package hello.springpart2.singleton;

import hello.springpart2.AppConfig;
import hello.springpart2.member.MemberRepository;
import hello.springpart2.member.MemberServiceImpl;
import hello.springpart2.order.OrderService;
import hello.springpart2.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    public void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        //여기서는 받아주는 타입을 구현체로 사용합니다




        MemberRepository memberRepository1=memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);


        //AppConfig에 있는 찐 MemberRepository객체 를 가져옴
        MemberRepository memberRepository = ac.getBean("memoryRepository", MemberRepository.class);
        System.out.println("memoryRepository = " + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);

    }
}
