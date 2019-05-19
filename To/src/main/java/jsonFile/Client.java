
package jsonFile;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Client {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("nationality")
    @Expose
    private List<Nationality> nationality = new ArrayList<Nationality>();
    @SerializedName("Phone")
    @Expose
    private Phone phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client withId(String id) {
        this.id = id;
        return this;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Client withIsActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Client withAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client withName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Client withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public List<Nationality> getNationality() {
        return nationality;
    }

    public void setNationality(List<Nationality> nationality) {
        this.nationality = nationality;
    }

    public Client withNationality(List<Nationality> nationality) {
        this.nationality = nationality;
        return this;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Client withPhone(Phone phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(isActive).append(age).append(name).append(gender).append(nationality).append(phone).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Client) == false) {
            return false;
        }
        Client rhs = ((Client) other);
        return new EqualsBuilder().append(id, rhs.id).append(isActive, rhs.isActive).append(age, rhs.age).append(name, rhs.name).append(gender, rhs.gender).append(nationality, rhs.nationality).append(phone, rhs.phone).isEquals();
    }

}
