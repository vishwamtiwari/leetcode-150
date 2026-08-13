class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows > s.length()) return s;

        StringBuilder[] rows = new StringBuilder[numRows];

        int rowCount = 0;
        int direction = 1;
        for (int i = 0; i < s.length(); i++) {
            if (rows[rowCount] == null) rows[rowCount] = new StringBuilder();
            rows[rowCount].append(s.charAt(i));
            if (rowCount == numRows - 1) {
                direction = -1;
            } else if (rowCount == 0){
                direction = 1;
            }
            rowCount += direction;
        }

        for (int i = 1; i < numRows && rows[i] != null; i++) {
            rows[0].append(rows[i]);
        }

        return rows[0].toString();
    }
}