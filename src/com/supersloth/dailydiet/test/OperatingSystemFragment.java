package com.supersloth.dailydiet.test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.supersloth.dailydiet.R;

public class OperatingSystemFragment extends Fragment{

	public static final String ARG_OS = "OS";
	private String str;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_layout, null);
		TextView tv = (TextView) view.findViewById(R.id.tvTodaysDate);	
		tv.setText(str);
		
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	
	
}
