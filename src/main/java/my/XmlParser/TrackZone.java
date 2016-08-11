package my.XmlParser;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by al792 on 10/05/2016.
 */
public class TrackZone {
    private int Z0=114;
    private int Z1=144;
    private int Z2=163;
    private int Z3=190;
    private int Z4=195;

    private int tpsZ0=0;
    private int tpsZ1=0;
    private int tpsZ2=0;
    private int tpsZ3=0;
    private int tpsZ4=0;
    Float tpsTotal;
    Float distotal;

    public  int getZ0() {
		return Z0;
	}

	public  int getZ1() {
		return Z1;
	}

	public  int getZ2() {
		return Z2;
	}

	public  int getZ3() {
		return Z3;
	}

	public  int getZ4() {
		return Z4;
	}
	
	
 public Float getTpsTotal() {
		return tpsTotal;
	}

	public void setTpsTotal(Float tpsTotal) {
		this.tpsTotal = tpsTotal;
	}

	public Float getDistotal() {
		return distotal;
	}

	public void setDistotal(Float distotal) {
		this.distotal = distotal;
	}

	public void setZ0(int z0) {
		Z0 = z0;
	}

	public void setZ1(int z1) {
		Z1 = z1;
	}

	public void setZ2(int z2) {
		Z2 = z2;
	}

	public void setZ3(int z3) {
		Z3 = z3;
	}

	public void setZ4(int z4) {
		Z4 = z4;
	}

public int getTpsZ0() {
        return tpsZ0;
    }

    public  void setTpsZ0(int tpsZ0) {
        this.tpsZ0 = tpsZ0;
    }

    public  int getTpsZ1() {
        return tpsZ1;
    }

    public  void setTpsZ1(int tpsZ1) {
        this.tpsZ1 = tpsZ1;
    }

    public  int getTpsZ2() {
        return tpsZ2;
    }

    public  void setTpsZ2(int tpsZ2) {
    	this.tpsZ2 = tpsZ2;
    }

    public  int getTpsZ3() {
        return tpsZ3;
    }

    public  void setTpsZ3(int tpsZ3) {
    	this.tpsZ3 = tpsZ3;
    }

    public  int getTpsZ4() {
        return tpsZ4;
    }

    public  void setTpsZ4(int tpsZ4) {
    	this.tpsZ4 = tpsZ4;
    }
    public  void initZone(ArrayList<Track> trackList){
         
        tpsTotal= (trackList.get(trackList.size()-1).getSec());
        distotal= Float.valueOf(trackList.get(trackList.size()-1).getDist());
        Iterator it=trackList.iterator();
        Track trackprec=(Track)it.next();
        tpsTotal=tpsTotal-trackprec.getSec();
        Track trackcur;
        Float tpstrack;
        Float disttrack;
        Float pctTrack;
        while(it.hasNext()){
            trackcur=(Track)it.next();
            tpstrack=trackcur.getSec()-trackprec.getSec();
            disttrack=Float.valueOf(trackcur.getDist())-Float.valueOf(trackprec.getDist());
            pctTrack=tpstrack;//(tpstrack/tpsTotal*100);
            if (Integer.parseInt(trackcur.getBpm())<=Z0) {
            	tpsZ0=(int) (tpsZ0+pctTrack);
            }
            else{ 
            	 if (Integer.parseInt(trackcur.getBpm())<=Z1){
            		 tpsZ0=(int) (tpsZ0+pctTrack);
            	 }
            	 else{
            		 if (Integer.parseInt(trackcur.getBpm())<=Z2){
            			 tpsZ1=(int) (tpsZ1+pctTrack);
            		 }
                     else{ 
                    	  if (Integer.parseInt(trackcur.getBpm())<=Z3){
                    		  tpsZ2=(int) (tpsZ2+pctTrack);
                    	  }
                          else{
                        	   if (Integer.parseInt(trackcur.getBpm())<=Z4){
                    		    tpsZ3=(int) (tpsZ3+pctTrack);
                        	   }
                        	   else{
                    	        tpsZ4=(int) (tpsZ4+pctTrack);
                              }        
            	          }
                     }
                  }
            }
            trackprec=trackcur;
        }

        
        
    }
}
