package com.example.android.camera2basic;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Size;

import com.example.android.camera2basic.camera2.Camera2Controller;
import com.example.android.camera2basic.camera2.ICameraListener;

public class CameraDemoActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA_PERMISSION = 1;
    AutoFitTextureView mTextureView;
    Camera2Controller cameraController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_demo);

        mTextureView = findViewById(R.id.texture);
        cameraController= new Camera2Controller(this, mListener, mTextureView);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestCameraPermission();
        }
    }

    @Override
    public void onResume(){
        super.onResume();

        cameraController.connectCamera();
    }

    @Override
    public void onPause(){
        super.onPause();

         cameraController.stopCamera();
    }

    private ICameraListener mListener = new ICameraListener() {
        @Override
        public void onNotSupported() {

        }

        @Override
        public void onPermissionNotGiven() {

        }

        @Override
        public void onCameraNotAvailable() {

        }

        @Override
        public void onCameraFailed() {

        }

        @Override
        public void onCameraFlipped() {

        }

        @Override
        public void onCameraSwitched() {

        }

        @Override
        public void onFlashEnabled(boolean enabled) {

        }

        @Override
        public void onPreviewStarted() {

        }

        @Override
        public void onPictureTaken(Image image, int orientation, Size size) {

        }

        @Override
        public void onPreRecording() {

        }

        @Override
        public void onVideoRecordingStarted() {

        }

        @Override
        public void onVideoRecordingStop(String filePath) {

        }
    };

    private void requestCameraPermission() {
        if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
//            new ConfirmationDialog().show(getChildFragmentManager(), FRAGMENT_DIALOG);
        } else {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults.length != 1 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
//                ErrorDialog.newInstance(getString(R.string.request_permission))
//                        .show(getChildFragmentManager(), FRAGMENT_DIALOG);
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}
