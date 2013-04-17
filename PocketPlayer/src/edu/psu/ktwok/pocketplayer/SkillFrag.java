package edu.psu.ktwok.pocketplayer;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class SkillFrag extends Fragment{

	//For later date
	//String[] skills = getResources().getStringArray(R.array.skills);
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
				//android.R.layout.simple_list_item_multiple_choice, skills);
		
		//setListAdapter(adapter);
		
		//return super.onCreateView(inflater, container, savedInstanceState);
		return (LinearLayout) inflater.inflate(R.layout.skill_tab, container, false);
	}
	
	//@Override
	/*public void onStart(){
		super.onStart();
		
		getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}
	*/
}
