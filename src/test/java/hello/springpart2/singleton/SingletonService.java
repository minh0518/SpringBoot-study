package hello.springpart2.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //자기자신 객체를 내부에하나 가지고 있는데 반드시 static으로 사용
    //이렇게 되면 클래스레벨에 딱 하나만 존재하게 된다


    //위에서 만든 자기자신 객체를 조회하는 메소드
    //간단하다 그냥 위에서 선언한 변수를 리턴해주는 메소드로 만들면 된다
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}


