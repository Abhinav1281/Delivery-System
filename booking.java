import java.util.*;
public class booking {
    static List<DeliveryBoy> deliveryBoy=new LinkedList<DeliveryBoy>();
    static Scanner sc=new Scanner(System.in);
    
    static int rest,dest,allowed;
    double time;

    static void setAllowed(int a)
    {
        allowed=a;
    }
    static void createDeliveryBoy(int num)
    {
        for(int i=0;i<num;i++)
        {
            DeliveryBoy d=new DeliveryBoy();
            d.setallowedDeli(allowed);
            System.out.println("Enter Del. Name");
            String x=sc.next();
            d.setDname(x);
            deliveryBoy.add(d);
        }
    }

    //Handle Booking
    static void bookingHandle()
    {
        System.out.println("Enter Rest.");
        int r=sc.nextInt();
        System.out.println("Enter Dest.");
        int d=sc.nextInt();
        System.out.println("Enter Booking time");
        double t=sc.nextDouble();
        System.out.println("Enter Booking id");
        int id=sc.nextInt();
        
        DeliveryBoy boy;
        try{
            boy=search(r,t);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }
        assignExec(r,d,t,boy,id);
    }

    static DeliveryBoy search(int val,double time) throws Exception
    {
        for(int i=0;i<deliveryBoy.size();i++)
        {
           int r=deliveryBoy.get(i).getRest();
            if(r==val)
            {
                int a=deliveryBoy.get(i).getCurrentDeli();
                if(a<=allowed)
                {
                    double t=deliveryBoy.get(i).getBookTime();
                    if(time<(t+0.15))
                        return deliveryBoy.get(i);
                }
            }
        }

        for(int i=0;i<deliveryBoy.size();i++)
        {
            int a=deliveryBoy.get(i).getCurrentDeli();
            if(a==0)
                return deliveryBoy.get(i);
        }

        throw new Exception("No Delivery Boy available");
    }

    //assigning Executive
    static void assignExec(int r,int d,double t,DeliveryBoy b,int id)
    {
        displayDelivery();
        assignedTo(b);
        b.order(r, d, t, id);
    }

    static void deliveryDone(int id,int boyIndex)
    {
        DeliveryBoy d=deliveryBoy.get(boyIndex);
        d.orderDone(id);
        if(d.getCurrentDeli()==0)
        {
            d.orderDone();
        }
    }

    static void allOrderDone()
    {
        for(int i=0;i<deliveryBoy.size();i++)
        {
            deliveryBoy.get(i).overrideOrderDone();
        }
    }
    //displaying executive info
    static void display()
    {
        for(int i=0;i<deliveryBoy.size();i++)
        {
            deliveryBoy.get(i).displayInfo();
            System.out.println();
        }
    }

    static void displayDelivery()
    {
        System.out.println("\nAVAILABLE EXEC:\nNAME\tINCOME EARNED");
        for(int i=0;i<deliveryBoy.size();i++)
        {
            deliveryBoy.get(i).deliveryList();
            System.out.println();
        }
    }

    static void assignedTo(DeliveryBoy b)
    {
        System.out.println(b.dname+" on order "+b.getCurrentDeli());
    }
}
