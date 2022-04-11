package hello.springpart2.singleton;

public class StatefulService {
    
    
    //private int price; //상태를 유지하는 필드. 이게 공유필드가 된다.

    //주문하면 가격을 저장해놓고
   public int order(String name,int price){
        System.out.println("name = " + name + "price = "+price);
   //     this.price=price; //여기서 문제가 발생!
        return price;
    }

//    //그 가격을 확인
//    public int getPrice(){
//       return price;
//    }
}
