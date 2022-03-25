package hello.springpart2.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
    //리턴하는 것이 Order객체
}
