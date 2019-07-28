import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration
public class OrderProcessingApp{

    @RequestMapping("/")
    public String processOrder(){

        return "Processing your order";
    }

    public static void main(String[] args){

        SpringApplication.run(OrderProcessingApp.class, args);
    }
}