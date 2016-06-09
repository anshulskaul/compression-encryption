package compressionproj;

/**
 *
 * @author anshulskaul
 */
public class HuffmanArray {
    public static void create_array(char data1[],int frequency1[],ArrayNode a[],int n) 
	{
		for(int i=1;i<=n;i++)
		{
			a[i] = new ArrayNode();
			a[i].left=null;
			a[i].right=null;
			a[i].letter=data1[i-1];
			a[i].frequency=frequency1[i-1];
		}
		
	}
}
