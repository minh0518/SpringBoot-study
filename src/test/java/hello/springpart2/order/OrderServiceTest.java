package hello.springpart2.order;

import hello.springpart2.AppConfig;
import hello.springpart2.member.Grade;
import hello.springpart2.member.Member;
import hello.springpart2.member.MemberService;
import hello.springpart2.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforEach(){
        AppConfig appConfig=new AppConfig();
        memberService = appConfig.memberService();
        orderService=appConfig.orderService();
    }


    @Test
    void createOrder(){
        Long memberId=1L;   //프리미티브 타입인 long으로 써도 되지만
                            //이러면 null을 넣을 수 없으므로 래퍼객체 사용
                            //DB에 넣고 하다보면 null값이 들어갈 수도 있엇
                            //이렇게 사용

        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        //검증

    }
}
