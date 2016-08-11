package my.XmlParser;


public class Track {
    String time;
    String dist;
    String bpm;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getBpm() {
        return bpm;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    public Float getSec(){
    	Float hh=(Float.valueOf(this.time.substring(11,13)))*3600;
    	Float mm=(Float.valueOf(this.time.substring(14,16)))*60;
    	Float ss=(Float.valueOf(this.time.substring(17,19)));
        return hh+mm+ss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (bpm != null ? !bpm.equals(track.bpm) : track.bpm != null) return false;
        if (dist != null ? !dist.equals(track.dist) : track.dist != null) return false;
        if (time != null ? !time.equals(track.time) : track.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (dist != null ? dist.hashCode() : 0);
        result = 31 * result + (bpm != null ? bpm.hashCode() : 0);
        return result;
    }
}
