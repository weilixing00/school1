package com.example.administrator.school.mvp.home.me.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.event.StartBrotherEvent;
import com.example.administrator.school.mvp.account.accountdetail.ui.AccountDetailFragment;
import com.example.administrator.school.mvp.account.login.ui.LoginFragment;
import com.example.administrator.school.mvp.account.resetloginpsw.ResetLoginPswFragment;
import com.example.administrator.school.mvp.account.resetphone.ui.ResetPhone1Fragment;
import com.example.administrator.school.mvp.other.aboutsoftware.AboutSoftWareFragment;
import com.example.administrator.school.utils.NoDoubleClickListener;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/28.
 * 我
 */
public class MeTabFragment extends BaseFragment {

    @BindView(R.id.iv_icon_fragment_me)
    ImageView ivIconFragmentMe;
    @BindView(R.id.tv_nickname_fragment_me)
    TextView tvNicknameFragmentMe;
    @BindView(R.id.tv_study_num_fragment_me)
    TextView tvStudyNumFragmentMe;
    @BindView(R.id.tv_phone_status_fragment_me)
    TextView tvPhoneStatusFragmentMe;
    @BindView(R.id.ll_phone_fragment_me)
    LinearLayout llPhoneFragmentMe;
    @BindView(R.id.tv_reset_status_fragment_me)
    TextView tvResetStatusFragmentMe;
    @BindView(R.id.ll_reset_login_psw_fragment_me)
    LinearLayout llResetLoginPswFragmentMe;
    @BindView(R.id.ll_about_software_fragment_me)
    LinearLayout llAboutSoftwareFragmentMe;
    @BindView(R.id.ll_exit_login_fragment_me)
    LinearLayout llExitLoginFragmentMe;

    public static MeTabFragment newInstance() {
        MeTabFragment meTabFragment = new MeTabFragment();
        return meTabFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        // TODO: 2016/9/3 联网获取个人信息? 还是在MainFragment中获取?
        llAboutSoftwareFragmentMe.setOnClickListener(noDoubleClick);
        llExitLoginFragmentMe.setOnClickListener(noDoubleClick);
        llPhoneFragmentMe.setOnClickListener(noDoubleClick);
        llResetLoginPswFragmentMe.setOnClickListener(noDoubleClick);
        ivIconFragmentMe.setOnClickListener(noDoubleClick);

    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_icon_fragment_me:
                    EventBus.getDefault().post(new StartBrotherEvent(AccountDetailFragment.newInstance()));
                    break;
                //手机  跳转到修改手机
                case R.id.ll_phone_fragment_me:
//                    EventBus.getDefault().post(new StartBrotherEvent(BindPhoneFragment.newInstance()));
                    EventBus.getDefault().post(new StartBrotherEvent(ResetPhone1Fragment.newInstance()));
                    break;
                //修改登录密码
                case R.id.ll_reset_login_psw_fragment_me:
                    EventBus.getDefault().post(new StartBrotherEvent(ResetLoginPswFragment.newInstance()));
                    break;
                //关于软件
                case R.id.ll_about_software_fragment_me:
                    EventBus.getDefault().post(new StartBrotherEvent(AboutSoftWareFragment.newInstance()));
                    break;
                //退出登录
                case R.id.ll_exit_login_fragment_me:
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("确认退出登录？");

//                    builder.setTitle("提示");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            //跳转到登录页面
                            EventBus.getDefault().post(new StartBrotherEvent(LoginFragment.newInstance()));
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }

                    });
                    builder.create().show();
                    break;
            }
        }
    };

}
