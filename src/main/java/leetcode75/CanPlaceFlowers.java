package leetcode75;

public class CanPlaceFlowers {
    public static void main(String[] args) {

        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 1));

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0) {
            return false;
        }
        if (flowerbed.length == 1) {
            return flowerbed[0] == 0;
        }
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean leftFlowerBed = i == 0 || flowerbed[i - 1] == 0;
                boolean rightFlower = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
                if (leftFlowerBed && rightFlower) {
                    flowerbed[i] = 1;
                    count++;
                }

            }


        }

        return count >= n;

    }
}
