package my.XmlParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;


public class  XmlParser {

    private Document document;
    private  Element racine;

     

    //Ajouter cette méthodes à la classe JDOM2
    public  void init(String FileName, ArrayList<Track> trackList)
    {
        //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
        //List listTr = racine.getChildren("TrainingCenterDatabase");
        //On crée une instance de SAXBuilder
        SAXBuilder sxb = new SAXBuilder();        

        try
        {
            //On crée un nouveau document JDOM avec en argument le fichier XML
            //Le parsing est terminé ;)
            document = sxb.build(new File(FileName));
        }
        catch(Exception e){}

        //On initialise un nouvel élément racine avec l'élément racine du document.
        racine = document.getRootElement();

        //Méthode définie dans la partie 3.2. de cet article

    
     


        Element elAct = racine.getChild("Activities");

        //On crée un Iterator sur notre liste

            //On recrée l'Element courant à chaque tour de boucle afin de
            //pouvoir utiliser les méthodes propres aux Element comme :
            //sélectionner un nœud fils, modifier du texte, etc...

            //On affiche le nom de l’élément courant
            //on récupère les activy
            List listActivity = elAct.getChildren("Activity");
            Iterator activityIt =listActivity.iterator();
            while (activityIt.hasNext()){
                Element actCur = (Element)activityIt.next();
                List listLap = actCur.getChildren("Lap");
                Iterator lapIt =listLap.iterator();
                while (lapIt.hasNext()) {
                    Element lapcur = (Element)lapIt.next();

                        Element trackcur = lapcur.getChild("Track");
                        List listTrackpoint = trackcur.getChildren("Trackpoint");
                        Iterator trackpointIt =listTrackpoint.iterator();
                        while (trackpointIt.hasNext()) {
                            Element trackpointcur = (Element)trackpointIt.next();
                            String distance=trackpointcur.getChild("DistanceMeters").getText();
                            String time=trackpointcur.getChild("Time").getText();
                            Element heartRate=trackpointcur.getChild("HeartRateBpm");
                            String value;
                            if (heartRate!=null){
                            	value=heartRate.getChild("Value").getText();
                            }else{
                            	value="0";
                            }
                            
                            Track track = new Track();
                            track.setDist(distance);
                            track.setTime(time);
                            track.setBpm(value);
                            trackList.add(track);
                        }
                    }

                }





    }
}