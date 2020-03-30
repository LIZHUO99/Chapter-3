# Chapter-3

BUPT Mobile Internet Course android part chapter3

- Android Studio：3.6.1
- Gradle：5.6.4
- Gradle Plugin：3.6.1



## 1. Exercise1

增加了两行代码

```java
animationView.setProgress((float) progress / 100);
Log.d("ex1", String.valueOf(progress)+" "+String.valueOf(animationView.getProgress()));
```

试了好长时间没有效果，最后开了一个log发现progress是0-1🤦‍



## 2. Exercise2

```java
// ex2-1
ObjectAnimator animator2_1 = ObjectAnimator.ofFloat(target,
        "scaleX", 1f, 2f);
animator2_1.setRepeatCount(ObjectAnimator.INFINITE);
animator2_1.setDuration(Integer.parseInt(durationSelector.getText().toString()));
animator2_1.setRepeatMode(ObjectAnimator.REVERSE);

ObjectAnimator animator2_2 = ObjectAnimator.ofFloat(target,
        "scaleY", 1f, 2f);
animator2_2.setRepeatCount(ObjectAnimator.INFINITE);
animator2_2.setDuration(Integer.parseInt(durationSelector.getText().toString()));
animator2_2.setRepeatMode(ObjectAnimator.REVERSE);

// ex2-2
ObjectAnimator animator3 = ObjectAnimator.ofFloat(target,
        "alpha", 0.5f, 1f);
animator3.setRepeatCount(ObjectAnimator.INFINITE);
animator3.setDuration(Integer.parseInt(durationSelector.getText().toString()));
animator3.setRepeatMode(ObjectAnimator.REVERSE);

// ex2-3
animatorSet = new AnimatorSet();
animatorSet.playTogether(animator1, animator2_1, animator2_2, animator3);
animatorSet.start();
```



## 3. Exercise3

Page and Tab

```java
// ex3-1
ViewPager pager = findViewById(R.id.view_pager);

pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
    @Override
    public Fragment getItem(int i) {
        return new PlaceholderFragment();
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "好友列表";
        }
        return "我的好友";
    }
});


// ex3-2

TabLayout tabLayout = findViewById(R.id.tab_layout);
tabLayout.setupWithViewPager(pager);
```

load RecycleView and animationView 

```java
// ex3-3
View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
itemList = view.findViewById(R.id.rc_view);
animationView = view.findViewById(R.id.animation_view);
LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
itemList.setLayoutManager(layoutManager);

mAdapter = new MyAdapter(100);

itemList.setAdapter(mAdapter);
return view;
```

fade in and fade out

```java
// ex3-4

//淡出
ObjectAnimator animator = ObjectAnimator.ofFloat(animationView, "alpha", 1f, 0f);
animator.setDuration(733);

//淡入
ObjectAnimator animator1 = ObjectAnimator.ofFloat(itemList, "alpha", 0f, 1f);
animator1.setDuration(733);

AnimatorSet animatorSet = new AnimatorSet();
animatorSet.playSequentially(animator, animator1);
animatorSet.start();
```

