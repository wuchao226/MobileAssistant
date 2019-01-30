package com.wuc.store.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.RegexUtils;
import com.wuc.store.R;
import com.wuc.store.base.BaseMvpActivity;
import com.wuc.store.bean.LoginBean;
import com.wuc.store.bean.User;
import com.wuc.store.common.Constant;
import com.wuc.store.mvp.model.LoginModule;
import com.wuc.store.mvp.presenter.LoginPresenter;
import com.wuc.store.mvp.view.LoginView;
import com.wuc.store.util.EditTextInputHelper;
import com.wuc.store.util.SpUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: wuchao
 * @date: 2018/11/13 11:50
 * @desciption: 登录
 */
public class LoginActivity extends BaseMvpActivity<LoginView, LoginPresenter> implements LoginView {

    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.et_number)
    AppCompatEditText mEtNumber;
    @BindView(R.id.text_number)
    TextInputLayout mTextNumber;
    @BindView(R.id.et_password)
    AppCompatEditText mEtPassword;
    @BindView(R.id.text_password)
    TextInputLayout mTextPassword;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    private LoginPresenter mPresenter;
    private EditTextInputHelper mEditTextInputHelper;

    @Override
    public int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mEditTextInputHelper = new EditTextInputHelper(mBtnLogin);
        mEditTextInputHelper.addViews(mEtNumber, mEtPassword);

        String num = SpUtils.getString(Constant.LOGIN_ACCOUNT);
        String pwd = SpUtils.getString(Constant.LOGIN_PASSWORD);
        if (!TextUtils.isEmpty(num)) {
            mTextNumber.getEditText().setText(num);
        }
        if (!TextUtils.isEmpty(pwd)) {
            mTextPassword.getEditText().setText(pwd);
        }
    }

    @Override
    public void onLoginResult(LoginBean loginBean) {
        String token = loginBean.getToken();
        SpUtils.putString(Constant.KEY_SP_TOKEN, token);
        User user = loginBean.getUser();
        SpUtils.putObject(Constant.USER, user);
        mRxBus.post(user);
        this.finish();
    }

    @OnClick({R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String num = mTextNumber.getEditText().getText().toString();
                String pwd = mTextPassword.getEditText().getText().toString();
                if (TextUtils.isEmpty(num)) {
                    mTextNumber.setError(getString(R.string.please_input_mobile_phone_number));
                    mTextNumber.getEditText().requestFocus();
                    return;
                } else if (!RegexUtils.isMobileExact(num)) {
                    mTextNumber.setError(getString(R.string.please_input_mobile_phone_number_error));
                    mTextNumber.getEditText().requestFocus();
                    return;
                } else {
                    mTextNumber.setError(null);
                    mTextNumber.setErrorEnabled(false);
                }
                if (TextUtils.isEmpty(pwd)) {
                    mTextPassword.setError(getString(R.string.please_input_password));
                    mTextPassword.getEditText().requestFocus();
                    return;
                } else {
                    mTextPassword.setError(null);
                    mTextPassword.setErrorEnabled(false);
                }
                SpUtils.putString(Constant.LOGIN_ACCOUNT, num);
                SpUtils.putString(Constant.LOGIN_PASSWORD, pwd);
                mPresenter.login(num, pwd);
                break;
            case R.id.btn_register:
                Uri uri = Uri.parse("http://www.cniao5.com/auth/user/reg.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            default:
        }
    }

    @Override
    protected void onDestroy() {
        mEditTextInputHelper.removeViews();
        super.onDestroy();
    }

    @Override
    protected LoginPresenter initPresenter() {
        LoginModule loginModule = new LoginModule();
        mPresenter = new LoginPresenter(loginModule);
        return mPresenter;
    }

    @Override
    protected LoginView initPresenterView() {
        return this;
    }
}
