package programmers.weeklyChallenge.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Block{
        private int numberOfCell = 0;
        private int width = 0, height = 0;
        private int[][] cells = new int[6][6];

        public Block(int[][] cellCoordis, int stdRow, int stdCol){
            numberOfCell = cellCoordis.length;

            for(int[] coordi: cellCoordis){
                int row = coordi[0] - stdRow;
                int col = coordi[1] - stdCol;
                cells[row][col] = 1;
                if(width < col) width = col;
                if(height < row) height = row;
            }
        }

        public int getNumberOfCell() {
            return numberOfCell;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Block)) return false;
            Block b = (Block) obj;
            if(b.numberOfCell != this.numberOfCell) return false;

            if(b.width == this.width && b.height == this.height) {
                // 그대로 비교
                Loop1:
                for (int i = 0; i <= this.height; i++) {
                    for (int j = 0; j <= this.width; j++) {
                        if ((b.cells[i][j] == 1 && this.cells[i][j] != 1)) break Loop1;
                        if (i == this.height && j == this.width) return true;
                    }
                }

                // 오른쪽으로 180도 회전하여 비교
                Loop1 :
                for(int i = 0; i <= this.height; i++){
                    for(int j = 0; j <= this.width; j++){
                        if((b.cells[i][j] == 1 && this.cells[this.height - i][this.width - j] != 1)) break Loop1;
                        if(i == this.height && j == this.width) return true;
                    }
                }
            }

            if((b.width == this.height && b.height == this.width)){
                // 오른쪽으로 90도 회전하여 비교
                Loop1:
                for (int i = 0; i <= this.height; i++) {
                    for (int j = 0; j <= this.width; j++) {
                        if ((b.cells[i][j] == 1  && this.cells[j][this.width - i] != 1)) break Loop1;
                        if (i == this.height && j == this.width) return true;
                    }
                }

                // 오른쪽으로 270도 회전하여 비교
                Loop1:
                for (int i = 0; i <= this.height; i++) {
                    for (int j = 0; j <= this.width; j++) {
                        if ((b.cells[i][j] == 1 && this.cells[this.height - j][i] != 1)) break Loop1;
                        if (i == this.height && j == this.width) return true;
                    }
                }
            }

            return false;
        }
    }

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        ArrayList<Block> blocks = new ArrayList<>();

        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                if(table[i][j] == 1){
                    ArrayList<int[]> coordis = new ArrayList<>();
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    int minR = i, minC = j;

                    table[i][j] = 0;

                    while (!q.isEmpty()){
                        int [] coordi = q.poll();
                        int r = coordi[0], c = coordi[1];

                        if(minR > r) minR = r;
                        if(minC > c) minC = c;

                        // 위
                        if(r - 1 >= 0 && table[r - 1][c] == 1){
                            q.offer(new int[]{r - 1, c});
                            table[r - 1][c] = 0;
                        }

                        // 아래
                        if(r + 1 < table.length && table[r + 1][c] == 1){
                            q.offer(new int[]{r + 1, c});
                            table[r + 1][c] = 0;
                        }

                        // 왼쪽
                        if(c - 1 >= 0 && table[r][c - 1] == 1){
                            q.offer(new int[]{r, c - 1});
                            table[r][c - 1] = 0;
                        }

                        // 오른쪽
                        if(c + 1 < table[r].length && table[r][c + 1] == 1){
                            q.offer(new int[]{r, c + 1});
                            table[r][c + 1] = 0;
                        }

                        coordis.add(coordi);
                    }
                    blocks.add(new Block(coordis.toArray(new int[coordis.size()][]), minR, minC));
                }
            }
        }

        for(int i = 0; i < game_board.length; i++){
            for(int j = 0; j < game_board[i].length; j++){
                if(game_board[i][j] == 0){
                    ArrayList<int[]> coordis = new ArrayList<>();
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    int minR = i, minC = j;

                    game_board[i][j] = 1;

                    while (!q.isEmpty()){
                        int [] coordi = q.poll();
                        int r = coordi[0], c = coordi[1];

                        if(minR > r) minR = r;
                        if(minC > c) minC = c;

                        // 위
                        if(r - 1 >= 0 && game_board[r - 1][c] == 0){
                            q.offer(new int[]{r - 1, c});
                            game_board[r - 1][c] = 1;
                        }

                        // 아래
                        if(r + 1 < game_board.length && game_board[r + 1][c] == 0){
                            q.offer(new int[]{r + 1, c});
                            game_board[r + 1][c] = 1;
                        }

                        // 왼쪽
                        if(c - 1 >= 0 && game_board[r][c - 1] == 0){
                            q.offer(new int[]{r, c - 1});
                            game_board[r][c - 1] = 1;
                        }

                        // 오른쪽
                        if(c + 1 < game_board[r].length && game_board[r][c + 1] == 0){
                            q.offer(new int[]{r, c + 1});
                            game_board[r][c + 1] = 1;
                        }

                        coordis.add(coordi);
                    }
                    Block blank = new Block(coordis.toArray(new int[coordis.size()][]), minR, minC);
                    for (Block block : blocks) {
                        if (blank.equals(block)) {
                            answer += blank.getNumberOfCell();
                            blocks.remove(block);
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
//        new Solution().solution(new int[][]{{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}},
//                                new int[][]{{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}});
//        new Solution().solution(new int[][]{{0,0,0},{1,1,0},{1,1,1}},
//                                new int[][]{{1,1,1},{1,0,0},{0,0,0}});
        new Solution().solution(new int[][]{{0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                                            {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
                                            {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0},
                                            {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1},
                                            {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                                            {0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
                                            {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
                                            {0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0},
                                            {1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0},
                                            {0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0},
                                            {0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1},
                                            {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}},
                                new int[][]{{1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1},
                                            {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1},
                                            {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0},
                                            {0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0},
                                            {1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0},
                                            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                                            {1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1},
                                            {1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1},
                                            {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1},
                                            {1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1},
                                            {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1},
                                            {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1}});
    }
}
