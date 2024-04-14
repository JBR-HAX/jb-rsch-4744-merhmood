package org.jetbrains.assignment;//// MovementOperation.java

// RobotController.java
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Application {
    private final RobotService robotService;

    public Application(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping("/locations")
    public List<Location> locations(@RequestBody List<MovementOperation> operations) {
        return robotService.move(operations);
    }

    @PostMapping("/moves")
    public List<MovementOperation> moves(@RequestBody List<Location> locations) {
        return robotService.calculateMoves(locations);
    }
}

