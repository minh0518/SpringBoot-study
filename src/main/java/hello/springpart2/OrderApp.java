package hello.springpart2;

import hello.springpart2.member.Grade;
import hello.springpart2.member.Member;
import hello.springpart2.member.MemberService;
import hello.springpart2.member.MemberServiceImpl;
import hello.springpart2.order.Order;
import hello.springpart2.order.OrderService;
import hello.springpart2.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


//Junit없이 일반 java코드로 order테스트
public class OrderApp {

    public static void main(String[] args) {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService=applicationContext.getBean("memberService",MemberService.class); //사용
        //new MemberServiceImpl(memoryRepository()); 가 리턴돼서 memberService변수로 들어감
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);//사용
        //OrderServiceImpl(memoryRepository(), discountPolicy())가 리턴돼서 orderService에 들어감


        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}