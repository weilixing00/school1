package com.example.administrator.school.mvp.other;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/11/30.
 * 只显示内容和标题的界面
 */
public class ContentFragment extends BaseFragment {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.tv_content_fragment_content)
    TextView tvContentFragmentContent;

    public static ContentFragment newInstance() {
        ContentFragment contentFragment = new ContentFragment();


        return contentFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeader.setText("查看");
        ivBackHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop();
            }
        });
        tvContentFragmentContent.setText("\t\t\t\t成功没有捷径可走，但有方法可循。对于很多小伙伴来说，到这个阶段，大家都希望有一些好的经验可以参考。尤其是政治这种可以快速提分的科目。下面，一起来看看考研政治成绩80分学长的经验。\n" +
                "\n" +
                "　　政治是第一门考的，也是我考完感觉最好的一门。其实政治这个东西真的不用复习太早，我是在9月中下旬左右，也就是大纲出来才开始看大纲。开始其实心里也没底，很慌，觉得好像那个时候看有一点迟，因为我同学暑假就开始看，9月已经开始做题了。\n" +
                "\n" +
                "　　好啦，说一下我具体怎么复习的。那个时候逛论坛，看了不少复习经验，最后决定用政治考90分大神的经验贴，但是当然啦我没能完全做到。从大纲出来开始(对了，大纲我们学校卖的盗版，希望同学们还是买正版吧，放心点)。\n" +
                "\n" +
                "　　第一遍纯看大纲，就跟看小说一样，一边看一边做记号，大概一天看40页(2个小时?记不太清了)。这样10天左右看完第一遍。第一遍没什么印象，很正常(看书之前要先看目录，对结构有了解哦)。\n" +
                "\n" +
                "　　第二遍：10月初开始，买一本肖秀荣的1000题，可以看完一章，做一章题，注意：做题答案不要直接写在本子上啊，方便日后再做，这个很重要，当初看到大神宝典，已经写完了(这个时候会慢一点，可以慢，很正常，这是开始消化吸收的阶段，这中间我还打印了每章结构图，然后对着结构图回忆内容啊，之前有报班，上了课梳理了结构啊之类。再次强调，脑子里有结构很重要啊)。\n" +
                "\n" +
                "　　第三遍：10月下旬吧，又开始看大纲书，这个时候做完了1000题，大概对书里内容有了印象，至少在说到哪些内容，要知道是哪一章吧。嗯，这时候做1000题第二遍，之前做错的题要标记，再看再做着重这些。那时候还买了本肖秀荣真题，没什么大用，其实1000题绝大部分是真题，但是也还好，可以做下，估计下自己水平。");
    }
}
