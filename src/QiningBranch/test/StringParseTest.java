package QiningBranch.test;

public class StringParseTest {

    public static void main(String[] args) {
        String raft = "11215";
        int col = Integer.parseInt(raft.substring( 3, 5));

        System.out.println(col);
    }
}
