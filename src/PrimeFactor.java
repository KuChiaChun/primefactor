import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;
//104403019 ���3A �j�ήm
public class PrimeFactor {
	private static Iterator it;
	private static boolean Do =true;
	private static TreeSet<Integer> ts;
	public static void main(String[] args) 
	{
		String input = JOptionPane.showInputDialog(null,"�п�J�@�ӥ����","���]��",JOptionPane.PLAIN_MESSAGE);
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
		    Integer.parseInt(input);//���ըϥΪ̿�J�O�_��integer
		   
		 
	Set<Integer> factor = new HashSet<Integer>();//new �@��hashset
	
	if(!input.equals(null)&&Integer.parseInt(input)>1)//�P�_�Ʀr�O�_���ŤάO�_�j��1
	{
		OriginNumber = Integer.parseInt(input);//�N�Ʀr�s�_��
		count = 0;
		factorcount = 0;
		primefactor = 0;
		
		//�}�l�M��Ʀr����]��  
		for(int i=2;i<OriginNumber;i++)
		{
			if(OriginNumber%i==0)//�P�_i�O�_��OriginNumber���]��
			{
				for(int j=2;j<=i;j++)//�P�_i�O�_�����
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
				if(count==1)//count==1�N��i�O���  �N���s�bhashset��
				{
					factorcount++;
					primefactor+=i;
					factor.add(i);					
				}
			}
			count = 0;
		}		
		if(!(factorcount>0))//factorcount���j��0 �N��OriginNumber�O���
		{										 					

			Flag=0;
			factorcount = 0;
			returnFlag = true;
			JOptionPane.showMessageDialog(null,OriginNumber+"�O�ӽ��","���",JOptionPane.PLAIN_MESSAGE);
			input = JOptionPane.showInputDialog(null,"�п�J�@�ӥ����","���]��",JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			ts = new TreeSet<Integer>(factor);//��treeset�s��hashset���� �H�Ƨ�
			it = ts.iterator(); //�ŧitreeset��iterator
			primefactor=1;
			while(it.hasNext())//�L�X�Ҧ�����]��
			{
	
			
				Flag++;
				JOptionPane.showMessageDialog(null, input+"����]�ƥ]�t  : "+(int)it.next(),"��]��"+primefactor+"/"+factorcount,JOptionPane.PLAIN_MESSAGE);	
				primefactor++;
			}
			input = JOptionPane.showInputDialog(null,"�п�J�@�ӥ����","���]��",JOptionPane.PLAIN_MESSAGE);
		}
	}
	else if(input.equals(null)||Integer.parseInt(input)==0)
	{
		JOptionPane.showMessageDialog(null, String.format("�п�J�@�ӥ����"));
		input = JOptionPane.showInputDialog(null,"�п�J�@�ӥ����","���]��",JOptionPane.PLAIN_MESSAGE);
	
	}
	else if(Integer.parseInt(input)==1)
	{
		
		JOptionPane.showMessageDialog(null, String.format("1���O��Ƥ]���O�X��"));
		input = JOptionPane.showInputDialog(null,"�п�J�@�ӥ����","���]��",JOptionPane.PLAIN_MESSAGE);
		
	}
	else if(Integer.parseInt(input)<0)
	{
		JOptionPane.showMessageDialog(null, String.format("%d ���O�����",Integer.parseInt(input)));
		input = JOptionPane.showInputDialog(null,"�п�J�@�ӥ����","���]��",JOptionPane.PLAIN_MESSAGE);
		
	}
}			
	catch (NumberFormatException e) //�ϥΪ̿�J���O��ƪ�exception
	{
	 	if(input.equals(""))
	 	{
	 		JOptionPane.showMessageDialog(null, String.format("�п�J�@�ӥ����"));
	 		input = JOptionPane.showInputDialog(null,"�п�J�@�ӥ����","���]��",JOptionPane.PLAIN_MESSAGE);
	 	
	 	}
	 	else 
	 	{
	 		JOptionPane.showMessageDialog(null, String.format("\""+input+"\""+"���O�����")); 
	 		input = JOptionPane.showInputDialog(null,"�п�J�@�ӥ����","���]��",JOptionPane.PLAIN_MESSAGE);
	 		
	 	}
	} 
		
		
		
	}
	
	while(Do);
}
}
