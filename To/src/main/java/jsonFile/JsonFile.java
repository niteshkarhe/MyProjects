
package jsonFile;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class JsonFile {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("clients")
    @Expose
    private List<Client> clients = new ArrayList<Client>();
    @SerializedName("customer")
    @Expose
    private List<Customer> customer = new ArrayList<Customer>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JsonFile withType(String type) {
        this.type = type;
        return this;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public JsonFile withClients(List<Client> clients) {
        this.clients = clients;
        return this;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public JsonFile withCustomer(List<Customer> customer) {
        this.customer = customer;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(clients).append(customer).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JsonFile) == false) {
            return false;
        }
        JsonFile rhs = ((JsonFile) other);
        return new EqualsBuilder().append(type, rhs.type).append(clients, rhs.clients).append(customer, rhs.customer).isEquals();
    }

}
