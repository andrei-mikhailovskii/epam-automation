package db;

public class University {
    private int university_id;
    private String u_name;
    private int student_quantity;
    private int city_id;

    public int getUniversity_id() { return university_id; }

    public void setUniversity_id(int university_id) { this.university_id = university_id; }

    public String getU_name() { return u_name; }

    public void setU_name(String u_name) { this.u_name = u_name; }

    public int getStudent_quantity() { return student_quantity; }

    public void setStudent_quantity(int student_quantity) { this.student_quantity = student_quantity; }

    public int getCity_id() { return city_id; }

    public void setCity_id(int city_id) { this.city_id = city_id; }

    public University(int university_id, String u_name, int student_quantity, int city_id) {
        this.university_id = university_id;
        this.u_name = u_name;
        this.student_quantity = student_quantity;
        this.city_id = city_id;
    }

    @Override
    public String toString() {
        return "University{" +
                "university_id=" + university_id +
                ", u_name='" + u_name + '\'' +
                ", student_quantity=" + student_quantity +
                ", city_id=" + city_id +
                '}';
    }
}
