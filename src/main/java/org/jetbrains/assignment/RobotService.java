package org.jetbrains.assignment;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RobotService {
    public List<Location> move(List<MovementOperation> operations) {
        List<Location> locations = new ArrayList<>();
        int x = 0, y = 0;
        locations.add(new Location(x, y));

        for (MovementOperation operation : operations) {
            switch (operation.getDirection()) {
                case "NORTH":
                    y += operation.getSteps();
                    break;
                case "SOUTH":
                    y -= operation.getSteps();
                    break;
                case "EAST":
                    x += operation.getSteps();
                    break;
                case "WEST":
                    x -= operation.getSteps();
                    break;
            }
            locations.add(new Location(x, y));
        }

        return locations;
    }

    public List<MovementOperation> calculateMoves(List<Location> locations) {
        List<MovementOperation> operations = new ArrayList<>();

        for (int i = 0; i < locations.size() - 1; i++) {
            Location current = locations.get(i);
            Location next = locations.get(i + 1);

            int xDiff = next.getX() - current.getX();
            int yDiff = next.getY() - current.getY();

            if (xDiff > 0) {
                operations.add(new MovementOperation("EAST", xDiff));
            } else if (xDiff < 0) {
                operations.add(new MovementOperation("WEST", -xDiff));
            }

            if (yDiff > 0) {
                operations.add(new MovementOperation("NORTH", yDiff));
            } else if (yDiff < 0) {
                operations.add(new MovementOperation("SOUTH", -yDiff));
            }
        }

        return operations;
    }
}
