import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunction implements RequestHandler<Void, String> {

    private static final long classloaderTime;
    private final long constructorTime;
    private long methodTime;

    static {
        classloaderTime = System.currentTimeMillis();
    }

    public LambdaFunction() {
        constructorTime = System.currentTimeMillis();
    }

    public String handleRequest(Void args, Context context) {

        try {
            long ms = 10000;
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        methodTime = System.currentTimeMillis();

        return new StringBuilder()
                .append("classloaderTime=")
                .append(classloaderTime)
                .append(", constructorTime=")
                .append(constructorTime)
                .append(", methodTime=")
                .append(methodTime)
                .toString();
    }

    public static void main(String[] args) {
        LambdaFunction function = new LambdaFunction();
        System.out.println(function.handleRequest(null, null));
        sleep();
        System.out.println(function.handleRequest(null, null));
        sleep();
        System.out.println(function.handleRequest(null, null));
        sleep();
        function = new LambdaFunction();
        System.out.println(function.handleRequest(null, null));
        sleep();
        System.out.println(function.handleRequest(null, null));
        sleep();
        System.out.println(function.handleRequest(null, null));
    }

    static void sleep() {
        try {
            long ms = 25;
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
