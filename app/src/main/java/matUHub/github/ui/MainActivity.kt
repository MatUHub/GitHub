package matUHub.github.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import matUHub.github.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter: GitProjectAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniView()
        initViewEvents()
        initViewModelEvents()

    }

    private fun iniView() {
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.adapter = adapter
    }

    private fun initViewModelEvents(){
        viewModel.repos.observe(this){
            adapter.setData(it)
        }
    }

    private fun  initViewEvents(){
        binding.showButton.setOnClickListener{
            val username = binding.searchEditText.text.toString()
            viewModel.onShowRepos(username)
        }
    }
}