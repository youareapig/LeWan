package com.leiwan.zl.home.mine;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.SplashActivity;
import com.leiwan.zl.address.AddressIndexActivity;
import com.leiwan.zl.bank.IDBankActivity;
import com.leiwan.zl.daren.DaRenActivity;
import com.leiwan.zl.data.FriendNumData;
import com.leiwan.zl.data.UserBean;
import com.leiwan.zl.data.WalletData;
import com.leiwan.zl.dingdan.DingDanActivity;
import com.leiwan.zl.friend.FriendActivity;
import com.leiwan.zl.lianxi.LianXiActivity;
import com.leiwan.zl.newpeople.NewPeopleActivity;
import com.leiwan.zl.quanyi.QuanYiActivity;
import com.leiwan.zl.regist.JoinVIPActivity;
import com.leiwan.zl.shiming.RenZhengActivity;
import com.leiwan.zl.shouru.ShouRuActivity;
import com.leiwan.zl.tixian.TiXianActivity;
import com.leiwan.zl.utils.CameraUtil;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SharedPreferencesUtil;
import com.leiwan.zl.utils.ToastUtil;
import com.leiwan.zl.yaoqing.YaoqingActivity;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionGrant;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

import static android.app.Activity.RESULT_OK;

/**
 * 选择图片需要裁剪
 */

public class MineFragment extends BaseFragment {
    @BindView(R.id.viphead)
    ImageView viphead;
    @BindView(R.id.view_yaoqing)
    RelativeLayout viewYaoqing;
    @BindView(R.id.view_jiaocheng)
    RelativeLayout viewJiaocheng;
    @BindView(R.id.view_yinhangka)
    RelativeLayout viewYinhangka;
    @BindView(R.id.view_youhui)
    RelativeLayout viewYouhui;
    @BindView(R.id.view_dingdan)
    RelativeLayout viewDingdan;
    @BindView(R.id.view_dizhi)
    RelativeLayout viewDizhi;
    @BindView(R.id.view_shiming)
    RelativeLayout viewShiming;
    @BindView(R.id.view_lianxi)
    RelativeLayout viewLianxi;
    @BindView(R.id.vip_tixian)
    RelativeLayout vipTiXian;
    @BindView(R.id.userhead)
    ImageView userhead;
    @BindView(R.id.vip_quanyi)
    TextView vipQuanyi;
    @BindView(R.id.vip_daren)
    RelativeLayout vipDaren;
    @BindView(R.id.yaoqingma)
    TextView yaoqingma;
    @BindView(R.id.copy)
    TextView copy;
    @BindView(R.id.vip_shouru)
    RelativeLayout vipShouru;
    @BindView(R.id.myfriend)
    RelativeLayout myfriend;
    @BindView(R.id.kehu)
    RelativeLayout kehu;
    @BindView(R.id.myallfriend)
    RelativeLayout myallfriend;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.userview)
    LinearLayout userview;
    @BindView(R.id.vip_name)
    TextView vipName;
    @BindView(R.id.kehunum)
    TextView kehunum;
    @BindView(R.id.hayounum)
    TextView hayounum;
    @BindView(R.id.allfriendnum)
    TextView allfriendnum;
    @BindView(R.id.vipview)
    LinearLayout vipview;
    @BindView(R.id.yaoqingtext)
    TextView yaoqingtext;
    @BindView(R.id.leaveName)
    TextView leaveName;
    @BindView(R.id.vip_leaveName)
    TextView vipLeaveName;
    @BindView(R.id.view_input_yaoqing)
    RelativeLayout viewInputYaoqing;
    @BindView(R.id.kehuadd)
    TextView kehuadd;
    @BindView(R.id.haoyouadd)
    TextView haoyouadd;
    @BindView(R.id.allfriendadd)
    TextView allfriendadd;
    @BindView(R.id.vip_all_money)
    TextView vipAllMoney;
    @BindView(R.id.vip_daijiesuan)
    TextView vipDaijiesuan;
    @BindView(R.id.vip_leijijiesuan)
    TextView vipLeijijiesuan;
    @BindView(R.id.vip_leijitixian)
    TextView vipLeijitixian;
    @BindView(R.id.vip_today)
    TextView vipToday;
    @BindView(R.id.vip_yestoday)
    TextView vipYestoday;
    @BindView(R.id.vip_benyue)
    TextView vipBenyue;
    @BindView(R.id.vip_shangyue)
    TextView vipShangyue;


    private Uri pictureUri = null;
    private String filePath = Environment.getExternalStorageDirectory() + File.separator + "myself" + File.separator;
    private ClipboardManager clipboardManager;
    private ClipData clipData;
    private final int ACT_GALLERY = 0;
    private final int ACT_CAMERA = 1;
    private final int ACT_CROP = 2;
    private Bundle bundle;

    @Override
    protected int setLayout() {
        return R.layout.mine_fragment;
    }

    @Override
    protected void setView() {

        clipboardManager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        bundle = new Bundle();

    }

    @Override
    protected void setData() {
        //TODO 创建文件夹
        CameraUtil.createDir(filePath);
        getUerInfo();

    }


    @OnClick({R.id.vip_tixian, R.id.view_input_yaoqing, R.id.kehu, R.id.myallfriend, R.id.myfriend, R.id.vip_shouru, R.id.vip_daren, R.id.copy, R.id.vip_quanyi, R.id.userhead, R.id.view_yaoqing, R.id.view_jiaocheng, R.id.view_yinhangka, R.id.view_youhui, R.id.view_dingdan, R.id.view_dizhi, R.id.view_shiming, R.id.view_lianxi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.view_yaoqing:
                toClass(getActivity(), YaoqingActivity.class);
                break;
            case R.id.view_input_yaoqing:
                toClass(getActivity(), JoinVIPActivity.class);
                break;
            case R.id.view_jiaocheng:
                toClass(getActivity(), NewPeopleActivity.class);
                break;
            case R.id.view_yinhangka:
                toClass(getActivity(), IDBankActivity.class);
                break;
            case R.id.view_youhui:

                break;
            case R.id.view_dingdan:
                toClass(getActivity(), DingDanActivity.class);
                break;
            case R.id.view_dizhi:
                toClass(getActivity(), AddressIndexActivity.class);
                break;
            case R.id.view_shiming:
                toClass(getActivity(), RenZhengActivity.class);
                break;
            case R.id.view_lianxi:
                toClass(getActivity(), LianXiActivity.class);
                break;
            case R.id.vip_quanyi:
                toClass(getActivity(), QuanYiActivity.class);
                break;
            case R.id.vip_shouru:
                toClass(getActivity(), ShouRuActivity.class);
                break;
            case R.id.vip_tixian:
                toClass(getActivity(), TiXianActivity.class);
                break;
            case R.id.copy:
                String stringMa = yaoqingma.getText().toString().trim();
                clipData = ClipData.newPlainText("ma", stringMa);
                clipboardManager.setPrimaryClip(clipData);
                ToastUtil.showShortToast("复制成功");
                break;
            case R.id.vip_daren:
                toClass(getActivity(), DaRenActivity.class);
                break;
            case R.id.myfriend:
                bundle.putString("friendtype", "3");
                bundle.putString("friendtitle", "直属好友");
                toClass(getActivity(), FriendActivity.class, bundle);
                break;
            case R.id.kehu:
                bundle.putString("friendtype", "2");
                bundle.putString("friendtitle", "我的客户");
                toClass(getActivity(), FriendActivity.class, bundle);
                break;
            case R.id.myallfriend:
                bundle.putString("friendtype", "1");
                bundle.putString("friendtitle", "全部好友");
                toClass(getActivity(), FriendActivity.class, bundle);
                break;
            case R.id.userhead:
                final AlertDialog builder = new AlertDialog.Builder(getActivity()).create();
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View layout = inflater.inflate(R.layout.layout_camera_control,
                        null);
                builder.setView(layout);
                builder.show();
                Window window = builder.getWindow();
                WindowManager.LayoutParams layoutParams = window.getAttributes();
                layoutParams.width = 800;
                window.setAttributes(layoutParams);
                layout.findViewById(R.id.photograph).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MPermissions.requestPermissions(MineFragment.this, 4, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE);
                        builder.cancel();
                    }
                });
                layout.findViewById(R.id.photo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MPermissions.requestPermissions(MineFragment.this, 5, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                        builder.cancel();
                    }
                });

                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(4)
    public void requestCameraSuccess() {
        startCamera();
    }

    @PermissionGrant(5)
    public void requestPhotoSuccess() {
        startGallery();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case ACT_GALLERY:
                galleryBack(data.getData());
                break;
            case ACT_CAMERA:
                startCrop(pictureUri);
                break;
            case ACT_CROP:
                cropBack(data.getData());
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void startGallery() {
        Intent intent = CameraUtil.openGallery();
        startActivityForResult(intent, ACT_GALLERY);
    }

    private void startCamera() {
        String fileName = CameraUtil.createFileName(".jpg");
        CameraUtil.createFile(filePath, fileName);
        File file = new File(filePath, fileName);
        pictureUri = Uri.fromFile(file);

        Intent intent = CameraUtil.openCamera(pictureUri);
        startActivityForResult(intent, ACT_CAMERA);

    }

    private void startCrop(Uri inUri) {
        Intent intent = CameraUtil.cropPicture(inUri, pictureUri);
        startActivityForResult(intent, ACT_CROP);
    }

    private void galleryBack(Uri inUri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getActivity().getContentResolver().query(inUri, projection, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String filePath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                startCrop(Uri.fromFile(new File(filePath)));

                Log.d("zhenglei", "path----需要上传" + filePath);
                Log.d("zhenglei", "path-------------" + Uri.fromFile(new File(filePath)));

            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

    }

    private void cropBack(Uri inUri) {
        if (inUri == null) {
            return;
        }
        try {
            Bitmap bitmap = CameraUtil.getBitmapByUri(getActivity(), inUri);
            userhead.setImageBitmap(bitmap);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取用户信息
    private void getUerInfo() {
        Connector.UserInfo(getActivity(), token, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "userinfo-----" + result);
                UserBean bean = JSON.parseObject(result, UserBean.class);
                if (bean.getCode() == 200) {
                    Glide.with(getActivity())
                            .load(bean.getData().getAvatar())
                            .placeholder(R.mipmap.yuan)
                            .error(R.mipmap.yuan)
                            .bitmapTransform(new CenterCrop(getActivity()), new CropCircleTransformation(getActivity()))
                            .into(viphead);

                    Glide.with(getActivity())
                            .load(bean.getData().getAvatar())
                            .placeholder(R.mipmap.yuan)
                            .error(R.mipmap.yuan)
                            .bitmapTransform(new CenterCrop(getActivity()), new CropCircleTransformation(getActivity()))
                            .into(userhead);
                    username.setText(bean.getData().getNickname());
                    vipName.setText(bean.getData().getNickname());
                    //保存用户等级，便于佣金的展示
                    SharedPreferencesUtil.getInstance(getActivity()).putSP("level", bean.getData().getLevel());
                    //保存用户token
                    SharedPreferencesUtil.getInstance(getActivity()).putSP("token", bean.getData().getToken() + "");
                    //保存邀请码
                    SharedPreferencesUtil.getInstance(getActivity()).putSP("recode", bean.getData().getRecode());
                    if (bean.getData().getLevel() == 1) {
                        //普通会员
                        leaveName.setText(bean.getData().getUsername());
                        userview.setVisibility(View.VISIBLE);
                        vipview.setVisibility(View.GONE);
                        yaoqingtext.setText("输入邀请码");
                        viewYinhangka.setVisibility(View.GONE);
                        viewShiming.setVisibility(View.GONE);
                        viewYaoqing.setVisibility(View.GONE);
                        viewInputYaoqing.setVisibility(View.VISIBLE);
                    } else {
                        //超级会员
                        vipLeaveName.setText(bean.getData().getUsername());
                        yaoqingma.setText(bean.getData().getRecode() + "");
                        userview.setVisibility(View.GONE);
                        vipview.setVisibility(View.VISIBLE);
                        yaoqingtext.setText("邀请好友");
                        viewYinhangka.setVisibility(View.VISIBLE);
                        viewShiming.setVisibility(View.VISIBLE);
                        viewYaoqing.setVisibility(View.VISIBLE);
                        viewInputYaoqing.setVisibility(View.GONE);
                        getFriendNum();
                        getMoney();
                    }
                }
            }
        });
    }

    //获取我的好友数量
    private void getFriendNum() {
        Connector.FriendNum(getActivity(), token, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "好友数量" + result);
                FriendNumData data = JSON.parseObject(result, FriendNumData.class);
                if (data.getCode() == 200) {
                    kehunum.setText(data.getData().getCustomer() + "");
                    kehuadd.setText("+" + data.getData().getNewcustomer());
                    hayounum.setText(data.getData().getDirectly() + "");
                    haoyouadd.setText("+" + data.getData().getNewdirectly());
                    allfriendnum.setText(data.getData().getWhole() + "");
                    allfriendadd.setText("+" + data.getData().getNewwhole());
                }
            }
        });
    }

    private void getMoney() {
        Connector.MyMoney(getActivity(), token, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "钱包" + result);
                WalletData data = JSON.parseObject(result, WalletData.class);
                if (data.getCode() == 200) {
                    vipAllMoney.setText(data.getData().getReward().getPutforward() + "");
                    vipDaijiesuan.setText(data.getData().getReward().getPending() + "");
                    vipLeijijiesuan.setText(data.getData().getReward().getGrandtotal() + "");
                    vipLeijitixian.setText(data.getData().getReward().getSumup() + "");

                    vipToday.setText(data.getData().getIncome().getToday() + "");
                    vipYestoday.setText(data.getData().getIncome().getYesterday() + "");
                    vipBenyue.setText(data.getData().getIncome().getThismonth() + "");
                    vipShangyue.setText(data.getData().getIncome().getLastmonth() + "");
                }
            }
        });
    }


}
