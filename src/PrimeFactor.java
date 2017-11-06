import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;
//104403019 資管3A 古佳峻
public class PrimeFactor {
	private static Iterator it;
	private static boolean Do =true;
	private static TreeSet<Integer> ts;
	public static void main(String[] args) 
	{
		String input = JOptionPane.showInputDialog(null,"請輸入一個正整數","找質因數",JOptionPane.PLAIN_MESSAGE);
		do {
			if(input ==null) 
			{
				System.exit(0);
			}
		int OriginNumber;
		int count = 0;
		int factorcount = 0;
		int primefactor = 0;
		int Flag = 0;
		
		boolean returnFlag = true;
		
		try {
		    Integer.parseInt(input);//測試使用者輸入是否為integer
		   
		 
	Set<Integer> factor = new HashSet<Integer>();//new 一個hashset
	
	if(!input.equals(null)&&Integer.parseInt(input)>1)//判斷數字是否為空及是否大於1
	{
		OriginNumber = Integer.parseInt(input);//將數字存起來
		count = 0;
		factorcount = 0;
		primefactor = 0;
		
		//開始尋找數字的質因數  
		for(int i=2;i<OriginNumber;i++)
		{
			if(OriginNumber%i==0)//判斷i是否為OriginNumber的因數
			{
				for(int j=2;j<=i;j++)//判斷i是否為質數
				{
					if(i%j==0)
					{
						count++;
						if(count>1)
						{
							break;
						}
					}
			
				}			
				if(count==1)//count==1代表i是質數  將它存在hashset裡
				{
					factorcount++;
					primefactor+=i;
					factor.add(i);					
				}
			}
			count = 0;
		}		
		if(!(factorcount>0))//factorcount不大於0 代表OriginNumber是質數
		{										 					

			Flag=0;
			factorcount = 0;
			returnFlag = true;
			JOptionPane.showMessageDialog(null,OriginNumber+"是個質數","質數",JOptionPane.PLAIN_MESSAGE);
			input = JOptionPane.showInputDialog(null,"請輸入一個正整數","找質因數",JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			ts = new TreeSet<Integer>(factor);//用treeset存取hashset的值 以排序
			it = ts.iterator(); //宣告treeset的iterator
			primefactor=1;
			while(it.hasNext())//印出所有的質因數
			{
	
			
				Flag++;
				JOptionPane.showMessageDialog(null, input+"的質因數包含  : "+(int)it.next(),"質因數"+primefactor+"/"+factorcount,JOptionPane.PLAIN_MESSAGE);	
				primefactor++;
			}
			input = JOptionPane.showInputDialog(null,"請輸入一個正整數","找質因數",JOptionPane.PLAIN_MESSAGE);
		}
	}
	else if(input.equals(null)||Integer.parseInt(input)==0)
	{
		JOptionPane.showMessageDialog(null, String.format("請輸入一個正整數"));
		input = JOptionPane.showInputDialog(null,"請輸入一個正整數","找質因數",JOptionPane.PLAIN_MESSAGE);
	
	}
	else if(Integer.parseInt(input)==1)
	{
		
		JOptionPane.showMessageDialog(null, String.format("1不是質數也不是合數"));
		input = JOptionPane.showInputDialog(null,"請輸入一個正整數","找質因數",JOptionPane.PLAIN_MESSAGE);
		
	}
	else if(Integer.parseInt(input)<0)
	{
		JOptionPane.showMessageDialog(null, String.format("%d 不是正整數",Integer.parseInt(input)));
		input = JOptionPane.showInputDialog(null,"請輸入一個正整數","找質因數",JOptionPane.PLAIN_MESSAGE);
		
	}
}			
	catch (NumberFormatException e) //使用者輸入不是整數的exception
	{
	 	if(input.equals(""))
	 	{
	 		JOptionPane.showMessageDialog(null, String.format("請輸入一個正整數"));
	 		input = JOptionPane.showInputDialog(null,"請輸入一個正整數","找質因數",JOptionPane.PLAIN_MESSAGE);
	 	
	 	}
	 	else 
	 	{
	 		JOptionPane.showMessageDialog(null, String.format("\""+input+"\""+"不是正整數")); 
	 		input = JOptionPane.showInputDialog(null,"請輸入一個正整數","找質因數",JOptionPane.PLAIN_MESSAGE);
	 		
	 	}
	} 
		
		
		
	}
	
	while(Do);
}
}
