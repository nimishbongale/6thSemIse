//telephone program using array list
//Author: @ishankdev
//Modifed last by @nimishbongale
import java.util.*;

class MissedCall 
{
	String name, phoneNo, time;
	MissedCall(String name, String phoneNo, String time)
	{
		this.name = name;
		this.phoneNo = phoneNo;
		this.time = time;
	}

    public String toString(){
        return this.name+'\n'+this.phoneNo+'\n'+this.time+'\n';
    }
}

class Caller
{
	int id;
	String name,ph;

	Caller(int id, String name, String ph)
	{
		this.id = id;
		this.name = name;
		this.ph = ph;
	}
}

public class phone
{
	public static void main(String[] args)
	{	
		int count = 0;
		Scanner sc = new Scanner(System.in);
		Calendar c = Calendar.getInstance();

		ArrayList<Caller> alist = new ArrayList<Caller>(); 
        ArrayList<MissedCall> mlist = new ArrayList<MissedCall>(); 
		
        alist.add(new Caller(1, "Ramu", "9087654321"));
		alist.add(new Caller(2, "Shamu", "9780654321"));
        alist.add(new Caller(2, "Private", "Not Available"));

		while(true)
		{
			System.out.println("\n1)Add missed calls\n2)Check call history\n3)Delete missed calls\n");
			int ch = sc.nextInt();
			switch(ch)
			{
				case 1:
				if(count > 10)
				{
					mlist.remove(0); 
					count--;
				}
				Caller caller = alist.get(new Random().nextInt(3)); 
				String time1 = c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
				mlist.add(new MissedCall(caller.name, caller.ph, time1)); 
				count++;
				System.out.println("**Missed Call recorded**" );
				break;

				case 2:
				if(mlist.size()==0)
					System.out.println("*** No new Missed Calls ***");
					
				for(int i = 0; i < mlist.size(); i++)
				{	
					System.out.println("***Missed Calls***");
					MissedCall missedCaller = mlist.get(i);
					System.out.println(missedCaller);
					if(i == mlist.size() -1 ){
						System.out.println("***Last record reached next record not available!***");
// 						break after last record is displayed
						break;
					}
					System.out.println("\n1) Display next\n2) Display next and delete current\n");
					int ch1 = sc.nextInt();
					switch(ch1)
					{
						case 1:
						continue;

						case 2:
						System.out.println(missedCaller + " deleted successfully\n");
						mlist.remove(i);
						i--;
						count--;
						continue;
					}
				}
				break;

				case 3:
				System.out.println("\nEnter number to delete: ");
				Scanner sc1 = new Scanner(System.in); 
				String delNum = sc1.nextLine();
				for(int i = 0; i < mlist.size(); i++)
				{
					MissedCall missedCaller = mlist.get(i);
					if(missedCaller.phoneNo.equals(delNum))
					{
						mlist.remove(i);
						count--;
						System.out.println("Deleted "+delnum);
					}
				}
			}
		}
	}
}
