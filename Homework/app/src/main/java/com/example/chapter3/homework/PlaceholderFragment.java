package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private MyAdapter mAdapter;
    private LottieAnimationView animationView;
    private RecyclerView itemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        itemList = view.findViewById(R.id.rc_view);
        animationView = view.findViewById(R.id.animation_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        itemList.setLayoutManager(layoutManager);


        mAdapter = new MyAdapter(100);

        itemList.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入

                ObjectAnimator animator = ObjectAnimator.ofFloat(animationView, "alpha", 1f, 0f);
                animator.setDuration(733);

                ObjectAnimator animator1 = ObjectAnimator.ofFloat(itemList, "alpha", 0f, 1f);
                animator1.setDuration(733);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(animator, animator1);
                animatorSet.start();
            }
        }, 5000);
    }
}
