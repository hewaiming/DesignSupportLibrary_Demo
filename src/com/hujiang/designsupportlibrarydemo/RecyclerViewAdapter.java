package com.hujiang.designsupportlibrarydemo;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<MyBean> mlist;

    public RecyclerViewAdapter(Context mContext,List<MyBean> myList) {
    	super();
        this.mContext = mContext;
        this.mlist=myList;
    }

    
    public RecyclerViewAdapter(Context mContext) {
		super();
		this.mContext = mContext;
	}


	@Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card_main, parent, false);
     
        return new ViewHolder(view);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, int position) {
        final View view = holder.mView; 
        
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationZ", 20, 0);
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mContext.startActivity(new Intent(mContext, DetailActivity.class));
                    }
                });
                animator.start();
            }
        });
        
        holder.tvTitle.setText(mlist.get(position).getTitle());
        holder.tvTakes.setText(mlist.get(position).getTakes());
    }       
        


    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public TextView tvTitle;
        public TextView tvTakes;
        public ViewHolder(View view) {
            super(view);           
            mView = view;         
            tvTitle=(TextView) view.findViewById(R.id.tvName);
            tvTakes=(TextView) view.findViewById(R.id.tvTakes);
        }
    }
}
