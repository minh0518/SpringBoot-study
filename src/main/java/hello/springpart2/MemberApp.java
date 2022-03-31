package hello.springpart2;

import hello.springpart2.member.*;

//Junit없이 일반 java코드로 member테스트
public class MemberApp {

    public static void main(String[] args) {

        //이렇게 AppConfig를 사용
        AppConfig appConfig=new AppConfig();
        MemberService memberService=appConfig.memberService();
        //MemoryMemberRepository와 연결된
        //MemberServiceImpl를 리턴

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); //회원가입


        Member findMember = memberService.findMember(1L);
        System.out.println("new member ="+member.getName());
        System.out.println("findMember = "+findMember.getName());
        //회원 조회
    }
}