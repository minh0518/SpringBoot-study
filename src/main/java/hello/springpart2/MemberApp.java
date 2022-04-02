package hello.springpart2;

import hello.springpart2.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Junit없이 일반 java코드로 member테스트
public class MemberApp {

    public static void main(String[] args) {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService",MemberService.class); //사용
        //new MemberServiceImpl(memoryRepository()); 가 리턴돼서 memberService변수로 들어감 


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); //회원가입


        Member findMember = memberService.findMember(1L);
        System.out.println("new member ="+member.getName());
        System.out.println("findMember = "+findMember.getName());
        //회원 조회
    }
}