import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by siddharthvarshney on 9/29/16.
 */
public class Trie {
    private TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }
    public void insert(String test)
    {
        TrieNode curr = root;
        int wordLen  = test.length();
        for(int i = 0; i < wordLen; i++)
        {
            char ch = test.charAt(i);
            if(curr.child[ch - 'a'] == null)
            {
                curr.child[ch - 'a'] = new TrieNode();
            }
            if(i == wordLen - 1)
                curr.child[ch - 'a'].isLeaf = true;
            curr = curr.child[ch - 'a'];
        }
    }
    boolean search(String test)
    {
        TrieNode curr = root;
        int wordLen = test.length();
        for(int i = 0; i < wordLen; i++)
        {
            char ch = test.charAt(i);
            if(curr.child[ch - 'a'] == null)
                return false;
            if(i == wordLen - 1)
            {
                if(curr.child[ch - 'a'].isLeaf == false)
                    return false;
            }
            curr = curr.child[ch - 'a'];
        }
        return true;
    }
    public boolean startsWith(String prefix)
    {
        TrieNode curr = root;
        int wordLen = prefix.length();
        for(int i = 0; i < wordLen; i++)
        {
            char ch = prefix.charAt(i);
            if(curr.child[ch - 'a'] == null)
                return false;
            curr = curr.child[ch - 'a'];
        }
        return true;
    }
    public void getWords(TrieNode head, String prefix, ArrayList<String> result)
    {
        TrieNode curr = head;
        for(int i = 0; i < 26; i++)
        {
            if(curr.child[i] != null)
            {
                int asc = (int)'a';
                asc = asc + i;
                char ch = (char)(asc);
                if(curr.child[i].isLeaf == true)
                {
                    result.add(prefix + String.valueOf(ch));
                    getWords(curr.child[i],prefix + String.valueOf(ch),result);
                }
                else
                {
                    getWords(curr.child[i],prefix + String.valueOf(ch),result);
                }
            }
        }

    }
    public ArrayList<String> autoComplete(String word)
    {
        ArrayList<String> result = new ArrayList<String>();
        TrieNode curr = root;
        int wordLen = word.length();
        for(int i = 0; i < wordLen; i++)
        {
            char ch = word.charAt(i);
            if(curr.child[ch - 'a'] == null)
                return result;
            if(i == wordLen - 1)
                result.add(word);
            curr = curr.child[ch - 'a'];
        }
        getWords(curr,word,result);
        return result;
    }
    public boolean regex(String word)
    {
        int wordLen = word.length();
        TrieNode curr = root;
        for(int i = 0; i < wordLen; i++)
        {
            char ch = word.charAt(i);
            if(ch != '.')
            {
                if(curr.child[ch - 'a'] == null)
                    return false;
                curr = curr.child[ch - 'a'];
            }
            else
            {
                for(int j = 0; j < 26; j++)
                {
                    if(curr.child[j] != null)
                    {

                    }
                }
            }
        }
        if(curr.isLeaf == false)
            return false;
        else
        return true;
    }
    public static void main(String args[])
    {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("a");
        trie.insert("abcz");
        trie.insert("abcdef");
        trie.insert("abcs");
        trie.insert("ab");
        trie.insert("ba");
        ArrayList<String> answer = new ArrayList<>(trie.autoComplete("a"));
        for(String s : answer)
        {
            System.out.println(s);
        }
        trie.regex("a..");
    }

}
