package compressionproj;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author anshulskaul
 */
public class HuffmanCompression extends javax.swing.JFrame {

        public static String content;
        public static String file_path;
        public static int w=0,j=0,count,z=0,l=0;
	public static String s = "";
        public static String letterbin = "";
        public static String letterfreq = "";
        public static String decodedstr = "";
	public static char huffman[];
	public static String binary[];
	public static int arr[] = new int[100001];
        public static ArrayNode a[];
        public static String newdata="";
	public static Map<Character, String> binformat = new HashMap<Character, String>();
        public HuffmanCompression()
        {
        initComponents();
        }
    public HuffmanCompression(int count) {
        initComponents();
        huffman=new char[count+1];
        binary=new String[count+1];
    }
    
    static void minheapify(ArrayNode a[],int k)
	{
		int l=2*k;
		int r=2*k+1;
		int min;
		//System.out.println(a[l].frequency+ a[k].frequency);
		if(l<=count && a[l].frequency<a[k].frequency)
		min=l;
		else
		min=k;
		if(r<count && a[r].frequency<a[min].frequency)
		min=r;
		if(min!=k)
		{
		   ArrayNode temp=a[k];
	      a[k]=a[min];
	      a[min]=temp;
		   minheapify(a,min);
		}
		return;
	}
	void build_minheap(ArrayNode a[],int count)
	{
		int j=count/2;
	    while(j>=1)
		{
		minheapify(a,j);
		j--;
	    }
	}
	
static String preorder(char ch, int arr[],ArrayNode head){
		if(head==null){
			w--;
			return s;
		}
		huffman[z]=ch;
		binary[z]="";
		if(head.letter==ch){
			for(int i=0;i<w;i++){
				binary[z]+=arr[i];
			}
			binformat.put(ch,binary[z]);
			System.out.println(ch+" -> "+binary[z]);
                        //letterbin += ch+" -> "+ binary[z]+'\n'; 
			z++;
			return s;
		}
		arr[w++]=0;
		preorder(ch,arr,head.left);
		arr[w++]=1;
		preorder(ch,arr,head.right);
		w--;
		return s;
		
	}
	
	static ArrayNode HeapExtractMin(ArrayNode a[]) 
	{ 
		ArrayNode temp = new ArrayNode();
	temp.letter= a[1].letter;
	temp.frequency= a[1].frequency;
	temp.right=a[1].right;
	temp.left=a[1].left;
	 a[1] = a[count];
	  count--;
	  minheapify(a,1);
	   return temp; 
	   }
	void Min_Heap_Insert(ArrayNode a[],ArrayNode first,ArrayNode second)
	{
	   ArrayNode temp = new ArrayNode();
	   temp.frequency=first.frequency+second.frequency;
	   temp.letter='$';
	   temp.left=first;
	   temp.right=second;
	   a[++count]=temp;
		build_minheap(a,count);
	}	
	
	public static String decode_huff(ArrayNode root,String s){
		char a []= s.toCharArray();
	    ArrayNode temp=root;
	    if(root==null)
	        return null;
	    int i,l=s.length();
	    if(l==0){
	        return null;
	    }
	    for(i=0;i<l;i++){
	        if(a[i]=='1'){
	            root=root.right;
	            if(root.letter!='$'){
	                decodedstr+=root.letter;
                        //System.out.print(root.letter);
	                root=temp;}
	        }
	        else{
	            root=root.left;
	            if(root.letter!='$'){
                        decodedstr+=root.letter;
	            	//System.out.print(root.letter);
	                root=temp;}
	        }
	    }
            return decodedstr;
	}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        headname = new javax.swing.JLabel();
        filePath = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        compressbutton = new javax.swing.JButton();
        decompressbutton = new javax.swing.JButton();
        encryptbutton = new javax.swing.JButton();
        decryptbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Protection Application");

        headname.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        headname.setText("Preventing your data from cyber attacks");

        filePath.setText("Your file path here...");
        filePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filePathActionPerformed(evt);
            }
        });

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Path:");

        compressbutton.setText("Compress");
        compressbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compressbuttonActionPerformed(evt);
            }
        });

        decompressbutton.setText("Decompress");
        decompressbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decompressbuttonActionPerformed(evt);
            }
        });

        encryptbutton.setText("Encrypyt");
        encryptbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptbuttonActionPerformed(evt);
            }
        });

        decryptbutton.setText("Decrypt");
        decryptbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(compressbutton)
                                    .addComponent(encryptbutton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(decryptbutton)
                                    .addComponent(decompressbutton)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filePath, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(browseButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(headname, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(headname, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filePath, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compressbutton)
                    .addComponent(decompressbutton))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encryptbutton)
                    .addComponent(decryptbutton))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        try{
            JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        file_path=f.getAbsolutePath();
        filePath.setText(file_path);
            content = new Scanner(new File(file_path)).useDelimiter("\\Z").next();
            //System.out.println(content);
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
    }                                            

    private void filePathActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
    }                                        

    private void compressbuttonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        try{
        HuffmanArray obj1 = new HuffmanArray();
        //String text = "Anshul Saraswat Kaul";
	char actual[] = content.toCharArray();
        l = content.length(); 
        System.out.print("Size: "+ l);
	Map<Character, Integer> m = new HashMap<Character, Integer>();
	for(int i=0;i<l;i++){
		char c = actual[i];
		if(m.containsKey(c))
			m.put(c, m.get(c)+1);
		else{
			m.put(c,1);
			count++;
                }
        }
        
                 HuffmanCompression obj2= new HuffmanCompression(count);
         
        int frequency[] = new int[count+1];
	char letter[] = new char[count+1];
	Set<Character> keyc = m.keySet();
	j=0;
		for (Character key : keyc){
			char q = key;
		    System.out.println(q+"="+m.get(q));
                    letterfreq += q+" -> "+m.get(q)+'\n'; 
		    frequency[j]=m.get(q);
		    letter[j++]=q;
		}

	a = new ArrayNode[count+1];
	obj1.create_array(letter,frequency,a,count);
	obj2.build_minheap(a,count);
	while(count!=1)
	{
		ArrayNode first = HeapExtractMin(a);
		ArrayNode second= HeapExtractMin(a);
		obj2.Min_Heap_Insert(a, first, second);
	}
	for(int i=0;i<letter.length;i++){
		w=0;
		preorder(letter[i],arr,a[1]);
	}
	for(int i=0;i<actual.length;i++){
		char q = actual[i];
		s+=binformat.get(q);
	}
        
	System.out.println("Compression Ratio:");
        FileWriter stream = new FileWriter(file_path);
		BufferedWriter out = new BufferedWriter(stream);
		out.write(s);
		out.close();
        JOptionPane.showMessageDialog(null, "The file Compressed successfully");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
        
        
        
        //print letterfreq on pane
            
    }                                              

    private void decompressbuttonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        try{
        JFileChooser cho = new JFileChooser();
        cho.showOpenDialog(null);
        File fil = cho.getSelectedFile();
        file_path=fil.getAbsolutePath();
            newdata = new Scanner(new File(file_path)).useDelimiter("\\Z").next();
            newdata= decode_huff(a[1],newdata);
            FileWriter stream = new FileWriter(file_path);
            BufferedWriter out = new BufferedWriter(stream);
            out.write(newdata);
            out.close();
            JOptionPane.showMessageDialog(null, "The file Decompressed successfully");
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);}       
        //print decodedstr on screen
    }                                                

    private void encryptbuttonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        try{
                        JFileChooser cho = new JFileChooser();
                        cho.showOpenDialog(null);
                        File fil = cho.getSelectedFile();
                        file_path=fil.getAbsolutePath();
			FileInputStream file = new FileInputStream(file_path);
			FileOutputStream outStream = new FileOutputStream("Encrypt.txt");
			byte k[]="AnshulSaraswatKl".getBytes();
			SecretKeySpec key = new SecretKeySpec(k, "AES");
			Cipher enc = Cipher.getInstance("AES");
			enc.init(Cipher.ENCRYPT_MODE, key);
			CipherOutputStream cos = new CipherOutputStream(outStream, enc);
                        
			byte[] buf = new byte[1024];
			int read;
			while((read=file.read(buf))!=-1){
				cos.write(buf,0,read);
			}
			file.close();
			outStream.flush();
			cos.close();
			JOptionPane.showMessageDialog(null, "The file encrypted successfully");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
    }                                             

    private void decryptbuttonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        try{
                        JFileChooser cho = new JFileChooser();
                        cho.showOpenDialog(null);
                        File fil = cho.getSelectedFile();
                        file_path=fil.getAbsolutePath();
			FileInputStream file = new FileInputStream(file_path);
			FileOutputStream outStream = new FileOutputStream("Decrypt.txt");
			byte k[]="AnshulSaraswatKl".getBytes();
			SecretKeySpec key = new SecretKeySpec(k, "AES");
			Cipher enc = Cipher.getInstance("AES");
			enc.init(Cipher.DECRYPT_MODE, key);
			CipherOutputStream cos = new CipherOutputStream(outStream, enc);
			byte[] buf = new byte[1024];
			int read;
			while((read=file.read(buf))!=-1){
				cos.write(buf,0,read);
			}
			file.close();
			outStream.flush();
			cos.close();
			JOptionPane.showMessageDialog(null, "The file was decrypted successfully");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
    }                                             

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HuffmanCompression.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HuffmanCompression.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HuffmanCompression.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HuffmanCompression.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        HuffmanCompression obj = new HuffmanCompression();
        obj.setVisible(true);
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton browseButton;
    private javax.swing.JButton compressbutton;
    private javax.swing.JButton decompressbutton;
    private javax.swing.JButton decryptbutton;
    private javax.swing.JButton encryptbutton;
    private javax.swing.JTextField filePath;
    private javax.swing.JLabel headname;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}
