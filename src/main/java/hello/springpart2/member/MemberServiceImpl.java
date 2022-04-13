package hello.springpart2.member;

public class MemberServiceImpl implements MemberService{

    private MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }




    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    //AppConfig에서 싱글톤이 깨지는지 아닌지 확인하기 위한 테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
