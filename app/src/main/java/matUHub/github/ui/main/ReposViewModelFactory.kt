package matUHub.github.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import matUHub.github.domain.ProjectsRepo

class ReposViewModelFactory(private val repo: ProjectsRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      return MainViewModel(repo) as T
    }
}