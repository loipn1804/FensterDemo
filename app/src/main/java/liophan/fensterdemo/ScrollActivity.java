package liophan.fensterdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.danikula.videocache.HttpProxyCacheServer;
import com.malmstein.fenster.controller.FensterPlayerControllerVisibilityListener;
import com.malmstein.fenster.controller.SimpleMediaFensterPlayerController;
import com.malmstein.fenster.view.FensterVideoView;

/**
 * Copyright (c) 2017, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since February 17, 2017
 */

public class ScrollActivity extends AppCompatActivity {

//    private String url = "https://stacck.s3.amazonaws.com/uploads/uploads/000/009/990/original/open-uri20170215-19627-sm18cb?1487147744";
    private String url = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

    private HttpProxyCacheServer mProxyCacheServer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        mProxyCacheServer = MyApplication.getProxy(this);

        setUpdateVideo1();
        setUpdateVideo2();
        setUpdateVideo3();
        setUpdateVideo4();
    }

    private void setUpdateVideo1() {
        FensterVideoView mFensterVideoView = (FensterVideoView) findViewById(R.id.play_video_texture_1);
        final SimpleMediaFensterPlayerController mMediaFensterPlayerController = (SimpleMediaFensterPlayerController) findViewById(R.id.play_video_controller_1);

        mFensterVideoView.setMediaController(mMediaFensterPlayerController);
        mFensterVideoView.setOnPlayStateListener(mMediaFensterPlayerController);

        mFensterVideoView.setVideo(mProxyCacheServer.getProxyUrl(url));
        mFensterVideoView.start();

        mFensterVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mMediaFensterPlayerController.isShowing()) {
                    mMediaFensterPlayerController.show();
                } else {
                    mMediaFensterPlayerController.hide();
                }
            }
        });
    }

    private void setUpdateVideo2() {
        FensterVideoView mFensterVideoView = (FensterVideoView) findViewById(R.id.play_video_texture_2);
        final SimpleMediaFensterPlayerController mMediaFensterPlayerController = (SimpleMediaFensterPlayerController) findViewById(R.id.play_video_controller_2);

        mFensterVideoView.setMediaController(mMediaFensterPlayerController);
        mFensterVideoView.setOnPlayStateListener(mMediaFensterPlayerController);

        mFensterVideoView.setVideo(mProxyCacheServer.getProxyUrl(url));
        mFensterVideoView.start();

        mFensterVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mMediaFensterPlayerController.isShowing()) {
                    mMediaFensterPlayerController.show();
                } else {
                    mMediaFensterPlayerController.hide();
                }
            }
        });
    }

    private void setUpdateVideo3() {
        FensterVideoView mFensterVideoView = (FensterVideoView) findViewById(R.id.play_video_texture_3);
        final SimpleMediaFensterPlayerController mMediaFensterPlayerController = (SimpleMediaFensterPlayerController) findViewById(R.id.play_video_controller_3);

        mFensterVideoView.setMediaController(mMediaFensterPlayerController);
        mFensterVideoView.setOnPlayStateListener(mMediaFensterPlayerController);

        mFensterVideoView.setVideo(mProxyCacheServer.getProxyUrl(url));
        mFensterVideoView.start();

        mFensterVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mMediaFensterPlayerController.isShowing()) {
                    mMediaFensterPlayerController.show();
                } else {
                    mMediaFensterPlayerController.hide();
                }
            }
        });
    }

    private void setUpdateVideo4() {
        FensterVideoView mFensterVideoView = (FensterVideoView) findViewById(R.id.play_video_texture_4);
        final SimpleMediaFensterPlayerController mMediaFensterPlayerController = (SimpleMediaFensterPlayerController) findViewById(R.id.play_video_controller_4);

        mFensterVideoView.setMediaController(mMediaFensterPlayerController);
        mFensterVideoView.setOnPlayStateListener(mMediaFensterPlayerController);

        mFensterVideoView.setVideo(mProxyCacheServer.getProxyUrl(url));
        mFensterVideoView.start();

        mFensterVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mMediaFensterPlayerController.isShowing()) {
                    mMediaFensterPlayerController.show();
                } else {
                    mMediaFensterPlayerController.hide();
                }
            }
        });
    }
}
