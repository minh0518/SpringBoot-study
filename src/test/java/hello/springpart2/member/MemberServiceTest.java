package hello.springpart2.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class MemberServiceTest {

    MemberService memberService=new MemberServiceImpl();

    @Test  //이걸 작성해야 junit에서 import가 됨
    void join(){
        //given  이게 주어졌고
        Member member=new Member(1L,"memberA",Grade.VIP);

        //when  이렇게 했을 때
        memberService.join(member);
        Member findMember=memberService.findMember(1L);

        //then  이렇게 된다
        Assertions.assertThat(member).isEqualTo(findMember);


    }
}
