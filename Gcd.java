/*
 * Get the greatest common divisor.
 */
public int getGcd(int a, int b) {
    while (b > 0) {
        int tmp = a;
        a = b;
        b = tmp % b;
    }
    return a;
}

/*
 * Get the least common multiple.
 */
public int getLcm(int a, int b) {
    return a * b / getGcd(a, b);
}
