package com.example.android.camera2basic.camera2;

import android.media.Image;
import android.util.Size;

/**
 * @author Murodjon
 */
public interface ICameraListener {
    default void onNotSupported(){}
    default void onPermissionNotGiven(){}
    default void onCameraNotAvailable(){}
    default void onCameraFailed(){}
    default void onCameraFlipped(){}
    default void onCameraSwitched(){}
    default void onFlashEnabled(boolean enabled){}

    default void onPreviewStarted(){}

    default void onPictureTaken(Image image, int orientation, Size size){}

    default void onPreRecording(){}
    default void onVideoRecordingStarted(){}
    default void onVideoRecordingStop(String filePath){}
}
