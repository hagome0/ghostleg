package logic;

import java.util.Random;

public class GhostLeg {
    private int[][] map;
    private int col;
    private int row;

    public GhostLeg(int num, int col) {
        this.row = num * 2 - 1;
        this.col = col;
        this.map = new int[col][row];

        getSadari();
        while (!isValid())getSadari();
    }

    private boolean isValid() {
        // invalid case: added line is zero
        for (int i = 1; i < row; i+=2) {
            int sum=0;
            for (int j = 0; j < col; j++) {
                sum+=map[j][i];
            }
            if (sum==0) return false;
        }
        return true;
    }

    private void getSadari() {
        Random rd = new Random();

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (j % 2 == 0) {
                    //case user line
                    map[i][j] = 1;
                } else {
                    //case added line
                    if (i == 0 || i == col - 1) {
                        // invalid case1: col equal 0 or col-1
                        map[i][j] = 0;
                    } else if (map[i - 1][j] == 1) {
                        // invalid case2: above map value 1
                        map[i][j] = 0;
                    } else {
                        // valid
                        if (rd.nextBoolean()) {
                            if (j == 1 || map[i][j - 2] == 0) {
                                // valid case
                                map[i][j] = 1;
                            } else {
                                // invalid case3: left left map value 1
                                map[i][j] = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    public void printSadari() {
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] getMap() {
        return map;
    }
}
