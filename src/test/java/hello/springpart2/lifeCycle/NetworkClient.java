package hello.springpart2.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean , DisposableBean {
    //새로 implements

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출 , url = " + url);
//        connect();
//        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect(){
        System.out.println("connect : "+url);
    }

    public void call(String message){
        System.out.println("call"+url+"message ="+message);
    }

    public void disconnect(){
        System.out.println("close : "+url);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //초기화 로직
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }

    @Override
    public void destroy() throws Exception {
        //종료 로직
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}