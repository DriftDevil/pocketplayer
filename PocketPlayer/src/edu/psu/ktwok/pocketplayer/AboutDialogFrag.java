package edu.psu.ktwok.pocketplayer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class AboutDialogFrag  extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle(R.string.about);
		builder.setMessage(R.string.about + "\n" + R.string.author + ": Kenny Huang & Kevin Joseph")
			.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int id) {
					dialog.dismiss();
				}
			});
		return builder.create();
	}

}
