import javax.persistence.*;
import java.util.List;

@Entity

@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int city_id;


    @Column(name = "city_name")
    private String city_name;


    public City(String city_name) {
            this.city_name = city_name;
        }

    public City() {

        }

        @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "id")
        private List<Employee> employee;

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public List<Employee> getEmployee() {
            return employee;
        }

        public void setEmployee(List<Employee> employee) {
            this.employee = employee;
        }

        @Override
        public String toString() {
            return "City{" +
                    "city_id=" + city_id +
                    ", city_name='" + city_name + '\'' +
                    '}';
        }
    }