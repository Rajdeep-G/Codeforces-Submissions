import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

/**
* @author soumitri12
*/

/* Name of the class has to be "Main" only if the class is public*/
public class D
{
    static class FastReader {
        
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    
    static class Node {
        
        long pp;
        long a, b;
        
        Node(long x, long y) {
            a = x;
            b = y;
            pp = a * b;
        }
    }
    static class Comp implements Comparator<Node> {
        
        public int compare(Node o1, Node o2) {
            if (o1.pp > o2.pp) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    static int gcd(int x, int y)
    {
        if(y==0) return x;
        else return gcd(y,x%y);
    } 
    static long mod_pow(long a, long b, long mod)
    {
        a%=mod;
        if(b==0) return 1%mod;
        if((b&1)==1) return a*(mod_pow(a,b-1,mod))%mod;
        else 
        {
            long u=mod_pow(a,b>>1,mod);
            return (u*u)%mod;
        }
    }
    static long _pow(long a, long b)
    {
        if(b==0) return 1;
        if((b&1)==1) return a*_pow(a,b-1);
        else 
        {
            long u=_pow(a,b>>1);
            return u*u;
        }
    }
    static int modInv(int a, int m)
    {
        if(gcd(a,m)!=1) return -999;
        else return (a%m+m)%m;
    }
    static boolean isPowerOfTwo(int x) 
    { 
        return x!=0 && ((x&(x-1)) == 0);          
    } 
    static boolean isprime(int x) 
    {
        for(int i=2;i<=Math.sqrt(x);i++)
        {
            if(x%i==0) return false;
        }
        return true;
    }
    static boolean prime[];
    static final int INT_MAX=1000007;

    static void sieve() {
        prime=new boolean[INT_MAX];
        Arrays.fill(prime,true);
        prime[0]=prime[1]=false;
        for(int i=2;i<=Math.sqrt(INT_MAX);i++)
        {
            if(prime[i]) {
                for(int j=i*2;j<INT_MAX;j+=i)
                prime[j]=false;
            }
        }
    }
    static class Pair {
        int len; Pointers ptr;
        public Pair(int len,Pointers ptr) {
            this.len=len; this.ptr=ptr;
        }
    }
    static class Pointers {
        int l,u;
        public Pointers(int l,int u) {
            this.l=l; this.u=u;
        } 
    }
    
    public static void main(String[] args) {
        FastReader sc=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        StringBuffer sb=new StringBuffer();
        //your code starts here
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int a[]=new int[n+1];
            PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>() {
                @Override
                public int compare(Pair p1,Pair p2) {
                    return (p1.len!=p2.len) ? p2.len-p1.len : p1.ptr.l-p2.ptr.l; 
                }
            });
            Pair init=new Pair(n,new Pointers(1,n));
            pq.add(init);
            int k=0;
            while(!pq.isEmpty())
            {
                Pair curr=pq.poll();
                int l=curr.ptr.l,u=curr.ptr.u;
                int mid=(l+u)/2;
                a[mid]=++k;
                if(l<=mid-1) pq.add(new Pair(mid-l,new Pointers(l,mid-1)));
                if(mid+1<=u) pq.add(new Pair(u-mid,new Pointers(mid+1,u)));
            }
            pq.clear();
            for(int i=1;i<=n;i++) sb.append(a[i]+" ");
            sb.append("\n");
        }
        out.println(sb.toString());
        out.close();
    }
}
