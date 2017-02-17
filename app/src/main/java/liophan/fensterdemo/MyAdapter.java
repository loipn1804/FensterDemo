package liophan.fensterdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.malmstein.fenster.controller.FensterPlayerControllerVisibilityListener;
import com.malmstein.fenster.controller.SimpleMediaFensterPlayerController;
import com.malmstein.fenster.view.FensterVideoView;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2016, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since October 19, 2016
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.BookViewHolder> {

    private List<String> listData;

    public MyAdapter(List<String> listData) {
        this.listData = new ArrayList<String>();
        this.listData.addAll(listData);
    }

    public void setListData(List<String> listData) {
        this.listData.clear();
        this.listData.addAll(listData);

        notifyDataSetChanged();
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter, parent, false);
        BookViewHolder bvh = new BookViewHolder(v);
        return bvh;
    }

    @Override
    public void onBindViewHolder(final BookViewHolder holder, int position) {
        holder.textureView.setMediaController(holder.fullScreenMediaPlayerController);
        holder.textureView.setOnPlayStateListener(holder.fullScreenMediaPlayerController);
        holder.textureView.setVideo("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        holder.textureView.start();

        holder.fullScreenMediaPlayerController.setVisibilityListener(new FensterPlayerControllerVisibilityListener() {
            @Override
            public void onControlsVisibilityChange(boolean value) {
                Log.e("LIO", "onControlsVisibilityChange " + value);
            }
        });

        holder.textureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!holder.fullScreenMediaPlayerController.isShowing()) {
                    holder.fullScreenMediaPlayerController.show(0);
                } else {
                    holder.fullScreenMediaPlayerController.hide();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        private FensterVideoView textureView;
        private SimpleMediaFensterPlayerController fullScreenMediaPlayerController;

        BookViewHolder(View itemView) {
            super(itemView);
            textureView = (FensterVideoView) itemView.findViewById(R.id.play_video_texture);
            fullScreenMediaPlayerController = (SimpleMediaFensterPlayerController) itemView.findViewById(R.id.play_video_controller);
        }
    }

}
