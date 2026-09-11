package java21;

public class Test {

    public static void main(String[] args) {
        TestRecord testRecord= new TestRecord(10,20);

        System.out.println(testRecord.x());
        testRecord= new TestRecord(20,30);
        System.out.println(testRecord.x());

    }
}
