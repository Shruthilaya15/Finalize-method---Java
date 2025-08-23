public class GarbageDemo {
    public static void main(String[] args) {
        MyObject obj = new MyObject("TestObject");
        obj = null;
        System.gc();
        try { Thread.sleep(1000); } catch (Exception e) {}
    }
}
class MyObject {
    private String name;
    public MyObject(String name) {
        this.name = name;
        System.out.println(name + " created");
    }
    @Override
    @Deprecated
    protected void finalize() throws Throwable {
        System.out.println("*** " + name + " is being garbage collected ***");
        super.finalize();
    }
}
