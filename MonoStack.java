/*
 * getPreviousSmallerElementIndices
 * getPreviousSmallerOrEqualElementIndices
 * 
 * getNextSmallerElementIndices
 * getNextSmallerOrEqualElementIndices
 *
 * getPreviousBiggerElementIndices
 * getPreviousBiggerOrEqualElementIndices
 * 
 * getNextBiggerElementIndices
 * getNextBiggerOrEqualElementIndices
 *
 * getSmallerOrEqualElementIndicesWithClosestValueGlobally
 * getBiggerOrEqualElementIndicesWithClosestValueGlobally
 */

public int[] getPreviousSmallerElementIndices(int[] nums) {
    int[] previousSmallerElementIndices = new int[nums.length];
    Stack<Integer> monoIncreaseStack = new Stack<>();
    for (int i = 0; i < nums.length; i++) {
        while (!monoIncreaseStack.isEmpty() && nums[monoIncreaseStack.peek()] >= nums[i]) {
            monoIncreaseStack.pop();
        }

        if (monoIncreaseStack.isEmpty()) {
            previousSmallerElementIndices[i] = -1;
        } else {
            previousSmallerElementIndices[i] = monoIncreaseStack.peek();
        }

        monoIncreaseStack.add(i);
    }
    return previousSmallerElementIndices;
}

public int[] getPreviousSmallerOrEqualElementIndices(int[] nums) {
    int[] previousSmallerOrEqualElementIndices = new int[nums.length];
    Stack<Integer> monoIncreaseStack = new Stack<>();
    for (int i = 0; i < nums.length; i++) {
        while (!monoIncreaseStack.isEmpty() && nums[monoIncreaseStack.peek()] > nums[i]) {
            monoIncreaseStack.pop();
        }

        if (monoIncreaseStack.isEmpty()) {
            previousSmallerOrEqualElementIndices[i] = -1;
        } else {
            previousSmallerOrEqualElementIndices[i] = monoIncreaseStack.peek();
        }

        monoIncreaseStack.add(i);
    }
    return previousSmallerOrEqualElementIndices;
}

public int[] getNextSmallerElementIndices(int[] nums) {
    int[] nextSmallerElementIndices = new int[nums.length];
    Stack<Integer> monoIncreaseStack = new Stack<>();
    for (int i = nums.length - 1; i >= 0; i--) {
        while (!monoIncreaseStack.isEmpty() && nums[monoIncreaseStack.peek()] >= nums[i]) {
            monoIncreaseStack.pop();
        }

        if (monoIncreaseStack.isEmpty()) {
            nextSmallerElementIndices[i] = -1;
        } else {
            nextSmallerElementIndices[i] = monoIncreaseStack.peek();
        }

        monoIncreaseStack.add(i);
    }
    return nextSmallerElementIndices;
}

public int[] getNextSmallerOrEqualElementIndices(int[] nums) {
    int[] nextSmallerOrEqualElementIndices = new int[nums.length];
    Stack<Integer> monoIncreaseStack = new Stack<>();
    for (int i = nums.length - 1; i >= 0; i--) {
        while (!monoIncreaseStack.isEmpty() && nums[monoIncreaseStack.peek()] > nums[i]) {
            monoIncreaseStack.pop();
        }

        if (monoIncreaseStack.isEmpty()) {
            nextSmallerOrEqualElementIndices[i] = -1;
        } else {
            nextSmallerOrEqualElementIndices[i] = monoIncreaseStack.peek();
        }

        monoIncreaseStack.add(i);
    }
    return nextSmallerOrEqualElementIndices;
}

public int[] getPreviousBiggerElementIndices(int[] nums) {
    int[] previousBiggerElementIndices = new int[nums.length];
    Stack<Integer> monoDecreaseStack = new Stack<>();
    for (int i = 0; i < nums.length; i++) {
        while (!monoDecreaseStack.isEmpty() && nums[monoDecreaseStack.peek()] <= nums[i]) {
            monoDecreaseStack.pop();
        }

        if (monoDecreaseStack.isEmpty()) {
            previousBiggerElementIndices[i] = -1;
        } else {
            previousBiggerElementIndices[i] = monoDecreaseStack.peek();
        }

        monoDecreaseStack.add(i);
    }
    return previousBiggerElementIndices;
}

public int[] getPreviousBiggerOrEqualElementIndices(int[] nums) {
    int[] previousBiggerOrEqualElementIndices = new int[nums.length];
    Stack<Integer> monoDecreaseStack = new Stack<>();
    for (int i = 0; i < nums.length; i++) {
        while (!monoDecreaseStack.isEmpty() && nums[monoDecreaseStack.peek()] < nums[i]) {
            monoDecreaseStack.pop();
        }

        if (monoDecreaseStack.isEmpty()) {
            previousBiggerOrEqualElementIndices[i] = -1;
        } else {
            previousBiggerOrEqualElementIndices[i] = monoDecreaseStack.peek();
        }

        monoDecreaseStack.add(i);
    }
    return previousBiggerOrEqualElementIndices;
}

public int[] getNextBiggerElementIndices(int[] nums) {
    int[] nextBiggerElementIndices = new int[nums.length];
    Stack<Integer> monoDecreaseStack = new Stack<>();
    for (int i = nums.length - 1; i >= 0; i--) {
        while (!monoDecreaseStack.isEmpty() && nums[monoDecreaseStack.peek()] <= nums[i]) {
            monoDecreaseStack.pop();
        }

        if (monoDecreaseStack.isEmpty()) {
            nextBiggerElementIndices[i] = -1;
        } else {
            nextBiggerElementIndices[i] = monoDecreaseStack.peek();
        }

        monoDecreaseStack.add(i);
    }
    return nextBiggerElementIndices;
}

public int[] getNextBiggerOrEqualElementIndices(int[] nums) {
    int[] nextBiggerOrEqualElementIndices = new int[nums.length];
    Stack<Integer> monoDecreaseStack = new Stack<>();
    for (int i = nums.length - 1; i >= 0; i--) {
        while (!monoDecreaseStack.isEmpty() && nums[monoDecreaseStack.peek()] < nums[i]) {
            monoDecreaseStack.pop();
        }

        if (monoDecreaseStack.isEmpty()) {
            nextBiggerOrEqualElementIndices[i] = -1;
        } else {
            nextBiggerOrEqualElementIndices[i] = monoDecreaseStack.peek();
        }

        monoDecreaseStack.add(i);
    }
    return nextBiggerOrEqualElementIndices;
}

public int[] getSmallerOrEqualElementIndicesWithClosestValueGlobally(int[] nums) {
    int[] smallerOrEqualElementIndicesWithClosestValueGlobally = new int[nums.length];
    Arrays.fill(smallerOrEqualElementIndicesWithClosestValueGlobally, -1);

    int[][] numsSorted = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++) {
        numsSorted[i][0] = nums[i];
        numsSorted[i][1] = i;
    }

    Arrays.sort(numsSorted, (e1, e2) -> {
        if (e1[0] != e2[0])
            return -(e1[0] - e2[0]);
        else
            return e1[1] - e2[1];
    });

    Stack<Integer> monoDecreaseStack = new Stack<>();
    for (int i = 0; i < numsSorted.length; i++) {
        int idx = numsSorted[i][1];
        while (!monoDecreaseStack.isEmpty() && monoDecreaseStack.peek() < idx) {
            smallerOrEqualElementIndicesWithClosestValueGlobally[monoDecreaseStack.pop()] = idx;
        }
        monoDecreaseStack.add(idx);
    }

    return smallerOrEqualElementIndicesWithClosestValueGlobally;
}

public int[] getBiggerOrEqualElementIndicesWithClosestValueGlobally(int[] nums) {
    int[] biggerOrEqualElementIndicesWithClosestValueGlobally = new int[nums.length];
    Arrays.fill(biggerOrEqualElementIndicesWithClosestValueGlobally, -1);

    int[][] numsSorted = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++) {
        numsSorted[i][0] = nums[i];
        numsSorted[i][1] = i;
    }

    Arrays.sort(numsSorted, (e1, e2) -> {
        if (e1[0] != e2[0])
            return e1[0] - e2[0];
        else
            return e1[1] - e2[1];
    });

    Stack<Integer> monoIncreaseStack = new Stack<>();
    for (int i = 0; i < numsSorted.length; i++) {
        int idx = numsSorted[i][1];
        while (!monoIncreaseStack.isEmpty() && monoIncreaseStack.peek() < idx) {
            biggerOrEqualElementIndicesWithClosestValueGlobally[monoIncreaseStack.pop()] = idx;
        }
        monoIncreaseStack.add(idx);
    }

    return biggerOrEqualElementIndicesWithClosestValueGlobally;
}
