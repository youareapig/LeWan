package com.leiwan.zl.shiming;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.CameraUtil;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionGrant;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 选择图片不裁剪
 */
public class RenZhengActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.userIDcard)
    EditText userIDcard;
    @BindView(R.id.idcard1)
    ImageView idcard1;
    @BindView(R.id.idcard2)
    ImageView idcard2;
    @BindView(R.id.submit)
    TextView submit;
    private final int ACT_GALLERY = 0;
    private String filePath = android.os.Environment.getExternalStorageDirectory() + File.separator + "DICM" + File.separator;

    @Override
    protected int setLayout() {
        return R.layout.activity_ren_zheng;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {
        CameraUtil.createDir(filePath);
    }


    @OnClick({R.id.back, R.id.idcard1, R.id.idcard2, R.id.submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.idcard1:
                showDialog();
                break;
            case R.id.idcard2:
                showDialog();
                break;
            case R.id.submit:
                break;
        }
    }

    private void showDialog() {
        final AlertDialog builder = new AlertDialog.Builder(this).create();
        LayoutInflater inflater = this.getLayoutInflater();
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
                MPermissions.requestPermissions(RenZhengActivity.this, 2, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE);
                builder.cancel();
            }
        });
        layout.findViewById(R.id.photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MPermissions.requestPermissions(RenZhengActivity.this, 3, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                builder.cancel();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(2)
    public void requestCameraSuccess() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, ACT_GALLERY);

    }

    @PermissionGrant(3)
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
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void startGallery() {
        Intent intent = CameraUtil.openGallery();
        startActivityForResult(intent, ACT_GALLERY);
    }


    private void galleryBack(Uri inUri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(inUri, projection, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String filePath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));

                Bitmap bitmap = CameraUtil.getBitmapByUri(this, inUri);
                idcard1.setImageBitmap(bitmap);
                Log.d("zhenglei", "path----需要上传" + filePath);
                Log.d("zhenglei", "path-------------" + Uri.fromFile(new File(filePath)));

            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

    }

}
