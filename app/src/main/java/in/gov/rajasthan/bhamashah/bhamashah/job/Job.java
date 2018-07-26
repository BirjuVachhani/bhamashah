package in.gov.rajasthan.bhamashah.bhamashah.job;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class Job implements Parcelable {
    private int id;
    private String position;
    private String company;
    private String city;

    public Job(int id) {
        this.id = id;
    }

    protected Job(Parcel in) {
        id = in.readInt();
        position = in.readString();
        company = in.readString();
        city = in.readString();
    }

    public static final Creator<Job> CREATOR = new Creator<Job>() {
        @Override
        public Job createFromParcel(Parcel in) {
            return new Job(in);
        }

        @Override
        public Job[] newArray(int size) {
            return new Job[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(position);
        dest.writeString(company);
        dest.writeString(city);
    }
}
