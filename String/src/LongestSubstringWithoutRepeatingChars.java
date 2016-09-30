import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by siddharthvarshney on 9/8/16.
 */
public class LongestSubstringWithoutRepeatingChars {
    static int longestSubstringWithoutRepeatingChars(String str)
    {
        int [] visited = new int[256];
        for(int i = 0; i < 256; i++)
            visited[i] = -1;
        visited[str.charAt(0)] = 0;
        int index = 0;
        int presentlen = 1;
        int maxlen = 1;
        while(index < str.length())
        {
            int prev_index = visited[str.charAt(index)];
            // new character
            if(prev_index == -1 || index - presentlen > prev_index)
            {
                presentlen = presentlen + 1;
            }
            // character already visited
            else
            {
                if(presentlen > maxlen)
                    maxlen = presentlen;
                presentlen = index - prev_index;
            }
            visited[str.charAt(index)] = index;
            index++;
        }
        if(presentlen > maxlen)
            maxlen = presentlen;
        return maxlen;
    }
    public static void main(String args[])
    {
        String test = "ABDEFGABEF";
        int len = longestSubstringWithoutRepeatingChars(test);
        System.out.println("Length is : " + len);
    }
}
