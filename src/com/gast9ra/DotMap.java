package com.gast9ra;

public class DotMap {

    private static final String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static final int[] masCrutch = {7, 8, 9, 4, 5, 6, 1, 2, 3};

    private int coorWord;
    private int coorWord1;
    private int[] secondOrdinate = {0, 0};
    private int[] thirdOrdinate = {0, 0};
    private int[] lastOrdinate = {0, 0};

    public DotMap(String strPos) {
        String[] allOrdinat = strPos.split("-");
        for (int i = 0; i < abc.length; i++) {
            if (abc[i].equals(allOrdinat[0].substring(0, 1))) {
                this.coorWord = i;
            }
        }
        this.coorWord1 = Integer.parseInt(strPos.substring(1, 2));
        this.secondOrdinate[0] = masCrutch[Integer.parseInt(allOrdinat[1]) - 1];
        this.thirdOrdinate[0] = masCrutch[Integer.parseInt(allOrdinat[2]) - 1];
        this.lastOrdinate[0] = masCrutch[Integer.parseInt(allOrdinat[3]) - 1];
        this.secondOrdinate = cubetoOrdinate(secondOrdinate);
        this.thirdOrdinate = cubetoOrdinate(thirdOrdinate);
        this.lastOrdinate = cubetoOrdinate(lastOrdinate);
    }

    private int[] cubetoOrdinate(int[] inputMas) {
        if (inputMas[0] % 3 == 0) return new int[]{3, inputMas[0] / 3};
        else return new int[]{inputMas[0] % 3, inputMas[0] / 3 + 1};
    }


    public Point getDot() {
        int y = coorWord1 * 300
                + (secondOrdinate[1] - 1) * 100
                + (thirdOrdinate[1] - 1) * 33
                + (lastOrdinate[1] - 1) * 11 + 6;
        int x = (coorWord - 1) * 300
                + (secondOrdinate[0] - 1) * 100
                + (thirdOrdinate[0] - 1) * 33
                + (lastOrdinate[0] - 1) * 11 + 6;
        return new Point(x, y);
    }

}
