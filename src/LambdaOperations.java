import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LambdaOperations {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        Collections.addAll(a,1,2,3,4);
        Optional<Integer> val = a.stream().filter(e -> e > 3).findFirst();
        if(val.isPresent())
        {
            System.out.println(val.get());
        }

    }
}
