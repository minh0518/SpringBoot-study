package hello.springpart2.beanfind;

import hello.springpart2.AppConfig;
import hello.springpart2.member.Member;
import hello.springpart2.member.MemberService;

import hello.springpart2.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);


//    @Test
//    @DisplayName("빈 이름으로 조회")
//    public void findByName(){
//        MemberService memberService = ac.getBean("memberService",MemberService.class);
//        //System.out.println("memberService = " + memberService);
//        //System.out.println("memberService = " + memberService.getClass());
//        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//    }

//    @Test
//    @DisplayName("이름없이 타입으로만 조회")
//    public void findByType(){
//        MemberService memberService = ac.getBean(MemberService.class);
//        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//    }
//    @Test
//    @DisplayName("구체 타입으로 조회")
//    public void findByType2(){
//        MemberService memberService = ac.getBean(MemberServiceImpl.class);
//        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//    }


    @Test
    @DisplayName("빈 조회 X")
    public void findByNameX(){
        //ac.getBean("xxxx", MemberService.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxxx", MemberService.class));
    }


}
