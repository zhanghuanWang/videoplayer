package cn.qssq666.videoplayer.playermanager.manager;

import android.content.res.AssetFileDescriptor;

import cn.qssq666.videoplayer.playermanager.PlayerMessageState;
import cn.qssq666.videoplayer.playermanager.ui.VideoPlayerView;
import cn.qssq666.videoplayer.playermanager.meta.MetaData;

/**
 * This is a general interface for VideoPlayerManager
 * It supports :
 * 1. Start playback of new video by calling:
 *  a) {@link #playNewVideo(MetaData, VideoPlayerView, String)} if you have direct url or path to video source
 *  b) {@link #playNewVideo(MetaData, VideoPlayerView,String, AssetFileDescriptor)} is your video file is in assets directory
 * 2. Stop existing playback. {@link #stopAnyPlayback()}
 * 3. Reset Media Player if it's no longer needed. {@link #resetMediaPlayer()}
 */
public interface VideoPlayerManager<T extends MetaData> {

    /**
     * Call it if you have direct url or path to video source
     * @param metaData - optional Meta Data
     * @param videoPlayerView - the actual video player
     * @param videoUrl - the link to the video source
     */
    void playNewVideo(T metaData, VideoPlayerView videoPlayerView, String videoUrl);
    PlayerMessageState getCurrentPlayerState();


    /**
     * Call it if you have video source in assets directory
     * @param metaData - optional Meta Data
     * @param videoPlayerView - the actual video player
     * @param assetFileDescriptor -The asset descriptor of the video file
     */
    void playNewVideo(T metaData, VideoPlayerView videoPlayerView,String uuid, AssetFileDescriptor assetFileDescriptor);

    /**
     * Call it if you need to stop any playback that is currently playing
     */
    void stopAnyPlayback();

    void stop();
    void continuePlay();

    /**
     * Call it if you no longer need the player
     */
    void resetMediaPlayer();

    boolean isCurrent(String video);

    boolean isPause();

    boolean isPlay();

    void pause();
    void destory();

    void onPause();

    void onResume();
}
