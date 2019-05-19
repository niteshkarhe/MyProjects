
package jsonFile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Nationality_ {

    @SerializedName("First")
    @Expose
    private String first;
    @SerializedName("Second")
    @Expose
    private String second;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public Nationality_ withFirst(String first) {
        this.first = first;
        return this;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public Nationality_ withSecond(String second) {
        this.second = second;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(first).append(second).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Nationality_) == false) {
            return false;
        }
        Nationality_ rhs = ((Nationality_) other);
        return new EqualsBuilder().append(first, rhs.first).append(second, rhs.second).isEquals();
    }

}
