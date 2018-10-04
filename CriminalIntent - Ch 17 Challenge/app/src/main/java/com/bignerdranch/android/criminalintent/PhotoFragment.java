package com.bignerdranch.android.criminalintent;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class PhotoFragment extends DialogFragment {

    private final static String ARG_PHOTO_PATH = "photo";

    private Button mDoneButton;
    private ImageView mPhotoView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_photo, null);

        mDoneButton = v.findViewById(R.id.done_button);
        mDoneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        mPhotoView = v.findViewById(R.id.crime_photo);
        String path = getArguments().getString(ARG_PHOTO_PATH);
        Bitmap bitmap = PictureUtils.getScaledBitmap(path, getActivity());
        mPhotoView.setImageBitmap(bitmap);

        return v;
    }

    public static PhotoFragment newInstance(File photo) {
        Bundle args = new Bundle();
        args.putString(ARG_PHOTO_PATH, photo.getPath());

        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }
}
