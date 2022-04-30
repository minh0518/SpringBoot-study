package hello.springpart2.lifeCycle;

public class NetworkClient {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출 , url = " + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작할 때 호출되는 메소드
    public void connect(){
        System.out.println("connect : "+url);
    }

    // 연결이 된 상태에서 사용할 수 있는 메소드드
   public void call(String message){
       System.out.println("call"+url+"message ="+message);
   }

    //서비스 종료시 호출되는 메소드
    public void disconnect(){
        System.out.println("close : "+url);
    }
}
