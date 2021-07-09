package com.example.simpleretrofit

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.simpleretrofit.databinding.FragmentFirstBinding
import com.example.simpleretrofit.Extension.bind

class FirstFragment : Fragment() {
    /*
    * コンパイルが高速: ビュー バインディングはアノテーション処理を必要としないため、コンパイル時間が短縮されます。
    * 使いやすい: ビュー バインディングは特別にタグ付けされた XML レイアウト ファイルを必要としないため、より迅速にアプリで利用できます。
    * モジュールでビュー バインディングを有効にすると、そのモジュールのすべてのレイアウトに自動的に適用されます。
    *
    * 逆に、ビュー バインディングには、データ バインディングに比べて次のような制約があります。
    * ビュー バインディングはレイアウト変数またはレイアウト式に対応していないため、動的 UI コンテンツを XML レイアウト ファイルから直接宣言できません。
    * ビュー バインディングは双方向データ バインディングに対応していません。
    * 現在のFragmentFirstBindingはViewDataBindingを継承（xmlで<data>を定義している）
    * <data>を定義しなければViewBindingを継承。
    * */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentFirstBinding.inflate(inflater, container, false).bind(viewLifecycleOwner) {
        it.firstText.text = "444"
//    it.firstText.setOnClickListener(object : View.OnClickListener {
//        override fun onClick(v: View?) {
//            Log.d("object", "clicked!")
//        }
//    }) この書き方は下記とおなじ
//      SAMインターフェイスとはSingleAbstractMethodの略で、
//      ひとつしか抽象メソッドを持たないインターフェイスのこと。
//      View.OnClickListenerもSAMです。
//      SAM変換とは、このようなSAMインターフェイスを
//      関数リテラル（ラムダ式）で置き換えることを言います。SAM変換によってコードが格段にすっきりします。
//
//        山田祥寛. 速習 Kotlin: Javaより簡単！新Android開発言語を今すぐマスター 速習シリーズ (Kindle Locations 1881-1885). WingsProject. Kindle Edition.
        it.firstText.setOnClickListener { Log.d("object", "clicked!") }
    }
}