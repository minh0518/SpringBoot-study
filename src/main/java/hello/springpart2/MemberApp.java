package hello.springpart2;

import hello.springpart2.member.*;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService=new MemberServiceImpl();
        //여기서도 마찬가지로, 인터페이스의 구현체를 반드시 선택해 줘야 한다
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); //회원가입

        
        Member findMember = memberService.findMember(1L);
        System.out.println("new member ="+member.getName());
        System.out.println("findMember = "+findMember.getName());
        //회원 조회
    }
}
