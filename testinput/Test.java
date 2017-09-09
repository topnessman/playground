import qual.Left;
import qual.Poly;
import qual.Right;
import qual.Top;

class A{
    @Poly A getObject(){return null;}
    @Poly A getSecondObject(@Poly A this){return null;}
    @Poly A getThirdObject(@Left A this){return null;}
    @Right A getForthObject(){
        return this.getThirdObject();
    }
}
public class Test{
    void test1(@Left A a){
        @Left Object l = a.getObject();
        @Right Object r = a.getObject();
    }

    void test2(@Left A a) {
        @Left Object l = a.getSecondObject();
        //:: error: (assignment.type.incompatible) //TODO Should be poly.invocation.error something...
        @Right Object r = a.getSecondObject();
    }

    void test3(@Left A a) {
        // This correctly typechecks
        @Right Object r = a.getObject().getThirdObject();
    }

    // TODO Poly return type used on poly receiver
    void test4(@Left A a) {
        //TODO doesn't typecheck right now. But should(?)
        @Left Object l = a.getObject().getSecondObject();
        //TODO doesn't typecheck right now. But should(?)
        @Right Object r = a.getSecondObject().getSecondObject();
    }
}