package hello.springpart2.singleton;

import hello.springpart2.AppConfig;
import hello.springpart2.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수 DI컨테이너")
    public void pureContainer(){

        AppConfig appConfig=new AppConfig();


        MemberService memberService1 = appConfig.memberService();
        //1.조회 : 호출할 때마다 객체를 생성


        MemberService memberService2 = appConfig.memberService();
        //2.조회 : 호출할 때마다 객체를 생성


        //참조 값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService1 = " + memberService2);


        //Assertions.assertThat(memberService1).isEqualTo(memberService2);
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest(){
        SingletonService singletonService1= SingletonService.getInstance();
        SingletonService singletonService2= SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
    }

}
