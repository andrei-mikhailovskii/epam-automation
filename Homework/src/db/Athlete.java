package db;

public class Athlete {

    private int athlete_id;
    private String first_name;
    private String last_name;
    private String birth_date_time;
    private int university_id;

    public int getAthlete_id() { return athlete_id; }

    public void setAthlete_id(int athlete_id) { this.athlete_id = athlete_id; }

    public String getFirst_name() { return first_name; }

    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }

    public void setLast_name(String last_name) { this.last_name = last_name; }

    public String getBirth_date_time() { return birth_date_time; }

    public void setBirth_date_time(String birth_date_time) { this.birth_date_time = birth_date_time; }

    public int getUniversity_id() { return university_id; }

    public void setUniversity_id(int university_id) { this.university_id = university_id; }

    public Athlete(int athlete_id, String first_name, String last_name, String birth_date_time, int university_id) {
        this.athlete_id = athlete_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date_time = birth_date_time;
        this.university_id = university_id;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "athlete_id=" + athlete_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birth_date_time='" + birth_date_time + '\'' +
                ", university_id=" + university_id +
                '}';
    }
}
