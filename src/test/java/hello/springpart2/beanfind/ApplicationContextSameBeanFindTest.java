package hello.springpart2.beanfind;

import hello.springpart2.AppConfig;
import hello.springpart2.discount.DiscountPolicy;
import hello.springpart2.member.Member;
import hello.springpart2.member.MemberRepository;
import hello.springpart2.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생")
    public void findBeanByTypeDuplicate(){

        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                ()->ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 됩니다")
    public void findByName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1",MemberRepository.class);
        org.assertj.core.api.Assertions.assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }


    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    public void findAllByType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key ="+key+" value ="+beansOfType.get(key));
            
        }
        System.out.println("beansOfType = " + beansOfType); //이건 그냥 통으로 출력

        org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }


    @Configuration
    static class SameBeanConfig {

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }

}
