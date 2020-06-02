package company.domain.roomtestcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import company.domain.roomtestcode.databinding.ActivityMainBinding
import company.domain.roomtestcode.ui.base.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(
                this,
                R.layout.activity_main
            )

        binding.lifecycleOwner = this

//        val viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        //  위에서 아래로 변경됨.
        //  UI 와 Logic 분리하기 위해 사용.
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        //  databinding 으로 view -> viewModel 연결
        binding.viewModel = viewModel

    }
}
