package com.example.retrofits.interfaces;

import com.example.retrofits.entity.SelectiveCourses;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @GET("/getSelectiveCourses")
    public Call<List<SelectiveCourses>> getSelectiveCourses();
    @GET("/getSelectiveCourses")
    public Call<List<SelectiveCourses>> getSelectiveCoursesOfId(@Query("id") int id);
}
