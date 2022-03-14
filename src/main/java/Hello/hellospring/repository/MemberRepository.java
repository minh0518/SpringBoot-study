package Hello.hellospring.repository;

import Hello.hellospring.domain.Member; //도메인 객체인 Member 클래스 사용
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
