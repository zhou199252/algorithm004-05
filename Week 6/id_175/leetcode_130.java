package week6;

/**
 * @author shizeying
 * @date 2019/12/1 22:25
 * @description
 */
public class leetcode_130 {
  public void solve(char[][] board) {
    if (board == null || board.length == 0) return;
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // 从边缘o开始搜索
        boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
        if (isEdge && board[i][j] == 'O') {
          _getDfs(board, i, j);
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
        if (board[i][j] == '#') {
          board[i][j] = 'O';
        }
      }
    }
  }

  public void _getDfs(char[][] board, int i, int j) {
    if (i < 0
        || j < 0
        || i >= board.length
        || j >= board[0].length
        || board[i][j] == 'X'
        || board[i][j] == '#') {
      return;
    }
    board[i][j] = '#';
    _getDfs(board, i - 1, j);
    _getDfs(board, i + 1, j);
    _getDfs(board, i, j - 1);
    _getDfs(board, i, j + 1);
  }
}