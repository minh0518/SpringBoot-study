package Hello.hellospring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TimeTraceAop {

    //공통 관심사항을 어디에다 타켓팅 할 것인가를 설정
    @Around("execution(* Hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start=System.currentTimeMillis();

        System.out.println("START : "+joinPoint.toString());
                        //어떤 메소드를 호출하는지 알려줌
        try{
            Object result=joinPoint.proceed(); //다음 메소드로 진행
            return result;
        }finally{
            long finish=System.currentTimeMillis();
            long timeMs=finish-start;
            System.out.println("END : "+joinPoint.toString()+" "+timeMs+"ms");
        }

    }

}
