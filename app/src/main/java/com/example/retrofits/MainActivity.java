package com.example.retrofits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.retrofits.entity.SelectiveCourses;
import com.example.retrofits.service.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public final String URL = "http://192.168.100.6:8080";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDataFromUrl();
    }

    private void getDataFromUrl() {
        final ListView listView = findViewById(R.id.listView);
        final TextView textView = findViewById(R.id.status_error);
        SelectiveCoursesAdapter selectiveCoursesAdapter = new SelectiveCoursesAdapter(this);
        NetworkService.getInstance(URL)
                .getJSONApi()
                .getSelectiveCourses()
                .enqueue(new Callback<List<SelectiveCourses>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<SelectiveCourses>> call, @NonNull Response<List<SelectiveCourses>> response) {
                        List<SelectiveCourses> post = response.body();
                        selectiveCoursesAdapter.setSelectiveCoursesList(post);
                        listView.setAdapter(selectiveCoursesAdapter);
                        selectiveCoursesAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<SelectiveCourses>> call, @NonNull Throwable t) {
                        textView.setVisibility(View.VISIBLE);
                        textView.setText("Error\n404");
                        t.printStackTrace();
                    }
                });
    }
}