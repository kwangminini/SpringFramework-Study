package fastcampus;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BeanScopeTest {
//    @Test
//    public void testIdentity(){ //동일성 테스트
//        //동일성(identity) : 객체 주소가 같다. - (obj1 == obj2 == obj3) == true
//        //동등성(equals) : 객체의 값이 같다 - (obj1.equals(obj2)) == true
//        A a1 = new A();
//        //A a2 = new A();
//        //Assert.assertTrue(a1==a2);  결과 : false
//        A a2=a1; //a2는 a1이 가리키는 메모리를 가리키고있다.
//        Assert.assertTrue(a1==a2);
//    }
    @Test
    public void testEquals(){ //동일성으로 보면 모두 다르다 그러나 동등성은 a1 과 a2는 동등하다
        A a1 = new A(10,"Hello world");
        A a2 = new A(10,"Hello world");
        A a3 = new A(5,"Hello");

        Assert.assertTrue(a1.equals(a2)); //equals는 동일성 비교이다. 따라서 override해줘야 함
        Assert.assertFalse(a1.equals(a3));
    }
}

@EqualsAndHashCode
@AllArgsConstructor
class A{
    private int a1;
    private String a2;
}
