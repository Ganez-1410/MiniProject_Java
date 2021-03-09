import java.util.ArrayList;
class BrickWall
{
     String[] op=new String[44];
    int k=0,t=0;
    ArrayList<String> wall=null;
    BrickWall(ArrayList<String> wall){
      this.wall=wall;
    }
	public synchronized void red() 
	{
      try {
		while(true)
		{
		
		op[k++]=wall.get(0);
		System.out.print(op[k-1]+" ");
		if(k==11||k==22||k==33||k==44)
			System.out.println();
		notify();
		wait();
		}
	} catch(Exception ex)
	{
		Thread.currentThread().suspend();
	}
	}
	public synchronized void black() 
	{
      try {
		while(true)
		{
		op[k++]=wall.get(1);
		System.out.print(op[k-1]+" ");
		if(k==11||k==22||k==33||k==44)
			System.out.println();
		notify();
		wait();
		}
		}catch(Exception ex)
		{
			Thread.currentThread().suspend();
		}
	}
}
class Red extends Thread
{
	BrickWall m;
	Red(BrickWall m){
	this.m=m;
	}
	public void run(){
		m.red();
  }
}
class Black extends Thread
{
	BrickWall m;
	Black(BrickWall m){
	this.m=m;
	}
	public void run(){
		m.black();
	}
}
public class MiniProg_2 {
public static void main(String[] args) throws InterruptedException {
	ArrayList<String> wall=new ArrayList<String>();
	System.out.println("The wall is");
	wall.add("RED");
	wall.add("BLACK");
	BrickWall m=new BrickWall(wall);
	Red r=new Red(m);
	Black b=new Black(m);
	r.start();
	b.start();
	b.join();
	}
}