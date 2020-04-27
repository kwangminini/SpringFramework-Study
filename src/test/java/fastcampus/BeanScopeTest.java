package fastcampus;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Objects;

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

class A{
    private int a1;
    private String a2;

    public A(int a1, String a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //두 객체가 동등성을 가지면 true
        if (!(o instanceof A)) return false; //타입 비교
        A a = (A) o; //object -> A로 타입 변환
        return a1 == a.a1 && //integer값이 같은지
                Objects.equals(a2, a.a2); //string값이 같은지
    }

    @Override
    public int hashCode() {
        return Objects.hash(a1, a2);
    }
}
