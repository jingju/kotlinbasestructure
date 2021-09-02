package com.doit.kotlinbasesture.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import java.util.List;

/**
 * 用户信息
 */
public class UserInfoBean implements Parcelable {
    public String avatar;// 头像url
    public Long birthday; // 生日	 Thu Jun 14 16:54:58 CST 2018
    public String nickName; // 昵称
    public Integer sex;// 性别
    public String signature; // 签名
    public Integer userType; // 用户类型
    public String userTypeText; // 用户类型
    public long userId; // 用户id
    public String constellation; // 星座
    public Integer age;//年龄
    public String voteAmount; // 获赞数
    public String followAmount; // 关注数
    public String fansAmount; // 粉丝数
    public int isFollow; // 关注状态：0未关注 1已关注 2互关注
    public boolean isDefriend; // 是否被拉黑（true是false否）
    public int examTimes; // 全真练次数
    public int commentTimes; // 一对一点评次数
    /**
     * 结构化小组
     */
    public int groupExamTimes;
    /**
     * 无领导
     */
    public int noLeaderTimes;

    public String token;
    public String phoneNum;
    public String bgImage;//个人主页上面的背景

    public String giftTip;//赠品提示
//    public List<RegisterGiftBean> gifts;
    /**
     * 是否为新用户
     */
    public boolean newUser;

    public UserInfoBean() {
    }

    public void checkPhone(String phone) {
        if (!TextUtils.equals(phone, phoneNum)) {
            phoneNum = phone;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.avatar);
        dest.writeValue(this.birthday);
        dest.writeString(this.nickName);
        dest.writeValue(this.sex);
        dest.writeString(this.signature);
        dest.writeValue(this.userType);
        dest.writeString(this.userTypeText);
        dest.writeLong(this.userId);
        dest.writeString(this.constellation);
        dest.writeValue(this.age);
        dest.writeString(this.voteAmount);
        dest.writeString(this.followAmount);
        dest.writeString(this.fansAmount);
        dest.writeInt(this.isFollow);
        dest.writeByte(this.isDefriend ? (byte) 1 : (byte) 0);
        dest.writeInt(this.examTimes);
        dest.writeInt(this.commentTimes);
        dest.writeInt(this.groupExamTimes);
        dest.writeInt(this.noLeaderTimes);
        dest.writeString(this.token);
        dest.writeString(this.phoneNum);
        dest.writeString(this.bgImage);
    }

    protected UserInfoBean(Parcel in) {
        this.avatar = in.readString();
        this.birthday = (Long) in.readValue(Long.class.getClassLoader());
        this.nickName = in.readString();
        this.sex = (Integer) in.readValue(Integer.class.getClassLoader());
        this.signature = in.readString();
        this.userType = (Integer) in.readValue(Integer.class.getClassLoader());
        this.userTypeText = in.readString();
        this.userId = in.readLong();
        this.constellation = in.readString();
        this.age = (Integer) in.readValue(Integer.class.getClassLoader());
        this.voteAmount = in.readString();
        this.followAmount = in.readString();
        this.fansAmount = in.readString();
        this.isFollow = in.readInt();
        this.isDefriend = in.readByte() != 0;
        this.examTimes = in.readInt();
        this.commentTimes = in.readInt();
        this.groupExamTimes = in.readInt();
        this.noLeaderTimes = in.readInt();
        this.token = in.readString();
        this.phoneNum = in.readString();
        this.bgImage = in.readString();
    }

    public static final Creator<UserInfoBean> CREATOR = new Creator<UserInfoBean>() {
        @Override
        public UserInfoBean createFromParcel(Parcel source) {
            return new UserInfoBean(source);
        }

        @Override
        public UserInfoBean[] newArray(int size) {
            return new UserInfoBean[size];
        }
    };
}
