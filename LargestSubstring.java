package two.list.sorted;

public class LargestSubstring {
    public static void main(String[] args) {

        // char[] booleans = new char[]{'#', '*', '#', '#', '*', '*', '*', '#', '#', '#', '*', '*', '#'};//expected :#*##***###**
        //  char[] booleans = new char[]{'#', '*', '#', '*', '#', '*', '#', '*', '#', '*', '#', '*', '#'};//expected  :#*#*#*#*#*#*
        //  char[] booleans = new char[]{'#', '#', '#', '#', '#', '#', '*', '*', '*', '*', '*', '*', '#'};//expected : ######******
        //char[] booleans = new char[]{'#', '*', '#', '#', '#', '*', '*', '#', '#', '#', '#', '#', '#'};//expected : *###**
        char[] booleans = new char[]{'#', '#', '#', '#', '*', '*', '*', '*', '*', '*', '*', '*', '#', '#'};//expected : ####****
        String cc = largestSubstring(booleans);
        System.out.println(cc);


    }


    public static String largestSubstring(char[] line) {

        int counterHash = 0, counterAsterik = 0, start = 0, end = 0;
        int counterReverseHash = 0, counterReverseAsterik = 0;

        int center = line.length / 2;


        for (int ind = 0; ind < line.length; ind++) {

            if (ind < center) {
                if ('*' == line[line.length - (ind + 1)]) {
                    counterReverseAsterik++;

                }
                if ('#' == line[line.length - (ind + 1)]) {
                    counterReverseHash++;
                }
            }
            if ('*' == line[ind]) {
                counterAsterik++;
            }
            if ('#' == line[ind]) {
                counterHash++;
            }

            int diffCounter = counterAsterik > counterHash ? counterAsterik - counterHash : counterHash - counterAsterik;

            if (diffCounter == 0) {
                end = ind;
            }
            if ((counterReverseAsterik == 0 || 0 == counterReverseHash) && ind == center) {
                start = end;
                end = ind;
                counterReverseAsterik = -1;
                counterReverseHash = -1;
            }


        }

        return buildString(start, end, line);
    }


   /* public static String largestSubstring(char[] line) {

        int duplicateCount = 1, auxDuplicateCount = 0, start = 0, end = 0;


        for (int ind = 1; ind < line.length; ind++) {

            if (line[ind - 1] != line[ind]) {
                if (duplicateCount > auxDuplicateCount) {
                    end = ind;
                    start = (ind - duplicateCount) - (duplicateCount - 1);
                }
                auxDuplicateCount = duplicateCount;
                duplicateCount = 0;

            }

            duplicateCount++;
        }

        return buildString(start, end, line);
    }*/


    private static String buildString(int start, int end, char[] line) {
        String substring = new String();
        for (int i = start; i <= end; i++) {
            substring += line[i];
        }
        return substring;
    }


}
