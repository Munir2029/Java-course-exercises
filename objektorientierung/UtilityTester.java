package objektorientierung;

public class UtilityTester {
    public static void main(String[] args) {
        int x = AssistentV1.inputBetween(1,5,"1. Change text\n2. Encode by X?\n3. Decode by X\n4. EXIT \n5. Zrück");
        System.out.println(x);
    }
}
