package hello.springpart2;

import hello.springpart2.member.Grade;
import hello.springpart2.member.Member;
import hello.springpart2.member.MemberService;
import hello.springpart2.member.MemberServiceImpl;
import hello.springpart2.order.Order;
import hello.springpart2.order.OrderService;
import hello.springpart2.order.OrderServiceImpl;


//Junit없이 일반 java코드로 order테스트
public class OrderApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}