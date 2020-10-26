//Source：https://blog.csdn.net/u013309870/article/details/69788342
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
public class GetKMajor {

    public static void main(String[] args) {
        int arr[]={1,2,3,3,5,2,2,3,3,3,5,6,2,2,2,3,3};
        int k=3;
        getKMajor(arr,k);
    }
    public static void getKMajor(int arr[],int k)
    {
        if(k<2)
        {
            return;
        }
        HashMap<Integer, Integer> hashMap=new HashMap<Integer, Integer>();
        for(int i=0;i<arr.length;i++)
        {
        //hashmap由于保存k个不同的数，当hashmap中有k个不同的数时，则每个数的次数减1，
        //如果某个数的次数为0，则将其从hashmap中删除。
            if(hashMap.containsKey(arr[i]))
            {
            //如果hashmap中存在这个数，则将这个数的次数加1
                hashMap.put(arr[i],hashMap.get(arr[i])+1);

            }
            else {
                if(hashMap.size()==k-1)
                {
                    //如果hashmap中不存在这个数，如此时hashmap中存在k-1个不同的数则将
                    //hashmap中的每个数的次数减1
                    AllminusOne(hashMap);
                }
                else {
                //hashmap中的不同数个数小于k-1，时将该数加入到hashmap中。
                    hashMap.put(arr[i], 1);

                }
            }
        }   
        for(Entry<Integer, Integer> set:hashMap.entrySet())
        {
            Integer key=set.getKey();
            hashMap.put(key, 0);    
            //对hashmap中剩下的每个数先将次数赋值为0，为后面计算每个数的次数是否大于N/K做准备。        
        }
        for(int i=0;i<arr.length;i++)
        {
            if(hashMap.containsKey(arr[i]))
            {
                hashMap.put(arr[i], hashMap.get(arr[i])+1);
            }
        }
        for(Entry<Integer, Integer> set:hashMap.entrySet())
        {
            Integer key=set.getKey();
            Integer value=set.getValue();
            if(value>arr.length/k)
                System.out.println(key);
                //如果某个数的次数大于K/N则将其输出。
        }
    }
    public static void AllminusOne(HashMap<Integer, Integer> hashMap)
    {
    //将hashmap中的每个数的次数减1，将减 1 后次数为0 的从hashmap中删除。
        ArrayList<Integer> removelist=new ArrayList<Integer>();
        for(Entry<Integer, Integer> set:hashMap.entrySet())
        {
            Integer key=set.getKey();
            Integer value=set.getValue();
            if(value==1)
            {
                removelist.add(key);
            }else {             
                hashMap.put(key, value-1);      
            }
        }
        for(Integer removekey:removelist)
        {
            hashMap.remove(removekey);
        }

    }
}
--------------------- 
版权声明：本文为CSDN博主「HankingHu」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/u013309870/article/details/69788342
