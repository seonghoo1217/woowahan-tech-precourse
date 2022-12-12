package bridge.domain;

import bridge.common.BridgeDirection;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validateBridgeSize(bridge);
        validateBridgeFloor(bridge);
        this.bridge = bridge;
    }

    private void validateBridgeFloor(List<String> bridge) {
        bridge.forEach((floor) -> {
            if (BridgeDirection.isBridgeDirection(floor))
                throw new IllegalBridgeFloorException();
        });
    }

    private void validateBridgeSize(List<String> bridge) {
        if (bridge.size() < 3)
            throw new RangeUnderFlowException();
        if (bridge.size() > 20)
            throw new RangeOverFlowException();
    }

    public static class RangeOverFlowException extends IllegalArgumentException {
    }

    public static class RangeUnderFlowException extends IllegalArgumentException {
    }

    public static class IllegalBridgeFloorException extends IllegalArgumentException {
    }
}

