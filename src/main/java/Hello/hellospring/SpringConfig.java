package Hello.hellospring;


import Hello.hellospring.repository.JDBCMemberRepository;
import Hello.hellospring.repository.JdbcTemplateMemberRepository;
import Hello.hellospring.repository.MemberRepository;
import Hello.hellospring.repository.MemoryMemberRepository;
import Hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class SpringConfig {

    private DataSource dataSource; //DataSource는 스프링 기본제공

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource=dataSource;
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
        return new JdbcTemplateMemberRepository(dataSource);
        //리턴하는건 구현체
    }
}
