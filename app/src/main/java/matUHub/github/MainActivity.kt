package matUHub.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import matUHub.github.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewEvents()
        initViewModelEvents()

    }

    private fun initViewModelEvents(){
        viewModel.echoMessage.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun  initViewEvents(){
        binding.showButton.setOnClickListener{
            val username = binding.searchEditText.text.toString()
            viewModel.onShowRepos(username)
        }
    }
}