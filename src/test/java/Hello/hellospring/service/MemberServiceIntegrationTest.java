package Hello.hellospring.service;

import Hello.hellospring.domain.Member;
import Hello.hellospring.repository.MemberRepository;
import Hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class MemberServiceIntegrationTest{

    //테스트케이스는 그냥 말 그대로 해당 코드만 테스트하면 되므로
//편한거 쓰면 돼서 필드 주입을 이용해서 의존관계를 만들어 줍니다
    @Autowired MemberService memberService;

    @Autowired MemberRepository repository;
//빈에다가는 구현체말고 인터페이스를 등록해 두었으므로

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");
        //When
        Long saveId = memberService.join(member);
        //회원가입(join)하면 id값이 리턴 되므로
        //Then
        Member findMember= memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1= new Member();
        member1.setName("spring");

        Member member2= new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);


        //then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");


    }


}