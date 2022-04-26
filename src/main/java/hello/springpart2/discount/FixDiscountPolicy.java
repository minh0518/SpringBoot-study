package hello.springpart2.discount;

import hello.springpart2.member.Grade;
import hello.springpart2.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount =1000;
                //1000원 할인


    @Override
    public int discount(Member member, int price) {  //할인된 금액을 리턴
        if (member.getGrade() == Grade.VIP) { //Enum타입은 isequal안쓰고 ==써도 됨
            return discountFixAmount;
        }
        else{
            return 0;
        }
    } //discount 메소드가 할인 금액을 리턴하는 것이므로 
        //1000원 or 0원을 리턴
}
