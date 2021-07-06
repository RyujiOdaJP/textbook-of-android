package com.example.simpleretrofit

import android.os.Bundle
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
* 現在のFragmentFirstBindingはデータバインディング（xmlで<data>を定義している）
* */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentFirstBinding.inflate(inflater, container, false).bind(viewLifecycleOwner) {
        it.firstText.text = "444"
    }
}