import java.util.*;
public class DeliveryBoy
{
    static int rest=0,dest=0,allowedDeli=0,currentDeli=0,totalorder=0;
    static double totalincome=0.0,orderIncome=0.0,startTime=0.0;
    static String dname="";

    List<Integer> customer=new LinkedList<Integer>();
    public void order(int r,int d,double start,int id)
    {
        if(allowedDeli<=0)
        {
            System.out.println("ORDER CANNOT BE GIVEN TO THIS DELIVERY BOY!!!");
            return;
        }
        if(currentDeli>0 && (start+0.30)>startTime)
        {
            System.out.println("ORDER CANNOT BE GIVEN TO THIS DELIVERY BOY!!!");
            return;    
        }
        customer.add(id);
        currentDeli++;
        rest=r;
        dest=d;
        startTime=start;
    }

    public void setDname(String d)
    {
        dname=d;
    }
    public double getTime()
    {
        return startTime;
    }

    public int getCurrentDeli()
    {
        return currentDeli;
    }

    public void setallowedDeli(int val)
    {
        allowedDeli=val;
    }

    public void orderDone()
    {
        currentDeli=0;
        startTime=0.0;
        orderIncome+=50-5;
        totalincome+=orderIncome;
        orderIncome=0;
        rest=0;
        dest=0;
    }

    public void orderDone(int id)
    {
        totalorder++;
        currentDeli--;
        orderIncome+=5.0;
        customer.remove(id);
    }

    int getRest()
    {
        return rest;
    }

    double getBookTime()
    {
        return startTime;
    }

    void displayInfo()
    {
        System.out.println("Name:"+dname+"\t Income:"+totalincome+"\tOrder Done:"+totalorder);
    }
}