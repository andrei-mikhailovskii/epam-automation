package db;

public class City {
    private int city_id;
    private String city_name;
    private int citizen;

    public int getCity_id() { return city_id; }

    public void setCity_id(int city_id) { this.city_id = city_id; }

    public String getCity_name() { return city_name; }

    public void setCity_name(String city_name) { this.city_name = city_name; }

    public int getCitizen() { return citizen; }

    public void setCitizen(int citizen) { this.citizen = citizen; }

    public City(int city_id, String city_name, int citizen) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.citizen = citizen;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                ", citizen=" + citizen +
                '}';
    }
}
