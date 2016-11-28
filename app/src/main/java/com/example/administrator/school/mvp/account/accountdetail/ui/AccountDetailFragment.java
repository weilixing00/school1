package com.example.administrator.school.mvp.account.accountdetail.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.utils.CropActivity;
import com.example.administrator.school.utils.JUtils;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.example.administrator.school.view.LikeIosPopupWindow;
import com.kevin.crop.UCrop;
import com.makeramen.roundedimageview.RoundedImageView;
import com.socks.library.KLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/9/3.
 * 账户详情
 */

public class AccountDetailFragment extends BaseFragment {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.iv_head_icon_fragment_account_detail)
    RoundedImageView ivHeadIconFragmentAccountDetail;
    @BindView(R.id.tv_nickname_fragment_account_detail)
    TextView tvNicknameFragmentAccountDetail;
    @BindView(R.id.tv_name_fragment_account_detail)
    TextView tvNameFragmentAccountDetail;
    @BindView(R.id.tv_sex_fragment_account_detail)
    TextView tvSexFragmentAccountDetail;
    @BindView(R.id.tv_school_fragment_account_detail)
    TextView tvSchoolFragmentAccountDetail;
    @BindView(R.id.tv_class_fragment_account_detail)
    TextView tvClassFragmentAccountDetail;
    @BindView(R.id.tv_date_fragment_account_detail)
    TextView tvDateFragmentAccountDetail;
    @BindView(R.id.tv_address_fragment_account_detail)
    TextView tvAddressFragmentAccountDetail;
    @BindView(R.id.root_main_fragment_account_detail)
    LinearLayout rootMainFragmentAccountDetail;
    private Uri mDestinationUri;
    private String mTempPhotoPath;
    private static final int GALLERY_REQUEST_CODE = 1004;
    private static final int CAMERA_REQUEST_CODE = 1005;
    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 1006;
    private OnPictureSelectedListener mOnPictureSelectedListener;

    public static AccountDetailFragment newInstance() {
        AccountDetailFragment fragment = new AccountDetailFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_detail, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvMiddleHeader.setText("账户详情");
        ivBackHeader.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                pop();
            }
        });
        ivHeadIconFragmentAccountDetail.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ivHeadIconFragmentAccountDetail.setCornerRadius(100);
        ivHeadIconFragmentAccountDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //拍照 相册选择
                showPopupwindow();
            }
        });

        // 设置裁剪图片结果监听
        setOnPictureSelectedListener(new OnPictureSelectedListener() {
            @Override
            public void onPictureSelected(Uri fileUri, Bitmap bitmap) {
                Toast.makeText(_mActivity, "选择了图片", Toast.LENGTH_SHORT).show();
                ivHeadIconFragmentAccountDetail.setImageBitmap(bitmap);
                String filePath = fileUri.getEncodedPath();
                KLog.e("filePath="+filePath+" bitmap ="+bitmap.getByteCount());
                String imagePath = Uri.decode(filePath);
                //todo 上传头像到服务器
//                uploadHeadIcon(imagePath);

            }
        });
    }



    private void showPopupwindow() {
        final LikeIosPopupWindow likeIosPopupWindow = new LikeIosPopupWindow( rootMainFragmentAccountDetail, getActivity(),"从相册选择","拍照");
        likeIosPopupWindow.t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 //选取照片
                Intent pickIntent = new Intent(Intent.ACTION_PICK, null);
                // 如果限制上传到服务器的图片类型时可以直接写如："image/jpeg 、 image/png等的类型"
                pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(pickIntent, GALLERY_REQUEST_CODE);
                likeIosPopupWindow.dismiss();
//                text2();
            }
        });
        likeIosPopupWindow.t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePhoto();
                likeIosPopupWindow.dismiss();
            }
        });

    }


    //拍照
    private void takePhoto() {
        Intent takeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //下面这句指定调用相机拍照后的照片存储的路径
        takeIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(mTempPhotoPath)));
        startActivityForResult(takeIntent, CAMERA_REQUEST_CODE);
    }

    @Override
    public void onResume() {
        super.onResume();
        mDestinationUri = Uri.fromFile(new File(getContext().getCacheDir(), "cropImage.jpeg"));
        mTempPhotoPath = Environment.getExternalStorageDirectory() + File.separator + "photo.jpeg";
//        fetchSexAndDetailAddress();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        KLog.e("sdsd resultCode="+resultCode);
        if (resultCode == RESULT_OK) {
            KLog.e("requestCode="+requestCode);
            switch (requestCode) {
                case CAMERA_REQUEST_CODE:   // 调用相机拍照
                    File temp = new File(mTempPhotoPath);
                    startCropActivity(Uri.fromFile(temp));
                    break;
                case GALLERY_REQUEST_CODE:  // 直接从相册获取
                    startCropActivity(data.getData());
                    break;
                case UCrop.REQUEST_CROP:    // 裁剪图片结果
                    handleCropResult(data);
                    break;
                case UCrop.RESULT_ERROR:    // 裁剪图片错误
                    handleCropError(data);
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    public void startCropActivity(Uri uri) {
        KLog.e();
        UCrop.of(uri, mDestinationUri)
                .withAspectRatio(1, 1)
                .withMaxResultSize(512, 512)
                .withTargetActivity(CropActivity.class)
                .start(getContext(),this);
    }


    /**
     * 设置图片选择的回调监听
     *
     * @param l
     */
    public void setOnPictureSelectedListener(OnPictureSelectedListener l) {
        this.mOnPictureSelectedListener = l;
    }

    /**
     * 图片选择的回调接口
     */
    public interface OnPictureSelectedListener {
        /**
         * 图片选择的监听回调
         *
         * @param fileUri
         * @param bitmap
         */
        void onPictureSelected(Uri fileUri, Bitmap bitmap);
    }


    /**
     * 处理剪切成功的返回值
     *
     * @param result
     */
    private void handleCropResult(Intent result) {
        JUtils.deleteTempPhotoFile(mTempPhotoPath);
        final Uri resultUri = UCrop.getOutput(result);
        if (null != resultUri && null != mOnPictureSelectedListener) {
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), resultUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            KLog.e("resultUri="+resultUri+"   bitmap="+bitmap);
            mOnPictureSelectedListener.onPictureSelected(resultUri, bitmap);
        } else {
            JUtils.Toast("无法剪切选择图片");
        }
    }

    /**
     * 处理剪切失败的返回值
     *
     * @param result
     */
    private void handleCropError(Intent result) {
        JUtils.deleteTempPhotoFile(mTempPhotoPath);

        final Throwable cropError = UCrop.getError(result);

        if (cropError != null) {
            Toast.makeText(_mActivity, cropError.getMessage(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(_mActivity, "无法剪切选择图片", Toast.LENGTH_SHORT).show();
        }
    }

}
