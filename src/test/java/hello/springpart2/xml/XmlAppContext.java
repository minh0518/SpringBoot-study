package hello.springpart2.xml;

import hello.springpart2.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

    @Test
    public void xmlAppContext(){
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        //GenericXmlApplicationContext 말고 부모인 ApplicationContext로 받아도 됨

        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
