package edu.psu.ktwok.pocketplayer;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;

public class ContactMail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_mail); //needed?
		//implement action bar
		ActionBar aBar = getActionBar();
		aBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		aBar.setDisplayShowHomeEnabled(false);
		aBar.setDisplayShowTitleEnabled(false);
		
		//friend tab
		String lab1 = getResources().getString(R.string.friends); //what do i id?
		Tab tab = aBar.newTab();
		tab.setText(lab1);
		TabListener<friendFrag> friFrag = new TabListener<friendFrag>(this, lab1, friendFrag.class);
		tab.setTabListener(friFrag);
		aBar.addTab(tab);
		
		//mail tab
		String lab2 = getResources().getString(R.string.mail);
		tab = aBar.newTab();
		tab.setText(lab2);
		TabListener<mailFrag> mFrag = new TabListener<mailFrag>(this, lab2, mailFrag.class);
		tab.setTabListener(mFrag);
		aBar.addTab(tab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_mail, menu);
		return true;
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
		
		public void onTabSelected(Tab t, FragmentTransaction ft){
			if(mFrag == null){
				mFrag = Fragment.instantiate(mAct, mClass.getName());
				ft.add(android.R.id.content, mFrag, mTag);
			}
			else
				ft.attach(mFrag);
		}
		
		public void onTabUnselected(Tab t, FragmentTransaction ft){
			if (mFrag == null)
				ft.detach(mFrag);
		}
		
		public void onTabReselected(Tab t, FragmentTransaction ft){
			//nothing when tapped twice :P
		}
	}

}
