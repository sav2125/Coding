/**
 * Created by siddharthvarshney on 9/8/16.
 */
public class GenerateParenthesis {
    static char [] arr = new char[8];
    private void generateUtil(int index, int n, int open, int close)
    {
        if(close == n) {
            System.out.println(arr);
            return;
        }
        else
        {
            if(open > close)
            {
                arr[index] = '}';
                generateUtil(index+1,n,open,close+1);
            }
            if(open < n)
            {
                arr[index] = '{';
                generateUtil(index + 1,n,open+1,close);
            }
        }
    }
    public void generate(int n)
    {
        generateUtil(0,n,0,0);
    }
    public static void main(String args[])
    {
        int n = 4;
        GenerateParenthesis obj = new GenerateParenthesis();
        obj.generate(n);
    }
}
