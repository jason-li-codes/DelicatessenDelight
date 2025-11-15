package com.pluralsight.utilizedclasses;

public class PrintColumns {

    public PrintColumns() {}

    // Print Strings in two separate columns
    public static void twoColumns(String leftBlock, String rightBlock) {
        // Initialize console width
        int totalWidth = 180;
        // Calculate columnWidth
        int columnWidth = (totalWidth - 5) / 3; // borders + spacing
        // Clean and split into lines
        String[] leftLines = leftBlock.stripIndent().trim().split("\n");
        String[] rightLines = rightBlock.stripIndent().trim().split("\n");
        // Find maximum number of lines
        int maxLines = Math.max(leftLines.length, rightLines.length);
        // Compute top padding for bottom alignment
        int leftPad = maxLines - leftLines.length;
        int rightPad = maxLines - rightLines.length;
        // Print top border
        printLine(2, '╔', '═', '╦', '╗', columnWidth);
        // Print main contents
        for (int i = 0; i < maxLines; i++) {
            // Check padding to bottom align Strings
            String left = (i < leftPad) ? "" : leftLines[i - leftPad];
            String right = (i < rightPad) ? "" : rightLines[i - rightPad];
            // Print line from left to right
            System.out.printf("║ %-" + columnWidth + "s ║ %-" + columnWidth * 2 + "s ║\n",
                    left, right);
        }
        // Print bottom border
        printLine(2, '╚', '═', '╩', '╝', columnWidth);
    }

    // Static method for top and bottom border
    private static void printLine(int numColumns, char left, char fill, char mid, char right, int width) {
        System.out.print(left);
        // Print different formats if column numbers are different
        if (numColumns == 2) {
            for (int i = 0; i < width + 2; i++) System.out.print(fill);
        System.out.print(mid);
            for (int i = 0; i < width * 2 + 2; i++) System.out.print(fill);
        }
        if (numColumns == 3) {
            for (int i = 0; i < width + 2; i++) System.out.print(fill);
            System.out.print(mid);
            for (int i = 0; i < width * 2 - 3; i++) System.out.print(fill);
            System.out.print(mid);
            for (int i = 0; i < width + 2; i++) System.out.print(fill);
        }
        System.out.println(right);
    }

    // Print Strings in three separate columns
    public static void threeColumns(String leftBlock, String midBlock, String rightBlock) {
        // Initialize console width
        int totalWidth = 180;
        // Calculate columnWidth
        int columnWidth = (totalWidth - 4) / 3;
        // Clean and split into lines
        String[] leftLines = leftBlock.stripIndent().trim().split("\n");
        String[] midLines = midBlock.stripIndent().trim().split("\n");
        String[] rightLines = rightBlock.stripIndent().trim().split("\n");
        // Find maximum number of lines
        int maxLines = Math.max(leftLines.length, Math.max(midLines.length, rightLines.length));
        // Compute top padding for bottom alignment
        int leftPad = maxLines - leftLines.length;
        int midPad = maxLines - midLines.length;
        int rightPad = maxLines - rightLines.length;
        // Print top border
        printLine(3, '╔', '═', '╦', '╗', columnWidth);
        // Print main contents
        for (int i = 0; i < maxLines; i++) {
            // Check padding to bottom align Strings
            String left = (i < leftPad) ? "" : leftLines[i - leftPad];
            String mid = (i < midPad) ? "" : midLines[i - midPad];
            String right = (i < rightPad) ? "" : rightLines[i - rightPad];
            // Print line from left to right
            System.out.printf("║ %-" + columnWidth + "s ║ %-" + (columnWidth * 2 - 5) + "s ║ %-" + columnWidth + "s ║\n",
                    left, mid, right);
        }
        // Print bottom border
        printLine(3, '╚', '═', '╩', '╝', columnWidth);
    }
}
