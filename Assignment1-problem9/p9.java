import java.util.ArrayList;
import java.util.Scanner;

public class P9 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        ArrayList<String> queries = new ArrayList<>();
        Link root = null;
        for(int i = 0; i<q; i++){
            String query = scanner.next();
            queries.add(query);
        }

        for (int i = 0; i< q; i++)
        {
            String[] strArray = queries.get(i).split(" ");
            q = Integer.parseInt(strArray[0]);
            int x = Integer.parseInt(strArray[1]);
            if(q == 1)
            {
                root = insert(root,x);

            }
            if(q == 2)
            {
                System.out.println(getIndex(root, x));
            }


        }
    }


    static class Link {

        private final int data;
        public Link left;
        public Link right;
        public static int leftSize =  -1;
        public static int rightSize = -1;
        public Link(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
        public int data() {
            return data;
        }

    }

    public static Link insert(Link root, int data)
    {
        if(root == null)
        {
            return root;
        }
        if(data <= root.data())
        {
            root.left = insert(root.left, data);
            Link.leftSize++;
        }
        else
        {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static int getIndex(Link root, int x)
    {
        if(root.data == x)
        {
            return (Link.leftSize++);
        }
        if(x < root.data())
        {
            if(root.left == null)
            {
                return -1;
            }else{
                return getIndex(root.left,x);
            }
        }
        else
        {
            if(root.right == null)
            {
                return -1;
            }
            else{
                Link.rightSize = getIndex(root.right,x);
                if(Link.rightSize == -1 )
                {
                    return - 1;
                }
                else
                {
                    return (Link.leftSize + 2 + Link.rightSize);
                }
            }
        }
    }

}