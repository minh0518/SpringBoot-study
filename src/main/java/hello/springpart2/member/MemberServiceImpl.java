package hello.springpart2.member;

public class MemberServiceImpl implements MemberService{


    private final MemberRepository memberRepository=new MemoryMemberRepository();
                                                    //인터페이스의 구현체를 반드시 선택해 줘야 한다

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
