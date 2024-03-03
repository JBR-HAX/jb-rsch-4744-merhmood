package org.jetbrains.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}

@RestController
class ApplicationRestController {
    ArrayList<HashMap> locationsResult = new ArrayList<HashMap>();
    Map<String, Integer> currentLocation = new HashMap<String, Integer>();
    currentLocation.put("x", 0);
    currentLocation.put("y", 0);

    @PostMapping("/locations")
    public String (@RequestBody String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'U') {
                currentLocation.put("y", currentLocation.get("y") + 1);
            } else if (input.charAt(i) == 'D') {
                currentLocation.put("y", currentLocation.get("y") - 1);
            } else if (input.charAt(i) == 'L') {
                currentLocation.put("x", currentLocation.get("x") - 1);
            } else if (input.charAt(i) == 'R') {
                currentLocation.put("x", currentLocation.get("x") + 1);
            }
            locationsResult.add(currentLocation);
        }
    }
    @PostMapping("/moves")
    public String (@RequestBody String input) {
        return "Hello World!";
    }
}
