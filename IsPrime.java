public boolean isPrime(int num) {
    if (num <= 1) {
        return false;
    }
    if (num <= 3) {
        return true;
    }
    if (num % 2 == 0 || num % 3 == 0) {
        return false;
    }

    for (int i = 5; i * i <= num; i += 6) {
        if (num % i == 0 || num % (i + 2) == 0) {
            return false;
        }
    }

    return true;
}

public boolean[] generateIsPrime(int maxVal) {
    if (maxVal == 0) {
        return new boolean[]{false};
    }
    if (maxVal == 1) {
        return new boolean[]{false, false};
    }

    boolean[] isPrime = new boolean[maxVal + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;

    for (int i = 2; i * i <= maxVal; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= maxVal; j += i) {
                isPrime[j] = false;
            }
        }
    }

    return isPrime;
}
