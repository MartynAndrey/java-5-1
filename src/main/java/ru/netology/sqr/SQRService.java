package ru.netology.sqr;

public class SQRService {
    public int sqrInLimitsCount(int leftLimit, int rightLimit) {
        // If the borders are set incorrectly, we swap them
        if (leftLimit > rightLimit) {
            int buffer = leftLimit;
            leftLimit = rightLimit;
            rightLimit = buffer;
        }
        int count = 0;
        for (int i = 10; i < 100; i++) {
            int sqr = i * i;
            if (leftLimit <= sqr && sqr <= rightLimit) {
                count++;
            }
            // If the square of the number is larger than the right border, there is no point in continuing
            if (sqr > rightLimit) {
                return count;
            }
        }
        return count;
    }
}
