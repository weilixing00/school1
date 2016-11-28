package com.example.administrator.school.mvp.course.contestdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.constant.KeyConstant;
import com.example.administrator.school.utils.JUtils;
import com.example.administrator.school.utils.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/5.
 */
public class ProjectContentFragment extends BaseFragment {
    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.et_fragment_project_content)
    EditText etFragmentProjectContent;
    @BindView(R.id.tv_fragment_project_content)
    TextView tvFragmentProjectContent;

    public static ProjectContentFragment newInstance(String content) {
        ProjectContentFragment projectContentFragment = new ProjectContentFragment();
        Bundle bundle=new Bundle();
        bundle.putString(KeyConstant.BundleKeyConstant.CONTENT,content);
        projectContentFragment.setArguments(bundle);
        return projectContentFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_project_content, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeader.setText("项目内容");
        tvRightHeaderShadow.setText("完成");
        String content = getArguments().getString(KeyConstant.BundleKeyConstant.CONTENT);
        etFragmentProjectContent.setText(content);
        ivBackHeader.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                JUtils.closeInputMethod(getActivity());
                pop();
            }
        });

        tvRightHeaderShadow.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                //完成
                Bundle bundle=new Bundle();
                bundle.putString(KeyConstant.BundleKeyConstant.CONTENT,etFragmentProjectContent.getText().toString().trim());
                setFramgentResult(RESULT_OK,bundle);
                JUtils.closeInputMethod(getActivity());
                pop();
            }
        });

        etFragmentProjectContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                tvFragmentProjectContent.setText(editable.length()+"/100字");
            }
        });
    }

    @Override
    public boolean onBackPressedSupport() {
        JUtils.closeInputMethod(getActivity());
        return super.onBackPressedSupport();
    }
}
