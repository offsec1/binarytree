import com.google.gson.Gson;
import java.io.*;

/**
 * Utility for BinaryTree objects
 */
public class BinaryTreeUtils {

    /**
     * Gson object which handles the json parsing
     */
    private static Gson gson = new Gson();

    /**
     * Serializes a binary tree to a json object and exports it to a file
     * @param binTree binary tree
     * @param path path / name of file
     */
    public static void exportBinaryTree(BinaryTree binTree, String path) {

        String json = gson.toJson(binTree);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(json);
            writer.close();
        }
        catch(IOException e) {
            System.out.println("[-] Error: creating file didn't work!");
        }

    }

    /**
     * Imports a json object from a file and creates a binary tree
     * @param path path / name of file
     * @return new binary tree
     */
    public static BinaryTree importBinaryTree(String path) {

        BinaryTree newBinTree = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            newBinTree = gson.fromJson(reader, BinaryTree.class);
        }
        catch (IOException e) {
            System.out.println("[-] Error: while reading from file!");
        }

        return newBinTree;
    }

}
