package edu.psu.ktwok.pocketplayer;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class SkillFrag extends ListFragment{

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		return (LinearLayout) inflater.inflate(R.layout.skill_tab, container, false);
	}
	
	private Context context;
	
	public void onActivityCreated(Bundle savedInstanceState){
		super.onSaveInstanceState(savedInstanceState);
		String [] skills = context.getResources().getStringArray(R.array.skills);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, skills);
		setListAdapter(adapter);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id){
		
	}
	
}
