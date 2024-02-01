def solution(bridge_length, weight, truck_weights):
    bridge = []
    bridge_sec = []

    sec = 0
    while truck_weights:
        if bridge and bridge_sec[0] + bridge_length == sec:
            bridge.pop(0)
            bridge_sec.pop(0)

        if sum(bridge) + truck_weights[0] <= weight and len(bridge) + 1 <= bridge_length:
            bridge.append(truck_weights.pop(0))
            bridge_sec.append(sec)

        sec += 1

    return sec + bridge_length