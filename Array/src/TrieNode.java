/**
 * Created by siddharthvarshney on 9/29/16.
 */
public class TrieNode {
    boolean isLeaf;
    TrieNode [] child;
    TrieNode()
    {
        child = new TrieNode[26];
    }
}
