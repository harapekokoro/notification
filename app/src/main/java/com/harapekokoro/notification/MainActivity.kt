package com.harapekokoro.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nifcloud.mbaas.core.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NCMB.initialize(this.applicationContext, BuildConfig.NCMB_API_KEY, BuildConfig.NCMB_CLIENT_KEY)

        // クラスのNCMBObjectを作成
        val obj = NCMBObject("TestClass")
        // オブジェクトの値を設定
        obj.put("message", "Hello, NCMB!")
        obj.saveInBackground(NCMBCallback { e, ncmbObj ->
            if (e != null) {
                //保存に失敗した場合の処理
                print("保存に失敗しました : " + e.message)
            } else {
                //保存に成功した場合の処理
                val result = ncmbObj as NCMBObject
                print("保存に成功しました ObjectID :" + result.getObjectId())
            }
        })


        setContentView(R.layout.activity_main)
    }
}
