package edu.psu.ktwok.pocketplayer;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CharInfo extends Activity {
	Intent i;
	private static final int SETTINGS_ACTIVITY_REQUEST_CODE = 200;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_char_info); //needed?
		
		//implement action bar
		ActionBar aBar = getActionBar();
		aBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		//stat tab
		String lab1 = getResources().getString(R.string.Stat); //what do i id?
		Tab tab = aBar.newTab();
		tab.setText(lab1);
		TabListener<StatFrag> stFrag = new TabListener<StatFrag>(this, lab1,StatFrag.class);
		tab.setTabListener(stFrag);
		aBar.addTab(tab);
		
		//weapon tab
		String lab2 = getResources().getString(R.string.Equipment);
		tab = aBar.newTab();
		tab.setText(lab2);
		TabListener<WeaponFrag> wFrag = new TabListener<WeaponFrag>(this, lab2, WeaponFrag.class);
		tab.setTabListener(wFrag);
		aBar.addTab(tab);
		
		//skill tab
		String lab3 = getResources().getString(R.string.skills);
		tab = aBar.newTab();
		tab.setText(lab3);
		TabListener<SkillFrag> skFrag = new TabListener<SkillFrag>(this, lab3, SkillFrag.class);
		tab.setTabListener(skFrag);
		aBar.addTab(tab);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case R.id.menu_settings:
				i = new Intent(this, SettingsActivity.class);
				startActivityForResult(i, SETTINGS_ACTIVITY_REQUEST_CODE);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	private class TabListener<T extends Fragment> implements ActionBar.TabListener{
		private Fragment mFrag;
		private final Activity mAct;
		private final String mTag;
		private final Class<T> mClass;
		
		public TabListener(Activity a, String t, Class<T> c){
			mAct = a;
			mTag = t;
			mClass = c;
		}
		
		@Override
		public void onTabSelected(Tab t, FragmentTransaction ft){
			if(mFrag == null){
				mFrag = Fragment.instantiate(mAct, mClass.getName());
				ft.add(android.R.id.content, mFrag, mTag);
			}
			else
				ft.attach(mFrag);
		}
		
		@Override
		public void onTabUnselected(Tab t, FragmentTransaction ft){
			if (mFrag != null)
				ft.detach(mFrag);
		}
		
		@Override
		public void onTabReselected(Tab t, FragmentTransaction ft){
			//nothing when tapped twice :P
		}
	}
}
