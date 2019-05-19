
package jsonFile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Phone {

    @SerializedName("Mobile")
    @Expose
    private String mobile;
    @SerializedName("Tele")
    @Expose
    private String tele;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Phone withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public Phone withTele(String tele) {
        this.tele = tele;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(mobile).append(tele).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Phone) == false) {
            return false;
        }
        Phone rhs = ((Phone) other);
        return new EqualsBuilder().append(mobile, rhs.mobile).append(tele, rhs.tele).isEquals();
    }

}
