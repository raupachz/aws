import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaCounter implements RequestHandler<Void, Integer> {

    int counter;

    public LambdaCounter() {
        counter = 0;
    }

    public Integer handleRequest(Void input, Context context) {
        return ++counter;
    }
}
