package hello.springpart2.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


class StatefulServiceTest {

    @Test
    public void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);


        //ThreadA: A사용자가 만약 1만원 짜리를 주문
        int userAPrice = statefulService1.order("userA", 10000);

        //ThreadB: B사용자가 만약 2만원 짜리를 주문
        int userBPrice = statefulService2.order("userA", 20000);

        //ThreadA: A사용자가 주문 금액을 조회
        //int price=statefulService1.getPrice();
        System.out.println("price = " + userAPrice);

      //  Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}