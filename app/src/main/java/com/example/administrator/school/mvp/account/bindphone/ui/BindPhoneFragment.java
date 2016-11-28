package com.example.administrator.school.mvp.account.bindphone.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.mvp.account.bindphone.BindPhoneContract;
import com.example.administrator.school.mvp.account.bindphone.presenter.BindPhonePresenter;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.example.administrator.school.view.TimeCountUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/3.
 * 绑定手机
 */
public class BindPhoneFragment extends BaseFragment implements BindPhoneContract.View {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeader;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.et_phone_fragment_bind_phone)
    EditText etPhoneFragmentBindPhone;
    @BindView(R.id.et_msgcode_fragment_bind_phone)
    EditText etMsgcodeFragmentBindPhone;
    @BindView(R.id.bt_msg_code_fragment_bind_phone)
    Button btMsgCodeFragmentBindPhone;
    @BindView(R.id.bt_sure_fragment_bind_phone)
    Button btSureFragmentBindPhone;
    private BindPhonePresenter presenter;
    private TimeCountUtil countUtil;

    public static BindPhoneFragment newInstance() {
        BindPhoneFragment bindPhoneFragment = new BindPhoneFragment();

        return bindPhoneFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bind_phone, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeader.setText("绑定手机");
        presenter = new BindPhonePresenter(this);
        countUtil = new TimeCountUtil(_mActivity,1000,btMsgCodeFragmentBindPhone);
        btMsgCodeFragmentBindPhone.setOnClickListener(noDoubleClick);
        btSureFragmentBindPhone.setOnClickListener(noDoubleClick);
        ivBackHeader.setOnClickListener(noDoubleClick);
    }

    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_back_header:

                    break;
                case R.id.bt_msg_code_fragment_bind_phone:
                    String phoneNum = etPhoneFragmentBindPhone.getText().toString().trim();
                    presenter.sendMsgCode(phoneNum);
                    break;
                case R.id.bt_sure_fragment_bind_phone:
                     phoneNum = etPhoneFragmentBindPhone.getText().toString().trim();
                    String msgCode = etMsgcodeFragmentBindPhone.getText().toString().trim();
                    presenter.bindPhone(phoneNum,msgCode);
                    break;
            }
        }
    };

    @Override
    public void onMsgCodeSuc() {
        countUtil.start();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(_mActivity, error, Toast.LENGTH_SHORT).show();
    }
}
