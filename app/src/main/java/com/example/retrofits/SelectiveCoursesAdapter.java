package com.example.retrofits;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.retrofits.entity.SelectiveCourses;

import java.util.ArrayList;
import java.util.List;

public class SelectiveCoursesAdapter extends BaseAdapter {
    private List<SelectiveCourses> selectiveCoursesList = new ArrayList<>();
    private final LayoutInflater inflater;

    public SelectiveCoursesAdapter(Context mContext) {
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setSelectiveCoursesList(List<SelectiveCourses> selectiveCoursesList) {
        this.selectiveCoursesList = selectiveCoursesList;
    }

    @Override
    public int getCount() {
        return selectiveCoursesList.size();
    }

    @Override
    public SelectiveCourses getItem(int position) {
        return selectiveCoursesList.get(position);
    }

    @Override
    public long getItemId(int position) { // не используется
        return position;
    }

    @SuppressLint({"ViewHolder", "InflateParams", "SetTextI18n"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.custom_text_view, null);
        ImageButton imageButton = view.findViewById(R.id.imageInfo);
        SelectiveCourses currentItem = getItem(i);
        ((TextView) view.findViewById(R.id.txt_subject)).setText(currentItem.getSubject());
        ((TextView) view.findViewById(R.id.txt_info)).setText(currentItem.getInfoSubject());
        ((TextView) view.findViewById(R.id.txt_faculty)).setText(currentItem.getFaculty());
        ((TextView) view.findViewById(R.id.txt_fullNameTeacher)).setText(currentItem.getFullNameTeacher());
        ((TextView) view.findViewById(R.id.txt_count_student)).setText(Integer.toString(currentItem.getCountStudents()));
        View finalView = view;
        imageButton.setOnClickListener(v -> {
            if (finalView.findViewById(R.id.txt_info).getVisibility() == View.VISIBLE) {
                finalView.findViewById(R.id.txt_info).setVisibility(View.GONE);
            } else {
                finalView.findViewById(R.id.txt_info).setVisibility(View.VISIBLE);
            }

        });
        return view;
    }


}
