import javax.persistence.*;
import java.util.List;

@Entity

@Table(name = "employee")


    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        @Column (name = "id")
        private int id;
        @Column(name = "first_name")
        private String first_name;
        @Column(name = "last_name")
        private String last_name;
        @Column(name = "gender")
        private String gender;


            public void setId(int id) {
                this.id = id;
            }


                @OneToOne(cascade = CascadeType.ALL)
                @JoinColumn(name = "city_id")
                private City city;

      public Employee( String first_name, String last_name, String gender, City city) {
                    this.first_name = first_name;
                    this.last_name = last_name;
                    this.gender = gender;
                    this.city = city;
                }


    public Employee() {
    }


                    public String getFirst_name() {
                        return first_name;
                    }


                        public List<Employee> setFirst_name(String first_name) {
                            this.first_name = first_name;
                            return null;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }


            public int getId() {
                return id;
            }


        }
