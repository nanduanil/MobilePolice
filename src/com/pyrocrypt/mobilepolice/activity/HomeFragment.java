package com.pyrocrypt.mobilepolice.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.pyrocrypt.mobilepolice.R;

public class HomeFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_home, container, false);
		return view;

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		final InputMethodManager inputMethodManager = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		inputMethodManager.hideSoftInputFromWindow(getView().getWindowToken(),
				0);
		final Button btnSavePin = (Button) getActivity().findViewById(
				R.id.btnSavePin);
		final Button btnCallBack = (Button) getActivity().findViewById(
				R.id.btnCallBack);
		final Button btnCallForward = (Button) getActivity().findViewById(
				R.id.btnCallForward);
		final Button btnExportContact = (Button) getActivity().findViewById(
				R.id.btnExportContact);
		final Button btnExportSMS = (Button) getActivity().findViewById(
				R.id.btnExportSMS);
		final Button btnGetLocation = (Button) getActivity().findViewById(
				R.id.btnGetLocation);
		final Button btnRingPhone = (Button) getActivity().findViewById(
				R.id.btnRingPhone);

		btnSavePin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer position = findPosition(btnSavePin.getText().toString());
				mCallback.onMenuButtonSelected(position);
			}
		});
		btnCallBack.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer position = findPosition(btnCallBack.getText()
						.toString());
				mCallback.onMenuButtonSelected(position);
			}
		});
		btnCallForward.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer position = findPosition(btnCallForward.getText()
						.toString());
				mCallback.onMenuButtonSelected(position);
			}
		});
		btnExportContact.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer position = findPosition(btnExportContact.getText()
						.toString());
				mCallback.onMenuButtonSelected(position);
			}
		});
		btnExportSMS.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer position = findPosition(btnExportSMS.getText()
						.toString());
				mCallback.onMenuButtonSelected(position);
			}
		});
		btnGetLocation.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer position = findPosition(btnGetLocation.getText()
						.toString());
				mCallback.onMenuButtonSelected(position);
			}
		});
		btnRingPhone.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer position = findPosition(btnRingPhone.getText()
						.toString());
				mCallback.onMenuButtonSelected(position);
			}
		});

	}

	private Integer findPosition(String text) {
		String[] allOptions = getResources().getStringArray(
				R.array.navDrawerOptions);
		int position = 0;
		for (int i = 0; i < allOptions.length; i++) {
			if (allOptions[i].equals(text)) {
				position = i;
				break;
			}

		}
		return position;
	}

	OnHomeSelectionListener mCallback;

	public interface OnHomeSelectionListener {
		public void onMenuButtonSelected(int position);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		// This makes sure that the container activity has implemented
		// the callback interface. If not, it throws an exception
		try {
			mCallback = (OnHomeSelectionListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnHomeSelectionListener");
		}
	}
}