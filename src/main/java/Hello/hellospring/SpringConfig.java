package Hello.hellospring;


import Hello.hellospring.repository.MemberRepository;
import Hello.hellospring.repository.MemoryMemberRepository;
import Hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
                                //@Autowired 기능
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository(); //리턴하는건 구현체
    }
}
