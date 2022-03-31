package hello.springpart2.member;

import hello.springpart2.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforEach(){
        AppConfig appConfig=new AppConfig();
        memberService = appConfig.memberService();
    }



    @Test
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