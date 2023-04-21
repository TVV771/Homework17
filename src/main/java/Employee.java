public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private int age;
    private int citi_id;
    private String citi_name;

    public Employee(int id, String first_name, String last_name, String gender, int age, int citi_id, String citi_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.citi_id = citi_id;
        this.citi_name = citi_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCiti_id() {
        return citi_id;
    }

    public void setCiti_id(int citi_id) {
        this.citi_id = citi_id;
    }

    public String getCiti_name() {
        return citi_name;
    }

    public void setCiti_name(String citi_name) {
        this.citi_name = citi_name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", citi_name=" + citi_name +
                '}';
    }
}