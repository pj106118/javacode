package jing.able;

/**
 * @author panjing
 * @describe:
 * @date 2019/4/3
 * @time 13:37
 */

public class ChessboardCover {
    static int[][] Board = new int[64][64];
    static int tile = 1;
    public static void main(String[] args) {
        int size  = 4;
        TileBoard(0, 0, 1, 1, size);
        for(int i=0; i< size; i++){
            for(int j=0; j<size; j++){
                System.out.print(Board[i][j]+" ");
            }
            System.out.println("");
        }
    }
    /**
     * Board[0][0]：表示棋盘中左上角的方格； tile：所使用的三格板数目，初始为1；
     *
     * @param tr
     *            棋盘中左上角方格所在行
     * @param tc
     *            棋盘中左上角方格所在列
     * @param dr
     *            残缺方格所在行
     * @param dc
     *            残缺方格所在列
     * @param size
     *            棋盘的行数或列数 需要的三格板数(size2-1)/3
     */
    public static void TileBoard(int tr, int tc, int dr, int dc, int  size) {
        if (size == 1)
            return;
        int t = tile++; // 所使用的三格板数目
        int s = size / 2; // 象限大小
        // 覆盖左上象限
        if (dr < tr + s && dc < tc + s) {
            // 残缺方格位于本象限
            TileBoard(tr, tc, dr, dc, s);
        } else {// 本象限中没有残缺方格
            // 把三角格板t放在右下角
            Board[tr + s - 1][tc + s - 1] = t;
            // 覆盖其余部分
            TileBoard(tr, tc, tr + s - 1, tc + s - 1, s);
        }
        // 覆盖右上象限
        if (dr < tr + s && dc >= tc + s) {
            // 残缺方格位于本象限
            TileBoard(tr, tc + s, dr, dc, s);
        } else {// 本象限中没有残缺方格
            // 把三角格板t放在左下角
            Board[tr + s - 1][tc + s] = t;
            // 覆盖其余部分
            TileBoard(tr, tc + s, tr + s - 1, tc + s, s);
        }
        // 覆盖左下象限
        if (dr >= tr + s && dc < tc + s)
            // 残缺方格位于本象限
            TileBoard(tr + s, tc, dr, dc, s);
        else { // 把三格板t放在右上角
            Board[tr + s][tc + s - 1] = t;
            // 覆盖其余部分
            TileBoard(tr + s, tc, tr + s, tc + s - 1, s);
        }
        // 覆盖右下象限
        if (dr >= tr + s && dc >= tc + s)
            // 残缺方格位于本象限
            TileBoard(tr + s, tc + s, dr, dc, s);
        else { // 把三格板t放在左上角
            Board[tr + s][tc + s] = t;
            // 覆盖其余部分
            TileBoard(tr + s, tc + s, tr + s, tc + s, s);
        }
    }
}
