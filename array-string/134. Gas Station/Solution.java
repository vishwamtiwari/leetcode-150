class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int netFuel = 0;
        int currFuel = 0;
        int len = gas.length;

        for (int i = 0; i < len; i++) {
            currFuel += gas[i] - cost[i];
            netFuel = netFuel + gas[i] - cost[i];
            if (currFuel < 0) {
                start = i + 1;
                currFuel = 0;
            }
        }
        if (netFuel >= 0) return start;
        return -1;
    }
}