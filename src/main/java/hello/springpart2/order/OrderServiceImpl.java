package hello.springpart2.order;

import hello.springpart2.annotation.MainDiscountPolicy;
import hello.springpart2.discount.DiscountPolicy;
import hello.springpart2.discount.FixDiscountPolicy;
import hello.springpart2.discount.RateDiscountPolicy;
import hello.springpart2.member.Member;
import hello.springpart2.member.MemberRepository;
import hello.springpart2.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceImpl implements OrderService{

    //2개가 필요함 MemberRepository에서 회원을 찾아야 하고
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원을 찾고
        int discountPrice = discountPolicy.discount(member, itemPrice);
                                    //할인 받을 금액을 리턴 해줌 (0 or 1000)
        return new Order(memberId,itemName,itemPrice,discountPrice);
                //Order객체엔 id,상품이름,가격,할인금액 이렇게 넣어줘야 했었습니다
    }
    //OrderServiceImpl는 주문을 넣으면 최종적으로 주문결과를 반환합니다


    //AppConfig에서 싱글톤이 깨지는지 아닌지 확인하기 위한 테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }


}
