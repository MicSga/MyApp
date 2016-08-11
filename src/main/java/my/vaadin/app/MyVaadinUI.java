package my.vaadin.app;

import java.util.ArrayList;

import my.XmlParser.Track;
import my.XmlParser.TrackZone;
import my.XmlParser.XmlParser;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{
	String FileName;
	
    public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public ArrayList<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(ArrayList<Track> trackList) {
        this.trackList = trackList;
    }

    private ArrayList<Track> trackList;

    
    @Override
    protected void init(VaadinRequest request) {
    	
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        final HorizontalLayout header = new HorizontalLayout();
        header.setMargin(true);
        final VerticalLayout body = new VerticalLayout();
    	TrackZone valZone = new TrackZone();
    	setFileName("c:\\20160520.xml");    	
        body.setMargin(true);
        
      	layout.addComponent(new Label(getFileName()));
        layout.addComponent(header);
        layout.addComponent(body);
        
    
    	
  
    	
    	TextField fieldmax=new TextField("FCMMAX:");    	
    	header.addComponent(fieldmax);
    	
    	final TextField fieldZ0=new TextField("Z0:");
    	fieldZ0.setValue(String.valueOf(valZone.getZ0()));
    	header.addComponent(fieldZ0);
    	
    	final TextField fieldZ1=new TextField("Z1:");
    	fieldZ1.setValue(String.valueOf(valZone.getZ1()));
    	header.addComponent(fieldZ1);
    	
    	final TextField fieldZ2=new TextField("Z2:");
    	fieldZ2.setValue(String.valueOf(valZone.getZ2()));
    	header.addComponent(fieldZ2);
    	
    	final TextField fieldZ3=new TextField("Z3:");
    	fieldZ3.setValue(String.valueOf(valZone.getZ3()));
    	header.addComponent(fieldZ3);
    	
    	final TextField fieldZ4=new TextField("Z4:");
    	fieldZ4.setValue(String.valueOf(valZone.getZ4()));
    	header.addComponent(fieldZ4);    	    	    	
    	
    
        
        Button button = new Button("CalcZone");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {                               
                trackList= new ArrayList();
                XmlParser xmlParser=new XmlParser();
                xmlParser.init(FileName,trackList);
                TrackZone zone=new TrackZone();
                zone.setZ0(Integer.parseInt(fieldZ0.getValue()));
                zone.setZ1(Integer.parseInt(fieldZ1.getValue()));
                zone.setZ2(Integer.parseInt(fieldZ2.getValue()));
                zone.setZ3(Integer.parseInt(fieldZ3.getValue()));
                zone.setZ4(Integer.parseInt(fieldZ4.getValue()));
                
                
                zone.initZone(getTrackList());
                float tpstotal=zone.getTpsTotal();
                body.addComponent(new Label("Z0 - "+zone.getTpsZ0()+" - "+zone.getTpsZ0()/tpstotal*100));
                body.addComponent(new Label("Z1 - "+zone.getTpsZ1()+" - "+zone.getTpsZ1()/tpstotal*100));
                body.addComponent(new Label("Z2 - "+zone.getTpsZ2()+" - "+zone.getTpsZ2()/tpstotal*100));
                body.addComponent(new Label("Z3 - "+zone.getTpsZ3()+" - "+zone.getTpsZ3()/tpstotal*100));
                body.addComponent(new Label("Z4 - "+zone.getTpsZ3()+" - "+zone.getTpsZ4()/tpstotal*100));
                body.addComponent(new Label("tpstotal - "+tpstotal+" -dist "+zone.getDistotal()));
                
              //  Chart chart =new Chart(CharType.COLUMN);
                
                
            }
        });
        body.addComponent(button);
    }

}
