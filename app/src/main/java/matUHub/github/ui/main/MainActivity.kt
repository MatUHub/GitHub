package matUHub.github.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import matUHub.github.app
import matUHub.github.databinding.ActivityMainBinding
import matUHub.github.ui.detailed.DetailActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels { ReposViewModelFactory(app.gitProjectsRepo) }
    private val adapter = GitProjectAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniView()
        initViewModelEvents()
        viewModel.showRepos()

        adapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("user", it)
            startActivity(intent)
        }
    }

    private fun iniView() {
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter.setHasStableIds(true)
        binding.mainRecyclerView.adapter = adapter
    }

    private fun initViewModelEvents() {
        viewModel.repos.observe(this) {
            adapter.setData(it)
        }
    }


}