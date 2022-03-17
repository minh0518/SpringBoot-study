package Hello.hellospring;


import Hello.hellospring.repository.*;
import Hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {


    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
                                //@Autowired 기능
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JDBCMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);

        return new JpaMemberRepository(em);
        //리턴하는건 구현체
    }
}
