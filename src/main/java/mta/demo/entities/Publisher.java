package mta.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "publishers")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Publisher implements Serializable {

    @Id
    @Column(name = "publisher_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(nullable = false, length = 255)
    private String url;

    @Column(nullable = false, length = 255)
    private String phone;

    /* GETTERS & SETTERS */

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    /* TO STRING */

    @Override
    public String toString() {
        return "Publisher{" +
                "publisher_id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", url='" + url + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
