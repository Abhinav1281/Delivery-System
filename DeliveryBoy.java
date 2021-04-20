import java.util.*;
public class DeliveryBoy
{
    int rest=0,dest=0,allowedDeli=0,currentDeli=0,totalorder=0;
    double totalincome=0.0,orderIncome=0.0,startTime=0.0;
    String dname="";

    List<Integer> customer=new LinkedList<Integer>();
    public void order(int r,int d,double start,int id)
    {
        if(allowedDeli<=0)
        {
            System.out.println("ORDER CANNOT BE GIVEN TO THIS DELIVERY BOY!!! DELIVERY BOY IS FULL");
            return;
        }
        if(currentDeli>0 && start>(startTime+0.15))
        {
            System.out.println("ORDER CANNOT BE GIVEN TO THIS DELIVERY BOY!!!DELIVERY TIME EXCEEDED"+currentDeli);
            return;    
        }
        customer.add(id);
        currentDeli++;
        rest=r;
        dest=d;
        startTime=start;
        orderGot();
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

    void overrideOrderDone()
    {
        if(currentDeli>1)
            orderIncome+=50+(5*(currentDeli-1));
        else 
            orderIncome+=50*currentDeli;
        totalincome+=orderIncome;
        
        currentDeli=0;
        startTime=0.0;
        orderIncome=0;
        rest=0;
        dest=0;
    }

    void orderGot()
    {
        System.out.println("Order recieved by:"+dname+"\nat "+startTime+"\nFrom:"+rest+"\nto:"+dest);
    }

    void deliveryList()
    {
        System.out.println(dname+"\t"+totalincome);
    }
}