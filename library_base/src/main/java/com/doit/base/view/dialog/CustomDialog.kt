package com.doit.base.view.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Typeface
import android.os.Bundle
import android.text.TextPaint
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.doit.base.R

class CustomDialog : Dialog {

    private var mLayoutId: Int = -1
    private var mInflater: LayoutInflater? = null

    private var rootView: View? = null
    private var mTitleView: TextView? = null
    private var mMessageView: TextView? = null
    private var mCancelBtn: TextView? = null
    private var mOkBtn: TextView? = null

    private var mCancelBtnClickListener: View.OnClickListener? = null
    private var mOkBtnClickListener: View.OnClickListener? = null

    constructor(context: Context, theme: Int) : super(context, theme) {
        mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        initView()
    }

    constructor(context: Context, theme: Int, layoutId: Int) : super(context, theme) {
        mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mLayoutId = layoutId
        initView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(rootView!!)
    }

    private fun initView() {
        rootView = mInflater!!.inflate(
            if (mLayoutId == -1) R.layout.layout_custom_dialog else mLayoutId,
            null
        )
        mTitleView = rootView!!.findViewById(R.id.custom_dialog_title_view)
        mMessageView = rootView!!.findViewById(R.id.custom_dialog_message_view)
        mCancelBtn = rootView!!.findViewById(R.id.custom_dialog_cancel_btn)
        mOkBtn = rootView!!.findViewById(R.id.custom_dialog_confirm_btn)

        mCancelBtn!!.setOnClickListener(View.OnClickListener { v ->
            dismiss()
            mCancelBtnClickListener?.onClick(v)
        })
        mOkBtn!!.setOnClickListener(View.OnClickListener { v ->
            dismiss()
            mOkBtnClickListener?.onClick(v)
        })
    }

    /**
     * 设置title
     */
    fun setTitle(title: String?) {
        mTitleView!!.text = title
    }

    /**
     * 设置dialog内容
     */
    fun setMessage(message: String?) {
        if (!TextUtils.isEmpty(message)) {
            mMessageView!!.text = message
        }
    }

    /**
     *  设置取消按钮信息 + 点击事件
     */
    fun setCancelBtn(text: String?, onClickListener: View.OnClickListener?) {
        if (!TextUtils.isEmpty(text)) {
            mCancelBtn!!.text = text
        }
        mCancelBtnClickListener = onClickListener
    }

    /**
     *  设置确定按钮信息 + 点击事件
     */
    fun setOkBtn(text: String?, onClickListener: View.OnClickListener?) {
        if (!TextUtils.isEmpty(text)) {
            mOkBtn!!.text = text
        }
        mOkBtnClickListener = onClickListener
    }

    class Builder(private val mContext: Context) {

        private var mTitleString: String? = null
        private var mMessageString: String? = null

        private var mCancelBtnTextStr: String? = null
        private var mCancelBtnClickListener: View.OnClickListener? = null
        private var mOkBtnTextStr: String? = null
        private var mOkBtnClickListener: View.OnClickListener? = null

        private var mLayoutId = -1

        fun setTitle(resId: Int): Builder {
            mTitleString = mContext.resources.getString(resId)
            return this
        }

        fun setTitle(title: String?): Builder {
            mTitleString = title
            return this
        }

        fun setMessage(resId: Int): Builder {
            mMessageString = mContext.resources.getString(resId)
            return this
        }

        fun setMessage(message: String?): Builder {
            mMessageString = message
            return this
        }

        /**
         * 自定义布局
         */
        fun setLayoutId(resId: Int): Builder {
            mLayoutId = resId
            return this
        }

        fun setCancelBtn(stringId: Int, onClickListener: View.OnClickListener?): Builder {
            mCancelBtnTextStr = mContext.resources.getString(stringId)
            mCancelBtnClickListener = onClickListener
            return this
        }

        fun setOkBtn(text: String?, onClickListener: View.OnClickListener?): Builder {
            mOkBtnTextStr = text
            mOkBtnClickListener = onClickListener
            return this
        }

        fun create(): CustomDialog {
            val dialog: CustomDialog =
                if (mLayoutId == -1) CustomDialog(
                    mContext, R.style.CustomDialog
                ) else CustomDialog(
                    mContext, R.style.CustomDialog, mLayoutId
                )
            if (!TextUtils.isEmpty(mTitleString)) {
                dialog.setTitle(mTitleString)
            }
            if (!TextUtils.isEmpty(mMessageString)) {
                dialog.setMessage(mMessageString)
            }
            if (!TextUtils.isEmpty(mCancelBtnTextStr) || mCancelBtnClickListener != null) {
                dialog.setCancelBtn(mCancelBtnTextStr, mCancelBtnClickListener)
            }
            if (!TextUtils.isEmpty(mOkBtnTextStr) || mOkBtnClickListener != null) {
                dialog.setOkBtn(mOkBtnTextStr, mOkBtnClickListener)
            }
            return dialog
        }
    }
}