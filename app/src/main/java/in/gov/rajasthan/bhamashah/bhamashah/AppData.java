package in.gov.rajasthan.bhamashah.bhamashah;

import android.content.Context;

import java.util.ArrayList;

import in.gov.rajasthan.bhamashah.bhamashah.hospital.Hospital;
import in.gov.rajasthan.bhamashah.bhamashah.job.Job;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class AppData {
    private static ArrayList<Hospital> hospitals = new ArrayList<>();
    private static ArrayList<Job> jobs = new ArrayList<>();

    public static void init(Context context) {
        createHospitalData(context);
        createJobData(context);
    }

    private static void createJobData(Context context) {
        String jobsRawData[] = context.getResources().getStringArray(R.array.jobs);
        for (String jobDetails : jobsRawData) {
            String[] tokens = jobDetails.split(":");
            Job job = new Job(Integer.parseInt(tokens[0]));
            job.setPosition(tokens[1]);
            job.setCompany(tokens[2]);
            job.setCity(tokens[3]);
            jobs.add(job);
        }
    }

    private static void createHospitalData(Context context) {
        String hospitalRawData[] = context.getResources().getStringArray(R.array.hospital_details);
        for (String hospitalDetails : hospitalRawData) {
            String[] tokens = hospitalDetails.split(":");
            Hospital hospital = new Hospital(Integer.parseInt(tokens[0]));
            hospital.setName(tokens[1]);
            hospital.setAddress(tokens[2]);
            hospital.setCity(tokens[3]);
            hospital.setSpecifications(tokens[4].split(","));
            hospital.setDescription(tokens[5]);
            hospitals.add(hospital);
        }
    }

    public static ArrayList<Hospital> getHospitals() {
        return hospitals;
    }

    public static ArrayList<Job> getJobs() {
        return jobs;
    }
}
