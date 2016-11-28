package com.example.administrator.school.mvp.course.contestdetail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.school.R;
import com.example.administrator.school.base.BaseFragment;
import com.example.administrator.school.constant.KeyConstant;
import com.example.administrator.school.utils.CropActivity;
import com.example.administrator.school.utils.JUtils;
import com.example.administrator.school.utils.NoDoubleClickListener;
import com.example.administrator.school.view.LikeIosPopupWindow;
import com.example.administrator.school.view.PhotoGridView;
import com.kevin.crop.UCrop;
import com.lidong.photopicker.ImageCaptureManager;
import com.lidong.photopicker.PhotoPickerActivity;
import com.lidong.photopicker.PhotoPreviewActivity;
import com.lidong.photopicker.SelectModel;
import com.lidong.photopicker.intent.PhotoPickerIntent;
import com.lidong.photopicker.intent.PhotoPreviewIntent;
import com.socks.library.KLog;

import org.json.JSONArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2016/9/5.
 * 国家级大学生学科竞赛项目
 */

public class ContestDetailFragment extends BaseFragment {


    @BindView(R.id.iv_back_header)
    ImageView ivBackHeader;
    @BindView(R.id.tv_middle_header)
    TextView tvMiddleHeader;
    @BindView(R.id.tv_right_header_shadow)
    TextView tvRightHeaderShadow;
    @BindView(R.id.layout_header)
    RelativeLayout layoutHeader;
    @BindView(R.id.tv_takeup_time_fragment_contest_detail)
    TextView tvTakeupTimeFragmentContestDetail;
    @BindView(R.id.ll_choose_year_fragment_contest_detail)
    LinearLayout llChooseYearFragmentContestDetail;
    @BindView(R.id.ll_choose_date_fragment_contest_detail)
    LinearLayout llChooseDateFragmentContestDetail;
    @BindView(R.id.iv_declare_type_person_fragment_contest_detail)
    ImageView ivDeclareTypePersonFragmentContestDetail;
    @BindView(R.id.tv_declare_type_person_fragment_contest_detail)
    TextView tvDeclareTypePersonFragmentContestDetail;
    @BindView(R.id.iv_declare_type_group_fragment_contest_detail)
    ImageView ivDeclareTypeGroupFragmentContestDetail;
    @BindView(R.id.tv_declare_type_group_fragment_contest_detail)
    TextView tvDeclareTypeGroupFragmentContestDetail;
    @BindView(R.id.et_person_show_fragment_contest_detail)
    EditText etPersonShowFragmentContestDetail;
    @BindView(R.id.iv_declare_member_add_fragment_contest_detail)
    ImageView ivDeclareMemberAddFragmentContestDetail;
    @BindView(R.id.et_declare_member_add_fragment_contest_detail)
    TextView etDeclareMemberAddFragmentContestDetail;
    @BindView(R.id.lv_group_fragment_contest_detail)
    ListView lvGroupFragmentContestDetail;
    @BindView(R.id.ll_group_choose_show_fragment_contest_detail)
    LinearLayout llGroupChooseShowFragmentContestDetail;
    @BindView(R.id.et_teacher_fragment_contest_detail)
    EditText etTeacherFragmentContestDetail;
    @BindView(R.id.et_reslut_name_fragment_contest_detail)
    EditText etReslutNameFragmentContestDetail;
    @BindView(R.id.tv_project_name_fragment_contest_detail)
    TextView tvProjectNameFragmentContestDetail;
    @BindView(R.id.ll_project_content_fragment_contest_detail)
    LinearLayout llProjectContentFragmentContestDetail;
    @BindView(R.id.et_self_declare_fragment_contest_detail)
    EditText etSelfDeclareFragmentContestDetail;
    @BindView(R.id.gv_fragment_contest_detail)
    PhotoGridView gridView;
    @BindView(R.id.rootview_fragment_contest_detail)
    LinearLayout rootviewFragmentContestDetail;
    private MyListViewAdapter adapter;
    ArrayList<ContestContent> items = new ArrayList<>();
    private static final int REQUEST_CAMERA_CODE = 10;
    private static final int REQUEST_PREVIEW_CODE = 20;
    private ArrayList<String> imagePaths = new ArrayList<>();
    private ImageCaptureManager captureManager; // 相机拍照处理类


    private GridAdapter gridAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contest_detail, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        tvRightHeaderShadow.setText("完成");
        ivBackHeader.setOnClickListener(noDoubleClick);
        tvRightHeaderShadow.setOnClickListener(noDoubleClick);
        llChooseDateFragmentContestDetail.setOnClickListener(noDoubleClick);
        llChooseYearFragmentContestDetail.setOnClickListener(noDoubleClick);
        llProjectContentFragmentContestDetail.setOnClickListener(noDoubleClick);
        ivDeclareTypePersonFragmentContestDetail.setOnClickListener(clickListener);
        tvDeclareTypePersonFragmentContestDetail.setOnClickListener(clickListener);
        ivDeclareTypeGroupFragmentContestDetail.setOnClickListener(clickListener);
        tvDeclareTypeGroupFragmentContestDetail.setOnClickListener(clickListener);
        ivDeclareMemberAddFragmentContestDetail.setOnClickListener(clickListener);
        KLog.e();
        JUtils.closeInputMethod(getActivity());//默认关闭输入法
        adapter = new MyListViewAdapter(items);
        lvGroupFragmentContestDetail.setAdapter(adapter);
        JUtils.setListViewHeight(lvGroupFragmentContestDetail, adapter, items.size());

        int cols = getResources().getDisplayMetrics().widthPixels / getResources().getDisplayMetrics().densityDpi;
        cols = cols < 3 ? 3 : cols;//或者修改为3
        gridView.setNumColumns(cols);

        // preview
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String imgs = (String) parent.getItemAtPosition(position);
                if ("000000".equals(imgs) ){
                    final LikeIosPopupWindow likeIosPopupWindow = new LikeIosPopupWindow(rootviewFragmentContestDetail, getActivity(), "从相册选择", "拍照");
                    likeIosPopupWindow.t1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //相册选择
                            PhotoPickerIntent intent = new PhotoPickerIntent(getActivity());
                            intent.setSelectModel(SelectModel.MULTI);
                            intent.setShowCarema(false); // 是否显示拍照
                            intent.setMaxTotal(8); // 最多选择照片数量，默认为6  这个地方修改了之后adapter里面也要跟着修改
                            intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                            startActivityForResult(intent, REQUEST_CAMERA_CODE);
                            likeIosPopupWindow.dismiss();
                        }
                    });
                    likeIosPopupWindow.t2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //拍照
                            takePhoto();

                            likeIosPopupWindow.dismiss();
                        }
                    });
                    // 设置裁剪图片结果监听
                    setOnPictureSelectedListener(new OnPictureSelectedListener() {
                        @Override
                        public void onPictureSelected(Uri fileUri, Bitmap bitmap) {
                            Toast.makeText(_mActivity, "选择了图片", Toast.LENGTH_SHORT).show();
//                                    ivHeadIconFragmentAccountDetail.setImageBitmap(bitmap);
                            String filePath = fileUri.getEncodedPath();
                            imagePaths.add(filePath);
                            adapter.notifyDataSetChanged();
                            KLog.e("filePath="+filePath+" bitmap ="+bitmap.getByteCount());
                            String imagePath = Uri.decode(filePath);
                            //todo 上传头像到服务器
//                uploadHeadIcon(imagePath);

                        }
                    });

//                    PhotoPickerIntent intent = new PhotoPickerIntent(getActivity());
//                    intent.setSelectModel(SelectModel.MULTI);
//                    intent.setShowCarema(true); // 是否显示拍照
//                    intent.setMaxTotal(8); // 最多选择照片数量，默认为6  这个地方修改了之后adapter里面也要跟着修改
//                    intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
//                    startActivityForResult(intent, REQUEST_CAMERA_CODE);
                }else{
                    PhotoPreviewIntent intent = new PhotoPreviewIntent(getContext());
                    intent.setCurrentItem(position);
                    intent.setPhotoPaths(imagePaths);
                    startActivityForResult(intent, REQUEST_PREVIEW_CODE);
                }
            }
        });
        imagePaths.add("000000");
        gridAdapter = new GridAdapter(imagePaths);
        gridView.setAdapter(gridAdapter);

        //提交
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                depp =textView.getText().toString().trim()!=null?textView.getText().toString().trim():"woowoeo";
//                new Thread(){
//                    @Override
//                    public void run() {
//                        super.run();
//                        FileUploadManager.uploadMany(imagePaths, depp);
////                        FileUploadManager.upload(imagePaths,depp);
//                    }
//                }.start();
//            }
//        });

    }

    View.OnClickListener noDoubleClick = new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back_header:
                    pop();
                    break;
                //完成
                case R.id.tv_right_header_shadow:
                    LikeIosPopupWindow likeIosPopupWindow = new LikeIosPopupWindow(rootviewFragmentContestDetail, getActivity(), "提交", "保存");
                    likeIosPopupWindow.t1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(_mActivity, "提交", Toast.LENGTH_SHORT).show();
                        }
                    });
                    likeIosPopupWindow.t2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(_mActivity, "保存", Toast.LENGTH_SHORT).show();
                        }
                    });

                    break;
                //项目年份
                case R.id.ll_choose_year_fragment_contest_detail:


                    break;
                //选择日期
                case R.id.ll_choose_date_fragment_contest_detail:

                    break;
                //项目内容
                case R.id.ll_project_content_fragment_contest_detail:
//                    start(ProjectContentFragment.newInstance());
                    String content = tvProjectNameFragmentContestDetail.getText().toString().trim();
                    if ("请输入项目内容".equals(content)) {
                        content = "";
                    }
                    startForResult(ProjectContentFragment.newInstance(content), RESULT_OK);
                    break;
            }
        }
    };




    private Uri mDestinationUri;
    private String mTempPhotoPath;
    private static final int GALLERY_REQUEST_CODE = 1004;
    private static final int CAMERA_REQUEST_CODE = 1005;
    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 1006;
    private OnPictureSelectedListener mOnPictureSelectedListener;

    //拍照
    private void takePhoto() {
        Intent takeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //下面这句指定调用相机拍照后的照片存储的路径
        takeIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(mTempPhotoPath)));
        startActivityForResult(takeIntent, CAMERA_REQUEST_CODE);
    }

private String photoPath;
    @Override
    public void onResume() {
        super.onResume();
        photoPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + JUtils.getApkPackageName() + "/pic/";
        mDestinationUri = Uri.fromFile(new File(getContext().getCacheDir(), "cropImage.jpeg"));
//        mDestinationUri = Uri.fromFile(new File(photoPath, "cropImage.jpeg"));
        mTempPhotoPath = Environment.getExternalStorageDirectory() + File.separator + "photo.jpeg";
//        fetchSexAndDetailAddress();
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
//        JUtils.deleteTempPhotoFile(mTempPhotoPath);
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








    @Override
    protected void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        KLog.e("onFragmentResult");
        if (requestCode == RESULT_OK && resultCode == RESULT_OK) {
            String content = data.getString(KeyConstant.BundleKeyConstant.CONTENT);
            //如果输入界面删除了所有的内容 则显示默认提示 请输入项目内容
            if (TextUtils.isEmpty(content)) {
                content = "请输入项目内容";
            }
            tvProjectNameFragmentContestDetail.setText(content);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        KLog.e();
        Log.e("weilixing", "chengg1");
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                // 选择照片
                case REQUEST_CAMERA_CODE:
                    ArrayList<String> list = data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT);
                    KLog.e("list: " + "list = [" + list.size());
                    loadAdpater(list);
                    break;
                // 预览
                case REQUEST_PREVIEW_CODE:
                    ArrayList<String> ListExtra = data.getStringArrayListExtra(PhotoPreviewActivity.EXTRA_RESULT);
                    KLog.e("ListExtra: " + "ListExtra = [" + ListExtra.size());
                    loadAdpater(ListExtra);
                    break;

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

    }

    private void loadAdpater(ArrayList<String> paths){
        if (imagePaths!=null&& imagePaths.size()>0){
            imagePaths.clear();
        }
        if (paths.contains("000000")){
            paths.remove("000000");
        }
        paths.add("000000");
        imagePaths.addAll(paths);
        gridAdapter  = new GridAdapter(imagePaths);
        gridView.setAdapter(gridAdapter);
        try{
            JSONArray obj = new JSONArray(imagePaths);
            KLog.e(obj.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private boolean isChooseGroup = false;//选择 个人或者团队 默认个人
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                //个人 显示学号输入框 隐藏新增学号
                case R.id.iv_declare_type_person_fragment_contest_detail:
                case R.id.tv_declare_type_person_fragment_contest_detail:
                    isChooseGroup = false;
                    ivDeclareTypeGroupFragmentContestDetail.setImageResource(R.mipmap.contestdetails_chose2x);
                    ivDeclareTypePersonFragmentContestDetail.setImageResource(R.mipmap.contestdetails_nochose2x);
                    etPersonShowFragmentContestDetail.setVisibility(View.VISIBLE);
                    llGroupChooseShowFragmentContestDetail.setVisibility(View.GONE);
                    break;
                //团队  显示新增学号   隐藏输入学号对话框
                case R.id.tv_declare_type_group_fragment_contest_detail:
                case R.id.iv_declare_type_group_fragment_contest_detail:
                    isChooseGroup = true;
                    ivDeclareTypeGroupFragmentContestDetail.setImageResource(R.mipmap.contestdetails_nochose2x);
                    ivDeclareTypePersonFragmentContestDetail.setImageResource(R.mipmap.contestdetails_chose2x);
                    etPersonShowFragmentContestDetail.setVisibility(View.GONE);
                    llGroupChooseShowFragmentContestDetail.setVisibility(View.VISIBLE);
                    break;
                //增加团队成员
                case R.id.iv_declare_member_add_fragment_contest_detail:
                    items.add(new ContestContent());
                    adapter.notifyDataSetChanged();
                    JUtils.setListViewHeight(lvGroupFragmentContestDetail, adapter, items.size());
                    break;
            }
        }
    };

    public static ContestDetailFragment newInstance() {
        ContestDetailFragment contestDetailFragment = new ContestDetailFragment();
        return contestDetailFragment;
    }


    private class MyListViewAdapter extends BaseAdapter {
        private ArrayList<ContestContent> items;

        public MyListViewAdapter(ArrayList<ContestContent> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items == null ? 0 : items.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_lv_contest_detail, viewGroup, false);
            final EditText et = (EditText) view.findViewById(R.id.et_item_lv_contest_detail);

            ImageView iv = (ImageView) view.findViewById(R.id.iv_del_item_lv_contest_detail);
            MyCustomEditTextListener watcher = new MyCustomEditTextListener();
            watcher.updatePosition(i);
            et.addTextChangedListener(watcher);
            et.setText(items.get(i).etContent);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    et.setText(items.get(i).etContent);
                    KLog.e("items.get(i).etContent=" + items.get(i).etContent + "  i=" + i);
                    items.remove(i);
                    adapter.notifyDataSetChanged();
                    JUtils.setListViewHeight(lvGroupFragmentContestDetail, adapter, items.size());
                }
            });
            return view;
        }

        private class MyCustomEditTextListener implements TextWatcher {
            private int position;

            public void updatePosition(int position) {
                this.position = position;
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                // no op
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                //将修改的条目保存到集合中的filename参数中去
                items.get(position).etContent = charSequence.toString();
                KLog.e("修改的条目 = " + items.get(position).etContent);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // no op
            }
        }
    }

    private class GridAdapter extends BaseAdapter{
        private ArrayList<String> listUrls;
        private LayoutInflater inflater;
        public GridAdapter(ArrayList<String> listUrls) {
            this.listUrls = listUrls;
            if(listUrls.size() == 7){
                listUrls.remove(listUrls.size()-1);
            }
            inflater = LayoutInflater.from(getContext());
        }

        public int getCount(){
            return  listUrls.size();
        }
        @Override
        public String getItem(int position) {
            return listUrls.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.item_image, parent,false);
                holder.image = (ImageView) convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder)convertView.getTag();
            }

            final String path=listUrls.get(position);
            if (path.equals("000000")){
                holder.image.setImageResource(R.mipmap.editdetails_addpicture2x);
            }else {
                Glide.with(getContext())
                        .load(path)
                        .placeholder(R.mipmap.default_error)
                        .error(R.mipmap.default_error)
                        .centerCrop()
                        .crossFade()
                        .into(holder.image);
            }
            return convertView;
        }
        class ViewHolder {
            ImageView image;
        }
    }
}
